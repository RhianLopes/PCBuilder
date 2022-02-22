package br.com.ifsul.pcbuilder.controller;

import br.com.ifsul.pcbuilder.dto.PCComponentCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;
import br.com.ifsul.pcbuilder.service.pccomponent.PCComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/components")
@RequiredArgsConstructor
public class PCComponentController {

    private final PCComponentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid PCComponentCreationRequestDto requestDto) {
        service.create(requestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PCComponentSearchResponseDto> search(@RequestParam(value = "brand", required = false) @Size(max = 255) String brand,
                                                     @RequestParam(value = "model", required = false) @Size(max = 255) String model,
                                                     @RequestParam(value = "category", required = false) @Size(max = 255) String category) {
        return service.search(brand, model, category);
    }
}
