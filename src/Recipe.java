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
}
