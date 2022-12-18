package ru.hvorostovsky.api.domain.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AudioDTO {

    private Long id;

    private String url;
}
