package br.futurodev.joiville.m1s08exercicios.repositories;

import br.futurodev.joiville.m1s08exercicios.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
