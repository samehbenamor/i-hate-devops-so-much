package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();
    public Universite retrieveUniversite(Long idUniversite);
    public Universite addUniversite(Universite u);
    public void removeUniversite(Long idUniversite);
    public Universite modifyUniversite(Universite universite);

    public Universite affecterFoyerAUniversite (Long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (Long idUniversite) ;
}
