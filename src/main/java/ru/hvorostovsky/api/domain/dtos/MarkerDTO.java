package ru.hvorostovsky.api.domain.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarkerDTO {

    private Integer order;

    private Double lat;

    private Double lng;
}
