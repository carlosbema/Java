package lessons.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class dateToText{
    public static void main(String[] args) {

        LocalDate d01 = LocalDate.parse("2022-07-20");
        LocalDateTime d02 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d03 = Instant.parse("2022-07-20T01:30:26Z");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        System.out.println("d01: " + d01.format(fmt1));
        System.out.println("d02: " + d02.format(fmt2));
        System.out.println("d03: " + fmt3.format(d03));
    }
}
