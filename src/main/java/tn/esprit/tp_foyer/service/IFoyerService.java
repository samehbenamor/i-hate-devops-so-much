package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyer();
    public Foyer retrieveFoyer(Long idFoyer);
    public Foyer addFoyer(Foyer f);
    public void removeFoyer(Long idFoyer);
    public Foyer modifyFoyer(Foyer foyer);
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
