package com.example.desafioQuality.repository;

import com.example.desafioQuality.aux.AllDistricts;
import com.example.desafioQuality.models.District;
import org.springframework.stereotype.Repository;

import java.util.Locale;
import java.util.NoSuchElementException;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository {

    @Override
    public District findDistrictByName(String districtName) {
        try{
            District propDistrict = AllDistricts.districtsList.stream()
                    .filter(district -> district.getName()
                            .equalsIgnoreCase(districtName))
                    .findAny().get();
            return propDistrict;
        }catch (NoSuchElementException ex){
            throw new NoSuchElementException("Bairro não encontrado");
        }

    }
}
