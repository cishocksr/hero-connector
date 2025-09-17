package com.cishockley.hero.client.nrd;

import com.cishockley.hero.dto.NrdResourceDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
public class NrdWebClient implements NrdClient {

    private static final String BASE = "https://nrd.gov/NRDRestService/search/common";
    private final WebClient http;

    public NrdWebClient(WebClient.Builder builder) {
        this.http = builder.build();
    }

    private String norm(String s) {
        return s.replace("&", "-").replaceAll("\\s+", "-");
    }
    private String join(List<String> vals) {
        return String.join(",", vals.stream().map(this::norm).toList());
    }

    @Override
    public Mono<List<NrdResourceDto>> search(
            Optional<String> term,
            List<String> categories,
            List<String> communities,
            List<String> types,
            List<String> audiences) {

        var uriBuilder = UriComponentsBuilder.fromHttpUrl(BASE);
        term.filter(t -> !t.isBlank()).ifPresent(t -> uriBuilder.queryParam("term", t));
        if (!categories.isEmpty())  uriBuilder.queryParam("Categories",  join(categories));
        if (!communities.isEmpty()) uriBuilder.queryParam("Communities", join(communities));
        if (!types.isEmpty())       uriBuilder.queryParam("Types",       join(types));
        if (!audiences.isEmpty())   uriBuilder.queryParam("Audiences",   join(audiences));

        return http.get()
                .uri(uriBuilder.build(true).toUri())
                .retrieve()
                .bodyToFlux(NrdResourceDto.class)
                .collectList();
    }
}
