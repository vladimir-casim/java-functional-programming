package stepic.examples.designpatterns.strategy.numbergeneration;

public class TestNumberGenerator {

    public static void main(String[] args) {
        final NumberGenerator uuidGenerator = new NumberGenerator(new UUIDGenerationStrategy());
        System.out.println(uuidGenerator.generate());
        final NumberGenerator randomGenerator = new NumberGenerator(new FormattedRandomGenerationStrategy());
        System.out.println(randomGenerator.generate());
    }

}
