import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes; // ArrayList?

    public RecipeManager() {
       this.recipes = new ArrayList<Recipe>(); // Recipes?
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public void removeRecipe(String title) {
        boolean removed = recipes.removeIf(recipe -> recipe.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Recipe removed successfully.");
        } else {
            System.out.println("No recipe found with that title.");
        }
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
