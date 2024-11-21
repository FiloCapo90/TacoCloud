package com.example.tacos.web;

import com.example.tacos.Ingredient;
import com.example.tacos.Ingredient.Type;
import com.example.tacos.Order;
import com.example.tacos.Taco;
import com.example.tacos.data.IngredientRepository;
import com.example.tacos.data.TacoRepository;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j //at runtime generate a Simple Logging Facade For Java Logger in the class
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
    
    private final IngredientRepository ingredientRepo;
    
    private TacoRepository designRepo;

    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) { //IngredientRepository or JdbcIngredientRepository?
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }
    
    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }
    
    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }
    
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
        
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), 
                    filterByType(ingredients, type));
        }
        
        //model.addAttribute("taco", new Taco());
        return "design";
    }
    
    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors, @ModelAttribute Order order, Model model){
        if(errors.hasErrors()){
            log.info("error"+errors);
            return showDesignForm(model);
            //return "design";
        }
        
        Taco saved = designRepo.save(taco);
        order.addDesign(saved);
        //Save the taco design..
        //We'll do this in chapter 3
        log.info("Processing design: "+ taco);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList()); 
    }
    
    
}
