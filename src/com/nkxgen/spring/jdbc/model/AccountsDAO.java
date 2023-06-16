package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class AccountsDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Accounts> getAllAccounts() {
		String jpql = "SELECT l FROM Accounts l";
		TypedQuery<Accounts> query = entityManager.createQuery(jpql, Accounts.class);
		return query.getResultList();
	}

	public List<Accounts> getAllAccountDetails() {
		String jpql = "SELECT l FROM Accounts l";
		TypedQuery<Accounts> query = entityManager.createQuery(jpql, Accounts.class);
		return query.getResultList();
	}

	public List<Accounts> getSelectedAccountDetails(int accountType) {
		System.out.println("selected accounts query method  " + accountType);
		String jpql = "SELECT l FROM Accounts l WHERE accountid = :accountType";
		TypedQuery<Accounts> query = entityManager.createQuery(jpql, Accounts.class);
		query.setParameter("accountType", accountType);
		return query.getResultList();
	}

}
