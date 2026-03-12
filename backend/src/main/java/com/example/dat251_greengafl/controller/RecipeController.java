package com.example.dat251_greengafl.controller;

import com.example.dat251_greengafl.entities.RecipeEntity;
import com.example.dat251_greengafl.model.Recipe;
import com.example.dat251_greengafl.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> findAll(){
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Recipe> findById(@PathVariable UUID id){
        return recipeService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    private Recipe create(@RequestBody RecipeEntity recipe){
        Recipe r = new Recipe();
        r.setName(recipe.name());
        r.setInstructions(recipe.instructions());
        r.setCookingTime(recipe.cookingTime());
        r.setDifficulty(recipe.difficulty());
        return recipeService.register(r);
    }

    @PutMapping
    public Recipe update(@RequestBody Recipe recipe){
        return recipeService.register(recipe);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        recipeService.deleteById(id);
    }

}
