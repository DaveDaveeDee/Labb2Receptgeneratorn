import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meny {

    public static void menuChoice() {
        RecipeManager recipeManager = new RecipeManager();
        Scanner sc = new Scanner(System.in);

        boolean inMenu = true;

        while (inMenu) {
            System.out.println("\nWhat would you like to do?" +
                    "\n1. Add recipe." +
                    "\n2. View recipe." +
                    "\n3. Remove recipe." +
                    "\n4. Save recipe to file." +
                    "\n5. Load recipe from file." +
                    "\n0. Close cooking book.");
            System.out.print("Enter number for choice > ");

            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter recipe title > ");
                    String title = sc.nextLine();

                    List<Ingredient> ingredients = new ArrayList<>();
                    String addMore;
                    do {
                        System.out.print("Enter ingredient name > ");
                        String ingredientName = sc.nextLine();
                        System.out.print("Enter ingredient quantity > ");
                        String ingredientQuantity = sc.nextLine();
                        ingredients.add(new Ingredient(ingredientName, ingredientQuantity)); // calls the constructor

                        System.out.print("Add more ingredients? (yes/no) > ");
                        addMore = sc.nextLine();
                        while ((!(addMore.equalsIgnoreCase("yes") || addMore.equalsIgnoreCase("no")))) {
                            System.out.print("Enter yes/no > ");
                            addMore = sc.nextLine();
                        }
                    } while (addMore.equalsIgnoreCase("yes"));

                    System.out.print("Enter instructions > ");
                    String instructions = sc.nextLine();

/*
                    System.out.print("Enter category > ");
                    String categoryName = sc.nextLine();
                    Category category = new Category(categoryName);
*/

                    // Display category options
                    System.out.println("Enter a number for this meals category: ");
                    for (CategoryType category : CategoryType.values()) {
                        System.out.println(category.ordinal() + 1 + ". " + category.getDisplayName());
                    }
                    System.out.print("> ");
                    // Get user choice
                    int categoryChoice = sc.nextInt();
                    sc.nextLine(); // Clear the newline character
                    CategoryType selectedCategory = CategoryType.values()[categoryChoice - 1];
                    Category category = new Category(selectedCategory.getDisplayName());

                    Recipe newRecipe = new Recipe(title, ingredients, instructions, category);
                    recipeManager.addRecipe(newRecipe);
                    System.out.println("Recipe added!\n");
                    break;

                case 2:
                    recipeManager.displayRecipes();
                    break;

                case 3:
                    System.out.print("Enter recipe title to remove > ");
                    String removeTitle = sc.nextLine();
                    recipeManager.removeRecipe(removeTitle);
                    break;

                case 4:
                    System.out.print("Enter filename to save recipes (e.g., recipes.txt) > ");
                    String fileNameToSave = sc.nextLine();
                    recipeManager.saveRecipesToFile(fileNameToSave);
                    break;

                case 5:
                    System.out.print("Enter filename to load recipes (e.g., recipes.txt) > ");
                    String fileNameToLoad = sc.nextLine();
                    recipeManager.loadFromFile(fileNameToLoad);
                    break;

                case 0:
                    System.out.println("You are closing the book...\n"); // här borde komma, do you really want to quit?
                    inMenu = false;
                    break;
                default:
                    System.out.println("Unknown command. Please try again.\n");
            }
        }
    }
}
