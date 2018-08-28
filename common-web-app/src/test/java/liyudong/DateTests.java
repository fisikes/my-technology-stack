package liyudong;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 时间戳 & LocalDatetime 互转
 * Created by lydon on 2018/8/28.
 */
public class DateTests {

    @Test
    public void unixToLocalDateTime() {
        // 获取时间戳
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(timestamp);

        // 时间戳转LocalDateTime
        LocalDateTime time = LocalDateTime.ofEpochSecond(timestamp / 1000, 0, ZoneOffset.ofHours(8));

        System.out.println(time);

        System.out.println(time.getHour());

    }

}
