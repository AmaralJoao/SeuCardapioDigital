package com.amaral.SeuCardapioDigital.Mapper;

import com.amaral.SeuCardapioDigital.Dto.Request.EstabelecimentoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.EstabelecimentoResponseDto;
import com.amaral.SeuCardapioDigital.Model.EstabelecimentoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EstabelecimentoMapper {

    EstabelecimentoMapper INSTANCE = Mappers.getMapper(EstabelecimentoMapper.class);

    EstabelecimentoModel requestToModel(EstabelecimentoRequestDto dto);

    EstabelecimentoResponseDto toDto(EstabelecimentoModel model);

    void updateModelFromDto(EstabelecimentoRequestDto dto, @MappingTarget EstabelecimentoModel model);

}
