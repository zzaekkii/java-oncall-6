package oncall.domain;

import oncall.day.Day;
import oncall.day.Month;
import oncall.day.OncallMonth;
import oncall.day.Week;

import java.util.ArrayList;
import java.util.List;

public class Oncalls {
    private final OncallOrder weekdayOncallOrder;
    private final OncallOrder holidayOncallOrder;
    private final List<Day> days;
    private final List<Oncall> schedule;

    public Oncalls(OncallMonth oncallMonth, OncallOrder weekOrder, OncallOrder holidayOrder) {
        this.weekdayOncallOrder = weekOrder;
        this.holidayOncallOrder = holidayOrder;
        this.days = getDays(oncallMonth);
        schedule = new ArrayList<>();
    }

    public List<Oncall> makeSchedule() {
        for (Day day : days) {
            if (day.isHoliday()) {
                makeOncall(day, holidayOncallOrder);
                continue;
            }

            makeOncall(day, weekdayOncallOrder);
        }

        return schedule;
    }

    private void makeOncall(Day day, OncallOrder oncallOrder) {
        Employee employee = oncallOrder.foundNextEmployee();

        if (schedule.isEmpty()) {
            oncallOrder.canWork();
            schedule.add(new Oncall(day, employee));
            return;
        }

        Employee prevEmployee = schedule.get(schedule.size() - 1).employee();
        if (prevEmployee.equals(employee)) {
            oncallOrder.isContinuous();
            schedule.add(new Oncall(day, oncallOrder.foundNextEmployee()));
            return;
        }

        oncallOrder.canWork();
        schedule.add(new Oncall(day, employee));
    }

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
