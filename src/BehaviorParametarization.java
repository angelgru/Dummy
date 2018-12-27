import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BehaviorParametarization {

    static class Apple {

        String color;
        double weight;

        Apple(String color, double weight) {
            this.color = color;
            this.weight = weight;
        }
    }

    @FunctionalInterface
    interface Predicate {
        boolean test(Apple item);
    }

//    The function's behavior changes due to the different implementation of its second parameter predicate
//    The behavior of filterApples depends on the code we pass via predicate object
    static List<Apple> filterApples(List<Apple> inventory, Predicate predicate) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        class RedApples implements Predicate {

            @Override
            public boolean test(Apple item) {
                return item.color.equals("Red");
            }
        }

        List<Apple> apples = Arrays.asList(new Apple("Red", 100), new Apple("Green", 120));
        apples = filterApples(apples, new RedApples());

        for(Apple apple: apples) {
            System.out.println(apple.color);
        }

        class GreaterThan90 implements Predicate {

            @Override
            public boolean test(Apple item) {
                return item.weight > 90;
            }
        }

        List<Apple> apples1 = Arrays.asList(
                new Apple("Red", 100),
                new Apple("Green", 120),
                new Apple("Red", 90));
        apples1 = filterApples(apples1, new GreaterThan90());
        for(Apple apple: apples1) {
            System.out.println(apple.color);
        }

        System.out.println("Using Lambda expression");
//        Using Lambda expression
        List<Apple> apples2 = Arrays.asList(
                new Apple("Red", 100),
                new Apple("Green", 120),
                new Apple("Red", 90));
        apples2 = filterApples(apples1, (Apple a) -> a.color.equals("Green"));
        for(Apple apple: apples2) {
            System.out.println(apple.color);
        }
    }


}
