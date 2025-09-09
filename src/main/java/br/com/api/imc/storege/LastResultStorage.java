package br.com.api.imc.storege;

import br.com.api.imc.dto.ImcResponse;
import org.springframework.stereotype.Component;

@Component
public class LastResultStorage {
    private ImcResponse imcResponse;

    public void salvarResultado(ImcResponse imcResponse) {
        this.imcResponse = imcResponse;
    }

    public ImcResponse obterUltimoResultado() {
        return imcResponse;
    }
}
