package put.take.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import put.take.exceptions.ElementNotFoundException;
import put.take.persistance.Movie;
import put.take.persistance.MoviesRepository;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MoviesRepository repo;

    @Autowired
    public MovieServiceImpl(MoviesRepository moviesRepository) {
        this.repo = moviesRepository;
    }

    @Override
    public List<Movie> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Movie> getAllByCategory(String movieCategory) {
        return repo.findAllByCategory(movieCategory);
    }

    @Override
    public Movie getOneById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ElementNotFoundException("Element not found"));
    }
}
