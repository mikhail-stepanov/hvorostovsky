package ru.hvorostovsky.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hvorostovsky.api.domain.dtos.MarkerDTO;
import ru.hvorostovsky.api.services.MarkerService;

import java.util.List;

@RestController
@RequestMapping("/v1/markers")
@RequiredArgsConstructor
public class MarkerController {

    private final MarkerService service;

    @GetMapping
    public List<MarkerDTO> getMarkers(
            @RequestParam(name = "audio", required = false, defaultValue = "false") boolean audio
    ) {
        return service.getMarkers(audio);
    }

    @GetMapping("/{id}")
    public MarkerDTO getMarker(
            @PathVariable long id
    ) {
        return service.getMarker(id);
    }
}
