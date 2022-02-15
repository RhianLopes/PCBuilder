package br.com.ifsul.pcbuilder.service.pc;

import br.com.ifsul.pcbuilder.dto.PCBuildingRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;
import br.com.ifsul.pcbuilder.model.Category;
import br.com.ifsul.pcbuilder.service.pccomponent.PCComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PCServiceImpl implements PCService {

    private final PCComponentService pcComponentService;

    @Override
    public List<PCComponentSearchResponseDto> build(PCBuildingRequestDto requestDto) {
        final List<PCComponentSearchResponseDto> filteredComponents = pcComponentService.searchByCompatibility(requestDto.getCompatibility());
        final List<PCComponentSearchResponseDto> recommendedComponents = new ArrayList<>();
        Arrays.asList(Category.values())
            .forEach(category -> recommendedComponents.add(findFirstComponentsByCategoryAndOrderByPriceDesc(filteredComponents, category))
        );
        return recommendedComponents;
    }

    private PCComponentSearchResponseDto findFirstComponentsByCategoryAndOrderByPriceDesc(List<PCComponentSearchResponseDto> components, Category category) {
        return components.stream()
                .filter(component -> category.equals(component.getCategory())).min(Comparator.comparing(PCComponentSearchResponseDto::getPrice))
                .orElse(null);
    }
}
