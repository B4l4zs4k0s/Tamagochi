package com.example.foxclub.repositories;

import com.example.foxclub.models.Fox;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoxRepositoryImpl implements FoxRepository {
    List<Fox> foxes = new ArrayList<>();

    @Override
    public void addFox(Fox fox) {
        foxes.add(fox);
    }

    @Override
    public List<Fox> getFoxes() {
        return foxes;
    }
}
