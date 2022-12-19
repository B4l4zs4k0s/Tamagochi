package com.example.foxclub.repositories;

import com.example.foxclub.models.Fox;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface FoxRepository {

    List<Fox> foxes = new ArrayList<>();

    void addFox(Fox fox);

    List<Fox> getFoxes();

}
