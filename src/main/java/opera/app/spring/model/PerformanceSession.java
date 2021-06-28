package opera.app.spring.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "performance_sessions")
public class PerformanceSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Performance performance;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stage stage;
    private LocalDateTime showTime;

    public PerformanceSession() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Performance getMovie() {
        return performance;
    }

    public void setMovie(Performance performance) {
        this.performance = performance;
    }

    public Stage getCinemaHall() {
        return stage;
    }

    public void setCinemaHall(Stage stage) {
        this.stage = stage;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "MovieSession{"
                + "id=" + id
                + ", movie=" + performance
                + ", cinemaHall=" + stage
                + ", showTime=" + showTime
                + '}';
    }
}
