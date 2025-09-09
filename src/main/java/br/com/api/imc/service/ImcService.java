package br.com.api.imc.service;

import br.com.api.imc.dto.ImcRequest;
import br.com.api.imc.dto.ImcResponse;
import br.com.api.imc.storege.LastResultStorage;
import br.com.api.imc.util.ImcCalculator;
import org.springframework.stereotype.Service;

@Service
public class ImcService {
    private final LastResultStorage lastResultStorage;

    public ImcService(LastResultStorage lastResultStorage) {
        this.lastResultStorage = lastResultStorage;
    }

    public ImcResponse calcularImc(ImcRequest imcRequest) {
        var alturaCm = ImcCalculator.calcularAlturaCm(imcRequest.altura());
        var pesoIdeal = ImcCalculator.calcularPesoIdeal(alturaCm, imcRequest.peso());
        var imc = ImcCalculator.calcularImc(imcRequest.altura(), imcRequest.peso());
        var interpretacao = ImcCalculator.calcularInterpretacao(imc);

        ImcResponse response = new ImcResponse(imc, interpretacao, pesoIdeal, alturaCm);
        lastResultStorage.salvarResultado(response);

        return response;
    }

    public ImcResponse obterUltimoResultado(){
        return lastResultStorage.obterUltimoResultado();
    }
}
