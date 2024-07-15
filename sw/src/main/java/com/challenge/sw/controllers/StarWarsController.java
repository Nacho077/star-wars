package com.challenge.sw.controllers;

import com.challenge.sw.domain.ApiResponse;
import com.challenge.sw.service.StarWarsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/star-wars")
@AllArgsConstructor
public class StarWarsController {

    private StarWarsService service;

    @GetMapping("/people")
    public Mono<ApiResponse> getPeople(
            @RequestParam(name = "page", required = false, defaultValue = "1") String page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") String limit,
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "id", required = false, defaultValue = "0") int id
    ) {
        return service.getPeople(page, limit, name, id);
    }

    @GetMapping("/films")
    public Mono<ApiResponse> getFilms(
            @RequestParam(name = "page", required = false, defaultValue = "1") String page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") String limit,
            @RequestParam(name = "name", required = false, defaultValue = "") String title,
            @RequestParam(name = "id", required = false, defaultValue = "0") int id
    ) {
        return service.getFilms(page, limit, title, id);
    }

    @GetMapping("/starships")
    public Mono<ApiResponse> getAllStarships(
            @RequestParam(name = "page", required = false, defaultValue = "1") String page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") String limit,
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "id", required = false, defaultValue = "0") int id
    ) {
        return service.getStarships(page, limit, name, id);
    }

    @GetMapping("/vehicles")
    public Mono<ApiResponse> getAllVechicles(
            @RequestParam(name = "page", required = false, defaultValue = "1") String page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") String limit,
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "id", required = false, defaultValue = "0") int id
    ) {
        return service.getVechicles(page, limit, name, id);
    }
}
