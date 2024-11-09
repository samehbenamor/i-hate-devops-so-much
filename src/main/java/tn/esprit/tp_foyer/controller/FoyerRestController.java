package tn.esprit.tp_foyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entities.Foyer;
import tn.esprit.tp_foyer.service.FoyerServiceImpl;
import tn.esprit.tp_foyer.service.IFoyerService;

import java.util.List;
@Tag(name = "Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {

     FoyerServiceImpl foyerService;

    // http://localhost:8089/tp-foyer/foyer/retrieve-all-foyers
    @Operation(description = "récupérer toutes les Foyers de la base de données")
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyer() {
        List<Foyer> listFoyer = foyerService.retrieveAllFoyer();
        return listFoyer;
    }

    // http://localhost:8089/tp-foyer/foyer/retrieve-foyer/8
    @Operation(description = "récupérer un Foyer de la base de données")
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long uniId) {
        Foyer foyer = foyerService.retrieveFoyer(uniId);
        return foyer;
    }

    // http://localhost:8089/tp-foyer/foyer/add-foyer
    @Operation(description = "ajouter un Foyer a la base de données")
    @PostMapping("/add-foyer")
    public Foyer addUniversite(@RequestBody Foyer f){
        Foyer foyer = foyerService.addFoyer(f);
        return foyer;
    }

    // http://localhost:8089/tp-foyer/foyer/remove-foyer/{foyer-id}
    @Operation(description = "supprimer un Foyer de la base de données")
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }

    // http://localhost:8089/tp-foyer/foyer/modify-foyer
    @Operation(description = "modifier un Foyer de la base de données")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer u) {
        Foyer foyer = foyerService.modifyFoyer(u);
        return foyer;
    }
@PostMapping("/create-foyer-with-blocs-and-assign-universite/{id-universite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable("id-universite") Long idUniversite){
        Foyer savedfoyer = foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
        return savedfoyer;
}

}
