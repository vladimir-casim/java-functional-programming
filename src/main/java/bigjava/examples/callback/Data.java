package bigjava.examples.callback;

public class Data {

    public static double average(Object[] objects, Measurer measurer) {
        double sum = 0;
        for (Object obj : objects) {
            sum = sum + measurer.measure(obj);
        }

        if (objects.length > 0)
            return sum / objects.length;
        else
            return 0;
    }

}
