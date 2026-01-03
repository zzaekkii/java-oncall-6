package oncall;

public enum Week {
    MON(false),
    TUE(false),
    WED(false),
    THU(false),
    FRI(false),
    SAT(true),
    SUN(true);

    private final boolean isWeekend;

    Week(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}
