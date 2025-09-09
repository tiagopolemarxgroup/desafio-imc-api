package br.com.api.imc.util.controller;

import br.com.api.imc.dto.ImcRequest;
import br.com.api.imc.dto.ImcResponse;
import br.com.api.imc.service.ImcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {
    private final ImcService imcService;

    public ImcController(ImcService imcService) {
        this.imcService = imcService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<ImcResponse> calcular(@RequestBody ImcRequest imcRequest) {
        return ResponseEntity.ok(imcService.calcularImc(imcRequest));
    }

    @GetMapping("/ultimo-resultado")
    public ResponseEntity<ImcResponse> ultimoResultado() {
       ImcResponse ultimoResultado = imcService.obterUltimoResultado();
       if(ultimoResultado != null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(imcService.obterUltimoResultado());
    }
}
