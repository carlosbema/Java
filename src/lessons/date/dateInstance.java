package lessons.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class dateInstance {
    public static void main(String[] args) {
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
    }
}
