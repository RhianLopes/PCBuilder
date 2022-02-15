package br.com.ifsul.pcbuilder.service.pc;

import br.com.ifsul.pcbuilder.dto.PCBuildingRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;

import java.util.List;

public interface PCService {

    List<PCComponentSearchResponseDto> build(PCBuildingRequestDto requestDto);

}
