package com.example.dat251_greengafl;

import com.example.dat251_greengafl.model.Difficulty;
import com.example.dat251_greengafl.model.Recipe;
import com.example.dat251_greengafl.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class RecipeTests {
    @Autowired
    private RecipeService recipeService;

    @Test
    void testCreateRecipe(){
        Recipe r = new Recipe();
        r.setName("Hamburger");
        r.setInstructions("Cook and serve");
        r.setCookingTime(20);
        r.setDifficulty(Difficulty.EASY);
        Recipe saved = recipeService.register(r);
        assertThat(saved).isNotNull();
        assertThat(saved.getName()).isEqualTo("Hamburger");
        assertThat(saved.getInstructions()).isEqualTo("Cook and serve");
        assertThat(saved.getCookingTime()).isEqualTo(20);
        assertThat(saved.getDifficulty()).isEqualTo(Difficulty.EASY);
        recipeService.deleteById(r.getId());
    }

    @Test
    void testDeleteRecipe(){
        Recipe r = new Recipe();
        r.setName("Hamburger");
        r.setInstructions("Cook and serve");
        Recipe saved = recipeService.register(r);
        recipeService.deleteById(r.getId());
        assertThat(recipeService.findById(saved.getId())).isEmpty();
    }

    @Test
    void testNoDuplicateRecipeName(){
        Recipe r1 = new Recipe();
        r1.setName("Best dish");
        Recipe r2 = new Recipe();
        r2.setName("Best dish");
        recipeService.register(r1);
        assertThatThrownBy(() -> recipeService.register(r2)).isInstanceOf(DataIntegrityViolationException.class);
        recipeService.deleteById(r1.getId());
    }
}
