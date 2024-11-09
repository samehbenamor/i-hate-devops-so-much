package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entities.Bloc;
import tn.esprit.tp_foyer.entities.Chambre;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;

import java.util.List;

@Service
@Slf4j
@ToString
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    @Override
    @Scheduled(cron = "0/60 * * * * *")
    public List<Bloc> retrieveAllBlocs() {
        List<Bloc> blocs = blocRepository.findAll();
        for (Bloc b: blocs) {
            log.info("Bloc :" + b);}
        return  blocs;
    }

    @Override
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        for(Long num: numChambres){
            Chambre chambre = chambreRepository.findByNumeroChambre(num);
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return blocRepository.save(bloc);
    }

    /*@Override
    public Bloc affecterChambresABloc(List<Long> idChambres, Long idBloc) {
        List<Chambre> chambres = chambreRepository.findAllByNumeroChambre(idChambres);
        Bloc bloc = blocRepository.findById(idBloc).get();
        bloc.setChambres(chambres);
        return blocRepository.save(bloc);
    }*/
}
