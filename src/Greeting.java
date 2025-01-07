import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Greeting {

    public static String greet() {
        return "\n\t Welcome \n \t\tto\n witches cauldron";
    }

    public static void main(String[] args) {
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
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
