package com.example.coffeebuilder.drinks;

public enum drinkType {
    COFFEE, TEA;
/* I know the UML diagram calls for two classes one for each drink type, theres nothing really
separating the two and i would rather not have a bunch of duplicate code if i can help it
 */
    public String getDescription() {
        switch (this) {
            case COFFEE:
                return "Coffee";
            case TEA:
                return "Tea";
            default:
                return "Unknown";
        }
    }
}
