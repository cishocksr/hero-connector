package com.cishockley.hero.api;

import com.cishockley.hero.dto.ResourceDto;
import com.cishockley.hero.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    private final ResourceService service;
    public ResourceController(ResourceService service) { this.service = service; }

    @GetMapping
    public List<ResourceDto> list() {
        return service.list();
    }
}
