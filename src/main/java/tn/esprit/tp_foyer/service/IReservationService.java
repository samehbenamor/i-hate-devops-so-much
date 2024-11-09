package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long idReservation);
    public Reservation addReservation(Reservation r);
    public void removeReservation(Long idReservation);
    public Reservation modifyReservation(Reservation reservation);
    public Reservation ajouterReservation (long idChambre, long cinEtudiant) ;
    public Reservation annulerReservation (long cinEtudiant) ;
    //public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) ;
}
