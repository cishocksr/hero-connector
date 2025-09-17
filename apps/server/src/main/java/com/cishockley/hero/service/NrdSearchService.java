package com.cishockley.hero.service;

import com.cishockley.hero.client.nrd.NrdClient;
import com.cishockley.hero.dto.NrdResourceDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class NrdSearchService {
    private final NrdClient client;
    public NrdSearchService(NrdClient client) { this.client = client; }

    public Mono<List<NrdResourceDto>> search(
            String term,
            List<String> categories,
            List<String> communities,
            List<String> types,
            List<String> audiences
    ) {
        // add any app-specific rules, caching, auditing, etc. here
        return client.search(Optional.ofNullable(term), categories, communities, types, audiences);
    }
}
