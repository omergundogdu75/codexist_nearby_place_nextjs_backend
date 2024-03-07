package com.omergundogdu.codexist_nearby_place_nextjs_backend.repository;

import com.omergundogdu.codexist_nearby_place_nextjs_backend.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}