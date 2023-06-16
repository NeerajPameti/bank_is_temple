package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class accountApplicationDAO {
	accountApplicationDAO() {

	}

	@PersistenceContext
	private EntityManager entityManager;

	public void save(AccountApplication accountApplication) {
		entityManager.persist(accountApplication);
	}

	public List<AccountApplication> getAccountsappByType(String value) {
	    System.out.println("neeraj function loki vacahav repository lo : " + value);
		
	    String jpql = "SELECT la FROM AccountApplication la WHERE la.acap_acty_id = :value";
	    TypedQuery<AccountApplication> query = entityManager.createQuery(jpql, AccountApplication.class);
	    query.setParameter("value", value);
		 
	    List<AccountApplication> list1 = query.getResultList();

	    if (!list1.isEmpty()) {
	        AccountApplication firstAccount = list1.get(0);
	        String acapActyId = firstAccount.getacap_acty_id();
	        System.out.println("acap_acty_id of first object: " + acapActyId);
	    }
	     
	    return list1;
	}

	public List<Account> getAccountsByType(String acnt_acty_id) {
		String jpql = "SELECT la FROM LoanAccount la WHERE la.loanType = :acty_id";
		TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
		query.setParameter("acnt_acty_id", acnt_acty_id);
		return query.getResultList();
	}

	public void save1(Account account) {
		entityManager.persist(account);

	}
}