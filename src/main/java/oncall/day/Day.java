package oncall.day;

public class Day {

    private final Month month;
    private final int day;
    private final Week week;

    public Day(Month month, int day, Week week) {
        this.month = month;
        this.day = day;
        this.week = week;
    }

    public boolean isHoliday() {
        return week.isWeekend() || Holiday.isHoliday(month.getMonth(), day);
    }
}
