package com.zxy.JDK8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Instant：一个瞬间点
 * Duration：两个Instant之间的距离
 * LocalDate：本地日期，不带时区
 * Period：两个LocalDate之间的距离
 * LocalTime：本地时间
 * LocalDateTime：日期+时间
 * ZonedDateTime：带时区的时间
 */
public class TestDate {
    public static void main(String[] args) {
        System.out.println(Instant.now().getEpochSecond());
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        System.out.println(System.currentTimeMillis());
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
        System.out.println(legacyDate);

        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");   // ZoneRules[currentStandardOffset=+01:00]
        ZoneId zone2 = ZoneId.of("Asia/Shanghai");   // ZoneRules[currentStandardOffset=+08:00]
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        System.out.println(Clock.systemDefaultZone().getZone());
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));  // true
        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween);       // 6
        System.out.println(minutesBetween);     // 360

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.CHINESE);
        LocalTime leetTime = LocalTime.parse("下午1:37", formatter);
        System.out.println(leetTime);   // 13:37
        formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.CHINESE);
        System.out.println(leetTime.format(formatter));

        LocalDate today = LocalDate.now();
        System.out.println("today:" + today);
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println("tomorrow:" + tomorrow);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println("yesterday:" + yesterday);
        LocalDate independenceDay = LocalDate.of(2016, Month.JANUARY, 1);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);
        System.out.println(LocalDate.ofEpochDay(1));

        LocalDate today2 = LocalDate.now();
        LocalDateTime eatLunch = today2.atTime(12, 30);
        System.out.println(eatLunch);

        formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(LocalDate.parse("2017/07/02", formatter));

        Period sixMonths = Period.ofMonths(6);
        System.out.println(LocalDate.now().plus(sixMonths));

        Duration twoHour = Duration.ofHours(2);
        System.out.println(LocalTime.now().minus(twoHour));

        LocalTime time1 = LocalTime.of(12, 0);
        LocalTime time2 = LocalTime.of(13, 10);
        Duration duration = Duration.between(time1, time2);
        System.out.println(duration.getSeconds());
    }

}
