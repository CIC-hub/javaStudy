package date_time;

import java.time.*;
import java.time.format.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

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
        // 本月第一天0:00时刻:       
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);
        // 本月最后1天:     
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);
        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);
   
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.of(2019, 11,19,8,15,0);
        System.out.println(now.isBefore(target));
//        System.out.println(LocalDate.now().isBefore(target));
        System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));
    }
}
