package oncall.domain;

import oncall.day.Day;
import oncall.day.Month;
import oncall.day.OncallMonth;
import oncall.day.Week;

import java.util.ArrayList;
import java.util.List;

public class Oncalls {

    private final OncallMonth oncallMonth;
    private final OncallOrder weekdayOncallOrder;
    private final OncallOrder holidayOncallOrder;
    private final List<Day> days;
    private List<Oncall> schedule;

    public Oncalls(OncallMonth oncallMonth, OncallOrder weekOrder, OncallOrder holidayOrder) {
        this.oncallMonth = oncallMonth;
        this.weekdayOncallOrder = weekOrder;
        this.holidayOncallOrder = holidayOrder;
        this.days = getDays(oncallMonth);
    }

//    public List<Oncall> makeSchedule() {
//
//    }

    private List<Day> getDays(OncallMonth oncallMonth) {
        List<Day> makingDays = new ArrayList<>();
        Month month = oncallMonth.month();
        Week firstDay = oncallMonth.firstDay();

        for (int day = 1; day <= month.getLastDay(); day++) {
            makingDays.add(new Day(month, day, firstDay.foundWeekSince(day - 1)));
        }
        return makingDays;
    }

}
