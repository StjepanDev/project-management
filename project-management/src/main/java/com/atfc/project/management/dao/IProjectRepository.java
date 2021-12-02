package com.atfc.project.management.dao;

import org.springframework.data.repository.CrudRepository;

import com.atfc.project.management.entities.Project;

public interface IProjectRepository extends CrudRepository<Project,Long>{
	

}
