package com.example.desafioQuality.models;

import com.example.desafioQuality.dtos.PropertyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
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

    public Property(PropertyRequest propertyRequest, District district){
        this.name = propertyRequest.getName();
        this.district = district;
        this.roomsList = propertyRequest.getRoomsList();
    }

    public double calculateTotalSquareMeters(){
        return roomsList.stream().mapToDouble(Room::getSquareMeters).sum();
    }

    public double calculateValue(){
        double totalSquareMeters = calculateTotalSquareMeters();

        return totalSquareMeters * district.getPricePerSquareMeter();
    }

    public Room getBiggestRoom(){
        return roomsList.stream().max(Comparator.comparing(Room::getSquareMeters)).get();
    }
}
