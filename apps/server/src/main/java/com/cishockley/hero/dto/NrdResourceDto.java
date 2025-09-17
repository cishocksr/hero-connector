package com.cishockley.hero.dto;

import java.util.List;

public record NrdResourceDto(
        String linkText,
        String linkUrl,
        String domain,
        String description,
        long id,
        boolean isPublic,
        boolean isGovernment,
        List<String> tags
) {}
