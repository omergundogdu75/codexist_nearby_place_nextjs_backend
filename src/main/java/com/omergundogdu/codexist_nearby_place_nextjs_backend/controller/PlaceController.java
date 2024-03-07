package com.omergundogdu.codexist_nearby_place_nextjs_backend.controller;

import com.omergundogdu.codexist_nearby_place_nextjs_backend.entities.Place;
import com.omergundogdu.codexist_nearby_place_nextjs_backend.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService service;

    @GetMapping("place")
    public String getPlace(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radius) {
        return service.findPlaces(latitude, longitude, radius);
    }

    @GetMapping("/places")
    public List<Place> getPlaces(@RequestParam double longitude, @RequestParam double latitude, @RequestParam double radius) {
        // Burada Google Places API ile entegrasyon yapılacak ve sonuçlar döndürülecek
        // Eğer veritabanında bu koordinatlar için bir kayıt varsa, Google Places API'ye istek yapmadan doğrudan veritabanından sonuçları döndür
        return null;
    }
}