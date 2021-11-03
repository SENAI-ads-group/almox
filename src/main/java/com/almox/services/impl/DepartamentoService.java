package com.almox.services.impl;

import com.almox.model.dto.FiltroDepartamentoDTO;
import com.almox.model.entidades.Departamento;
import com.almox.repositories.DepartamentoRepository;
import com.almox.repositories.OrcamentoDepartamentoRepository;
import com.almox.services.IDepartamentoService;
import com.almox.services.IUsuarioService;
import com.almox.util.CondicaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartamentoService implements IDepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final OrcamentoDepartamentoRepository orcamentoDepartamentoRepository;
    private final IUsuarioService usuarioService;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository, OrcamentoDepartamentoRepository orcamentoDepartamentoRepository, IUsuarioService usuarioService) {
        this.departamentoRepository = departamentoRepository;
        this.orcamentoDepartamentoRepository = orcamentoDepartamentoRepository;
        this.usuarioService = usuarioService;
    }

    public List<Departamento> buscarTodos(FiltroDepartamentoDTO filtro) {
        return departamentoRepository.findAll(filtro);
    }

    @Override
    public List<Departamento> buscarTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento buscarPorId(Long id) {
        return CondicaoUtil.verificarEntidade(departamentoRepository.findById(id));
    }

    public Departamento criar(@Valid Departamento entidade) {
        return salvar(entidade);
    }

    @Transactional
    public Departamento atualizar(Long id, Departamento entidade) {
        buscarPorId(id);
        return salvar(entidade);
    }

    private Departamento salvar(Departamento entidade) {
        return departamentoRepository.save(entidade);
    }

    @Override
    public void excluir(long id) {
        var entidadeEncontrada = buscarPorId(id);
        entidadeEncontrada.setDataExclusao(LocalDateTime.now());
        entidadeEncontrada.setExcluidoPor(usuarioService.getUsuarioLogado());
        departamentoRepository.save(entidadeEncontrada);
    }

}
