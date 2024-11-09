package tn.esprit.tp_foyer.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity

public class Reservation implements Serializable {
    @Id
    String idReservation;
    @Temporal(TemporalType.DATE)
    Date anneeUniversitaire;
    Boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "reservations")
    List<Etudiant> etudiants;
}
