package com.example.desafioQuality.unit.models;

import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.models.Room;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PropertyTest {
    Property property;

    @BeforeEach
    void setup(){
        property = new Property();
        Room kitchen = new Room("Cozinha",5.0,10.0);
        Room bedroom = new Room("Quarto",4.0,4.0);
        Room bathroom = new Room("Banheiro",2.0,5.0);

        property.setDistrict(new District("Carrao",5.0));
        property.setRoomsList(
                List.of(
                        kitchen,
                        bedroom,
                        bathroom
        ));
    }

    @Test
    void shouldReturnPropertySize() {
        //when
        double result = property.calculateTotalSquareMeters();

        //then
        assertThat(result).isEqualTo(76.0);
    }

    @Test
    void shouldReturnPropertyValue() {
        //when
        double result = property.calculateValue();

        //then
        assertThat(result).isEqualTo(380.0);
    }

    @Test
    void shouldReturnBiggestRoom() {
        //when
        Room result = property.getBiggestRoom();

        //then
        Room expected = new Room("Cozinha",5.0,10);
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

}