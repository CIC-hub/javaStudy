package date_time;

import java.time.*;
import java.time.format.*;

public class Main5DateTimeFormatter {
    public static void main(String[] args) {
        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("1."+dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println("2."+dt);
        System.out.println("3."+dtf.format(dt));
        
        LocalDateTime dt2 = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println("4.dt2  "+dt2);
        System.out.println("5."+dt2.plusDays(5).minusHours(3));
        System.out.println("6."+dt2.minusMonths(1));
        
        LocalDateTime dt3 = LocalDateTime.of(2019, 10, 31, 20, 30, 59);
        System.out.println("7.dt3  "+dt2);        
        System.out.println("8."+dt3.withDayOfMonth(29));
        System.out.println("9."+dt3.withMonth(9));
    }
}
