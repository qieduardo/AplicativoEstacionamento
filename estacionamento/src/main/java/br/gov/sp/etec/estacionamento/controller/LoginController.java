package br.gov.sp.etec.estacionamento.controller;

import br.gov.sp.etec.estacionamento.entity.UsuarioEntity;
import br.gov.sp.etec.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etec.estacionamento.model.usuario;
import br.gov.sp.etec.estacionamento.service.UsuarioService;
import br.gov.sp.etec.estacionamento.service.VeiculoService;
import br.gov.sp.etec.estacionamento.service.VeiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UsuarioService service;

    @Autowired
    VeiculoService veiculoService;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("tela-cadastro")
    public String cadastrar() {
        return "tela-cadastro";
    }

    @PostMapping("/efetuar-cadastro")
    public String efetuarCadastro(usuario usuario) {
        log.info(usuario.toString());
        service.cadastroUsuario(usuario);
        return "cadastro-sucesso";
    }
    @PostMapping("/autenticar")
    public String autenticar(String email, String senha, Model model) {
        usuario xpto = service.buscaUsuarioPorEmail(email);
        if (xpto != null && senha.equals(xpto.getSenha())) {
            List<VeiculoEntity> Veiculos = veiculoService.listarVeiculo();
            model.addAttribute("Veiculos", Veiculos);
            return "painel";
        } else {
            return "erro";
        }
    }
}
