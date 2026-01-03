package oncall.view;

public class OutputView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printMonthAndFirstDayRequest() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
