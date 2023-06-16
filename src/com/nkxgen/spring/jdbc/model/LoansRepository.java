package com.nkxgen.spring.jdbc.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoansRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Loans loans) {
		entityManager.merge(loans);
	}

}