package com.amaral.SeuCardapioDigital.Service;

import com.amaral.SeuCardapioDigital.Dto.Request.ClienteRequestDto;
import com.amaral.SeuCardapioDigital.Mapper.ClienteMapper;
import com.amaral.SeuCardapioDigital.Model.ClienteModel;
import com.amaral.SeuCardapioDigital.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel salvarCliente(ClienteRequestDto clienteRequestDto){

        ClienteModel novoCliente = clienteMapper.requestToModel(clienteRequestDto);
        return clienteRepository.save(novoCliente);

    }
}
