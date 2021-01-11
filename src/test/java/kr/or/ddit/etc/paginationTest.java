package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class paginationTest {

	@Test
	public void paginationTest() {
		/***Given***/
		int userToCnt = 16;
		int pageSize = 5;

		/***When***/
		int pagination = (int) Math.ceil((double)userToCnt/pageSize);
		//int paging = (int) Math.ceil((double)userToCnt/pageSize);
		
		/***Then***/
		assertEquals(4, pagination);
	}

}
