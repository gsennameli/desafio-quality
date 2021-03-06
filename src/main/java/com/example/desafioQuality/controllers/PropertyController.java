package com.example.desafioQuality.controllers;

import com.example.desafioQuality.dtos.PropertyRequest;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.services.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/house")
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping("/size")
    public ResponseEntity getPropertySize(@Valid @RequestBody PropertyRequest propertyRequest){
        return new ResponseEntity(propertyService.getTotalSquareMeters(propertyRequest), HttpStatus.OK);
    }

    @PostMapping("/value")
    public ResponseEntity getPropertyValue(@Valid @RequestBody PropertyRequest propertyRequest){
        return new ResponseEntity(propertyService.getPropertyValue(propertyRequest),HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity getBiggestRoom(@Valid @RequestBody PropertyRequest propertyRequest){
        return new ResponseEntity(propertyService.getBiggestRoom(propertyRequest),HttpStatus.OK);
    }

    @PostMapping("rooms/sizes")
    public ResponseEntity getSizesPerRoom(@Valid @RequestBody PropertyRequest propertyRequest){
        return new ResponseEntity(propertyService.getSizesPerRoom(propertyRequest),HttpStatus.OK);
    }
}
