package com.challenge.sw.service;

import com.challenge.sw.domain.ApiResponse;
import com.challenge.sw.repositories.StarWarsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StarWarsService {

     private StarWarsRepository repository;

     public Mono<ApiResponse> getPeople(String page, String limit, String name, int id) {
          if (id > 0) {
               return repository.getPeopleById(id);
          }

          return repository.getAllPeople(page, limit, name);
     }

     public Mono<ApiResponse> getFilms(String page, String limit, String title, int id) {
          if (id > 0) {
               return repository.getFilmById(id);
          }

          return repository.getAllFilms(page, limit, title);
     }

     public Mono<ApiResponse> getStarships(String page, String limit, String name, int id) {
          if (id > 0) {
               return repository.getStarshipById(id);
          }

          return repository.getAllStarships(page, limit, name);
     }

     public Mono<ApiResponse> getVechicles(String page, String limit, String name, int id) {
          if (id > 0) {
               return repository.getVehicleById(id);
          }

          return repository.getAllVehicles(page, limit, name);
     }
}
