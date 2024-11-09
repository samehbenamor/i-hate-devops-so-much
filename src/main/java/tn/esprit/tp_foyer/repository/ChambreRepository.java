package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entities.Bloc;
import tn.esprit.tp_foyer.entities.Chambre;
import tn.esprit.tp_foyer.entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository <Chambre, Long>
{
 public  Chambre findByNumeroChambre(Long numChambres);
 public  List<Chambre> findALLByBlocAndTypeC(Bloc bloc, TypeChambre typeChambre);

 @Query("SELECT Chambre FROM Chambre chambre where chambre.typeC = :type and chambre.bloc.idBloc= :idBloc")

 List<Chambre> findByChambreTypeEtBloc(@Param("type") TypeChambre type, @Param("idBloc") Long idBloc);

}
