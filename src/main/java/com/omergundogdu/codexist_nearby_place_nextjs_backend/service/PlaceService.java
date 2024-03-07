package com.omergundogdu.codexist_nearby_place_nextjs_backend.service;

import com.omergundogdu.codexist_nearby_place_nextjs_backend.dto.PlaceDTO;
import com.omergundogdu.codexist_nearby_place_nextjs_backend.entities.Place;
import com.omergundogdu.codexist_nearby_place_nextjs_backend.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repository;
    private final RestTemplate restTemplate;

    @Value("${google.places.api.key}")
    private String apiKey;

    public String findPlaces(double latitude, double longitude, double radius) {
        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/place/nearbysearch/json")
                .queryParam("location", latitude + "," + longitude)
                .queryParam("radius", radius)
                .queryParam("key", apiKey)
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }

    public Place getById(Long id){
        return repository.findById(id).orElse(null);
    }
    public List<Place> getAll(){
        return repository.findAll();
    }
    public Place add(PlaceDTO placeDTO){
        Place data = Place.builder()
                .name(placeDTO.getName())
                .latitude(placeDTO.getLatitude())
                .longitude(placeDTO.getLongitude())
                .radius(placeDTO.getRadius())
                .build();
       return repository.save(data);
    }

    public Place update(Long id,PlaceDTO placeDTO){

        Place data = getById(id);
        data.setName(placeDTO.getName());
        data.setLatitude(placeDTO.getLatitude());
        data.setLongitude(placeDTO.getLongitude());
        data.setRadius(placeDTO.getRadius());

        return repository.save(data);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
}
