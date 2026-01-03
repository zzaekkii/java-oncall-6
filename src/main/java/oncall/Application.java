package oncall;

import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new OncallController(
            new InputView(),
            new OutputView()
        ).run();
    }
}
