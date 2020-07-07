package application;

import java.io.Serializable;
import java.time.*;

public class DateControl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	LocalTime totalHrs;
	boolean firstTime = false;
}
