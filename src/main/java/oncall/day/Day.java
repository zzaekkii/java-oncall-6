package oncall.day;

public class Day {

    private final Month month;
    private final int day;
    private final Week week;
    private final boolean isHoliday;

    public Day(Month month, int day, Week week, boolean isHoliday) {
        this.month = month;
        this.day = day;
        this.week = week;
        this.isHoliday = isHoliday;
    }
}
