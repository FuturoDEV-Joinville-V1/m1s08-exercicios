package br.futurodev.joiville.m1s08exercicios.repositories;

import br.futurodev.joiville.m1s08exercicios.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p " +
            "FROM Project p " +
            "WHERE UPPER(p.region) LIKE '%' || UPPER(:search) || '%' " +
            "OR UPPER(p.organization.name) LIKE '%' || UPPER(:search) || '%' ")
    List<Project> findAllByRegionOrOrganizationName(String search);

}
