package br.com.ifsul.pcbuilder.mapper;

import br.com.ifsul.pcbuilder.dto.PCComponentCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;
import br.com.ifsul.pcbuilder.model.PCComponent;
import org.springframework.stereotype.Component;

@Component
public class PCComponentMapper {

    public PCComponent mapCreationToPCComponent(PCComponentCreationRequestDto requestDto) {
        return PCComponent.builder()
                .brand(requestDto.getBrand())
                .category(requestDto.getCategory())
                .compatibility(requestDto.getCompatibility())
                .model(requestDto.getModel())
                .price(requestDto.getPrice())
                .build();
    }

    public PCComponentSearchResponseDto mapPCComponentToSearchDto(PCComponent pcComponent) {
        return PCComponentSearchResponseDto.builder()
                .id(pcComponent.getId())
                .brand(pcComponent.getBrand())
                .category(pcComponent.getCategory())
                .compatibility(pcComponent.getCompatibility())
                .model(pcComponent.getModel())
                .price(pcComponent.getPrice())
                .build();
    }
}
