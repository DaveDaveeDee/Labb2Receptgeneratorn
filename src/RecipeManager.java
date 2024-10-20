import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes;

    public RecipeManager() {
       this.recipes = new ArrayList<Recipe>(); // Recipes?
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        this.recipes.remove(recipe); // recipes.removeIf(recipe -> recipe.getTitle().equalsIgnoreCase(title));
    }

    public void displayRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("no recipes available.");
            return;
        }
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
            System.out.println();
        }
    }
}
