package com.example.desafioQuality.aux;

import com.example.desafioQuality.models.District;

import java.util.List;

public class AllDistricts {
    public static List<District> districtsList = List.of(
            new District("Itaquera",2.0),
            new District("Tatuape",3.0),
            new District("Carrao",4.0)
    );
}
