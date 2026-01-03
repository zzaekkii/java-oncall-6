package oncall.view;

import oncall.domain.Oncall;

import java.util.List;

public class OutputView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printMonthAndFirstDayRequest() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }

    public void printWeekDayOncallOrderRequest() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printHoliDayOncallOrderRequest() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printResult(List<Oncall> oncallSchedule) {
        System.out.println();

        for(Oncall oncall: oncallSchedule) {
            int month = oncall.day().getMonth().getMonth();
            int day = oncall.day().getDay();
            String week = oncall.day().getWeek().getLabel();

            if(oncall.day().isWeekday() && oncall.day().isHoliday()) {
                week += "(휴일)";
            }

            String employeeName = oncall.employee().name();
            System.out.println(month + "월 " + day + "일 " + week + " " + employeeName);
        }
    }
}
