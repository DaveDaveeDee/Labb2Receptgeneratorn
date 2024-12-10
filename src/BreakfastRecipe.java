import java.util.List;

public class BreakfastRecipe extends Recipe {

    public BreakfastRecipe(String title, List<Ingredient> ingredients, String instructions) {
        super(title, ingredients, instructions, new Category("Breakfast"));
    }
}