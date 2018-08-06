package com.kaihuang.commondemo.common.utils;

import android.text.format.Time;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * 对于时间的帮助类
 *
 * @author admin
 */
public class DateUtil {


    /**
     * 获取当前月
     *
     * @return
     */
    public static String getNowMonth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String dateString = simpleDateFormat.format(new Date());

        return dateString;
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getNowDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = simpleDateFormat.format(new Date());

        return dateString;
    }

    /**
     * 获取前n天日期、后n天日期
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDate(int distanceDay) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        LogUtil.d("前7天==" + dft.format(endDate));
        return dft.format(endDate);
    }

//    /**
//     * 获取当前时间
//     *
//     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
//     * @return
//     */
//    public static String getNowDate() {
//        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Date beginDate = new Date();
//        Calendar date = Calendar.getInstance();
//        date.setTime(beginDate);
//        Date endDate = null;
//        try {
//            endDate = dft.parse(dft.format(date.getTime()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
////        LogUtil.d("前7天==" + dft.format(endDate));
//        return dft.format(endDate);
//    }

    /**
     * 比较两个日期的大小，日期格式为yyyy-MM-dd
     *
     * @param str1 the first date
     * @param str2 the second date
     * @return true <br/>false
     */
    public static boolean isDateOneBigger(String str1, String str2) {
        boolean isBigger = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = sdf.parse(str1);
            dt2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dt1.getTime() > dt2.getTime()) {
            isBigger = true;
        } else if (dt1.getTime() < dt2.getTime()) {
            isBigger = false;
        }
        return isBigger;
    }

    /**
     * 比较两个日期的大小，日期格式为yyyy-MM-dd
     *
     * @param str1 the first date
     * @param str2 the second date
     * @return true <br/>false
     */
    public static boolean isDate2Bigger(String str1, String str2) {
        boolean isBigger = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = sdf.parse(str1);
            dt2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dt1.getTime() > dt2.getTime()) {
            isBigger = false;
        } else if (dt1.getTime() <= dt2.getTime()) {
            isBigger = true;
        }
        return isBigger;
    }


    public static String getDateByFormat(Date date, String reg) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(reg);

        return dateFormat.format(date);
    }

    public static String getCurrentDate() {
        return getDateByFormat(new Date(), "yyyy年MM月dd日 HH:mm");
    }

    public static String getNoewDate() {//获取当前时间，年月日时分
        return getDateByFormat(new Date(), "yyyy-MM-dd HH:mm");
    }

    public static String getCurrentDate1() {
        return getDateByFormat(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateToStr() {
        return getDateByFormat(new Date(), "yyyy-MM-dd");
    }

    public static String getDate(String reg) {
        return getDateByFormat(new Date(), reg);
    }

    public static Date getDate(String reg, String datestr) {
        try {
            return new SimpleDateFormat(reg).parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    //判断是否是long型时间，
    public static String checkDatatype(String currentTime) {
        String datestr = currentTime;
        String chedata = currentTime.substring(0, 2);
        if (currentTime != null && chedata.equals("15")) {
            try {
                datestr = longToString(Long.parseLong(currentTime), "yyyy-MM-dd HH:mm");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {

        }
        return datestr;
    }

    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }




    /**
     * 只是比较到日
     *
     * @param date
     * @param date2
     * @return
     */
    public static int compareDate(Date date, Date date2) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        Calendar cl2 = Calendar.getInstance();
        cl2.setTime(date2);
        if (cl.get(Calendar.YEAR) > cl2.get(Calendar.YEAR)) {
            return 1;
        } else if (cl.get(Calendar.YEAR) < cl2.get(Calendar.YEAR)) {
            return -1;
        } else {
            if (cl.get(Calendar.MONTH) > cl2.get(Calendar.MONTH)) {
                return 1;
            } else if (cl.get(Calendar.MONTH) < cl2.get(Calendar.MONTH)) {
                return -1;
            } else {
                if (cl.get(Calendar.DAY_OF_MONTH) > cl2
                        .get(Calendar.DAY_OF_MONTH)) {
                    return 1;
                } else if (cl.get(Calendar.DAY_OF_MONTH) < cl2
                        .get(Calendar.DAY_OF_MONTH)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    //日期减去用户的生日来得到用户的年龄有多少年月日
    public static String getYoufuData(String birthday) {
//        birthday =  "2016-11-07 08:55";
        String y, m, d;
        SimpleDateFormat formatBirthday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        int yearBirthday = 0, monthBirthday = 0, dayBirthday = 0, hourBirthday = 0, minuteBirthday = 0, secondBirthday = 0;
        try {
            if (birthday.trim().length() > 17) {

            } else {
                return birthday;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return birthday;

        }
        try {
            Date dateBirthday = formatBirthday.parse(birthday);
//            Date dateBirthday = formatBirthday.parse( "2016-11-07 08:55" );
            Calendar calendarBirthday = Calendar.getInstance();
            calendarBirthday.setTime(dateBirthday);
            yearBirthday = calendarBirthday.get(Calendar.YEAR);
            monthBirthday = calendarBirthday.get(Calendar.MONTH) + 1;
            dayBirthday = calendarBirthday.get(Calendar.DAY_OF_MONTH);
            hourBirthday = calendarBirthday.get(Calendar.HOUR_OF_DAY);
            minuteBirthday = calendarBirthday.get(Calendar.MINUTE);
            secondBirthday = calendarBirthday.get(Calendar.SECOND);
        } catch (ParseException e) {
            e.printStackTrace();
            return birthday;
        }
        SimpleDateFormat formatMoment = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Calendar calendarMoment = Calendar.getInstance();
        int yearMoment = 0, monthMoment = 0, dayMoment = 0, hourMoment = 0, minuteMoment = 0, secondMoment = 0;
        ;
        try {
            Time time = new Time();
            time.setToNow();
            yearMoment = time.year;
            monthMoment = time.month + 1;
            dayMoment = time.monthDay;
            hourMoment = time.hour;
            minuteMoment = time.minute;
            secondMoment = time.second;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (yearBirthday > yearMoment || yearBirthday == yearMoment && monthBirthday > monthMoment || yearBirthday == yearMoment && monthBirthday == monthMoment && dayBirthday > dayMoment) {
            return birthday;
        } else {
            int yearAge = yearMoment - yearBirthday;
            int monthAge = monthMoment - monthBirthday;
            int dayAge = dayMoment - dayBirthday;
            int hourAge = hourMoment - hourBirthday;
            int minuteAge = minuteMoment - minuteBirthday;
            //按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减
            //按照减法原理，先year相减，
            if (yearAge > 0) {//不是同一年
//                return birthday;
                return yearBirthday + "-" + (monthBirthday < 10 ? "0" + monthBirthday : monthBirthday) + "-" + (dayBirthday < 10 ? "0" + dayBirthday : dayBirthday) + "  " + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday);

            } else if (monthAge > 0) {//是同一年，但不是同一个月
                return (monthBirthday < 10 ? "0" + monthBirthday : monthBirthday) + "-" + (dayBirthday < 10 ? "0" + dayBirthday : dayBirthday) + "  " + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday);
            } else if (dayAge > 0) {//不是同一天
                if (dayAge == 1) {
                    return "昨天" + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday) + ":" + (secondBirthday < 10 ? "0" + secondBirthday : secondBirthday);
                } else {
                    return (monthBirthday < 10 ? "0" + monthBirthday : monthBirthday) + "-" + (dayBirthday < 10 ? "0" + dayBirthday : dayBirthday) + "  " + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday);
                }

            } else if (hourAge > 0) {//不是同一个小时内
                return "今天" + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday);
            } else if (Math.abs(minuteAge) > 0) {//不是同意分钟内
                return Math.abs(minuteAge) + "分钟前";
            } else {//错误
                return "刚刚";
            }

        }
    }

    //日期减去用户的生日来得到用户的年龄有多少年月日
    public static String getQuChangData(String birthday) {
//        birthday =  "2016-11-07 08:55";
        String y, m, d;
        SimpleDateFormat formatBirthday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        int yearBirthday = 0, monthBirthday = 0, dayBirthday = 0, hourBirthday = 0, minuteBirthday = 0, secondBirthday = 0;
        try {
            Date dateBirthday = formatBirthday.parse(birthday);
//            Date dateBirthday = formatBirthday.parse( "2016-11-07 08:55" );
            Calendar calendarBirthday = Calendar.getInstance();
            calendarBirthday.setTime(dateBirthday);
            yearBirthday = calendarBirthday.get(Calendar.YEAR);
            monthBirthday = calendarBirthday.get(Calendar.MONTH) + 1;
            dayBirthday = calendarBirthday.get(Calendar.DAY_OF_MONTH);
            hourBirthday = calendarBirthday.get(Calendar.HOUR_OF_DAY);
            minuteBirthday = calendarBirthday.get(Calendar.MINUTE);
            secondBirthday = calendarBirthday.get(Calendar.SECOND);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat formatMoment = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Calendar calendarMoment = Calendar.getInstance();
        int yearMoment = 0, monthMoment = 0, dayMoment = 0, hourMoment = 0, minuteMoment = 0, secondMoment = 0;
        ;
        try {
            Time time = new Time();
            time.setToNow();
            yearMoment = time.year;
            monthMoment = time.month + 1;
            dayMoment = time.monthDay;
            hourMoment = time.hour;
            minuteMoment = time.minute;
            secondMoment = time.second;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        LogUtils.sysout( "**********************************************************" );
//        LogUtils.sysout( "+++++yearMoment ="+yearMoment+"monthMoment="+monthMoment+"dayMoment="+dayMoment+"hourMoment="+hourMoment +"minuteMoment="+minuteMoment);
//        LogUtils.sysout( "+++++yearBirthday ="+yearBirthday+"monthBirthday="+monthBirthday+"dayBirthday="+dayBirthday+"hourBirthday="+hourBirthday +"minuteBirthday="+minuteBirthday);

        if (yearBirthday > yearMoment || yearBirthday == yearMoment && monthBirthday > monthMoment || yearBirthday == yearMoment && monthBirthday == monthMoment && dayBirthday > dayMoment) {

//            y = "??年";
//            m = "??月";
//            d = "??日";
//            LogUtils.sysout( "999999999999999999" );
//            LogUtils.sysout( "yearBirthday > yearMoment" );
            return birthday;
//            return "??年-??月-??日";
        } else {
//            LogUtils.sysout( "yearMoment ="+yearMoment+"monthMoment="+monthMoment+"dayMoment="+dayMoment+"hourMoment="+hourMoment +"minuteMoment="+minuteMoment);
//            LogUtils.sysout( "yearBirthday ="+yearBirthday+"monthBirthday="+monthBirthday+"dayBirthday="+dayBirthday+"hourBirthday="+hourBirthday +"minuteBirthday="+minuteBirthday);
            int yearAge = yearMoment - yearBirthday;
            int monthAge = monthMoment - monthBirthday;
            int dayAge = dayMoment - dayBirthday;
            int hourAge = hourMoment - hourBirthday;
            int minuteAge = minuteMoment - minuteBirthday;
            //按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减
            //按照减法原理，先year相减，
            if (yearAge > 0) {//不是同一年
                return birthday;
            } else if (monthAge > 0) {//是同一年，但不是同一个月
                return (monthBirthday < 10 ? "0" + monthBirthday : monthBirthday) + "月" + (dayBirthday < 10 ? "0" + dayBirthday : dayBirthday) + "日 " + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday) + ":" + (secondBirthday < 10 ? "0" + secondBirthday : secondBirthday);
            } else if (dayAge > 0) {//不是同一天
                if (dayAge == 1) {
                    return "昨天" + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday) + ":" + (secondBirthday < 10 ? "0" + secondBirthday : secondBirthday);
                } else {
                    return (monthBirthday < 10 ? "0" + monthBirthday : monthBirthday) + "月" + (dayBirthday < 10 ? "0" + dayBirthday : dayBirthday) + "日 " + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday) + ":" + (secondBirthday < 10 ? "0" + secondBirthday : secondBirthday);
                }

            } else if (hourAge > 0) {//不是同一个小时内
//                hourBirthday = 0,minuteBirthday = 0,secondBirthday = 0;
                return "今天" + (hourBirthday < 10 ? "0" + hourBirthday : hourBirthday) + ":" + (minuteBirthday < 10 ? "0" + minuteBirthday : minuteBirthday) + ":" + (secondBirthday < 10 ? "0" + secondBirthday : secondBirthday);
            } else if (Math.abs(minuteAge) > 0) {//不是同意分钟内
//                return minuteBirthday+ ":"+secondBirthday;
                return Math.abs(minuteAge) + "分钟前";
            } else {//错误
//                return birthday;
                return "刚刚";
            }

        }
    }

    //日期减去用户的生日来得到用户的年龄有多少年月日
    private void getAge(String birthday, String time, TextView tvAgeYear, TextView tvAgeMonth, TextView tvAgeDay) {
        SimpleDateFormat formatBirthday = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        int yearBirthday = 0, monthBirthday = 0, dayBirthday = 0;
        try {
            Date dateBirthday = formatBirthday.parse(birthday);
            Calendar calendarBirthday = Calendar.getInstance();
            calendarBirthday.setTime(dateBirthday);
            yearBirthday = calendarBirthday.get(Calendar.YEAR);
            monthBirthday = calendarBirthday.get(Calendar.MONTH);
            dayBirthday = calendarBirthday.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat formatMoment = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Calendar calendarMoment = Calendar.getInstance();
        int yearMoment = 0, monthMoment = 0, dayMoment = 0;
        try {
            Date dateMoment = formatMoment.parse(time);
            calendarMoment.setTime(dateMoment);
            yearMoment = calendarMoment.get(Calendar.YEAR);
            monthMoment = calendarMoment.get(Calendar.MONTH);
            dayMoment = calendarMoment.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (yearBirthday > yearMoment || yearBirthday == yearMoment && monthBirthday > monthMoment || yearBirthday == yearMoment && monthBirthday == monthMoment && dayBirthday > dayMoment) {
            tvAgeYear.setText("??年");
            tvAgeMonth.setText("??月");
            tvAgeDay.setText("??天");
        } else {
            int yearAge = yearMoment - yearBirthday;
            int monthAge = monthMoment - monthBirthday;
            int dayAge = dayMoment - dayBirthday;
            //按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减
            if (dayAge < 0) {
                monthAge -= 1;
                calendarMoment.add(Calendar.MONTH, -1);//得到上一个月，用来得到上个月的天数
                dayAge = dayAge + calendarMoment.getActualMaximum(Calendar.DAY_OF_MONTH);
            }
            if (monthAge < 0) {
                monthAge = (monthAge + 12) % 12;
                yearAge--;
            }
            String year, month, day;
            if (yearAge < 10) {
                year = "0" + yearAge + "年";
            } else {
                year = yearAge + "年";
            }
            if (monthAge < 10) {
                month = "0" + monthAge + "月";
            } else {
                month = monthAge + "月";
            }
            if (dayAge < 10) {
                day = "0" + dayAge + "天";
            } else {
                day = dayAge + "天";
            }
            tvAgeYear.setText(year);
            tvAgeMonth.setText(month);
            tvAgeDay.setText(day);
        }
    }
    /**
     * 得到当前时间
     *
     * @param dateFormat 时间格式
     * @return 转换后的时间格式
     */
    public static String getStringToday(String dateFormat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将字符串型日期转换成日期
     *
     * @param dateStr    字符串型日期
     * @param dateFormat 日期格式
     * @return
     */
    public static Date stringToDate(String dateStr, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String dateToString(Date date, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    /**
     * 两个时间点的间隔时长（分钟）
     *
     * @param before 开始时间
     * @param after  结束时间
     * @return 两个时间点的间隔时长（分钟）
     */
    public static long compareMin(Date before, Date after) {
        if (before == null || after == null) {
            return 0l;
        }
        long dif = 0;
        if (after.getTime() >= before.getTime()) {
            dif = after.getTime() - before.getTime();
        } else if (after.getTime() < before.getTime()) {
            dif = after.getTime() + 86400000 - before.getTime();
        }
        dif = Math.abs(dif);
        return dif / 60000;
    }

    /**
     * 获取指定时间间隔分钟后的时间
     *
     * @param date 指定的时间
     * @param min  间隔分钟数
     * @return 间隔分钟数后的时间
     */
    public static Date addMinutes(Date date, int min) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, min);
        return calendar.getTime();
    }

    /**
     * 根据时间返回指定术语，自娱自乐，可自行调整
     *
     * @param hourday 小时
     * @return
     */
    public static String showTimeView(int hourday) {
        if (hourday >= 22 && hourday <= 24) {
            return "晚上";
        } else if (hourday >= 0 && hourday <= 6) {
            return "凌晨";
        } else if (hourday > 6 && hourday <= 12) {
            return "上午";
        } else if (hourday > 12 && hourday < 22) {
            return "下午";
        }
        return null;
    }



}
