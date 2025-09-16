package com.cishockley.hero.service;

import com.cishockley.hero.dto.ResourceDto;
import com.cishockley.hero.mapper.ResourceMapper;
import com.cishockley.hero.model.Resource;
import com.cishockley.hero.repo.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepository repo;
    public ResourceService(ResourceRepository repo) { this.repo = repo;}

    public List<ResourceDto> list() {
        return repo.findAll().stream().map(ResourceMapper::toDto).toList();
    }
}
