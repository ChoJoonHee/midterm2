package org.joonhee.midterm;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class VoteMain {

	/**
	 * main() 메서드
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"joonhee.xml");
		VoteService voteService = ctx.getBean("voteService", VoteService.class);
		voteService.voteFor();
		voteService.listVotes();
		ctx.close();
	}
}