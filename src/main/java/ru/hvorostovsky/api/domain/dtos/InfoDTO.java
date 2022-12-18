package ru.hvorostovsky.api.domain.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfoDTO {

    private String country;

    private String city;

    private String place;

    private String address;

    private String description;

    private String year;

}
