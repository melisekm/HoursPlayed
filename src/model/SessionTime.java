package model;

import java.io.Serializable;
import java.time.LocalTime;

public class SessionTime implements Serializable{
	private static final long serialVersionUID = 1L;
	
	long sessionLength;
	LocalTime sessionStarted;
	
	SessionTime(LocalTime sessionStarted, long sessionLength){
		this.sessionLength = sessionLength;
		this.sessionStarted = sessionStarted;
	}
}

