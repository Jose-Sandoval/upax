package com.upax.upax.service;

import com.upax.upax.models.Gender;
import com.upax.upax.repository.GenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GernderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;

    @Override
    public Gender getGender(Long id){
        Optional<Gender> gender = genderRepository.findById(id);
        if (gender.isPresent()){
            return gender.get();
        }else return null;

    }

}
