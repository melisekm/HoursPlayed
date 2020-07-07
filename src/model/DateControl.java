package model;

import java.io.Serializable;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * https://www.baeldung.com/java-8-date-time-intro
 */

public class DateControl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double totalHoursPlayed;
	private LocalDateTime totalTime;
	
	public LocalTime totalHrs;
	public String totalF;

	public DateControl() {
		this.totalHoursPlayed = 0.0;
		this.totalTime = LocalDateTime.now();
		
		
		
		/*this.totalHrs = LocalTime.now();
		DateTimeFormatter totalFormat = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(this.totalHrs);
		LocalTime initialTime = this.totalHrs;

		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(60));

		long five = Duration.between(initialTime, finalTime).toSeconds();
		String between = finalTime.format(totalFormat);
		String formattedTime = finalTime.format(totalFormat);
		System.out.println(five);
		this.totalF = formattedTime;*/
	}

	public double getTotalHoursPlayed() {
		return totalHoursPlayed;
	}

	public void setTotalHoursPlayed(double totalHoursPlayed) {
		this.totalHoursPlayed = totalHoursPlayed;
	}

	public String getTotalTime() {
		DateTimeFormatter totalFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		String formattedTotalTime = this.totalTime.format(totalFormat);
		return formattedTotalTime;
	}

	public void setTotalTime(LocalDateTime totalTime) {
		this.totalTime = totalTime;
	}

}
