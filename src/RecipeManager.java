import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


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

    public void saveRecipesToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Recipes of the Witches Cauldron"));) {
            for (Recipe recipe : recipes) {
                writer.println(recipe);
                writer.println();
            }
            System.out.println("Recipes saved to " + "Recipes of the Witches Cauldron");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        }
}
