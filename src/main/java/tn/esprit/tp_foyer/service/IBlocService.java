package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entities.Bloc;
import tn.esprit.tp_foyer.entities.Chambre;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long blocId);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long blocId);
    public Bloc modifyBloc(Bloc bloc);
    public Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc);
}
