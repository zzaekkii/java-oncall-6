package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.day.Month;
import oncall.day.OncallMonth;
import oncall.day.Week;
import oncall.domain.Employee;
import oncall.domain.OncallOrder;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String SEPARATOR = ",";

    public OncallMonth readOncallMonthInfo() {
        String input = readLine();

        nullCheck(input);

        input = input.trim();

        return separateMonthInfo(input);
    }

    public OncallOrder readOncallOrder() {
        String input = readLine();

        nullCheck(input);

        input = input.trim();

        return separateEmployee(input);
    }

    private OncallOrder separateEmployee(String input) {
        validateSeparatorPattern(input);

        String[] tokens = input.split(SEPARATOR);

        List<Employee> orders = new ArrayList<>();
        for (String token : tokens) {
            nullCheck(token);
            orders.add(Employee.fromString(token));
        }

        if (orders.stream().distinct().count() != orders.size()) {
            throw new IllegalArgumentException("중복된 근무자가 입력되었습니다.");
        }

        return new OncallOrder(orders);
    }

    private OncallMonth separateMonthInfo(String input) {
        validateSeparatorPattern(input);

        String[] tokens = input.split(SEPARATOR);

        if (tokens.length != 2) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }

        for (String token : tokens) {
            nullCheck(token);
        }

        Month month = Month.fromMonth(getMonth(tokens[0]));

        if (!tokens[1].matches("^[가-힣]$")) {
            throw new IllegalArgumentException("요일은 한글을 입력해야 합니다.");
        }
        Week firstDay = Week.fromString(tokens[1]);

        return new OncallMonth(month, firstDay);
    }

    private int getMonth(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("월은 숫자를 입력해야 합니다.");
        }
    }

    private static void nullCheck(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static void validateSeparatorPattern(String value) {
        // 앞/뒤에 등장하지 않아야 함
        if (value.startsWith(",") || value.endsWith(",")) {
            throw new IllegalArgumentException("구분자 형식이 맞지 않습니다.");
        }

        // 연속
        if (value.contains(",,")) {
            throw new IllegalArgumentException("구분자가 연속되어 있습니다.");
        }
    }
}
