package br.futurodev.joiville.m1s08exercicios.controllers;

import br.futurodev.joiville.m1s08exercicios.entities.Project;
import br.futurodev.joiville.m1s08exercicios.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired private ProjectService service;

    @GetMapping
    public List<Project> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Project getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project post(@RequestBody Project project) {
        project.setId(null);
        return service.save(project);
    }

    @PutMapping("{id}")
    public Project put(@PathVariable Long id, @RequestBody Project project) {
        project.setId(id);
        return service.save(project);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}
