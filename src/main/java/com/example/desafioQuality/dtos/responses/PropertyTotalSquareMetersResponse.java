package com.example.desafioQuality.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropertyTotalSquareMetersResponse {
    private String prop_name;
    private double totalSquareMeters;
}
