package com.learner.workshop.examples.session4;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/*
 * @Author Debu Paul
 */

public class DateTime {
	public static void main(String[] args) {

		// Discovering The Ramanujan in you....
		Date firstDate = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.setTime(firstDate);
		c.add(Calendar.DATE, -1);
		Date dayAgo = c.getTime();
		System.out.println("yesterday () = " + dayAgo);

		// LocalDate
		LocalDate today = LocalDate.now();
		System.out.println("today = " + today);

		LocalDate tomo = today.plusDays(1);
		System.out.println("tomo = " + tomo);

		LocalDate ld1 = LocalDate.of(2019, Month.FEBRUARY, 6);
		System.out.println("local date = " + ld1);

		LocalDate ld2 = LocalDate.parse("2019-02-06");
		System.out.println("local date parse = " + ld2);

		String ld3 = today.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		System.out.println("Formatted Date = " + ld3);

		int dayOfYear = ld2.getDayOfYear();
		System.out.println("06-02-2019 dayOfYear = " + dayOfYear);

		// LocalTime
		LocalTime now = LocalTime.now();
		System.out.println("now = " + now);

		LocalTime of = LocalTime.of(15, 40);
		System.out.println("of = " + of);

		LocalTime thousandSecsOfDay = LocalTime.ofSecondOfDay(1000);
		System.out.println("thousandSecsFrom_00:00 = " + thousandSecsOfDay);

		// LocalDateTime
		LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("dateTime = " + dateTime);

		LocalDateTime plus5days = dateTime.plusDays(5);
		System.out.println("plus5days = " + plus5days);

		// Duration
		Duration fiveHrs = Duration.ofHours(5);
		System.out.println("fiveHrs = " + fiveHrs);

		Duration fiveHrsPlus1Day = fiveHrs.plusDays(1);
		System.out.println("fiveHrsPlus1Day = " + fiveHrsPlus1Day);

		// Period
		Period period = Period.between(LocalDate.of(1992, 12, 29), LocalDate.of(2018, 12, 29));
		System.out.println("Age = " + period.getYears());

		// ZonedDateTime

		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
		System.out.println("zonedDateTime = " + zonedDateTime);
	}
}