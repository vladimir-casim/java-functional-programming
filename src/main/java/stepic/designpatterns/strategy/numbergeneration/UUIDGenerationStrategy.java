package stepic.designpatterns.strategy.numbergeneration;

import java.util.UUID;

/**
 * Concrete generation strategy. It generates number based on UUID
 */
public class UUIDGenerationStrategy extends GenerationStrategy {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }

}
