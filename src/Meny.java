import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meny {

    public static void menuChoice() {
        Scanner sc = new Scanner(System.in);

        boolean inMenu = true;

        while (inMenu) {
            System.out.println("\nVad vill du göra med "
                    + "?" +
                    "\n1. add recipe." +
                    "\n2. Lägg till en ny " + "." +
                    "\n3. Ändra en " +  "." +
                    "\n4. Ta bort en " +  "." +
                    "\n0. Exit Program");
            System.out.print("Ange siffran för menyval > ");

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
                    } while (addMore.equalsIgnoreCase("yes"));

                    System.out.println("Enter instructions: ");
                    String instructions = sc.nextLine();

                    Recipe newRecipe = new Recipe(title, ingredients, instructions);
                    break;
                case 2:
                    System.out.println("case 2");
                    break;
                case 3:
                    System.out.println("case 3");
                    break;
                case 4:
                    System.out.println("case 4");
                    break;
                case 0:
                    System.out.println("Exits Recipe...\n"); // här borde komma, do you really want to quit?
                    inMenu = false;
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.\n");
            }
        }
    }
}
