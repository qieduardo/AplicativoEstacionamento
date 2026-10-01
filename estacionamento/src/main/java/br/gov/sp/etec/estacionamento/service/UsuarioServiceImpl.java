package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.entity.UsuarioEntity;
import br.gov.sp.etec.estacionamento.model.usuario;
import br.gov.sp.etec.estacionamento.repository.UsuarioRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Override
    public String cadastroUsuario(usuario usuario) {

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setDatanascimento(usuario.getDatanascimento());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioEntity.setTelefone(usuario.getTelefone());

        repository.save(usuarioEntity);

        return "Usuario cadastrado com sucesso";
    }

    @Override
    public List<usuario> listarUsuario() {
        return List.of();
    }

    @Override
    public String atualizarUsuario(usuario usuario) {
        return "";
    }

    @Override
    public String deletarUsuario(Long id) {
        return "";
    }

    @Override
    public usuario buscaUsuarioPorEmail(String email) {
        UsuarioEntity entity = repository.findByEmail(email);
        usuario user = toUsuario(entity);
        return user;
    }
    private usuario toUsuario(UsuarioEntity entity){
        usuario usuario = new usuario();
        usuario.setEmail(entity.getEmail());
        usuario.setNome(entity.getNome());
        usuario.setCpf(entity.getCpf());
        usuario.setSenha(entity.getSenha());
        usuario.setDatanascimento(entity.getDatanascimento());
        usuario.setTelefone(entity.getTelefone());
        return usuario;
    }
}
