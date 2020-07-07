package model;

import java.io.Serializable;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

/**
 * https://www.baeldung.com/java-8-date-time-intro
 */

public class DateControl implements Serializable {
	private static final long serialVersionUID = 1L;

	private long totalHoursPlayed;
	private LocalDateTime totalTime;
	private LocalTime sessionStart;
	private LocalTime sessionEnd;
	private long sessionTime;
	private boolean sessionStarted;


	public DateControl() {
		this.totalHoursPlayed = 0;
		this.totalTime = null;
		this.sessionStarted = false;
	}

	public void startSession() {
		this.sessionStarted = true;
		this.sessionStart = LocalTime.now();
		
	}
	
	public void stopSession() {
		if(this.sessionStarted) {
			this.sessionTime = this.sessionTime();
			this.totalHoursPlayed += this.sessionTime;
			System.out.println(this.sessionTime);
		}
		else
			this.sessionTime = 0;
		this.sessionStarted = false;
	}
	
	public long sessionTime() {
		this.sessionEnd = LocalTime.now();
		return Duration.between(sessionStart, sessionEnd).toMillis();
	}
	
	public String millisToTime(long millis) {
		return String.format("%02d hours %02d minutes", 
				TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis) -  
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)));
	}
	
	public long getTotalHoursPlayed() {
		return totalHoursPlayed;
	}

	public void setTotalHoursPlayed(long totalHoursPlayed) {
		this.totalHoursPlayed = totalHoursPlayed;
	}

	public String getTotalTime() {
		if (this.totalTime == null)
			return "\nAplikacia este nebola spustena.";
		try {
			// DateTimeFormatter totalFormat = DateTimeFormatter.ISO_LOCAL_TIME;
			DateTimeFormatter totalFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
			String formattedTotalTime = this.totalTime.format(totalFormat);
			return formattedTotalTime;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("getTotalTime ERROR");
		}
		return null;
	}

	public void setTotalTime(LocalDateTime totalTime) {
		this.totalTime = totalTime;
	}

	public void setTotalTime() {
		this.totalTime = LocalDateTime.now();
	}

	public String firstRunTotalTime() {
		if (this.totalTime == null)
			this.setTotalTime();
		return "od " + this.getTotalTime();
	}

	public LocalTime getSessionStart() {
		return sessionStart;
	}

	public void setSessionStart(LocalTime sessionStart) {
		this.sessionStart = sessionStart;
	}

	public LocalTime getSessionEnd() {
		return sessionEnd;
	}

	public void setSessionEnd(LocalTime sessionEnd) {
		this.sessionEnd = sessionEnd;
	}

	public boolean isSessionStarted() {
		return sessionStarted;
	}

	public void setSessionStarted(boolean sessionStarted) {
		this.sessionStarted = sessionStarted;
	}

	public long getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(long sessionTime) {
		this.sessionTime = sessionTime;
	}

}
