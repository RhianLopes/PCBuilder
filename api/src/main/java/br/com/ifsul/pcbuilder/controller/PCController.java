package br.com.ifsul.pcbuilder.controller;

import br.com.ifsul.pcbuilder.dto.PCBuildingRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;
import br.com.ifsul.pcbuilder.service.pc.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pc")
@RequiredArgsConstructor
public class PCController {

    private final PCService service;

    @PostMapping("/build")
    public List<PCComponentSearchResponseDto> build(@RequestBody PCBuildingRequestDto requestDto) {
        return service.build(requestDto);
    }
}
