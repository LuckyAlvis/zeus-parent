package smart.dai.utils.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String defaultDateFormatter = "yyyy-MM-dd HH:mm:ss";

    public static final String defaultTimeZone = "GMT+8";

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    public static Date now() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取默认格式化日期字符串
     *
     * @return 格式化日期字符串
     */
    public static String getNowString() {
        return new SimpleDateFormat(defaultDateFormatter).format(now());
    }

    /**
     * 计算两个时间间隔毫秒
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static Long between(Date startTime, Date endTime) {

        return getTime(endTime) - getTime(startTime);
    }

    /**
     * 获取毫秒数
     *
     * @param date
     * @return
     */
    static Long getTime(Date date) {
        return date.getTime();
    }
}
