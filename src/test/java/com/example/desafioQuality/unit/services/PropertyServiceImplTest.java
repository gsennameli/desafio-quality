package com.example.desafioQuality.unit.services;

import com.example.desafioQuality.dtos.PropertyRequest;
import com.example.desafioQuality.dtos.responses.SizesPerRoomResponse;
import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.models.Room;
import com.example.desafioQuality.repository.PropertyRepositoryImpl;
import com.example.desafioQuality.services.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PropertyServiceImplTest {
    //TODO Talvez testar os métodos do service principalmente getSizerPerRoom

    @Mock
    PropertyRepositoryImpl propertyRepository;

    @Mock
    PropertyService propertyService;

    PropertyRequest propertyRequest;

    @BeforeEach
    void setup(){

        Room kitchen = new Room("Cozinha",5.0,10.0);
        Room bedroom = new Room("Quarto",4.0,4.0);
        Room bathroom = new Room("Banheiro",2.0,5.0);


        List<Room> roomList = List.of(kitchen, bedroom, bathroom);

        PropertyRequest propertyRequest = new PropertyRequest();
        propertyRequest.setName("Casa");
        propertyRequest.setRoomsList(roomList);
        propertyRequest.setProp_district("Carrao");
    }

    @Test
    @Disabled
    void getSizesPerRoom() {
//        //given
//        List<SizesPerRoomResponse> expected = List.of(
//                new SizesPerRoomResponse("Cozinha",50.0),
//                new SizesPerRoomResponse("Quarto",16.0),
//                new SizesPerRoomResponse("Banheiro",10.0)
//        );
//        //when(propertyService.getPropertyByPropertyRequest(propertyRequest)).thenReturn();
//        //when
//        List<SizesPerRoomResponse> result = propertyService.getSizesPerRoom(propertyRequest);
//
//        //then
//        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @Disabled
    void getPropertyByPropertyRequest() {
        //given
        propertyRequest.setProp_district("Monteiro");

        //when

    }
}