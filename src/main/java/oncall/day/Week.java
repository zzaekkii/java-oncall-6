package oncall.day;

public enum Week {
    MON("월", false, 0),
    TUE("화", false, 1),
    WED("수", false, 2),
    THU("목", false, 3),
    FRI("금", false, 4),
    SAT("토", true, 5),
    SUN("일", true, 6);

    private final String label;
    private final boolean isWeekend;
    private final int sequence;

    Week(String label, boolean isWeekend, int sequence) {
        this.label = label;
        this.isWeekend = isWeekend;
        this.sequence = sequence;
    }

    public static Week fromString(String data) {
        for (Week week : Week.values()) {
            if (week.label.equals(data)) {
                return week;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 요일입니다.");
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public Week foundWeekSince(int day) {
        day = (day + sequence) % 7;

        for (Week week: Week.values()) {
            if (week.sequence == day) {
                return week;
            }
        }
        throw new IllegalArgumentException("요일 계산 중 요류가 발생했습니다.");
    }
}
