package com.example.foxclub.services;

import com.example.foxclub.models.Fox;
import com.example.foxclub.repositories.FoxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxServiceImpl implements FoxService {
    FoxRepository foxRepository;

    public FoxServiceImpl(FoxRepository foxRepository) {
        this.foxRepository = foxRepository;
    }

    @Override
    public Fox loadFox(String name) {
        Integer index = null;
        for (int i = 0; i < foxRepository.getFoxes().size(); i++) {
            if (name.equals(foxRepository.getFoxes().get(i).getName())) {
                index = i;
            }
        }
        if (index == null) {
            return createFoxAndAddToClub(name);
        }
        return foxRepository.getFoxes().get(index);
    }

    public Fox createFoxAndAddToClub(String name) {
        Fox fox = new Fox(name);
        foxRepository.getFoxes().add(fox);
        return fox;
    }

    public List<String> loadFoxTrickList(String name) {
        return loadFox(name).getListOfTricks();
    }


    public List<String> addTrick(String name, String trick) {
        if (loadFoxTrickList(name).contains(trick)) {
            return loadFoxTrickList(name);
        }
        loadFoxTrickList(name).add(trick);
        return loadFoxTrickList(name);
    }
}
