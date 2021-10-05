package com.example.coffeebuilder.drinks;

import com.example.coffeebuilder.order.Drink;

;

public class extra extends OrderDecorator {
    private String name;

    public extra(Drink drink, String name) {
        super(drink);
        this.name = name;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", +" + name;
    }
}
