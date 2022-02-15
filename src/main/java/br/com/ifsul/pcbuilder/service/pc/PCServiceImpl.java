package br.com.ifsul.pcbuilder.service.pc;

import br.com.ifsul.pcbuilder.dto.PCBuildingRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;
import br.com.ifsul.pcbuilder.service.pccomponent.PCComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PCServiceImpl implements PCService {

    private final PCComponentService pcComponentService;

    @Override
    public List<PCComponentSearchResponseDto> build(PCBuildingRequestDto requestDto) {
        return pcComponentService.searchByCompatibility(requestDto.getCompatibility());
    }
}
