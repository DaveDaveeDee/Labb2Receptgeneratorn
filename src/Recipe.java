import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String title;
    private List<Ingredient> ingredients; // skiljer sig från Poe 2.0
    private String instructions;

    public Recipe(String title, List<Ingredient> ingredients, String instructions) {
        this.title = title;
        this.ingredients = ingredients; // to prevent nullpointerException // this.ingredients = ingredients != null ? ingredients : new ArrayList<>();
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nIngredients: " + ingredients + "\nInstructions: " + instructions;
    }
}
