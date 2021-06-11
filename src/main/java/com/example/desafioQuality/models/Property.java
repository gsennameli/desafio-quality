package com.example.desafioQuality.models;

import com.example.desafioQuality.dtos.PropertyDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Property {

    private String name;

    @Valid
    private District district;

    @Valid
    private List<Room> roomsList = new ArrayList<>();

    public Property(PropertyDTO propertyDTO,District district){
        this.name = propertyDTO.getName();
        this.district = district;
        this.roomsList = propertyDTO.getRoomsList();
    }

    public double calculateTotalSquareMeters(){
        return roomsList.stream().mapToDouble(Room::getSquareMeters).sum();
    }

    public double calculateValue(){
        double totalSquareMeters = calculateTotalSquareMeters();

        return totalSquareMeters * district.getPricePerSquareMeter();
    }
}
