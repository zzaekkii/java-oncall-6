package oncall.day;

public enum Holiday {
    SINJEONG(1, 1, "신정"),
    SAMIL(3, 1, "삼일절"),
    CHILD(5, 5, "어린이날"),
    MEMORIAL(6, 6, "현충일"),
    LIBERATION(8, 15, "광복절"),
    FOUNDATIONAL(10, 3, "개천절"),
    KOREAN(10, 9, "한글날"),
    CHRISTMAS(12, 25, "성탄절");

    private final int month;
    private final int day;
    private final String label;

    Holiday(int month, int day, String label) {
        this.month = month;
        this.day = day;
        this.label = label;
    }
}
