package br.com.ifsul.pcbuilder.service.pccomponent;

import br.com.ifsul.pcbuilder.dto.PCComponentCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;
import br.com.ifsul.pcbuilder.model.Compatibility;

import java.util.List;

public interface PCComponentService {

    void create(PCComponentCreationRequestDto requestDto);

    List<PCComponentSearchResponseDto> search(String brand, String model, String category);

    List<PCComponentSearchResponseDto> searchByCompatibility(Compatibility compatibility);

}
