package com.omergundogdu.codexist_nearby_place_nextjs_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceDTO {
    private String name;
    private double longitude;
    private double latitude;
    private double radius;
}
