package put.take.service;

import org.springframework.stereotype.Service;
import put.take.persistance.Movie;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> getAll();

    List<Movie> getAllByCategory(String movieCategory);

    Movie getOneById(Long id);

}
