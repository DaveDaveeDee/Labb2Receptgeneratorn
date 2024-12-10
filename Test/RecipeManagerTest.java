import org.junit.jupiter.api.BeforeEach;

public class RecipeManagerTest {
    private RecipeManager recipeManager;

    @BeforeEach
    void setUp() {
        recipeManager = new RecipeManager();
        recipeManager.viewRecipes().clear();
    }