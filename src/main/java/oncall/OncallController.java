package oncall;

import oncall.day.OncallMonth;
import oncall.domain.Oncall;
import oncall.domain.OncallOrder;
import oncall.domain.Oncalls;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;

public class OncallController {

    private final InputView inputView;
    private final OutputView outputView;

    public OncallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Oncalls oncalls = makeOncalls();
        List<Oncall> oncallSchedule = oncalls.makeSchedule();
        showOncallSchdule(oncallSchedule);
    }

    private OncallMonth requestOncallMonth() {
        while (true) {
            outputView.printMonthAndFirstDayRequest();

            try {
                return inputView.readOncallMonthInfo();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Oncalls requestOncallOrder(OncallMonth oncallMonth) {
        while (true) {
            try {
                OncallOrder weekDayOncallOrder = requestWeekDayOncallOrder();
                OncallOrder holidayOncallOrder = requestHolidayOncallOrder();
                return new Oncalls(oncallMonth, weekDayOncallOrder, holidayOncallOrder);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private OncallOrder requestWeekDayOncallOrder() {
        while (true) {
            outputView.printWeekDayOncallOrderRequest();

            try {
                return inputView.readOncallOrder();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private OncallOrder requestHolidayOncallOrder() {
        while (true) {
            outputView.printHoliDayOncallOrderRequest();

            try {
                return inputView.readOncallOrder();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Oncalls makeOncalls() {
        OncallMonth oncallMonth = requestOncallMonth();
        return requestOncallOrder(oncallMonth);
    }

    private void showOncallSchdule(List<Oncall> oncallSchedule) {
        outputView.printResult(oncallSchedule);
    }
}
