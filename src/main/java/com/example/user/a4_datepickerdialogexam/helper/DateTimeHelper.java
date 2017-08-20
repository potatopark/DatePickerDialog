package com.example.user.a4_datepickerdialogexam.helper;

import java.util.Calendar;

/**
 * Created by user on 2017-08-20.
 */




public class DateTimeHelper {

    private static DateTimeHelper current = null;

    public static DateTimeHelper getInstance(){
        if(current == null){
            current = new DateTimeHelper();
        }
        return current;
    }

    public static void freeinstance(){
        current = null;
    }
    private DateTimeHelper(){
        super();
    }
    public int[] getDate(){
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);

        int[] result = {yy,mm,dd};

        return result;
    }
    public int[] getTime(){
        Calendar calendar = Calendar.getInstance();
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mi = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);

        int [] result = {hh,mi,ss};

        return result;
    }
}
