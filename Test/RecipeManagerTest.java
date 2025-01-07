import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeManagerTest {
    private RecipeManager recipeManager;

    @BeforeEach
    void setUp() {
        recipeManager = new RecipeManager();
        // Clear the recipe list to start fresh for each test
        recipeManager.viewRecipes().clear();
    }

    @Test
    void testAddRecipe() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Eggs", "2"));
        Recipe recipe = new BreakfastRecipe("Omelette", ingredients, "Beat the eggs and cook.");

        recipeManager.addRecipe(recipe);
        List<Recipe> recipes = recipeManager.viewRecipes();

        assertEquals(1, recipes.size());
        assertEquals("Omelette", recipes.get(0).getTitle());
    }

    @Test
    void testViewRecipes() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Tomatoes", "2"));
        Recipe recipe1 = new LunchRecipe("Tomato Salad", ingredients, "Chop tomatoes and serve.");
        recipeManager.addRecipe(recipe1);

        List<Recipe> recipes = recipeManager.viewRecipes();

        assertFalse(recipes.isEmpty());
        assertEquals(1, recipes.size());
        assertEquals("Tomato Salad", recipes.get(0).getTitle());
    }

    @Test
    void testRemoveRecipe() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Flour", "2 cups"));
        Recipe recipe = new DinnerRecipe("Pancakes", ingredients, "Mix ingredients and cook on a skillet.");

        recipeManager.addRecipe(recipe);
        assertEquals(1, recipeManager.viewRecipes().size());

        recipeManager.removeRecipe("Pancakes");
        assertEquals(0, recipeManager.viewRecipes().size());

        // Attempting to remove again should not throw an error and should not change the list
        recipeManager.removeRecipe("Pancakes");
        assertEquals(0, recipeManager.viewRecipes().size());
    }
}