package stepic.designpatterns.strategy.numbergeneration;

import java.util.Random;

/**
 * Concrete generation strategy. It generates number based on the prefix and a random value
 */
public class FormattedRandomGenerationStrategy extends GenerationStrategy {
    private final Random random = new Random();

    @Override
    public String generate() {
        return "111-123-" + Math.abs(random.nextInt());
    }
}
