package org.joonhee.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("VoteDao")
public class VoteDaoImp implements VoteDao {

	
	static final String SELECT_BY_USERID = "SELECT (pollId, userId, name, choice) FROM vote WHERE userId=?";

	static final String INSERT = "INSERT vote(pollId, userId, name, choice, cdate) VALUES(?, ?, ?, ?, NOW() )";

	static final String SELECT_ALL = "SELECT pollId,userId,name, choice FROM vote WHERE pollId=? ";
	
	static final String GET_AVERAGE = "SELECT avg(choice) FROM vote WHERE pollId=?";

	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * p.194의 memberRowMapper<br>
	 * Member 오브젝트와 member 테이블의 한 행을 매핑하는 rowMapper
	 */
	RowMapper<Vote> memberRowMapper = new BeanPropertyRowMapper<>(
			Vote.class);
	
	@Override
	public Vote selectBypollId(String pollId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SELECT_BY_USERID, memberRowMapper,
				pollId);
	}

	@Override
	public void insert(Vote vote) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(INSERT, vote.getPollId(), vote.getUserId(),
				vote.getName(), vote.getChoice());

	}

	@Override
	public List<Vote> listVotes(String pollId) {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.query(SELECT_ALL, memberRowMapper, pollId);
	}
	
	public double getAverage(String pollId) {
		return jdbcTemplate.queryForObject(GET_AVERAGE, Double.class, pollId);
	}
}
