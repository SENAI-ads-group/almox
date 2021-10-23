package com.almox.repositorios;

import com.almox.model.entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>, DepartamentoRepositoryCustom {

}
