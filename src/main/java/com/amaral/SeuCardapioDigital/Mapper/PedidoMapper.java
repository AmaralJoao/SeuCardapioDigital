package com.amaral.SeuCardapioDigital.Mapper;

import com.amaral.SeuCardapioDigital.Dto.Request.PedidoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Request.ProdutoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.PedidoResponseDto;
import com.amaral.SeuCardapioDigital.Dto.Response.ProdutoResponseDto;
import com.amaral.SeuCardapioDigital.Model.PedidoModel;
import com.amaral.SeuCardapioDigital.Model.ProdutoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoModel requestToModel(PedidoRequestDto dto);

    PedidoResponseDto toDto(PedidoModel model);

    void updateModelFromDto(PedidoRequestDto dto, @MappingTarget PedidoModel model);
}
