package com.example.desafioQuality.repository;

import com.example.desafioQuality.models.District;

public interface PropertyRepository {
    District findDistrictByName(String districtName);
}
