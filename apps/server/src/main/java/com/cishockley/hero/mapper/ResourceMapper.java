package com.cishockley.hero.mapper;

import com.cishockley.hero.dto.ResourceDto;
import com.cishockley.hero.model.Resource;

public final class ResourceMapper {
    private ResourceMapper() {}

    public static ResourceDto toDto(Resource e) {
        return new ResourceDto(e.getId(), e.getName(), e.getCategory());
    }

    /** For POST /api/resources (new entity; do NOT set id) */
    public static Resource toNewEntity(ResourceDto d) {
        Resource e = new Resource();
        e.setName(d.name());
        e.setCategory(d.category());
        return e;
    }

    /** For PUT/PATCH /api/resources/{id} (update existing entity) */
    public static void updateEntity(Resource e, ResourceDto d) {
        if (d.name() != null) e.setName(d.name());
        if (d.category() != null) e.setCategory(d.category());
    }
}
