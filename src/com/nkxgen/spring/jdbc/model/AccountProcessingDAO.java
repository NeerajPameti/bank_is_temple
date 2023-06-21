package com.nkxgen.spring.jdbc.model;

import java.util.List;

public interface AccountProcessingDAO {

	public List<InterestCal> getSavAcc(String acctype);

	public void executeProcedure(int accno);

}
