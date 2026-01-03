package oncall.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class OncallOrder {

    private static final int MINIMUM_EMPLOYEES = 5;
    private static final int MAXIMUM_EMPLOYEES = 35;

    private final Deque<Employee> orders;
    private final Stack<Employee> changeLog;

    public OncallOrder(List<Employee> orders) {
        if(orders.size() < MINIMUM_EMPLOYEES || MAXIMUM_EMPLOYEES < orders.size()) {
            throw new IllegalArgumentException("근무자는 5명 이상, 35명 이하여야 합니다.");
        }

        this.orders = new ArrayDeque<>(orders);
        this.changeLog = new Stack<>();
    }

    public void canWork() {
        if (changeLog.isEmpty()) {
            orders.addLast(orders.removeFirst());
            return;
        }

        while (!changeLog.isEmpty()) {
            orders.addLast(changeLog.pop());
        }
    }

    public void isContinuous() {
        Employee continuousEmployee = orders.removeFirst();
        Employee nextEmployee = orders.removeFirst();

        changeLog.push(nextEmployee);
        changeLog.push(continuousEmployee);
    }

    public Employee foundNextEmployee() {
        if (changeLog.isEmpty()) {
            return orders.getFirst();
        }

        return changeLog.peek();
    }
}
