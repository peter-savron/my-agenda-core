package si.savron.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import si.savron.dtos.tag.TagDto;
import si.savron.dtos.tag.TagPostDto;
import si.savron.dtos.tag.TagPutDto;
import si.savron.mappers.TagMapper;
import si.savron.models.ActiveUserEntity;
import si.savron.models.TagEntity;
import si.savron.repositories.ActiveUserRepository;
import si.savron.repositories.TagRepository;
import si.savron.utils.EntityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class TagService {
    @Inject TagRepository tagRepository;
    @Inject TagMapper tagMapper;
    @Inject ActiveUserRepository activeUserRepository;

    public List<TagDto> getUserTags(UUID userId){
        return tagMapper.toDtoList(tagRepository.findAllByOwner(userId).list());
    }

    @Transactional
    public List<TagDto> createTags(List<TagPostDto> newTagsPost, UUID ownerId){

        ActiveUserEntity ownerEntity = activeUserRepository.findById(ownerId);
        if(ownerEntity == null){
            throw new BadRequestException("Owner is null");
        }

        for(TagPostDto tagPostDto : newTagsPost){
            var newEntity = createTagEntity(tagPostDto, ownerEntity);
            tagRepository.persist(newEntity);
        }

        return getUserTags(ownerId);
    }

    @Transactional
    public List<TagDto> updateTags(List<TagPutDto> putTags, UUID ownerID){

        List<UUID> tagIds = putTags.stream().map(TagPutDto::id).toList();
        Map<UUID, TagEntity> tags = EntityUtil.toMap(tagRepository.findByIds(tagIds, ownerID));

        for (var putTag : putTags){
            var tagEntity = tags.get(putTag.id());
            updateTagEntity(tagEntity, putTag);
            tagRepository.persist(tagEntity);
        }
        return getUserTags(ownerID);
    }

    @Transactional
    public void deleteTags(List<UUID> tagIds, UUID ownerId){
        tagRepository.deleteByIds(tagIds, ownerId);
    }

    // PRIVATE methods
    private TagEntity createTagEntity(TagPostDto tagPostDto, ActiveUserEntity ownerEntity){
        TagEntity newEntity = tagMapper.fromPostDto(tagPostDto);
        newEntity.owner = ownerEntity;
        return newEntity;
    }

    private void updateTagEntity(TagEntity tagEntity, TagPutDto putTag){
        tagEntity.tag = putTag.tag();
        tagEntity.description = putTag.description() != null ? putTag.description() : tagEntity.description;
    }
}
