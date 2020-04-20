package lab.bookings.repositories;

import lab.bookings.models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    @Query("select a from Apartment a " +
            "where a.capacity >= :numGuests and " +
            "not exists (select b from a.bookings b " +
            " where :startDay < b.toDate and :endDay > b.fromDate) " +
            "order by a.capacity")
    List<Apartment> getFreeApartments(@Param("numGuests") Integer numGuests,
                                      @Param("startDay") LocalDate startDay,
                                      @Param("endDay") LocalDate endDay);
}
