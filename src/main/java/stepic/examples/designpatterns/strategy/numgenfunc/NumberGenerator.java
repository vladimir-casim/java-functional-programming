package stepic.examples.designpatterns.strategy.numgenfunc;

public class NumberGenerator {

    // This may be any subclass of GenerationStrategy
    private final GenerationStrategy strategy;

    public NumberGenerator(GenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public String generate() {
        return strategy.generate();
    }

    public GenerationStrategy getStrategy() {
        return strategy;
    }
}
