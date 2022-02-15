package br.com.ifsul.pcbuilder.dto;

import br.com.ifsul.pcbuilder.model.Compatibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PCBuildingRequestDto {

    @NotNull
    private Compatibility compatibility;

}
