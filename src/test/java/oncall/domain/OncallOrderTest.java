package oncall.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OncallOrderTest {

    @Test
    void 다음_순번의_근무자를_반환한다() {
        OncallOrder testOrders = makeTestOrders();

        assertThat(testOrders.foundNextEmployee()).isEqualTo(new Employee("재키"));
    }

    @Test
    void 근무_순번의_근무자가_정상적으로_일_할_수_있으면_근무_순번이_가장_뒤로_넘어간다() {
        OncallOrder testOrders = makeTestOrders();

        testOrders.canWork();
        assertThat(testOrders.foundNextEmployee()).isEqualTo(new Employee("조이"));
    }

    @Test
    void 연속_근무자인_경우_다음_순번의_근무자와_순서를_변경한다() {
        OncallOrder testOrders = makeTestOrders();

        testOrders.isContinuous();

        assertThat(testOrders.foundNextEmployee()).isEqualTo(new Employee("조이"));
    }

    private static OncallOrder makeTestOrders() {
        List<Employee> testEmployees = List.of(new Employee("재키"), new Employee("조이"),
            new Employee("비타민"), new Employee("양송이"), new Employee("맥스"));

        return new OncallOrder(testEmployees);
    }
}