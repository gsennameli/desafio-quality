package com.example.desafioQuality.unit.models;

import com.example.desafioQuality.models.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class RoomTest {
    Room room;
    @Test
    void shouldReturnRoomSize() {
        //given
        room = new Room("Quarto",2.0,5.0);

        //when
        double result = room.getSquareMeters();

        //then
        assertThat(result).isEqualTo(10.0);

    }
}