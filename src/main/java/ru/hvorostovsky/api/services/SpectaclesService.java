package ru.hvorostovsky.api.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.hvorostovsky.api.domain.dtos.*;
import ru.hvorostovsky.api.domain.entities.Spectacle;
import ru.hvorostovsky.api.repositories.SpectaclesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpectaclesService {

    private final ModelMapper modelMapper;

    private final SpectaclesRepository repository;

    public List<SpectacleDTO> getSpectacles() {
        if (repository.count() == 0L) {
            return new ArrayList<>();
        }
        return repository.findAll().stream().map(this::assembly).collect(Collectors.toList());
    }

    private SpectacleDTO assembly(Spectacle spectacle) {

        List<MarkerDTO> markers = new ArrayList<>();
        spectacle.getMarkers().forEach(marker -> markers.add(modelMapper.map(marker, MarkerDTO.class)));

        List<PhotoDTO> photos = new ArrayList<>();
        spectacle.getPhotos().forEach(photo -> photos.add(modelMapper.map(photo, PhotoDTO.class)));

        List<VideoDTO> videos = new ArrayList<>();
        spectacle.getVideos().forEach(video -> videos.add(modelMapper.map(video, VideoDTO.class)));

        List<AudioDTO> audios = new ArrayList<>();
        spectacle.getAudios().forEach(audio -> audios.add(modelMapper.map(audio, AudioDTO.class)));

        MediaDTO media = MediaDTO.builder()
                .photos(photos)
                .audios(audios)
                .videos(videos)
                .build();

        InfoDTO info = InfoDTO.builder()
                .country(spectacle.getCountry())
                .city(spectacle.getCity())
                .place(spectacle.getPlace())
                .address(spectacle.getAddress())
                .description(spectacle.getDescription())
                .year(spectacle.getYear())
                .build();

        return SpectacleDTO.builder()
                .id(spectacle.getId())
                .staticId(spectacle.getStaticId())
                .name(spectacle.getName())
                .subject(spectacle.getSubject())
                .info(info)
                .markers(markers)
                .media(media)
                .build();
    }
}
