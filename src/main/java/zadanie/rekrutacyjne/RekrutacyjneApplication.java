package zadanie.rekrutacyjne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import zadanie.rekrutacyjne.models.Category;
import zadanie.rekrutacyjne.models.Happening;
import zadanie.rekrutacyjne.repos.CategoryRepository;
import zadanie.rekrutacyjne.repos.HappeningRepository;

import java.util.List;

@SpringBootApplication
public class RekrutacyjneApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RekrutacyjneApplication.class, args);

		CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
		HappeningRepository happeningRepository = context.getBean(HappeningRepository.class);

	}
}