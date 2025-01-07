import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String title;
    private List<Ingredient> ingredients;
    private String instructions;
    private Category category;

    public Recipe(String title, List<Ingredient> ingredients, String instructions, Category category) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("category: ").append(category.getName()).append("\n");
        sb.append("Instructions: ").append(instructions).append("\n");
        sb.append("Ingredients: ");

        for (int i = 0; i < ingredients.size(); i++) {
            sb.append(ingredients.get(i).toString());
            if (i < ingredients.size() -1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static Recipe fromString(List<String> lines) {
        String title = lines.get(0).substring(7).trim();
        Category category = new Category(lines.get(1).substring(9).trim());
        String instructions = lines.get(2).substring(13).trim();

        List<Ingredient> ingredients = new ArrayList<>();
        String ingredientLine = lines.get(3);
        String[] ingredientParts = ingredientLine.substring(12).split(",");

        for (String ingredientStr : ingredientParts) {
            String[] parts = ingredientStr.split(" ", 2);
            if (parts.length == 2) {
                String quantity = parts[0];
                String name = parts[1];
                ingredients.add(new Ingredient(quantity, name));
            }
        }
        return new Recipe(title, ingredients, instructions, category);
    }
}
