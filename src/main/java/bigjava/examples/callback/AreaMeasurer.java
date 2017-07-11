package bigjava.examples.callback;

import java.awt.*;

public class AreaMeasurer implements Measurer {

    @Override
    public double measure(Object anObject) {
        Rectangle aRectangle = (Rectangle) anObject;
        double area = aRectangle.getWidth() * aRectangle.getHeight();
        return area;
    }

}
