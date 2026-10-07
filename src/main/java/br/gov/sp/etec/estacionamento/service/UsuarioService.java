package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.model.usuario;

import java.util.List;

public interface UsuarioService {
    String cadastroUsuario(usuario usuario);
    List<usuario> listarUsuario();
    String atualizarUsuario(usuario usuario);
    String deletarUsuario(Long id);
    usuario buscaUsuarioPorEmail(String email);
}
