package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class LoansDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Loans> getAllLoans() {
		String jpql = "SELECT l FROM Loans l";
		TypedQuery<Loans> query = entityManager.createQuery(jpql, Loans.class);
		return query.getResultList();
	}

	public List<Loans> getAllLoanDetails() {
		String jpql = "SELECT l FROM Loans l";
		TypedQuery<Loans> query = entityManager.createQuery(jpql, Loans.class);
		return query.getResultList();
	}

	public List<Loans> getSelectedLoanDetails(int loanType) {
		System.out.println("selected loans query method  " + loanType);
		String jpql = "SELECT l FROM Loans l WHERE loanid = :loanType";
		TypedQuery<Loans> query = entityManager.createQuery(jpql, Loans.class);
		query.setParameter("loanType", loanType);
		return query.getResultList();
	}

}
