package lessons.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class dateInstance {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d01 = LocalDate.now();
        System.out.println(d01);
        
        LocalDateTime d02= LocalDateTime.now();
        System.out.println(d02);
        
        Instant d03 = Instant.now(); //instant gera o localtime no GMT (Londres)
        System.out.println(d03);

        LocalDate d04 = LocalDate.parse("2022-07-20");
        System.out.println(d04);

        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T17:30:45");
        System.out.println(d05);

        Instant d06 = Instant.parse("2022-07-20T03:30:45Z");
        System.out.println(d06);

        Instant d07 = Instant.parse("2022-07-20T03:30:45-03:00");
        System.out.println(d07);

        LocalDate d08 = LocalDate.parse("20/02/2022", fmt1);
        System.out.println(d08);

        LocalDateTime d09 = LocalDateTime.parse("20/02/2022 17:30", fmt2);
        System.out.println(d09);

        LocalDate d10 = LocalDate.of(2022, 7 , 20);
        LocalDateTime d11 = LocalDateTime.of(2022, 7 , 20, 17, 30);

        System.out.println("d10: " + d10.toString());
        System.out.println("d11: " + d11.toString());
    }
}
