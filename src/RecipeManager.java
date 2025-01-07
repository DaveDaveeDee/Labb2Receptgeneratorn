import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipeList;
    private final String filePath = "recipes.txt";

    public RecipeManager() {
        this.recipeList = new ArrayList<Recipe>();
        loadRecipes();
    }

    public void addRecipe(Recipe recipe) {
        recipeList.add(recipe);
        saveRecipes();
    }

    public List<Recipe> viewRecipes() {
       return new ArrayList<>(recipeList);
    }

    public void removeRecipe(String title) {
        boolean removed = recipeList.removeIf(recipe -> recipe.getTitle().equalsIgnoreCase(title));
        if (removed) {
            saveRecipes();
            System.out.println("Recipe successfully removed.");
        } else {
            System.out.println("Recipe not found.");
        }
    }

    private void saveRecipes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Recipe recipe : recipeList) {
                writer.write(recipe.toString());
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving recipes: " + e.getMessage());
        }
    }

    private void loadRecipes() { // TODO onödig?
        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> recipeLines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (!recipeLines.isEmpty()) {
                        recipeList.add(Recipe.fromString(recipeLines));
                        recipeLines.clear();
                    }
                } else {
                    recipeLines.add(line);
                }
            } if (!recipeLines.isEmpty()) {
                recipeList.add(Recipe.fromString(recipeLines));
            }
        } catch (IOException e) {
            System.out.println("Error loading recipes: " + e.getMessage());
        }
    }
}
