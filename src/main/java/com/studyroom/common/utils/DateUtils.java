package com.studyroom.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 */
@Slf4j
@Component
public class DateUtils {

    /**
     * 日期格式：yyyy-MM-dd
     */
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 日期时间格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间格式：HH:mm:ss
     */
    public static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * 日期格式化器：yyyy-MM-dd
     */
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * 日期时间格式化器：yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

    /**
     * 时间格式化器：HH:mm:ss
     */
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);

    /**
     * 获取当前日期字符串（yyyy-MM-dd）
     */
    public static String getCurrentDate() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期时间字符串（yyyy-MM-dd HH:mm:ss）
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 获取当前时间字符串（HH:mm:ss）
     */
    public static String getCurrentTime() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    /**
     * 获取当前时间戳（秒）
     */
    public static long getCurrentTimestamp() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 获取当前时间戳（毫秒）
     */
    public static long getCurrentTimestampMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 日期字符串转LocalDate
     */
    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    /**
     * 日期时间字符串转LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    /**
     * 时间字符串转LocalTime
     */
    public static LocalTime parseTime(String timeStr) {
        return LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    /**
     * LocalDate转字符串
     */
    public static String formatDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    /**
     * LocalDateTime转字符串
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DATETIME_FORMATTER);
    }

    /**
     * LocalTime转字符串
     */
    public static String formatTime(LocalTime time) {
        return time.format(TIME_FORMATTER);
    }

    /**
     * Date转LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Date转LocalDate
     */
    public static LocalDate toLocalDate(Date date) {
        return toLocalDateTime(date).toLocalDate();
    }

    /**
     * LocalDateTime转Date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate转Date
     */
    public static Date toDate(LocalDate localDate) {
        return toDate(localDate.atStartOfDay());
    }

    /**
     * 获取指定日期的开始时间（00:00:00）
     */
    public static LocalDateTime getDayStart(LocalDate date) {
        return date.atStartOfDay();
    }

    /**
     * 获取指定日期的结束时间（23:59:59）
     */
    public static LocalDateTime getDayEnd(LocalDate date) {
        return date.atTime(23, 59, 59);
    }

    /**
     * 计算两个日期之间的天数差
     */
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        return Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay()).toDays();
    }

    /**
     * 计算两个时间之间的分钟差
     */
    public static long minutesBetween(LocalDateTime startTime, LocalDateTime endTime) {
        return Duration.between(startTime, endTime).toMinutes();
    }

    /**
     * 计算两个时间之间的小时差
     */
    public static long hoursBetween(LocalDateTime startTime, LocalDateTime endTime) {
        return Duration.between(startTime, endTime).toHours();
    }

    /**
     * 添加天数
     */
    public static LocalDate addDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    /**
     * 添加小时
     */
    public static LocalDateTime addHours(LocalDateTime dateTime, int hours) {
        return dateTime.plusHours(hours);
    }

    /**
     * 添加分钟
     */
    public static LocalDateTime addMinutes(LocalDateTime dateTime, int minutes) {
        return dateTime.plusMinutes(minutes);
    }

    /**
     * 检查时间是否在范围内
     */
    public static boolean isWithinRange(LocalDateTime time, LocalDateTime startTime, LocalDateTime endTime) {
        return !time.isBefore(startTime) && !time.isAfter(endTime);
    }

    /**
     * 检查日期是否在范围内
     */
    public static boolean isDateWithinRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

    /**
     * 获取本周的开始日期（周一）
     */
    public static LocalDate getWeekStart() {
        LocalDate today = LocalDate.now();
        return today.with(DayOfWeek.MONDAY);
    }

    /**
     * 获取本周的结束日期（周日）
     */
    public static LocalDate getWeekEnd() {
        LocalDate today = LocalDate.now();
        return today.with(DayOfWeek.SUNDAY);
    }

    /**
     * 获取本月的开始日期
     */
    public static LocalDate getMonthStart() {
        LocalDate today = LocalDate.now();
        return today.withDayOfMonth(1);
    }

    /**
     * 获取本月的结束日期
     */
    public static LocalDate getMonthEnd() {
        LocalDate today = LocalDate.now();
        return today.withDayOfMonth(today.lengthOfMonth());
    }

    /**
     * 获取指定日期是星期几（中文）
     */
    public static String getChineseDayOfWeek(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY: return "星期一";
            case TUESDAY: return "星期二";
            case WEDNESDAY: return "星期三";
            case THURSDAY: return "星期四";
            case FRIDAY: return "星期五";
            case SATURDAY: return "星期六";
            case SUNDAY: return "星期日";
            default: return "";
        }
    }

    /**
     * 获取时间段描述（如：08:00-12:00）
     */
    public static String getTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime.toLocalTime().toString() + "-" + endTime.toLocalTime().toString();
    }

    /**
     * 字符串转Date（兼容旧代码）
     */
    public static Date parseStringToDate(String dateStr, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            log.error("日期解析失败: {} - {}", dateStr, pattern, e);
            return null;
        }
    }

    /**
     * Date转字符串（兼容旧代码）
     */
    public static String formatDateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取预约时间段列表（每30分钟一段）
     */
    public static String[] generateTimeSlots() {
        String[] slots = new String[48]; // 24小时 * 2（30分钟一段）
        for (int i = 0; i < 48; i++) {
            int hour = i / 2;
            int minute = (i % 2) * 30;
            slots[i] = String.format("%02d:%02d", hour, minute);
        }
        return slots;
    }
}