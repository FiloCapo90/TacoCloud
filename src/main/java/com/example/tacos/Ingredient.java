package com.example.tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
//@Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
//annotations on the class (except that no constructor will be generated if any explicitly written constructors 
//already exist).
public class Ingredient {
    
    private final String id;
    private final String name;
    private final Type type;
    
    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
