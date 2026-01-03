package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.day.Month;
import oncall.day.OncallMonth;
import oncall.day.Week;

public class InputView {
    private static final String SEPARATOR = ",";

    public OncallMonth readOncallMonthInfo() {
        String input = readLine();

        nullCheck(input);

        input = input.trim();

        return separateMonthInfo(input);
    }

    private OncallMonth separateMonthInfo(String input) {
        validateSeparatorPattern(input);

        String[] tokens = input.split(SEPARATOR);

        if (tokens.length != 2) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }

        Month month = Month.fromMonth(getMonth(tokens[0]));
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
