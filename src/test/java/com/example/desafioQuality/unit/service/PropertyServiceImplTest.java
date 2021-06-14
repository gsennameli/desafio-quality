package com.example.desafioQuality.unit.service;

import com.example.desafioQuality.dtos.PropertyRequest;
import com.example.desafioQuality.dtos.RoomDTO;
import com.example.desafioQuality.dtos.responses.SizesPerRoomResponse;
import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.models.Room;
import com.example.desafioQuality.repository.PropertyRepositoryImpl;
import com.example.desafioQuality.services.PropertyService;
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
    void shouldReturnProperty() {

        when(propertyService.getPropertyByPropertyRequest(propertyRequest)).thenCallRealMethod();
        //when
        Property result = propertyService.getPropertyByPropertyRequest(propertyRequest);

        assertThat(result.getName()).isEqualTo(propertyRequest.getName());
        assertThat(result.getRoomsList()).usingRecursiveComparison().isEqualTo(propertyExist.getRoomsList());
        assertThat(result.getDistrict().getName()).isEqualTo(propertyRequest.getProp_district());

    }
}