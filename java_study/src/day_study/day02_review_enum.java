package day_study;

import java.util.Calendar;

    //Calendar 클래스 사용
public class day02_review_enum {
    public static void main(String[] args) {
        day02_Week_enum today = null;
        Calendar now = Calendar.getInstance();
        int week = now.get(Calendar.DAY_OF_WEEK);

        switch (week) {
            case 1:
                today = day02_Week_enum.SUNDAY;
                break;
            case 2:
                today = day02_Week_enum.MONDAY;
                break;
            case 3:
                today = day02_Week_enum.TUESDAY;
                break;
            case 4:
                today = day02_Week_enum.WEDNESDAY;
                break;
            case 5:
                today = day02_Week_enum.THURSDAY;
                break;
            case 6:
                today = day02_Week_enum.FRIDAY;
                break;
            case 7:
                today = day02_Week_enum.SATURDAY;
                break;
        }

        System.out.println("오늘 요일: " + today);
    }
}
