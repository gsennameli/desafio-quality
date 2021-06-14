package com.example.desafioQuality.dtos.responses;

import com.example.desafioQuality.dtos.RoomDTO;
import com.example.desafioQuality.models.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SizesPerRoomResponse {
    List<RoomDTO> roomsList = new ArrayList<>();
}
