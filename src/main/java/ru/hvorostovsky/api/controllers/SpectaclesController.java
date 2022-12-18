package ru.hvorostovsky.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hvorostovsky.api.domain.dtos.SpectacleDTO;
import ru.hvorostovsky.api.services.SpectaclesService;

import java.util.List;

@RestController
@RequestMapping("/v1/spectacles")
@RequiredArgsConstructor
public class SpectaclesController {

    private final SpectaclesService service;

    @GetMapping
    public List<SpectacleDTO> getSpectacles() {
        return service.getSpectacles();
    }
}
