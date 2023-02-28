package m2s7_abstract_class_interface.m2s7_dont_review.animal_class_edible_interface;

import m2s7_abstract_class_interface.m2s7_dont_review.animal_class_edible_interface.animal.*;
import m2s7_abstract_class_interface.m2s7_dont_review.animal_class_edible_interface.edible.Edible;
import m2s7_abstract_class_interface.m2s7_dont_review.animal_class_edible_interface.fruit.*;

public class AnimalFruitEdibleTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}