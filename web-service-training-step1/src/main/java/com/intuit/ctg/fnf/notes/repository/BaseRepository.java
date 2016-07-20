package com.intuit.ctg.fnf.notes.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;


/**
 * @author mbach1
 *
 */
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID>
{
	void deleteById(ID id);

	List<T> findAll();

	T findOne(ID id);

	T save(T entity);
}