package com.cishockley.hero.api;

import com.cishockley.hero.dto.NrdResourceDto;
import com.cishockley.hero.service.NrdSearchService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/nrd")
public class NrdController {
    private final NrdSearchService service;
    public NrdController(NrdSearchService service) { this.service = service; }

    @GetMapping("/search")
    public Mono<List<NrdResourceDto>> search(
            @RequestParam(required = false) String term,
            @RequestParam(required = false, name = "Categories") List<String> categories,
            @RequestParam(required = false, name = "Communities") List<String> communities,
            @RequestParam(required = false, name = "Types") List<String> types,
            @RequestParam(required = false, name = "Audiences") List<String> audiences
    ) {
        return service.search(
                term,
                categories == null ? List.of() : categories,
                communities == null ? List.of() : communities,
                types == null ? List.of() : types,
                audiences == null ? List.of() : audiences
        );
    }
}
