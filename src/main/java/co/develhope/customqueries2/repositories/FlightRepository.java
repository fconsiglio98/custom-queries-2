package co.develhope.customqueries2.repositories;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Page<Flight> findAllByStatus(FlightStatus status, Pageable pageable);

    @Query("SELECT f FROM Flight f WHERE f.status = ?1 or f.status = ?2")
    List<Flight> getCustomFlight(FlightStatus p1, FlightStatus p2);
}