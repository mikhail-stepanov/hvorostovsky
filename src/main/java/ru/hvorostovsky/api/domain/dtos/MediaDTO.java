package ru.hvorostovsky.api.domain.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MediaDTO {

    private List<PhotoDTO> photos;

    private List<VideoDTO> videos;

    private List<AudioDTO> audios;

}
