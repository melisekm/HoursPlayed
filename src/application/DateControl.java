package application;
/**
 * https://www.baeldung.com/java-8-date-time-intro
 */


import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateControl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	LocalTime totalHrs;
	String totalF;
	DateControl(){
		this.totalHrs = LocalTime.now();
		DateTimeFormatter totalFormat = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(this.totalHrs);
		LocalTime initialTime = this.totalHrs;
		 
		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(60));
		
		long five = Duration.between(initialTime, finalTime).toSeconds();
		String between = finalTime.format(totalFormat);
		String formattedTime = finalTime.format(totalFormat);
		System.out.println(five);
		this.totalF = formattedTime;
	}
}
