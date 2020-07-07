package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SessionTime implements Serializable{
	private static final long serialVersionUID = 1L;
	
	long sessionLength;
	LocalDateTime sessionStarted;
	
	SessionTime(LocalDateTime sessionStarted, long sessionLength){
		this.sessionLength = sessionLength;
		this.sessionStarted = sessionStarted;
	}
}

