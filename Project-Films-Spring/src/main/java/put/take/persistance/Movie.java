package put.take.persistance;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Movie implements Serializable, Cloneable {

    @Id
    private Long id;
    private String title;

    private String category;
    private String year;
    private String cast;
    private String director;
    private String story;
    private Double price;

    @Override
    public Movie clone() throws CloneNotSupportedException {
        return (Movie)super.clone();
    }
}
