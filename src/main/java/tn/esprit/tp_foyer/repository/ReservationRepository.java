package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entities.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public Reservation findReservationByIdReservationStartingWith(String numChabre);
    /*@Query("SELECT reservation FROM Universite universite "
            + " INNER JOIN universite.Foyer foyer"
            + " INNER JOIN foyer.bloc bloc"
            + " INNER JOIN bloc.chambres chambre"
            + " INNER JOIN chambre.reservations reservation"
            + " WHERE universite.nomUniversite = :nomUniversite"
            + " AND reservation.anneeUniversitaire=:annee")
    List<Reservation> getReservationByUniversiteFoyerAndTechnologieReverseOrder(@Param("nomUniversite") String nomUniversite, @Param("annee") Date date);*/
}
