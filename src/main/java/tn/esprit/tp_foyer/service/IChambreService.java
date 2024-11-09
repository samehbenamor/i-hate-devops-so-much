package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entities.Chambre;
import tn.esprit.tp_foyer.entities.TypeChambre;

import java.util.List;
public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
// Here we will add later methods calling keywords and methods calling JPQL
public List<Chambre> getChambresParNomUniversite( String nomUniversite) ;
    public List<Chambre> getChambresParBlocEtType (Long idBloc, TypeChambre typeC) ;
    public List<Chambre> getByChambreTypeEtBloc(Long idBloc, TypeChambre typeC);

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite,TypeChambre type) ;
}
