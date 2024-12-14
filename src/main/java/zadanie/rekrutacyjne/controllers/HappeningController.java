package zadanie.rekrutacyjne.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zadanie.rekrutacyjne.models.Happening;
import zadanie.rekrutacyjne.services.HappeningService;
import jakarta.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/api/happenings")
@Validated
public class HappeningController {

    private final HappeningService happeningService;

    public HappeningController(HappeningService happeningService) {
        this.happeningService = happeningService;
    }

    @GetMapping
    public List<Happening> getAllHappenings() {
        return happeningService.getAllHappenings();
    }

    @GetMapping("/{id}")
    public Happening getHappeningById(@PathVariable Integer id) {
        return happeningService.getHappeningById(id);
    }

    @PostMapping
    public Happening createHappening(@Valid @RequestBody Happening happening) {
        Happening savedHappening = happeningService.saveHappening(happening);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHappening).getBody();
    }

    @PutMapping("/{id}")
    public Happening updateHappening(@PathVariable Integer id,@Valid @RequestBody Happening happening) {
        happening.setId(id);
        return happeningService.saveHappening(happening);
    }

    @DeleteMapping("/{id}")
    public void deleteHappening(@PathVariable Integer id) {
        happeningService.deleteHappening(id);
    }


}
