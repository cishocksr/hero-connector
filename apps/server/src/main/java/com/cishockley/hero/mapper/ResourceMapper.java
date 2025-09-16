package com.cishockley.hero.mapper;

import com.cishockley.hero.dto.ResourceDto;
import com.cishockley.hero.model.Resource;

public class ResourceMapper {
    public static ResourceDto toDto(Resource resource) {
        return new ResourceDto(resource.getId(), resource.getName(), resource.getCategory());
    }
    public static Resource toEntity(ResourceDto d ) {
        Resource resource = new Resource();
        resource.setId(d.id());
        resource.setName(d.name());
        resource.setCategory(d.category());
        return resource;
    }
}
