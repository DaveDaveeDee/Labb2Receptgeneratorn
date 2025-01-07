import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

/*    public static String menu() {

        return """
                
                
                How can we help you today?
                
                1) Add recipe.
                2) View recipe.
                3) Remove recipe.
                4) Save recipe to file.
                0) Close cooking book.
                """
                ;
    }*/

    public static void menuChoice() { // TODO String[] args
        RecipeManager recipeManager = new RecipeManager();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            int choice = getMenuChoice(scanner);
            switch (choice) {
                case 1:
                    addRecipe(scanner, recipeManager);
                    break;
                case 2:
                    viewRecipes(recipeManager);
                    break;
                case 3:
                    removeRecipe(scanner, recipeManager);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close(); // TODO behövs denna? Stängs i main...
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getMenuChoice(Scanner scanner) {
        while (true) {
         //   System.out.println("Choose an option: 1. Add recipe, 2. View recipes, 3. Remove recipe, 4. Exit");

            System.out.println("""
                
                
                How can we help you today?
                
                1) Add recipe.
                2) View recipe.
                3) Remove recipe.
                4) Close cooking book.
                
                Enter a number between 1 and 4.
                """);


            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1 and 4.");
            }
        }
    }


    private static void addRecipe(Scanner scanner, RecipeManager recipeManager) {
        String title = getRecipeTitle(scanner);

        List<Ingredient> ingredients = new ArrayList<>();
        int number = getPositiveInteger(scanner, "Enter number of ingredients (must be positive number): ");

        for (int i = 0; i < number; i++) {
            String name = getIngredientName(scanner);
            String quantity = getIngredientQuantity(scanner);
            ingredients.add(new Ingredient(name, String.valueOf(quantity)));
        }

        String instructions = getInstructions(scanner);
        int categoryChoice = getCategoryChoice(scanner);
        Recipe newRecipe = null;

        switch (categoryChoice) {
            case 1:
                newRecipe = new BreakfastRecipe(title, ingredients, instructions);
                break;
            case 2:
                newRecipe = new LunchRecipe(title, ingredients, instructions);
                break;
            case 3:
                newRecipe = new DinnerRecipe(title, ingredients, instructions);
                break;
            default:
                System.out.println("Invalid choice. No category selected.");
        }

        if (newRecipe != null) {
            recipeManager.addRecipe(newRecipe);
            System.out.println("Recipe added.");
        }
    }

    private static String getIngredientQuantity(Scanner scanner) {
        while (true) {
            System.out.println("Enter quantity with unit, example '2dl'): ");
            String quantity = scanner.nextLine().trim();
            if (!quantity.isEmpty()) {
                return quantity;
            }
            else {
                System.out.println("Quantity cannot be empty. Enter a valid quantity with unit.");
            }
        }
    }


    private static String getRecipeTitle(Scanner scanner) {
        while (true) {
            System.out.print("Enter recipe title: ");
            String title = scanner.nextLine().trim();
            if (!title.isEmpty()) {
                return title;
            } else {
                System.out.println("Title cannot be empty! Enter a valid title.");
            }
        }
    }

    private static String getIngredientName(Scanner scanner) {
        while (true) {
            System.out.print("Enter ingredient name: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            } else {
                System.out.println("Ingredient name can't be empty. Enter a valid name.");
            }
        }
    }

    private static String getInstructions(Scanner scanner) {
        while (true) {
            System.out.print("Enter instructions: ");
            String instructions = scanner.nextLine().trim();
            if (!instructions.isEmpty()) {
                return instructions;
            } else {
                System.out.println("Instructions cannot be empty. Enter valid instructions.");
            }
        }
    }


    private static void viewRecipes(RecipeManager recipeManager) {
        List<Recipe> recipes = recipeManager.viewRecipes();
        if (recipes.isEmpty()) {
            System.out.println("No recipes to display.");
        } else {
            for (Recipe recipe : recipes) {
                System.out.println(recipe);
                System.out.println();
            }
        }
    }


    private static void removeRecipe(Scanner scanner, RecipeManager recipeManager) {
        String titleToRemove = getTitleToRemove(scanner);
        recipeManager.removeRecipe(titleToRemove);
    }


    private static String getTitleToRemove(Scanner scanner) {
        while (true) {
            System.out.print("Enter title for the recipe you want to remove: ");
            String titleToRemove = scanner.nextLine().trim();
            if (!titleToRemove.isEmpty()) {
                return titleToRemove;
            } else {
                System.out.println("Title cannot be empty. Enter a valid title.");
            }
        }
    }

    private static int getPositiveInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Enter a positive number >0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid positive number.");
            }
        }
    }


    private static int getCategoryChoice(Scanner scanner) {
        while (true) {
            System.out.println("""
            Choose a category: 1. Breakfast, 2. Lunch, 3. Dinner
            
            """);
            // System.out.println("Choose a category: 1. Breakfast, 2. Lunch, 3. Dinner");
            int choice = getPositiveInteger(scanner, "Your choice: ");
            if (choice >= 1 && choice <= 3) {
                return choice;
            } else {
                System.out.println("Invalid choice. Select number between 1 and 3.");
            }
        }
    }
}