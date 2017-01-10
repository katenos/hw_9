/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author kate_
 */
public class DateHelper {

    private Calendar startDate = Calendar.getInstance();
    private Calendar currentDate = Calendar.getInstance();
    private static final int DURATION = 45;

    public String getFormattedStartDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
        return sdf.format(startDate.getTime());
    }

    public void skipTime() {
        currentDate.add(Calendar.MINUTE, DURATION);
    }

    public String getFormattedDiff() {
        Calendar distinct = Calendar.getInstance();
        distinct.setTime(new Date(currentDate.getTime().getTime() - startDate.getTime().getTime()));
        long hour = distinct.getTimeInMillis() / 3600000;
        long minutes = (distinct.getTimeInMillis() - hour * 3600000) / 60000;
        return hour + " часов " + minutes + " минут";
    }
}
