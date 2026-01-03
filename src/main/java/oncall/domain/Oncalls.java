package oncall.domain;

import oncall.day.Month;
import oncall.day.Week;

import java.util.List;

public class Oncalls {

    private final Month month;
    private final Week firstDay;
    private final OncallOrder weekdayOncallOrder;
    private final OncallOrder holidayOncallOrder;
    private List<Oncall> schedule;

    public Oncalls(Month month, Week firstDay, OncallOrder weekdayOncallOrder, OncallOrder holidayOncallOrder) {
        this.month = month;
        this.firstDay = firstDay;
        this.weekdayOncallOrder = weekdayOncallOrder;
        this.holidayOncallOrder = holidayOncallOrder;
    }

    public List<Oncall> makeSchedule() {

    }
}
