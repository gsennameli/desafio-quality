package com.example.desafioQuality.dtos;

import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropertyRequest {
    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Size(max = 30,message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "[A-Z][a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\\s]*",message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String name;

    @NotNull(message = "O bairro não pode estar vazio.")
    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(max = 45,message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;

    @Valid
    private List<Room> roomsList;
}
