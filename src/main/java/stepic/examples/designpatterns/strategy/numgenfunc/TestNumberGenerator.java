package stepic.examples.designpatterns.strategy.numgenfunc;

import java.util.Random;
import java.util.UUID;

public class TestNumberGenerator {

    public static void main(String[] args) {
        // It's instead of UUIDGeneratingStrategy
        final NumberGenerator uuidGenerator = new NumberGenerator(() -> UUID.randomUUID().toString());
        System.out.println(uuidGenerator.generate());

        final Random random = new Random();
        final NumberGenerator testGenerator = new NumberGenerator(() -> "test-" + String.valueOf(random.nextInt(100)));
        System.out.println(testGenerator.generate());
    }

}
