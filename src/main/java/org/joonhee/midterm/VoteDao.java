package org.joonhee.midterm;

import java.util.List;

/**
 * p.184 [리스트 8.2] MemberDao 를 interface로 수정<br>
 * 회원 테이블을 조작하는 Data Access Object
 * 
 * @author Jacob
 */
public interface VoteDao {


	Vote selectBypollId(String pollId);

	/**
	 * 회원정보 저장
	 */
	void insert(Vote member);


	/**
	 * 회원 목록
	 */
	List<Vote> listVotes(String pollId);
	
	double getAverage(String pollId);

}
