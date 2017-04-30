package com.epam.training.shop.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.epam.training.shop.service.BasicService;

public class BasicServiceImpl<T, REPOSITORY extends JpaRepository<T, ID>, ID extends Serializable>
		implements BasicService<T, ID> {

	private static Logger logger = LoggerFactory.getLogger(BasicServiceImpl.class);
	@Autowired
	protected REPOSITORY repository;

	@Override
	@Transactional
	public T save(T entity) {
		logger.debug("Save entity " + entity);
		return (T) repository.save(entity);
	}

	@Override
	@Transactional
	public T findOne(ID id) {
		logger.debug("Find entity by id " + id);
		return (T) repository.findOne(id);
	}

	@Override
	@Transactional
	public boolean exists(ID id) {
		return repository.exists(id);
	}

	@Override
	@Transactional
	public List<T> findAll() {
		logger.debug("Find all");
		return (List<T>) repository.findAll();
	}

	@Override
	@Transactional
	public long count() {
		return repository.count();
	}

	@Override
	@Transactional
	public void delete(ID id) {
		logger.debug("Delete entity by ID " + id);
		repository.delete(id);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		logger.debug("Delete entity " + entity.getClass());
		repository.delete(entity);
	}

	@Override
	@Transactional
	public void deleteAll() {
		logger.debug("Delete all");
		repository.deleteAll();
	}

	@Override
	@Transactional
	public <S extends T> S saveAndFlush(S entity) {
		logger.debug("Save entity " + entity.getClass());
		return repository.saveAndFlush(entity);
	}

}
