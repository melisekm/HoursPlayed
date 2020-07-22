package model;

import java.io.Serializable;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DateControl implements Serializable {
	private static final long serialVersionUID = 1L;

	private long totalHoursPlayed;
	private LocalDateTime totalTime;
	private LocalDateTime sessionStart;
	private LocalDateTime sessionEnd;
	private long sessionTime;
	private boolean sessionStarted;
	private ArrayList<SessionTime> twoWeekSessions;

	public DateControl() {
		this.totalHoursPlayed = 0;
		this.totalTime = null;
		this.sessionStarted = false;
		this.setTwoWeekSessions(new ArrayList<SessionTime>());
	}

	public void startSession() {
		this.sessionStarted = true;
		this.sessionStart = LocalDateTime.now();
	}

	public void stopSession() {
		if (this.sessionStarted) {
			this.sessionTime = this.sessionTime();
			SessionTime current = new SessionTime(this.sessionStart, this.sessionTime);
			if (this.getTwoWeekSessions() == null)
				this.setTwoWeekSessions(new ArrayList<SessionTime>());
			this.getTwoWeekSessions().add(current);
			this.totalHoursPlayed += this.sessionTime;
		}
		this.sessionStarted = false;
	}

	public long sessionTime() {
		LocalDateTime sessionEnd = LocalDateTime.now();
		return Duration.between(this.sessionStart, sessionEnd).toMillis();
	}

	public void checkToTwoWeekSum() {
		ArrayList<SessionTime> toremove = new ArrayList<SessionTime>();
		for (SessionTime i : this.getTwoWeekSessions()) {
			if (i.sessionStarted.isBefore(LocalDateTime.now().minusHours(336))) {
				toremove.add(i);
			}
		}
		for (SessionTime i : toremove) {
			this.getTwoWeekSessions().remove(i);
		}
	}

	public long calcTwoWeekSum() {
		long sum = 0;
		for (SessionTime i : this.getTwoWeekSessions()) {
			if (i.sessionStarted.isAfter(LocalDateTime.now().minusHours(336)))
				sum += i.sessionLength;
		}
		return sum;
	}

	public String getTwoWeeks() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDateTime prev = LocalDateTime.now().minusHours(336);
		LocalDateTime now = LocalDateTime.now();
		String formatPrev = prev.format(dateFormat);
		String formatNow = now.format(dateFormat);
		return formatPrev + " - " + formatNow;

	}

	public String millisToTime(long millis) {
		return String.format("%02d hours %02d minutes", TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)));
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
			DateTimeFormatter totalFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String formattedTotalTime = this.totalTime.format(totalFormat);
			return "od " + formattedTotalTime;

		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("getTotalTime ERROR");
		}
		return null;
	}

	public String extractSessions() {
		String sessionList = "";
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		for (SessionTime i : this.twoWeekSessions) {
			LocalDateTime sessionEnd = i.sessionStarted.plusMinutes(TimeUnit.MILLISECONDS.toMinutes(i.sessionLength));
			sessionList += i.sessionStarted.format(dateFormat) + " " + sessionEnd.format(dateFormat) + " - "
					+ this.millisToTime(i.sessionLength) + "\n";
		}
		return sessionList;
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
		return this.getTotalTime();
	}

	public LocalDateTime getSessionStart() {
		return sessionStart;
	}

	public void setSessionStart(LocalDateTime sessionStart) {
		this.sessionStart = sessionStart;
	}

	public LocalDateTime getSessionEnd() {
		return sessionEnd;
	}

	public void setSessionEnd(LocalDateTime sessionEnd) {
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

	public ArrayList<SessionTime> getTwoWeekSessions() {
		return twoWeekSessions;
	}

	public void setTwoWeekSessions(ArrayList<SessionTime> twoWeekSessions) {
		this.twoWeekSessions = twoWeekSessions;
	}

}
