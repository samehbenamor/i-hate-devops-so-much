package tn.esprit.tp_foyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entities.Chambre;
import tn.esprit.tp_foyer.entities.Etudiant;
import tn.esprit.tp_foyer.service.IEtudiantService;

import java.util.List;
@Tag(name = "Gestion Etudiant")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    IEtudiantService etudiantService;

    // http://localhost:8089/tp-foyer/etudiant/retrieve-all-etudiants
    @Operation(description = "récupérer toutes les Etudiants de la base de données")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants(){
        List<Etudiant> listEtudiant = etudiantService.retrieveAllEtudiants();
        return listEtudiant;
    }

    // http://localhost:8089/tp-foyer/etudiant/retrieve-etudiant/8
    @Operation(description = "récupérer un Etudiant de la base de données")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long chId) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(chId);
        return etudiant;
    }

    // http://localhost:8089/tp-foyer/etudiant/add-etudiant
    @Operation(description = "ajouter un Etudiant a la base de données")
    @PostMapping("/add-etudiant")
    public Etudiant addChambre(@RequestBody Etudiant c) {
        Etudiant etudiant = etudiantService.addEtudiant(c);
        return etudiant;
    }

    // http://localhost:8089/tp-foyer/etudiant/remove-etudiant/{etudiant-id}
    @Operation(description = "supprimer un Etudiant de la base de données")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long chId) {
        etudiantService.removeEtudiant(chId);
    }

    // http://localhost:8089/tp-foyer/etudiant/modify-etudiant
    @Operation(description = "modifier un Etudiant de la base de données")
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.modifyEtudiant(e);
        return etudiant;
    }
}
