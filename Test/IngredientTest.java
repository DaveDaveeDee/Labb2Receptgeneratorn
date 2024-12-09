import org.junit.jupiter.api.Test;

public class IngredientTest {

    @Test
    void testIngredientCreation() {
        Ingredient ingredient = new Ingredient("Honey, 1spoon");
        assertEquals("Honey", ingredient.getName());
        assertEquals("1spoon", ingredient.getQuantity());
    }
}
