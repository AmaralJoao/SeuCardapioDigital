package com.amaral.SeuCardapioDigital.Mapper;

import com.amaral.SeuCardapioDigital.Dto.Request.ProdutoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.ProdutoResponseDto;
import com.amaral.SeuCardapioDigital.Model.ProdutoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoModel requestToModel(ProdutoRequestDto dto);

    ProdutoResponseDto toDto(ProdutoModel model);

    void updateModelFromDto(ProdutoRequestDto dto, @MappingTarget ProdutoModel model);
}
