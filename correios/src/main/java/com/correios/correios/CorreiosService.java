package com.correios.correios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CorreiosService {

    @Autowired
    private RestTemplate restTemplate;

    public Cep buscarCEP(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Cep> response = restTemplate.exchange(url, HttpMethod.GET, entity, Cep.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Erro ao consultar CEP: " + response.getStatusCode());
        }
    }
}
