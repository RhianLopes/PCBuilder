package br.com.ifsul.pcbuilder.service;

import br.com.ifsul.pcbuilder.dto.PCComponentCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;
import br.com.ifsul.pcbuilder.model.Category;

import java.util.List;

public interface PCComponentService {

    void create(PCComponentCreationRequestDto requestDto);

    List<PCComponentSearchResponseDto> search(String brand, String model, String category);

}
