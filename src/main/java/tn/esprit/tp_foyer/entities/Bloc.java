package tn.esprit.tp_foyer.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBloc;
    String nomBloc;
    Long capaciteBloc;
    @ManyToOne
    @JoinColumn(name = "foyer_id_foyer")
    @JsonBackReference
    Foyer foyer;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "bloc" )
    List<Chambre> chambres;
}
