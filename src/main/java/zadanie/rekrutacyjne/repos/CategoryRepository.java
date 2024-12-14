package zadanie.rekrutacyjne.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import zadanie.rekrutacyjne.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}