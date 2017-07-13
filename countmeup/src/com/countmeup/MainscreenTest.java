package com.countmeup;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MainscreenTest {
	ArrayList<Candidate> list_candidates=new ArrayList<Candidate>();
	Mainscreen main_screen=new Mainscreen();
	
	@Test
	public void test() {
		list_candidates.add(new Candidate("John",3));//John with 3 votes
		list_candidates.add(new Candidate("John Smith",1));//John Smith with no votes
		list_candidates.add(new Candidate("Jose Gomez",2));//Jose Gomez with 2 votes
		list_candidates.add(new Candidate("Abebe",2));//Abebe with 1 vote
		list_candidates.add(new Candidate("Abebe Abera",0));//Abebe Abera with no votes
		
		/* Against findCandidate method */
		//assertEquals(-1,main_screen.findCandidate(null, null));
		//assertEquals(-1,main_screen.findCandidate("", null));
		//assertEquals(-1,main_screen.findCandidate("Abebe", null));
		//assertEquals(-1,main_screen.findCandidate(null, list_candidates));
		//assertEquals(3,main_screen.findCandidate("Abebe", list_candidates));
		
		/* Against candidateRegistered method */
		//assertEquals(false,main_screen.candidateRegistered(null,null));
		//assertEquals(false,main_screen.candidateRegistered(null,"Abebe"));
		//assertEquals(false,main_screen.candidateRegistered(list_candidates,null));
		//assertEquals(false,main_screen.candidateRegistered(list_candidates,""));
		//assertEquals(false,main_screen.candidateRegistered(list_candidates,"Tony"));
		
		/*Against displayMsg method*/
		/*Against getUsersVotes method*/
		
		assertEquals(true,main_screen.candidateRegistered(list_candidates,"Abebe"));
		
	    }}
