package lessons.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.Duration;

public class dateCalcs {
    public static void main(String[] args) {
    LocalDate d01 = LocalDate.parse("2022-07-20");
    LocalDateTime d02 = LocalDateTime.parse("2022-07-20T01:30:26");
    Instant d03 = Instant.parse("2022-07-20T01:30:26Z");

    LocalDate pastWeekLocalDate = d01.minusDays(7);
    LocalDate nextWeekLocalDate = d01.plusDays(7);

    LocalDateTime pastWeekLocalDateTime = d02.minusDays(7);
    LocalDateTime nextWeekLocalDateTime = d02.plusDays(7);

    Instant pastWeekInstant = d03.minus(7, ChronoUnit.DAYS); 
    Instant nextWeekInstant = d03.plus(7, ChronoUnit.DAYS);

    Duration t2 = Duration.between(pastWeekLocalDateTime, d02);
    Duration t3 = Duration.between(pastWeekInstant, d03);

    System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
    System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
    System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
    System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
    System.out.println("pastWeekInstant = " + pastWeekInstant);
    System.out.println("nextWeekInstant = " + nextWeekInstant);
    System.out.println("t2 = " + t2.toDays());
    System.out.println("t3 = " + t3.toDays());
    }
}
