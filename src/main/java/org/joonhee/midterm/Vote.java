package org.joonhee.midterm;

/**
 * p.60 [리스트 3.3] Member 클래스 수정<br>
 * 회원정보 도메인 오브젝트. 회원 테이블과 매핑한다.
 * 
 * @author Jacob
 */
public class Vote {
	String pollId;
	String userId;
	String name;
	String choice;
	

	/**
	 * Default Constructor
	 */
	public Vote() {
	}

	public Vote(String pollId, String userId, String name, String choice) {
		this.pollId = pollId;
		this.userId = userId;
		this.name = name;
		this.choice = choice;
	}

	
	public String getPollId() {
		return pollId;
	}

	public void setPollId(String pollId) {
		this.pollId = pollId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	@Override
	public String toString() {
		return " {pollId:" + pollId + ", userId=" + userId
				+ ", name:" + name + ", choice:" + choice + "]\n";
	}
}
