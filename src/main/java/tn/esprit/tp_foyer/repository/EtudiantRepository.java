package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.config.PersistentEntitiesFactoryBean;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    public Etudiant findByCin(long cinEtudiant);

}
