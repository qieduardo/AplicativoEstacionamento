package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etec.estacionamento.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    public void cadastrarVeiculo(Veiculo veiculo);
    public List<VeiculoEntity> listarVeiculo();
    public boolean deletarCadastro(Long id);
    public VeiculoEntity atualizarCadastro(VeiculoEntity veiculo);
    public VeiculoEntity buscaVeiculoPorId(Long id);
    public void registrarSaida(Long id);
}
