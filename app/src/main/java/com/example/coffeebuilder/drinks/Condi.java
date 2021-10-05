package com.example.coffeebuilder.drinks;

import com.example.coffeebuilder.order.Drink;

public class Condi implements Drink {
    private drinkType dType;
    private Boolean milk;
    private Boolean sugar;
    private Boolean lemon;

    public Condi(Builder builder) {
        this.dType = builder.dType;
        this.milk = builder.milk;
        this.sugar = builder.sugar;
        this.lemon = builder.lemon;
    }

    @Override
    public String getDescription() {
        String description = dType.getDescription();
        if(milk)
            description += ", milk";
        if(sugar)
            description += ", sugar";
        if(lemon)
            description += ", lemon";
        return description;
    }

    public static class Builder {
        private drinkType dType;
        private Boolean milk = false;
        private Boolean sugar = false;
        private Boolean lemon = false;

        public Builder(drinkType dType) {
            this.dType = dType;
        }

        public Builder addMilk() {
            this.milk = true;
            return this;
        }

        public Builder addSugar() {
            this.sugar = true;
            return this;
        }

        public Builder addLemon() {
            this.lemon = true;
            return this;
        }

        public Condi build() {
            Condi coffee = new Condi(this);
            return coffee;
        }
    }
}
