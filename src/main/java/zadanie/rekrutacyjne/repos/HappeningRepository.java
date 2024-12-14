package zadanie.rekrutacyjne.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import zadanie.rekrutacyjne.models.Happening;

public interface HappeningRepository extends JpaRepository<Happening, Integer> {
}