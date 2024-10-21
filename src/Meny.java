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
                    "\n0. Exit Program.");
            System.out.print("Ange siffran för menyval > \n");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter recipe title: ");
                    String title = sc.nextLine();

                    List<Ingredient> ingredients = new ArrayList<>();
                    String addMore;
                    do {
                        System.out.print("Enter ingredient name: ");
                        String ingredientName = sc.nextLine();
                        System.out.print("Enter ingredient quantity: ");
                        String ingredientQuantity = sc.nextLine();
                        ingredients.add(new Ingredient(ingredientName, ingredientQuantity)); // calls the constructor

                        System.out.print("Add more ingredients? (yes/no): ");
                        addMore = sc.nextLine();
                        while ((!(addMore.equalsIgnoreCase("yes") || addMore.equalsIgnoreCase("no")))) {
                            System.out.println("Enter yes/no");
                            addMore = sc.nextLine();
                        }
                    } while (addMore.equalsIgnoreCase("yes"));

                    System.out.println("Enter instructions: ");
                    String instructions = sc.nextLine();

                    Recipe newRecipe = new Recipe(title, ingredients, instructions);
                    recipeManager.addRecipe(newRecipe);
                    System.out.println("Recipe added!\n");
                    break;

                case 2:
                    recipeManager.displayRecipes();
                    break;

                case 3:
                    System.out.print("Enter recipe title to remove: ");
                    String removeTitle = sc.nextLine();
                    recipeManager.removeRecipe(removeTitle);
                    System.out.println("Recipe removed (if it existed).\n");
                    break;

                case 0:
                    System.out.println("Exits Recipe...\n"); // här borde komma, do you really want to quit?
                    inMenu = false;
                    break;
                default:
                    System.out.println("Unknown command. Please try again.\n");
            }
        }
    }
}
