package com.dao.result.user;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.result.user.Attempted;
@Repository
public class UserEntryDAOImpl implements UserEntryDAO {
	
	@Autowired
JdbcTemplate jdbcTemplate;
	@Override
	public boolean insertResult(Attempted attempted) {
	
		boolean answered=false;
		int rowcount=jdbcTemplate.update("insert into attempted values(?,?,?)",
				attempted.getAnswer(),attempted.getQnum(),attempted.getTestid());
		if(rowcount==1) {
			answered=true;
		}
		
		return answered;

	}
	
	
	public Attempted calculateResult(Attempted attempted) {
	
	List<Attempted> helo=jdbcTemplate.query("select q.q_no,q.correctoption from question where q_no=?",new CalculateMapper());
		return helo.size()>0?helo.get(0):null;
	}
}
class CalculateMapper implements RowMapper<Attempted>{
@Override
public Attempted mapRow(ResultSet rs, int arg1) throws SQLException {
	
	Attempted loginResponse=new Attempted();
	loginResponse.setQ_no(rs.getString(1));
	loginResponse.setCorrectoption(rs.getString(2));
	return loginResponse;
}
}
