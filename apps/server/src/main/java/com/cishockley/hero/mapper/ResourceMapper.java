package com.cishockley.hero.mapper;

import com.cishockley.hero.dto.ResourceDto;
import com.cishockley.hero.model.Resource;

public final class ResourceMapper {
    private ResourceMapper() {}

    public static ResourceDto toDto(Resource e) {
        return new ResourceDto(e.getId(), e.getName(), e.getCategory());
    }

    public static Resource toNewEntity(ResourceDto d) {
        return new Resource(d.name(), d.category());
    }

    public static void updateEntity(Resource e, ResourceDto d) {
        if (d.name() != null) e.setName(d.name());
        if (d.category() != null) e.setCategory(d.category());
    }
}
