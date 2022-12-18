package ru.hvorostovsky.api.domain.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MarkerDTO {

    private Long id;

    private Integer order;

    private Double lat;

    private Double lng;

    private String description;

    private List<SpectacleDTO> spectacles;

}
