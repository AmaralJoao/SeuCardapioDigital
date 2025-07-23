package com.amaral.SeuCardapioDigital.Controller.Auth;

import com.amaral.SeuCardapioDigital.Dto.Request.PedidoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.PedidoResponseDto;
import com.amaral.SeuCardapioDigital.Service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth/api/estabelecimento")
public class AuthPedidoController {

    private PedidoService pedidoService;

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> editarPedido(@PathVariable Long id, @RequestBody PedidoRequestDto pedido) {
        try {
            PedidoResponseDto pedidoEditado = pedidoService.editarPedido(id, pedido);
            return ResponseEntity.ok(pedidoEditado);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/listartodos")
    public ResponseEntity<List<PedidoResponseDto>> listarPedidos() {
        long id = 0;

        return ResponseEntity.ok(pedidoService.listarTodos(id));
    }
}
