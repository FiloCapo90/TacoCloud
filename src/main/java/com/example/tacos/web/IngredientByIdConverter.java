package com.example.tacos.web;

import com.example.tacos.Ingredient;
import com.example.tacos.data.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String,Ingredient>{
    
    private IngredientRepository ingredientRepo;

    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String source) {
        return ingredientRepo.findOne(source);
    }
    
}
