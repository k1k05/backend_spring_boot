package zadanie.rekrutacyjne.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Happening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_h")
    private Integer id;

    @NotBlank(message = "Nazwa nie może być pusta.")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Wybierz datę początkową.")
    @FutureOrPresent(message = "Data początkowa nie może być w przeszłości.")
    @Column(name = "starting_time", nullable = false)
    private LocalDateTime startingTime;

    @NotNull(message = "Wybierz datę końcową.")
    @Column(name = "ending_time", nullable = false)
    private LocalDateTime endingTime;

    @ManyToOne
    @JoinColumn(name = "id_c")
    private Category category;

    @AssertTrue(message = "Data końcowa nie może być przed datą końcową.")
    public boolean isValidTimes() {
        if (startingTime == null || endingTime == null) {
            return true;
        }
        return endingTime.isAfter(startingTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
