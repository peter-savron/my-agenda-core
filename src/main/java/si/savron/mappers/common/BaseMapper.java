package si.savron.mappers.common;

import java.util.List;

public interface BaseMapper <Target, Source, PostDto>{
    Target toDto(Source source);
    List<Target> toDtoList(List<Source> sources);
    Source fromPostDto(PostDto postDto);
}
