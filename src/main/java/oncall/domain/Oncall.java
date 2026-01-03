package oncall.domain;

import oncall.day.Day;

public record Oncall(
    Day day,
    Employee employee
) {
}
