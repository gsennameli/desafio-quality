package com.example.desafioQuality.unit.service;

import com.example.desafioQuality.dtos.PropertyRequest;
import com.example.desafioQuality.dtos.RoomDTO;
import com.example.desafioQuality.dtos.responses.SizesPerRoomResponse;
import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.models.Room;
import com.example.desafioQuality.repository.PropertyRepositoryImpl;
import com.example.desafioQuality.services.PropertyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PropertyServiceImplTest {

    @Mock
    PropertyRepositoryImpl propertyRepository;

    @Spy
    @InjectMocks
    PropertyServiceImpl propertyService;

    @Mock
    PropertyRequest propertyRequest;

    private List<Room> roomList;
    private Room kitchen;
    private Room bathroom;
    private Room bedroom;
    private Property propertyExist;

    @BeforeEach
    void setup(){

        kitchen = new Room("Cozinha",5.0,10.0);
        bedroom = new Room("Quarto",4.0,4.0);
        bathroom = new Room("Banheiro",2.0,5.0);

        roomList = List.of(kitchen, bedroom, bathroom);

        propertyRequest = new PropertyRequest();
        propertyRequest.setName("Casa");
        propertyRequest.setRoomsList(roomList);
        propertyRequest.setProp_district("Carrao");

        propertyExist = new Property(propertyRequest,new District("Carrao",4D));
    }

    @Test
    void shouldReturnSizeOfRooms() {
        //given
        SizesPerRoomResponse sizesPerRoomResponse = new SizesPerRoomResponse();
        sizesPerRoomResponse.setRoomsList(List.of(
                new RoomDTO(kitchen),
                new RoomDTO(bedroom),
                new RoomDTO(bathroom)
        ));
        District carraoDistrict = new District("Carrao",4D);
        Property property = new Property(propertyRequest,carraoDistrict);

        doReturn(property).when(propertyService).getPropertyByPropertyRequest(propertyRequest);

        //when
        SizesPerRoomResponse result = propertyService.getSizesPerRoom(propertyRequest);

        //then
        assertThat(result.getRoomsList().get(0)).usingRecursiveComparison().isEqualTo(sizesPerRoomResponse.getRoomsList().get(0));
        assertThat(result.getRoomsList().get(1)).usingRecursiveComparison().isEqualTo(sizesPerRoomResponse.getRoomsList().get(1));
        assertThat(result.getRoomsList().get(2)).usingRecursiveComparison().isEqualTo(sizesPerRoomResponse.getRoomsList().get(2));
    }

    @Test
    void shouldReturnProperty() {

        when(propertyService.getPropertyByPropertyRequest(propertyRequest)).thenCallRealMethod();
        //when
        Property result = propertyService.getPropertyByPropertyRequest(propertyRequest);

        //then
        assertThat(result.getName()).isEqualTo(propertyRequest.getName());
        assertThat(result.getRoomsList()).usingRecursiveComparison().isEqualTo(propertyExist.getRoomsList());
        assertThat(result.getDistrict().getName()).isEqualTo(propertyRequest.getProp_district());
    }

}