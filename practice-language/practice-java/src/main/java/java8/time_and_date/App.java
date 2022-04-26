package java8.time_and_date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class App {
    public static void main(String[] args) {

    }

    private static void DateTimeFormatter() {
        ZonedDateTime today = ZonedDateTime.now();

        // 표준 포맷터
        String formatted = DateTimeFormatter.ISO_DATE_TIME.format(today);

        // 로케일 포맷터
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        String localeFormatted = formatter.format(today);

        // 커스텀 포맷터
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
        String customFormatted = customFormatter.format(today);

        // 파싱
        LocalDate parsedLocalDate = LocalDate.parse("1903-06-14");
        ZonedDateTime parsedZonedDateTime = ZonedDateTime.parse("1969-07-16 03:32:00-0400",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx"));
    }

    private static void ZonedDateTime() {
        // America/New_York의 ZonedDateTime
        ZonedDateTime zonedDateTimeForNewYork = ZonedDateTime.of(
                LocalDate.of(2022, 4, 26),
                LocalTime.of(42, 0, 0, 0),
                ZoneId.of("America/New_York"));

        ZonedDateTime zonedDateTimeForUTC = ZonedDateTime.of(
                LocalDate.of(2022, 4, 26),
                LocalTime.of(3, 42, 0, 0),
                ZoneId.of("UTC"));

        // 일광 절약 시간이 시작할 때는 시계가 1시간 후로 간다.
        // 중유럽은 2013년 3월 31일 2시에 일광 절약시간으로 전환했다.
        // 3월 31일 3시 30분을 생성한다.
        ZonedDateTime skipped = ZonedDateTime.of(
                LocalDate.of(2013, 3, 31),
                LocalTime.of(2, 30),
                ZoneId.of("Europe/Berlin"));
    }

    private static void LocalTime() {
        LocalTime rightNow = LocalTime.now();
        LocalTime bedTime = LocalTime.of(22, 30);
        LocalTime wakeupTime = bedTime.plusHours(8);
    }

    private static void TemporalAdjuster() {
        // 특정 월의 첫 번째 화요일
        LocalDate firstTuesday = LocalDate.of(2022, 5, 1).with(
                TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));

        LocalDate today = LocalDate.now();

        // 다음 번 평일을 구하는 조정기
        TemporalAdjuster NEXT_WORKDAY = w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);
            return result;
        };

        // ofDateAdjuster 를 통해 캐스팅을 제거
        NEXT_WORKDAY = TemporalAdjusters.ofDateAdjuster(w -> {
            LocalDate result = w;
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);
            return result;
        });

        LocalDate backToWork = today.with(NEXT_WORKDAY);
    }

    private static void LocalDateAndPeriod() {
        LocalDate today = LocalDate.now();
        LocalDate myBirthday = LocalDate.of(1992, 10, 4);
        myBirthday = LocalDate.of(2022, Month.OCTOBER, 4);

        // 프로그래머의 날 구하기 -> 프로그래머의 날은 매년 256번째 날이다.
        LocalDate programmersDay = LocalDate.of(2022, 1, 1).plusDays(255);

        LocalDate nextYearMyBirthday = myBirthday.plus(Period.ofYears(1));

        // 윤년인 경우 올바른 결과를 내지 못한다.
//        LocalDate nextYearMyBirthdayByDuration = myBirthday.plus(Duration.ofDays(365));

        Period untilMyBirthday = today.until(myBirthday);
        long untilDaysMyBirthday = today.until(myBirthday, ChronoUnit.DAYS); // 일수

        DayOfWeek dayOfWeek = myBirthday.getDayOfWeek();    // TUESDAY
        int value = dayOfWeek.getValue();   // 2
    }

    private static void InstantAndDuration() {
        Instant start = Instant.now();
        logic();
        Instant end = Instant.now();

        Duration timeElapsed = Duration.between(start, end);
        long millis = timeElapsed.toMillis();

        System.out.println(millis);

        /**
         * 두 가지 timeElapsed 가 있을 때 비교
         */
        Duration timeElapsed2 = Duration.between(start, end);
        boolean overTenTimesFaster = timeElapsed.multipliedBy(10)
                .minus(timeElapsed2)
                .isNegative();
    }

    private static void logic() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
