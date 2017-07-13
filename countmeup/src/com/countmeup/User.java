package com.countmeup;

import java.util.ArrayList;

class User{
	String user_name;
	ArrayList<String> liked_candidates=new ArrayList<String>();
	User(String user_name,ArrayList<String> liked_candidates){
	   this.user_name=user_name;
	   this.liked_candidates=liked_candidates;}}