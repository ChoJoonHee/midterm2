package org.joonhee.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.joonhee.midterm.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * p.204 [리스트 8.13]를 Main과 Service로 분리한 Service 부분
 * 
 * @author Jacob
 */
@Service
public class VoteService {

	Logger logger = LogManager.getLogger();

	@Autowired
	VoteDao voteDao;

	public void setVoteDao(VoteDao voteDao) {
		this.voteDao = voteDao;
	}

	
	public void voteFor() {
		Vote vote = new Vote();
		vote.setPollId("1");
		vote.setUserId("18");
		vote.setName("조주니");
		vote.setChoice("4");

		try {
			voteDao.insert(vote);
			logger.debug("투표가 잘 되었습니다.");
		} catch (DuplicateKeyException e) { // 중복 투표할 경우
			logger.error("이미 투표하셨습니다.");
		}
	}

	/**
	 * (2) 결과보기
	 */
	public void listVotes() {
		final String pollId = "1";
		List<Vote> voteList = voteDao.listVotes(pollId);
		double average = voteDao.getAverage(pollId);

		logger.debug(voteList);
		logger.debug("Average = {}", average);
	}
}