import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RecipeManagerTest {

    @Test
    void addRecipe() {
        RecipeManager recipeManager = new RecipeManager();
    }

    @Test
    void removeRecipe() {
        RecipeManager recipeManager = new RecipeManager();
    }

    @Test
    void displayRecipes() {
        RecipeManager recipeManager = new RecipeManager();
    }

    @Test
    public void testAddMultipleRecipes() {
        List<Ingredient> ingredients1 = List.of(new Ingredient("Eggs", "2"), new Ingredient("Flour", "1 cup"));
        Recipe recipe1 = new Recipe("Pancakes", ingredients1, "Mix and cook.", new Category("Breakfast"));

        List<Ingredient> ingredients2 = List.of(new Ingredient("Chicken", "1 kg"), new Ingredient("Spices", "to taste"));
        Recipe recipe2 = new Recipe("Grilled Chicken", ingredients2, "Grill until cooked.", new Category("Dinner"));

        RecipeManager.addRecipe(recipe1);
        RecipeManager.addRecipe(recipe2);
        List<Recipe> recipes = RecipeManager.getRecipes();

        assertEquals(2, recipes.size()); // Expecting 2 recipes
        assertEquals("Pancakes", recipes.get(0).getTitle());
        assertEquals("Grilled Chicken", recipes.get(1).getTitle());
    }
}