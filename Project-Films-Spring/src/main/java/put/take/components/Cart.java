package put.take.components;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import put.take.persistance.Movie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@SessionScope
@Log4j2
public class Cart {

    public Set<Movie> movies;

    public Cart() {
        this.movies = new HashSet<>();
    }

    public void add(Movie m) {
        movies.add(m);
        log.log(Level.INFO, "Added: " + m.getTitle() + "\tsize: " + movies.size());
    }

    public void remove(Long id) {
        this.movies = movies.stream().filter(m -> !m.getId().equals(id)).collect(Collectors.toSet());
    }

    public void clear() {
        this.movies.clear();
    }

    public List<Movie> getMovies() {
        return this.movies.stream().map(m -> {
            try {
                return m.clone(); // clone objects to avoid changes when manipulating price
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                log.error(e.getMessage());
                return null;
            }
        }).collect(Collectors.toList());

    }
}
