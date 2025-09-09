package br.com.api.imc.dto;

public record ImcResponse(double imc, String interpretacao, double pesoIdeal, double altura) {
}
