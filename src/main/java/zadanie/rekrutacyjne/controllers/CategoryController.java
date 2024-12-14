package zadanie.rekrutacyjne.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import zadanie.rekrutacyjne.models.Category;
import zadanie.rekrutacyjne.services.CategoryService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id,@Valid @RequestBody Category category) {
        category.setId(id);
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
