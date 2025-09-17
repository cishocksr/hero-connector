package com.cishockley.hero.client.nrd;

import com.cishockley.hero.dto.NrdResourceDto;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface NrdClient {
    Mono<List<NrdResourceDto>> search(
            Optional<String> term,
            List<String> categories,
            List<String> communities,
            List<String> types,
            List<String> audiences
    );
}
