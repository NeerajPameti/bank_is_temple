package com.nkxgen.spring.jdbc.model;

public class service {

	public static Customer dotheservice(Customertrail customertrail) {
		Customer customer = new Customer();
		customer.setcust_id(customertrail.getId());
		customer.setcustTitle(customertrail.getTitle());
		customer.setcust_type(customertrail.getType());
		customer.setcust_caddress(customertrail.getCurrentAddress());
		customer.setcust_capincode(customertrail.getCurrentPINCode());
		customer.setcust_dob(customertrail.getDateOfBirth());
		customer.setcust_mobile1(customertrail.getMobile1());
		customer.setcust_mobile2(customertrail.getMobile2());
		customer.setcust_rphone(customertrail.getResidencePhone());
		customer.setcust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

}
