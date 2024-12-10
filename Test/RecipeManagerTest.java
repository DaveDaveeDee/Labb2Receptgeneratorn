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
        recipeManager.viewRecipes().clear(); // Start fresh for each test
    }

    @Test
    void testAddRecipe() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Eggs", "2"));
        Recipe recipe = new BreakfastRecipe("ScrambledEggs", ingredients, "Whisp and cook.");

        recipeManager.addRecipe(recipe);
        List<Recipe> recipes = recipeManager.viewRecipes();

        assertEquals(1, recipes.size());
        assertEquals("ScrambledEggs", recipes.get(0).getTitle());
    }

    @Test
    void testRemoveRecipe() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Flour", "2 cups"));
        Recipe recipe = new DinnerRecipe("Buns", ingredients, "Mix and cook in oven.");

        recipeManager.addRecipe(recipe);
        assertEquals(1, recipeManager.viewRecipes().size());

        recipeManager.removeRecipe("Pancakes");
        assertEquals(0, recipeManager.viewRecipes().size());
    }

    @Test
    void testViewRecipes() {
        List<Recipe> recipes = recipeManager.viewRecipes();
        System.out.println("Recipes in the list. " + recipes);
        assertEquals(0, recipes.size());
    }

}