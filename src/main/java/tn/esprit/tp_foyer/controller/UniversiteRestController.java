package tn.esprit.tp_foyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entities.Reservation;
import tn.esprit.tp_foyer.entities.Universite;
import tn.esprit.tp_foyer.service.IUniversiteService;

import java.util.List;
@Tag(name = "Gestion Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    IUniversiteService universiteService;
    // http://localhost:8089/tp-foyer/universite/retrieve-all-universites
    @Operation(description = "récupérer toutes les Universites de la base de données")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversite() {
        List<Universite> listUniversites = universiteService.retrieveAllUniversites();
        return listUniversites;
    }

    // http://localhost:8089/tp-foyer/universite/retrieve-universite/8
    @Operation(description = "récupérer une Universite de la base de données")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long uniId) {
        Universite universite = universiteService.retrieveUniversite(uniId);
        return universite;
    }

    // http://localhost:8089/tp-foyer/universite/add-universite
    @Operation(description = "ajouter une Universite a la base de données")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u){
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }

    // http://localhost:8089/tp-foyer/universite/remove-universite/{universite-id}
    @Operation(description = "supprimer une Universite de la base de données")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long uniId) {
        universiteService.removeUniversite(uniId);
    }

    // http://localhost:8089/tp-foyer/universite/modify-universite
    @Operation(description = "modifier une Universite de la base de données")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.modifyUniversite(u);
        return universite;
    }
    @PutMapping("/assign-foyer-to-universite/{universite-nom}/{foyer-id}")
    public Universite affecterFoyerAUniversite(@PathVariable("foyer-id") Long idFoyer, @PathVariable("universite-nom") String nomUniversite ){
        Universite universite = universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite );
        return universite;
    }
    @PutMapping("/unassign-foyer-to-universite/{universite-id}")
    public  Universite desaffecterFoyerAUniversite(@PathVariable("universite-id") Long uniId){
        Universite universite = universiteService.desaffecterFoyerAUniversite(uniId);
        return universite;
    }
}
