import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {

    @Test
    void testRecipeCreation() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Ham", "700g"));
        Recipe recipe = new Recipe("Christmas Ham", ingredients, "Slice and cook.", new Category("Breakfast"));

        assertEquals("Christmas Ham", recipe.getTitle());
        assertEquals(1, recipe.getIngredients().size());
        assertEquals("Slice and cook.", recipe.getInstructions());
        assertEquals("Breakfast", recipe.getCategory().getName());
        assertEquals("Christmas Ham, Breakfast, Slice and cook.", recipe.getIngredients().toString());
    }
}
