import java.util.List;

public class LunchRecipe extends Recipe {

    public LunchRecipe(String title, List<Ingredient> ingredients, String instructions) {
        super(title, ingredients, instructions, new Category("Lunch"));
    }
}