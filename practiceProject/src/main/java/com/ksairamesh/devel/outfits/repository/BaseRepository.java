package com.ksairamesh.devel.outfits.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID>
{
	T findOne(ID id); //get by id

	T save(T entity); // add

	void deleteById(ID id); // delete by id

	List<T> findAll(); // get all


}
