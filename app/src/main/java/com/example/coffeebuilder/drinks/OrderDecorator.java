package com.example.coffeebuilder.drinks;

import com.example.coffeebuilder.order.Drink;

public abstract class OrderDecorator implements Drink {
    private Drink drink;

    public OrderDecorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String getDescription() {
        return drink.getDescription();
    }
}
