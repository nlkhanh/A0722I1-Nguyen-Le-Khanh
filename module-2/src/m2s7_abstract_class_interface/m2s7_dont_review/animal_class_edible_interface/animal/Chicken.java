package m2s7_abstract_class_interface.m2s7_dont_review.animal_class_edible_interface.animal;

import m2s7_abstract_class_interface.m2s7_dont_review.animal_class_edible_interface.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "Can fried!";
    }
}