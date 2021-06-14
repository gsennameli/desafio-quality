package com.example.desafioQuality.integration;


import com.example.desafioQuality.dtos.PropertyRequest;
import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.models.Room;
import com.example.desafioQuality.services.PropertyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

    private static final double HOUSE_SIZE = 76.0;
    private static final String HOUSE_NAME = "Casa";
    private static final double HOUSE_VALUE = 304.0;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ObjectMapper objectMapper;

    static PropertyRequest propertyRequest;
    static Room kitchen;
    static Room bedroom;
    static Room bathroom;

    @BeforeAll
    public static void setup(){
        propertyRequest = new PropertyRequest();
        propertyRequest.setName(HOUSE_NAME);
        kitchen = new Room("Cozinha",5.0,10.0);
        bedroom = new Room("Quarto",4.0,4.0);
        bathroom = new Room("Banheiro",2.0,5.0);

        propertyRequest.setProp_district("Carrao");
        propertyRequest.setRoomsList(
                List.of(
                        kitchen,
                        bedroom,
                        bathroom
                ));
    }

    @Test
    public void getPropertySize() throws Exception {
        this.mockMvc.perform(post("/house/size")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(propertyRequest)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.prop_name").value(this.HOUSE_NAME))
                .andExpect(jsonPath("$.totalSquareMeters").value(this.HOUSE_SIZE));
    }

    @Test
    public void getPropertyValue() throws Exception{
        this.mockMvc.perform(post("/house/value")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(propertyRequest)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.prop_name").value(this.HOUSE_NAME))
                .andExpect(jsonPath("$.value").value(this.HOUSE_VALUE));
    }

    @Test
    public void getBiggestRoom() throws Exception {
        this.mockMvc.perform(post("/house/biggestRoom")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(propertyRequest)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Cozinha"))
                .andExpect(jsonPath("$.length").value(5.0))
                .andExpect(jsonPath("$.width").value(10.0))
                .andExpect(jsonPath("$.squareMeters").value(50.0));
    }

    @Test
    public void getSizesPerRoom() throws Exception {
        this.mockMvc.perform(post("/house/rooms/sizes")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(propertyRequest)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.roomsList").isArray())
                .andExpect(jsonPath("$.roomsList[0].name").value("Cozinha"))
                .andExpect(jsonPath("$.roomsList[0].size").value(50.0))
                .andExpect(jsonPath("$.roomsList[1].name").value("Quarto"))
                .andExpect(jsonPath("$.roomsList[1].size").value(16.0))
                .andExpect(jsonPath("$.roomsList[2].name").value("Banheiro"))
                .andExpect(jsonPath("$.roomsList[2].size").value(10.0));
    }

}
