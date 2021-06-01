package com.example.application.service;

import com.example.application.entity.Solution;
import com.example.application.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class SolutionService extends CrudService<Solution, Integer> {

    private final SolutionRepository repository;

    public SolutionService(@Autowired SolutionRepository repository) {
        this.repository = repository;
    }

    @Override
    protected SolutionRepository getRepository() {
        return repository;
    }

}
