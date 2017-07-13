package com.countmeup;
import java.util.ArrayList;

public interface SimpleMethods {
	
	boolean candidateRegistered(ArrayList<Candidate> list_candidates2, String string);
	
	String getUsersVotes(String user_name,ArrayList<String> liked_candidates2);
	
	int findCandidate(String string, ArrayList<Candidate> list_candidates2);
	
	int findUser(String user_name, ArrayList<User> user_list);}
