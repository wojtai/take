package put.take.api;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import put.take.components.CurrencyConverter;
import put.take.persistance.Movie;
import put.take.service.MovieService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@CrossOrigin()
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private MovieService movieService;
    private CurrencyConverter currencyConverter;

    private List<String> allCategories = Arrays.stream(MovieCategory.values()).map(MovieCategory::toString).collect(Collectors.toList());

    @Autowired
    public MovieController(MovieService movieService, CurrencyConverter currencyConverter){
        this.movieService = movieService;
        this.currencyConverter = currencyConverter;
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam(required = false, defaultValue = "") String movieCategory,
                                 @RequestParam(required = false, defaultValue = "PLN") CurrencyType currencyType) {
        log.log(Level.INFO, movieCategory + "\t" + currencyType);
        List<Movie> result;
        if(allCategories.contains(movieCategory)) {
            result = movieService.getAllByCategory(movieCategory);
        }
        else {
            result = movieService.getAll();
        }

        if(currencyType == CurrencyType.EUR) {
            result = result.stream().peek(movie -> movie.setPrice(currencyConverter.plnToEur(movie.getPrice()))).collect(Collectors.toList());
        }

        return result;
    }

}
