package com.example.desafioQuality.dtos.responses;

import com.example.desafioQuality.models.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SizesPerRoomResponse {
    private String name;
    private double size;

    public SizesPerRoomResponse(Room room){
        this.name = room.getName();
        this.size = room.getSquareMeters();
    }
}
