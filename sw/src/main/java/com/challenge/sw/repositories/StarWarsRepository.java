package com.challenge.sw.repositories;

import com.challenge.sw.domain.ApiResponse;
import com.challenge.sw.exceptions.InternalException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class StarWarsRepository {

    private WebClient client;

    public Mono<ApiResponse> getAllPeople(String page, String limit, String name) {
        return this.doGet("/people",
                "page", page,
                "limit", limit,
                "name", name
        );
    }
    public Mono<ApiResponse> getPeopleById(int id) {
        if (id <= 0) {
            throw new InternalException("id cannot be below 1", HttpStatus.BAD_REQUEST);
        }

        return this.doGet(String.format("/people/%d", id));
    }

    public Mono<ApiResponse> getAllFilms(String page, String limit, String title) {
        return this.doGet("/films",
                "page", page,
                "limit", limit,
                "title", title
        );
    }

    public Mono<ApiResponse> getFilmById(int id) {
        if (id <= 0) {
            throw new InternalException("id cannot be below 1", HttpStatus.BAD_REQUEST);
        }

        return this.doGet(String.format("/films/%d", id));
    }

    public Mono<ApiResponse> getAllStarships(String page, String limit, String name) {
        return this.doGet("/starships",
                "page", page,
                "limit", limit,
                "name", name
        );
    }

    public Mono<ApiResponse> getStarshipById(int id) {
        if (id <= 0) {
            throw new InternalException("id cannot be below 1", HttpStatus.BAD_REQUEST);
        }

        return this.doGet(String.format("/starships/%d", id));
    }

    public Mono<ApiResponse> getAllVehicles(String page, String limit, String name) {
        return this.doGet("/vehicles",
                "page", page,
                "limit", limit,
                "name", name
        );
    }

    public Mono<ApiResponse> getVehicleById(int id) {
        if (id <= 0) {
            throw new InternalException("id cannot be below 1", HttpStatus.BAD_REQUEST);
        }

        return this.doGet(String.format("/vehicles/%d", id));
    }

    private Mono<ApiResponse> doGet(String uri, String... filters) {
        return client
                .get()
                .uri(uri + this.getFilters(filters))
                .retrieve()
                .bodyToMono(ApiResponse.class);
    }

    private String getFilters(String... filters) {
        final String filtersFormat = "%s=%s";
        StringBuilder finalFilters = new StringBuilder("?");

        if (filters.length % 2 != 0 || filters.length < 2) {
            return finalFilters.toString();
        }

        finalFilters.append(String.format(filtersFormat, filters[0], filters[1]));

        for (var i = 2; i < filters.length; i += 2) {
            finalFilters.append("&").append(String.format(filtersFormat, filters[i], filters[i + 1]));
        }

       return finalFilters.toString();
    }
}
