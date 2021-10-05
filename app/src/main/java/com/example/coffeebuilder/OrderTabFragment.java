package com.example.coffeebuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.coffeebuilder.drinks.Condi;
import com.example.coffeebuilder.drinks.extra;
import com.example.coffeebuilder.drinks.drinkType;
import com.example.coffeebuilder.order.Drink;
import com.example.coffeebuilder.views.DrinkMenuView;

public class OrderTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.<DrinkMenuView>findViewById(R.id.order1).setOnButtonClickListener(view1 -> {
            firstOrder();
        });

        view.<DrinkMenuView>findViewById(R.id.order2).setOnButtonClickListener(view1 -> {
            secondOrder();
        });
        view.<DrinkMenuView>findViewById(R.id.order3).setOnButtonClickListener(view1 -> {
            thirdOrder();
        });
    }

    private void firstOrder() {
        Drink drink = new Condi.Builder(drinkType.TEA)
            .addLemon()
            .build();
        showOrderDescription(drink);
    }

    private void secondOrder() {
        Drink drink = new Condi.Builder(drinkType.COFFEE)
                .addMilk()
                .addSugar()
                .build();
        showOrderDescription(drink);
    }

    private void thirdOrder() {
        Drink drink = new Condi.Builder(drinkType.TEA)
                .addSugar()
                .build();
        drink = new extra(drink, "sugar");
        showOrderDescription(drink);
    }



    private void showOrderDescription(@NonNull Drink drink) {

        AlertDialog alert = new AlertDialog.Builder(requireContext())
            .setMessage(drink.getDescription())
            .setCancelable(true)
            .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel())
            .create();
        alert.show();
    }
}
