package oncall;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class OncallOrder {
    private Deque<Employee> orders;
    private Stack<Employee> changeLog;

    public void InitializeOrder(List<Employee> orders) {
        this.orders = new ArrayDeque<>(orders);
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
