package com.example.application.service;

import com.example.application.entity.Issue;

import com.example.application.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class IssueService extends CrudService<Issue, Integer> {

    private final IssueRepository repository;

    public IssueService(@Autowired IssueRepository repository) {
        this.repository = repository;
    }

    @Override
    protected IssueRepository getRepository() {
        return repository;
    }

}
