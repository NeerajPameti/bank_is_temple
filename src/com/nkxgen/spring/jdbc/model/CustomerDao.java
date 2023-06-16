package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save_trail(Customertrail customer) {
		entityManager.persist(customer);
	}

	public Customertrail getCustomerById(Long id) {
		// Retrieve customer data from the table based on the ID
		Customertrail customer = entityManager.find(Customertrail.class, id);
		return customer;
	}

	public void save(Customer customer) {
		entityManager.persist(customer);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String jpql = "SELECT la FROM Customer la";
		TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
		return query.getResultList();
	}

	public void updateCustomerDataById(Customer updatedCustomer) {
		System.out.println(updatedCustomer);
		entityManager.merge(updatedCustomer);

	}

	public void deleteCusById(Customertrail cus) {
		// TODO Auto-generated method stub
		// Assuming Customertrail class has an 'id' property

		long customerId = cus.getId();

		Customertrail customer = entityManager.find(Customertrail.class, customerId);

		if (customer != null) {
			entityManager.remove(customer);
			System.out.println("Customer with ID " + customerId + " has been deleted successfully.");
		} else {
			System.out.println("Customer with ID " + customerId + " does not exist.");
		}
	}

	public Customer getRealCustomerById(Long customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		return customer;
	}
}
// =======================================
