package br.com.ifsul.pcbuilder.dto;

import br.com.ifsul.pcbuilder.model.Category;
import br.com.ifsul.pcbuilder.model.Compatibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PCComponentSearchResponseDto {

    private Long id;

    private String brand;

    private String model;

    private Category category;

    private BigDecimal price;

    private Compatibility compatibility;

}
