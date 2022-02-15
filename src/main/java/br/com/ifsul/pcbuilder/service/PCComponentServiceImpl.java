package br.com.ifsul.pcbuilder.service;

import br.com.ifsul.pcbuilder.dto.PCComponentCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.PCComponentSearchResponseDto;
import br.com.ifsul.pcbuilder.mapper.PCComponentMapper;
import br.com.ifsul.pcbuilder.model.Category;
import br.com.ifsul.pcbuilder.model.PCComponent;
import br.com.ifsul.pcbuilder.repository.PCComponentRepository;
import br.com.ifsul.pcbuilder.specification.PCComponentSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PCComponentServiceImpl implements PCComponentService {

    private final PCComponentRepository repository;

    private final PCComponentMapper mapper;

    @Override
    public void create(PCComponentCreationRequestDto requestDto) {
        repository.save(mapper.mapCreationToPCComponent(requestDto));
    }

    @Override
    public List<PCComponentSearchResponseDto> search(String brand, String model, String category) {
        final Specification<PCComponent> specification = PCComponentSpecification.getPCComponentsBySpecification(brand, model, category);
        return repository.findAll(specification).stream()
                .map(mapper::mapPCComponentToSearchDto)
                .collect(Collectors.toList());
    }
}
