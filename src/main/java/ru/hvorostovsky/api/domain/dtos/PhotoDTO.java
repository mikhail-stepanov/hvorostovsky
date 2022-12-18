package ru.hvorostovsky.api.domain.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhotoDTO {

    private Long id;

    private String url;
}
