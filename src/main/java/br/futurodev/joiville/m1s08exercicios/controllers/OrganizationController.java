package br.futurodev.joiville.m1s08exercicios.controllers;

import br.futurodev.joiville.m1s08exercicios.entities.Organization;
import br.futurodev.joiville.m1s08exercicios.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organizations")
public class OrganizationController {

    @Autowired private OrganizationService service;

    @GetMapping
    public List<Organization> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Organization getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization post(@RequestBody Organization organization) {
        organization.setId(null);
        return service.save(organization);
    }

    @PutMapping("{id}")
    public Organization put(@PathVariable Long id, @RequestBody Organization organization) {
        organization.setId(id);
        return service.save(organization);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}
