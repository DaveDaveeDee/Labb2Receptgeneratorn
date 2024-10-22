import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecipeManager {
    private List<Recipe> recipes = new ArrayList<>();

    public RecipeManager() {
       this.recipes = new ArrayList<Recipe>();
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
        System.out.println("Recipe added: " + recipe.getTitle()); // Debugging line
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Recipe recipe : recipes) {
                writer.println("Title: " + recipe.getTitle());
                writer.println("Category: " + recipe.getCategory().getName());
                writer.println("Ingredients:");
                for (Ingredient ingredient : recipe.getIngredients()) {
                    writer.println("- " + ingredient.getName() + ": " + ingredient.getQuantity());
                }
                writer.println("Instructions: " + recipe.getInstructions());
                writer.println();
            }
            System.out.println("Recipes saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // kan läsa men måste få till att lagra ner recepten från fil till programmets Array
    public void loadFromFile(String fileNameToLoad) {
        File infile = new File(fileNameToLoad);
        try (Scanner input = new Scanner(infile);) {
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen gick inte att öppna: " + e);
        }
    }
}