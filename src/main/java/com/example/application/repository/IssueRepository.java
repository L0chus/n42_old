package com.example.application.repository;

import com.example.application.dto.IssueDTO;
import com.example.application.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface IssueRepository extends JpaRepository<Issue, Integer> {

    @Query("SELECT i.id, i.name, i.description, i.minValue, i.maxValue" + "From Issue i")
    List<Object[]> IssueToSolution();

    @Query(" SELECT  i.id, i.name, i.description, i.minCost, i.maxCost" + "From Solution s")
    List<IssueDTO> findAllIssuesWithMostImportantValues();

    List<IssueDTO> findAllIssuesByIdNotNull();




}