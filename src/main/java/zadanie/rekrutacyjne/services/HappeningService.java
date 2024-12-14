package zadanie.rekrutacyjne.services;
import org.springframework.stereotype.Service;
import zadanie.rekrutacyjne.exceptions.ResourceNotFoundException;
import zadanie.rekrutacyjne.models.Happening;
import zadanie.rekrutacyjne.repos.HappeningRepository;

import java.util.List;

@Service
public class HappeningService {

    private final HappeningRepository happeningRepository;

    public HappeningService(HappeningRepository happeningRepository) {
        this.happeningRepository = happeningRepository;
    }

    public List<Happening> getAllHappenings() {
        return happeningRepository.findAll();
    }

    public Happening getHappeningById(Integer id) {
        return happeningRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Happening not found"));
    }

    public Happening saveHappening(Happening happening) {
        return happeningRepository.save(happening);
    }

    public void deleteHappening(Integer id) {
        happeningRepository.deleteById(id);
    }
}
