package com.atfc.project.management.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atfc.project.management.entities.Project;

public interface IProjectRepository extends CrudRepository<Project,Long>{
	
	@Override
	public List<Project> findAll();
}
