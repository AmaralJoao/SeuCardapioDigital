package com.amaral.SeuCardapioDigital.Mapper;

import com.amaral.SeuCardapioDigital.Dto.Request.ClienteRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Request.EstabelecimentoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.EstabelecimentoResponseDto;
import com.amaral.SeuCardapioDigital.Model.ClienteModel;
import com.amaral.SeuCardapioDigital.Model.EstabelecimentoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteModel requestToModel(ClienteRequestDto dto);

    //EstabelecimentoResponseDto toDto(EstabelecimentoModel model);

    void updateModelFromDto(ClienteRequestDto dto, @MappingTarget ClienteModel model);

}
