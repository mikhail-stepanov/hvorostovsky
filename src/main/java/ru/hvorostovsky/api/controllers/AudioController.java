package ru.hvorostovsky.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hvorostovsky.api.domain.dtos.AudioDTO;
import ru.hvorostovsky.api.services.AudioService;

@RestController
@RequestMapping("/v1/audios")
@RequiredArgsConstructor
public class AudioController {

    private final AudioService service;

    @GetMapping("/{id}")
    public AudioDTO getMarker(@PathVariable long id) {
        return service.getAudioById(id);
    }
}
