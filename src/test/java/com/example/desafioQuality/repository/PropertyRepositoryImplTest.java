package com.example.desafioQuality.repository;

import com.example.desafioQuality.aux.AllDistricts;
import com.example.desafioQuality.models.District;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PropertyRepositoryImplTest {
    @Autowired
    PropertyRepositoryImpl propertyRepository;

    @Test
    void shouldReturnDistrict() {
        //when
        District result = propertyRepository.findDistrictByName("Itaquera");

        //then
        District expected = new District("Itaquera",2.0);
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @Disabled
    void shouldReturnException(){

    }
}