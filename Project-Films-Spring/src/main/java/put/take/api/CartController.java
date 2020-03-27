package put.take.api;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.web.bind.annotation.*;
import put.take.components.Cart;
import put.take.components.CurrencyConverter;
import put.take.persistance.Movie;
import put.take.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin()
@RestController
@RequestMapping("/api/cart")
@Log4j2
public class CartController {

    private Cart cart;
    private MovieService movieService;
    private CurrencyConverter currencyConverter;

    public CartController(Cart cart, MovieService movieService, CurrencyConverter currencyConverter) {
        this.cart = cart;
        this.movieService = movieService;
        this.currencyConverter = currencyConverter;
    }

    @PostMapping("/{id}")
    public void add (@PathVariable Long id) {
        this.cart.add(movieService.getOneById(id));
    }

    @GetMapping
    public List<Movie> getCart(@RequestParam(required = false, defaultValue = "PLN") CurrencyType currencyType) {
        List<Movie> result = cart.getMovies();

        if(currencyType == CurrencyType.EUR) {
            result = result.stream().peek(movie -> movie.setPrice(currencyConverter.plnToEur(movie.getPrice()))).collect(Collectors.toList());
        }

        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.cart.remove(id);
    }

    @DeleteMapping("/clear")
    public void clear() {
        this.cart.clear();
        log.log(Level.INFO, "Cart cleared");
    }
}
