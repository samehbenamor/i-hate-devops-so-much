package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entities.Chambre;
import tn.esprit.tp_foyer.entities.Etudiant;
import tn.esprit.tp_foyer.entities.Reservation;
import tn.esprit.tp_foyer.repository.ChambreRepository;
import tn.esprit.tp_foyer.repository.EtudiantRepository;
import tn.esprit.tp_foyer.repository.ReservationRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).get();
    }
    public Reservation addReservation(Reservation c) {
        return reservationRepository.save(c);
    }
    public void removeReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        Chambre chambre = chambreRepository.findById(idChambre).get();
        Long numChambre = chambre.getNumeroChambre();
        String nonChambre = chambre.getBloc().getNomBloc();
        if(chambre.getTypeC().toString().equals("SIMPLE") && !chambre.getReservations().isEmpty()){
            return null;

        } else if (chambre.getTypeC().toString().equals("DOUBLE") && chambre.getReservations().size()>=2) {
            return null;
        }else if (chambre.getTypeC().toString().equals("TRIPLE") && chambre.getReservations().size()>= 3) {
            return null;
        }else {
            Reservation reservation = new Reservation();
            reservation.setIdReservation(numChambre.toString()+"-"+nonChambre+"-"+cinEtudiant);
            reservation.setEstValide(true);
            chambre.getReservations().add(reservation);
            chambreRepository.save(chambre);
            //reservation.getEtudiants().add(etudiant);
            etudiant.getReservations().add(reservation);
            etudiantRepository.save(etudiant);
            reservationRepository.save(reservation);
            return reservation;
        }
    }
    public Reservation annulerReservation (long cinEtudiant){
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        Reservation reservation = null;
        for( Reservation res : etudiant.getReservations()){
            reservation = res;
            continue;
        }
        reservation.setEstValide(false);
        etudiant.getReservations().remove(reservation);
        String[] reservationIdSplit = reservation.getIdReservation().split("-");
        String NumChambre = reservationIdSplit[0];
        Chambre chambre = chambreRepository.findByNumeroChambre(Long.parseLong(NumChambre));
        chambre.getReservations().remove(reservation);
        chambreRepository.save(chambre);
        reservationRepository.save(reservation);
        return reservation;
    }
    /*public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        return reservationRepository.getReservationByUniversiteFoyerAndTechnologieReverseOrder(nomUniversite,anneeUniversite);
    }*/
    /*@Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        List<Reservation> reservations = etudiant.getReservations();
        for (Reservation reservation: reservations){
            etudiant.getReservations().remove(reservation);
            reservation.setEstValide(false);


        }


        return null;
    }*/
}
