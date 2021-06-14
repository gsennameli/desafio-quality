package com.example.desafioQuality.dtos;

import com.example.desafioQuality.models.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {
    private String name;
    private double size;

    public RoomDTO(Room room){
        this.name = room.getName();
        this.size = room.getSquareMeters();
    }
}
