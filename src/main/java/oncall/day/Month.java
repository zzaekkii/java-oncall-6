package oncall.day;

public enum Month {
    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    private final int month;
    private final int lastDay;

    Month(int month, int lastDay) {
        this.month = month;
        this.lastDay = lastDay;
    }

    public static Month fromMonth(int month) {
        for (Month mon: Month.values()) {
            if (mon.month == month) {
                return mon;
            }
        }
        throw new IllegalArgumentException("1부터 12까지의 숫자만 입력해야 합니다.");
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay() {
        return lastDay;
    }
}
