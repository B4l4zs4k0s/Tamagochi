package com.example.foxclub.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fox {
    private String name;
    private List<String> listOfTricks;
    private String food;
    private String drink;

    public Fox(String name) {
        this.name = name;
        food = "meat";
        drink = "water";
        listOfTricks = new ArrayList<>();
    }
}
