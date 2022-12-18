package ru.hvorostovsky.api.domain.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpectacleDTO {

    private Long id;

    private String staticId;

    private String name;

    private String subject;

    private InfoDTO info;

    private MediaDTO media;
}
