package com.example.desafioQuality.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class District {
    private String name;
    private Double pricePerSquareMeter;
}
