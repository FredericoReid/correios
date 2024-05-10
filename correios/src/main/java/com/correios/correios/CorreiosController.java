package com.correios.correios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorreiosController {

    @Autowired
    private CorreiosService cepService;

    @GetMapping("/cep")
    public Cep getCepInfo(@RequestParam String cep) {
        return cepService.buscarCEP(cep);
    }
}
