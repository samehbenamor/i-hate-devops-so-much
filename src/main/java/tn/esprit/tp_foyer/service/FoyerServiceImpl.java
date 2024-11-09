package tn.esprit.tp_foyer.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entities.Bloc;
import tn.esprit.tp_foyer.entities.Foyer;
import tn.esprit.tp_foyer.entities.Universite;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.FoyerRepository;
import tn.esprit.tp_foyer.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;
    UniversiteRepository universiteRepository;
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepository.findAll();
    }

    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Foyer savedFoyer = foyerRepository.save(foyer);
        List<Bloc> blocs= savedFoyer.getBlocs();
        for(Bloc bloc: blocs){
            bloc.setFoyer(savedFoyer);
            blocRepository.save(bloc);
        }
        foyerRepository.save(savedFoyer);
        Universite universite = universiteRepository.findById(idUniversite).get();
        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);


        return savedFoyer;
    }
}
