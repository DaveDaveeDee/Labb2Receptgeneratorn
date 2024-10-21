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
       // this.recipes.remove(title); // recipes.removeIf(recipe -> recipe.getTitle().equalsIgnoreCase(title));
         recipes.removeIf(recipe -> recipe.getTitle().equalsIgnoreCase(title));
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
