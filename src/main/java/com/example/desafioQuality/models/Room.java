package com.example.desafioQuality.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @NotNull(message = "O campo não pode estar vazio.")
    @NotBlank(message = "O campo não pode estar vazio.")
    @Size(max = 30,message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    @Pattern(regexp = "[A-Z][a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\\s]*",message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String name;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33,message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private double length;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25,message = "A largura máxima permitida por cômodo é de 25 metros")
    private double width;

    public double getSquareMeters(){
        return width*length;
    }
}
