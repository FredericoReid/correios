package com.correios.correios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CorreiosController {

    @Autowired
    private CorreiosService correiosService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/buscar-cep")
    public String buscarCep(@RequestParam String cep, Model model) {
        try {
            Cep resultado = correiosService.buscarCEP(cep);
            model.addAttribute("resultado", resultado);
            return "resultado";
        } catch (RuntimeException ex) {
            model.addAttribute("mensagem", ex.getMessage());
            return "erro";
        }
    }
}
