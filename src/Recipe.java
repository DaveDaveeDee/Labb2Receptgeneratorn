import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String title;
    private List<Ingredient> ingredients; // skiljer sig från Poe 2.0
    private String instructions;
    private Category category;

    public Recipe(String title, List<Ingredient> ingredients, String instructions, Category category) {
        this.title = title;
        this.ingredients = ingredients; // to prevent nullpointerException // this.ingredients = ingredients != null ? ingredients : new ArrayList<>();
        this.instructions = instructions;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

/*    @Override
    public String toString() {
        return  "Title: " + title +
                "\nCategory: " + category +
                "\nIngredients: " + ingredients +
                "\nInstructions: " + instructions;
    }*/

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", ingredients=" + ingredients +
                ", instructions='" + instructions + '\'' +
                ", category=" + category +
                '}';
    }
}
