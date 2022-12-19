package com.example.foxclub.services;

import com.example.foxclub.models.Fox;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoxService {
    Fox loadFox(String name);

    List<String> loadFoxTrickList(String name);

    List<String> addTrick(String name, String trick);
}
