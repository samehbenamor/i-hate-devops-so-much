package tn.esprit.tp_foyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entities.Reservation;
import tn.esprit.tp_foyer.entities.Universite;
import tn.esprit.tp_foyer.service.IReservationService;
import tn.esprit.tp_foyer.service.IUniversiteService;

import java.util.Date;
import java.util.List;
@Tag(name = "Gestion Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IReservationService reservationService;
    IUniversiteService universiteService;

    // http://localhost:8089/tp-foyer/reservation/retrieve-all-reservations
    @Operation(description = "récupérer toutes les Reservations de la base de données")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }

    // http://localhost:8089/tp-foyer/reservation/retrieve-reservation/8
    @Operation(description = "récupérer une Reservation de la base de données")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reId) {
        Reservation reservation = reservationService.retrieveReservation(reId);
        return reservation;
    }

    // http://localhost:8089/tp-foyer/reservation/add-reservation
    @Operation(description = "ajouter une Reservation a la base de données")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r){
        Reservation reservation = reservationService.addReservation(r);
        return reservation;
    }

    // http://localhost:8089/tp-foyer/reservation/remove-reservation/{reservation-id}
    @Operation(description = "supprimer une Reservation de la base de données")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reId) {
        reservationService.removeReservation(reId);
    }

    // http://localhost:8089/tp-foyer/reservation/modify-reservation
    @Operation(description = "modifier une Reservation de la base de données")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.modifyReservation(r);
        return reservation;
    }
    @PostMapping("create-reservation-assigned/{id-chambre}/{cin-etudiant}")
    public Reservation ajouterReservation(@PathVariable("id-chambre") Long idChambre, @PathVariable("cin-etudiant") Long cinEtudiant ) {
        Reservation reservation = reservationService.ajouterReservation(idChambre, cinEtudiant);
        return reservation;
    }
    @Operation(description = "Desaffecter foyer d'une université!")
    @PutMapping("/remove-foyer-from-universite/{id-foyer}")
    public Universite RemoveFoyerFromUniversite(@PathVariable("id-foyer") Long idFoyer) {
        Universite universite = universiteService.desaffecterFoyerAUniversite(idFoyer);
        return universite;
    }

    /*// http://localhost:8089/tpfoyer/foyer/retrieve-all-res-nom
    @Operation(description = "Récupérer toutes les reservations!")
    @GetMapping("/retrieve-all-reservations-annnee/{date}/{nom}")
    public List<Reservation> getFoyer(@PathVariable("date") Date annee, @PathVariable("nom") String nomUniv ) {
        List<Reservation> listRes = reservationService.getReservationParAnneeUniversitaireEtNomUniversite(annee,nomUniv);
        return listRes;
    }*/

    }

