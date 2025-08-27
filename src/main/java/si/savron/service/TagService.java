package si.savron.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import si.savron.dtos.tag.TagDto;
import si.savron.dtos.tag.TagPostDto;
import si.savron.mappers.TagMapper;
import si.savron.models.TagEntity;
import si.savron.repositories.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TagService {
    @Inject TagRepository tagRepository;
    @Inject TagMapper tagMapper;

    // TODO can basic CRUD be abstracted via mappers and Base Service?
    public List<TagDto> getUserTags(UUID userId){
        return tagMapper.toDtoList(tagRepository.findAllByOwner(userId));
    }

    @Transactional
    public List<TagDto> createTags(List<TagPostDto> newTagsPost){
        List<TagDto> newTags = new ArrayList<>(newTagsPost.size());
        for(TagPostDto tagPostDto : newTagsPost){
            TagEntity newEntity = tagMapper.fromPostDto(tagPostDto);
            tagRepository.persist(newEntity);
            newTags.add(tagMapper.toDto(newEntity));
        }
        return newTags;
    }
}
