package ru.hvorostovsky.api.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.hvorostovsky.api.domain.dtos.*;
import ru.hvorostovsky.api.domain.entities.Marker;
import ru.hvorostovsky.api.repositories.MarkerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarkerService {

    private final ModelMapper modelMapper;

    private final MarkerRepository repository;

    public List<MarkerDTO> getMarkers(boolean audio) {
        if (repository.count() == 0L) {
            return new ArrayList<>();
        }
        if (audio) {
            return repository.findAllByAudios().stream().map(this::assembly).collect(Collectors.toList());
        } else {
            return repository.findAllByNotAudios().stream().map(this::assembly).collect(Collectors.toList());
        }
    }

    public MarkerDTO getMarker(Long id) {
        return repository.findById(id).map(this::assembly).orElse(null);
    }

    private MarkerDTO assembly(Marker marker) {

        List<SpectacleDTO> spectacles = new ArrayList<>();
        marker.getSpectacles().forEach(spectacle -> {
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
            spectacles.add(SpectacleDTO.builder()
                    .id(spectacle.getId())
                    .staticId(spectacle.getStaticId())
                    .name(spectacle.getName())
                    .subject(spectacle.getSubject())
                    .info(info)
                    .media(media)
                    .build());
        });

        return MarkerDTO.builder()
                .id(marker.getId())
                .description(marker.getDescription())
                .order(marker.getOrder())
                .lat(marker.getLat())
                .lng(marker.getLng())
                .spectacles(spectacles)
                .build();
    }
}
