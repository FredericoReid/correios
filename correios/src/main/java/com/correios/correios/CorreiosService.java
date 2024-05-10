// CorreiosService.java
package com.correios.correios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.correios.correios.util.SSLUtil;

@Service
public class CorreiosService {

    private static final Logger log = LoggerFactory.getLogger(CorreiosService.class);

    public Cep buscarCEP(String cep) {
        SSLUtil.disableCertificateValidation();
        final String uri = "https://opencep.com/v1/" + cep;

        RestTemplate restTemplate = new RestTemplate();
        Cep result = null;
        try {
            result = restTemplate.getForObject(uri, Cep.class);
            log.info("CEP encontrado: {}", result);
        } catch (RestClientException e) {
            log.error("Erro ao buscar CEP: {}", cep, e);
        }
        return result;
    }
}
