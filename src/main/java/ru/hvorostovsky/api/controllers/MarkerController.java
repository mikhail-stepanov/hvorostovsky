package ru.hvorostovsky.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hvorostovsky.api.domain.dtos.MarkerDTO;
import ru.hvorostovsky.api.services.MarkerService;

import java.util.List;

@RestController
@RequestMapping("/v1/markers")
@RequiredArgsConstructor
public class MarkerController {

    private final MarkerService service;

    @GetMapping
    public List<MarkerDTO> getMarkers() {
        return service.getMarkers();
    }

    @GetMapping("/{id}")
    public MarkerDTO getMarker(@PathVariable long id) {
        return service.getMarker(id);
    }
}
