package ru.hvorostovsky.api.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.hvorostovsky.api.domain.dtos.AudioDTO;
import ru.hvorostovsky.api.repositories.AudioRepository;

@Service
@RequiredArgsConstructor
public class AudioService {

    private final ModelMapper modelMapper;

    private final AudioRepository repository;

    public AudioDTO getAudioById(long id) {
        if (repository.count() == 0L) {
            return null;
        }
        return modelMapper.map(repository.findById(id), AudioDTO.class);
    }
}
