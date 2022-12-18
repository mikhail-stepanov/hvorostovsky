package ru.hvorostovsky.api.domain.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SpectacleDTO {

    private long id;

    private String staticId;

    private String name;

    private String subject;

    private List<MarkerDTO> markers;

    private InfoDTO info;

    private MediaDTO media;
}
