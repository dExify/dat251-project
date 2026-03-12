package com.example.dat251_greengafl.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    private String instructions;

    /** Cooking time in minutes. */
    private Integer cookingTime;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "recipe_categories", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "category")
    private Set<FoodCategory> categories = new HashSet<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> ingredients = new ArrayList<>();

    public Recipe() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<FoodCategory> getDirectCategories() {
        return categories;
    }

    public void addCategory(FoodCategory category) {
        this.categories.add(category);
    }

    public void removeCategory(FoodCategory category) {
        this.categories.remove(category);
    }

    /**
     * Returns all categories for this recipe: directly assigned ones plus
     * those derived from its ingredients.
     */
    public Set<FoodCategory> getCategories() {
        return Stream.concat(
                categories.stream(),
                ingredients.stream().flatMap(ri -> ri.getCategories().stream())
        ).collect(Collectors.toSet());
    }
}
