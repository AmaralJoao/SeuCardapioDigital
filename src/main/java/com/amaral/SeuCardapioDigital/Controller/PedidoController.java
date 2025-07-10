package com.amaral.SeuCardapioDigital.Controller;

import com.amaral.SeuCardapioDigital.Dto.Request.PedidoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.PedidoResponseDto;
import com.amaral.SeuCardapioDigital.Model.PedidoModel;
import com.amaral.SeuCardapioDigital.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/auth/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/novopedido")
    public ResponseEntity<PedidoResponseDto> criarPedido(@RequestBody PedidoRequestDto pedido) {
        try {
            PedidoResponseDto novoPedido = pedidoService.criarPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PreAuthorize("isAuthenticated()")
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

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/listartodos")
    public ResponseEntity<List<PedidoResponseDto>> listarPedidos() {
        long id = 0;

        return ResponseEntity.ok(pedidoService.listarTodos(id));
    }

    /*@PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscarPedido(@PathVariable Long id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/
}
