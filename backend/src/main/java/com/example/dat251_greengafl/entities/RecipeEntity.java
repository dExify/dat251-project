package com.example.dat251_greengafl.entities;

import com.example.dat251_greengafl.model.Difficulty;

public record RecipeEntity(String name, String instructions, Integer cookingTime, Difficulty difficulty) {
}
