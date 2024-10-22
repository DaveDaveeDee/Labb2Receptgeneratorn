import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
     //   fileName = fileName; // "Recipes of the Witches Cauldron";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Recipe recipe : recipes) {
                writer.println("Title: " + recipe.getTitle());
                writer.println("Category: " + recipe.getCategory().getName());
                writer.println("Ingredients:");
                for (Ingredient ingredient : recipe.getIngredients()) {
                    writer.println("- " + ingredient.getName() + ": " + ingredient.getQuantity());
                }
                writer.println("Instructions: " + recipe.getInstructions());
                writer.println(); // Blank line between recipes
            }
            System.out.println("Recipes saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /*// New method to read recipes from a file
    public void loadRecipesFromFile(String fileName) {
      //  try (Scanner scanner = new Scanner(new File(fileName))) {
        try (Scanner scanner = new Scanner(fileName);) {
            while (scanner.hasNextLine()) {
                String title = scanner.nextLine().replace("Title: ", "").trim();
                String categoryLine = scanner.nextLine();
                String category = categoryLine.replace("Category: ", "").trim();
                List<Ingredient> ingredients = new ArrayList<>();

                // Read ingredients
                while (scanner.hasNextLine()) {
                    String ingredientLine = scanner.nextLine();
                    if (ingredientLine.equals("Instructions:")) {
                        break; // Stop reading ingredients when reaching instructions
                    }
                    if (ingredientLine.startsWith("-")) {
                        String[] parts = ingredientLine.substring(1).trim().split(": ");
                        ingredients.add(new Ingredient(parts[0], parts[1])); // Create Ingredient
                    }
                }
            }
        }*//*
    // New method to read recipes from a file
    public void loadRecipesFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
   //     try (Scanner scanner = new Scanner(fileName);) {
      //      try (Scanner scanner = new Scanner(fileName);) {
            while (scanner.hasNextLine()) {
                String title = scanner.nextLine().replace("Title: ", "").trim();
                String categoryLine = scanner.nextLine();
                String category = categoryLine.replace("Category: ", "").trim();
                List<Ingredient> ingredients = new ArrayList<>();

                // Read ingredients
                while (scanner.hasNextLine()) {
                    String ingredientLine = scanner.nextLine();
                    if (ingredientLine.equals("Instructions:")) {
                        break; // Stop reading ingredients when reaching instructions
                    }
                    if (ingredientLine.startsWith("-")) {
                        String[] parts = ingredientLine.substring(1).trim().split(": ");
                        ingredients.add(new Ingredient(parts[0], parts[1])); // Create Ingredient
                    }
                }

                // Read instructions
                String instructions = scanner.nextLine().replace("Instructions: ", "").trim();

                // Create and add the recipe
                Recipe recipe = new Recipe(title, ingredients, instructions, new Category(category));
                addRecipe(recipe);
                scanner.nextLine(); // Skip blank line between recipes
            }
            System.out.println("Recipes loaded from " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }*/

    public void loadRecipesFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String titleLine = scanner.nextLine();
                if (titleLine.isEmpty()) {
                    continue; // Skip empty lines
                }
                String title = titleLine.replace("Title: ", "").trim();

                if (!scanner.hasNextLine()) {
                    break; // Break if no more lines are available
                }
                String categoryLine = scanner.nextLine();
                String category = categoryLine.replace("Category: ", "").trim();

                List<Ingredient> ingredients = new ArrayList<>();

                // Read ingredients
                while (scanner.hasNextLine()) {
                    String ingredientLine = scanner.nextLine();
                    if (ingredientLine.equals("Instructions:")) {
                        break; // Stop reading ingredients when reaching instructions
                    }
                    if (ingredientLine.startsWith("-")) {
                        String[] parts = ingredientLine.substring(1).trim().split(": ");
                        if (parts.length == 2) {
                            ingredients.add(new Ingredient(parts[0], parts[1])); // Create Ingredient
                        }
                    }
                }

                // Read instructions
                if (scanner.hasNextLine()) {
                    String instructionsLine = scanner.nextLine();
                    String instructions = instructionsLine.replace("Instructions: ", "").trim();

                    // Create and add the recipe
                    Recipe recipe = new Recipe(title, ingredients, instructions, new Category(category));
                    addRecipe(recipe);
                }

                // Skip any blank lines after the recipe
                while (scanner.hasNextLine() && scanner.nextLine().isEmpty()) {}
            }
            System.out.println("Recipes loaded from " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
