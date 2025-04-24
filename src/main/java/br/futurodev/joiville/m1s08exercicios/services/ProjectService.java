package br.futurodev.joiville.m1s08exercicios.services;

import br.futurodev.joiville.m1s08exercicios.entities.Organization;
import br.futurodev.joiville.m1s08exercicios.entities.Project;
import br.futurodev.joiville.m1s08exercicios.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProjectService {

    @Autowired private ProjectRepository repository;
    @Autowired private OrganizationService organizationService;

    public List<Project> findAll(String search) {
        if (StringUtils.hasText(search)) {
            return repository.findAllByRegionOrOrganizationName(search);
        }
        return repository.findAll();
    }

    public Project findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /** Insert or update */
    public Project save(Project project) {
        if (project.getId() != null) {
            Project old = findById(project.getId());
            if (old != null) {
                project.setId(old.getId());
            } else {
                project.setId(null);
            }
        }

        // Find and verify organization
        Organization organization = organizationService.findById(project.getOrganization().getId());
        if (organization == null) {
            return null;
        }

        project.setOrganization(organization);

        return repository.save(project);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
