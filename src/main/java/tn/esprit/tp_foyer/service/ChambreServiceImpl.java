package tn.esprit.tp_foyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entities.*;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;
import tn.esprit.tp_foyer.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;
    UniversiteRepository universiteRepository;
    BlocRepository blocRepository;
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Foyer foyer =universite.getFoyer();
        List<Bloc> blocs = foyer.getBlocs();
        List<Chambre> chambres = new ArrayList<>();
        for(Bloc bloc: blocs){
            List<Chambre> chambresBloc = bloc.getChambres();
            for (Chambre chambreb: chambresBloc){
                chambres.add(chambreb);
            }
        }
        return chambres;
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC) {


        return chambreRepository.findALLByBlocAndTypeC(blocRepository.findById(idBloc).get(),typeC);
    }

    public List<Chambre> getByChambreTypeEtBloc(Long idBloc, TypeChambre typeC) {


        return chambreRepository.findByChambreTypeEtBloc(typeC,idBloc);
    }

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite,TypeChambre type) {
        List<Chambre> chambresNonReserves = new ArrayList<>();
        List<Chambre> chambres = getChambresParNomUniversite(nomUniversite);
        for(Chambre chambre: chambres){
            if(chambre.getTypeC().equals(type)&& chambre.getReservations().isEmpty()){
                chambresNonReserves.add(chambre);
            }
        }
        return chambresNonReserves;

    }
    /*@Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        List<Chambre> chambres = new ArrayList<>();
       for(Chambre chambre : bloc.getChambres()){
           if(chambre.getTypeC()==typeC){
                chambres.add(chambre);
           }
       }


        return chambres;
    }*/
}