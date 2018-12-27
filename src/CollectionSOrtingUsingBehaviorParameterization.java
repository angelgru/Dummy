import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionSOrtingUsingBehaviorParameterization {

    static class Apple {

        String color;
        double weight;

        Apple(String color, double weight) {
            this.color = color;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(
                new Apple("Red", 100),
                new Apple("Green", 120),
                new Apple("Red", 90));

//        Using anonymous class sorting in ascending order
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                if(o1.weight == o2.weight)
                    return 0;
                else if(o1.weight > o2.weight)
                    return 1;
                else
                    return -1;
            }
        });

        for(Apple apple: apples) {
            System.out.println(apple.weight);
        }

//        Using Lambda expression sorting in descending order
        apples.sort((Apple a1, Apple a2) -> {
            if(a1.weight == a2.weight)
                return 0;
            else if(a1.weight < a2.weight)
                return 1;
            else
                return -1;
        });

        for(Apple apple: apples) {
            System.out.println(apple.weight);
        }
    }
}
