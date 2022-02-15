package br.com.ifsul.pcbuilder.dto;

import br.com.ifsul.pcbuilder.model.Category;
import br.com.ifsul.pcbuilder.model.Compatibility;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PCComponentCreationRequestDto {

    @NotNull
    @Size(max = 255)
    private String brand;

    @NotNull
    @Size(max = 255)
    private String model;

    @NotNull
    private Category category;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Compatibility compatibility;

}
