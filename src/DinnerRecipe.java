import java.util.List;

public class DinnerRecipe extends Recipe {

    public DinnerRecipe (String title, List<Ingredient> ingredients, String instructions) {
        super(title, ingredients, instructions, new Category("Dinner"));
    }
}