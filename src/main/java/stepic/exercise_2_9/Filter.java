package stepic.exercise_2_9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter<T> {

    List<T> doFilter(List<T> elements, Predicate<T> predicate) {
        List<T> filterdList = new ArrayList<>();
        for (T element: elements) {
            if (predicate.test(element)) {
                filterdList.add(element);
            }
        }
        return filterdList;
    }

}
