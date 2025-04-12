package br.futurodev.joiville.m1s08exercicios.services;

import br.futurodev.joiville.m1s08exercicios.entities.Organization;
import br.futurodev.joiville.m1s08exercicios.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired private OrganizationRepository repository;

    public List<Organization> findAll() {
        return repository.findAll();
    }

    public Organization findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /** Insert or update */
    public Organization save(Organization organization) {
        if (organization.getId() != null) {
            Organization old = findById(organization.getId());
            if (old != null) {
                organization.setId(old.getId());
            } else {
                organization.setId(null);
            }
        }
        return repository.save(organization);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
