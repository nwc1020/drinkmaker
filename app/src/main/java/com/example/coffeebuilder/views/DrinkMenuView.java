package com.example.coffeebuilder.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.coffeebuilder.R;
import com.google.android.material.button.MaterialButton;

public class DrinkMenuView extends ConstraintLayout {

    private TextView nameText;
    private TextView descriptionText;
    private MaterialButton button;

    public DrinkMenuView(@NonNull Context context) {
        super(context);
        initView(context, null, 0, 0);
    }

    public DrinkMenuView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, 0, 0);
    }

    public DrinkMenuView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr, 0);
    }

    public DrinkMenuView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        inflate(context, R.layout.item_drinnk, this);

        nameText = findViewById(R.id.nameText);
        descriptionText = findViewById(R.id.descriptionText);
        button = findViewById(R.id.makeButton);

        int paddingHorizontal = getResources().getDimensionPixelSize(R.dimen.padding_m);
        int paddingVertical = getResources().getDimensionPixelSize(R.dimen.padding_xl);
        setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical);
        int height = getResources().getDimensionPixelSize(R.dimen.item_size_h);
        setMinHeight(height);

        if (attrs != null) {
            TypedArray attributes = context.getTheme()
                    .obtainStyledAttributes(attrs, R.styleable.PizzaMenuView, defStyleAttr, defStyleRes);

            try {
                String name = attributes.getString(R.styleable.PizzaMenuView_name);
                String description = attributes.getString(R.styleable.PizzaMenuView_description);
                String action = attributes.getString(R.styleable.PizzaMenuView_action);

                setName(name);
                setDescription(description);
                setAction(action);
            } finally {
                attributes.recycle();
            }
        }

    }

    public void setName(String name) {
        nameText.setText(name);
    }

    public void setDescription(String description) {
        descriptionText.setText(description);
    }

    public void setAction(String name) {
        button.setText(name);
    }

    public void setOnButtonClickListener(View.OnClickListener listener) {
        button.setOnClickListener(listener);
    }
}
