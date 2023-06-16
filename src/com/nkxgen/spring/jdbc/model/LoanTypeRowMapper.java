package com.nkxgen.spring.jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoanTypeRowMapper implements RowMapper<Loans> {

	@Override
	public Loans mapRow(ResultSet rs, int rowNum) throws SQLException {
		Loans loanType = new Loans();
		loanType.setLoanId(rs.getInt("loanId"));
		loanType.setLoanType(rs.getString("loanType"));
		loanType.setDescriptionForm(rs.getString("descriptionForm"));
		// Set other properties if needed
		return loanType;
	}
}
