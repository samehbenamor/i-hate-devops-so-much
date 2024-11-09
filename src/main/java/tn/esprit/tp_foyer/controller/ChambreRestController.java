package tn.esprit.tp_foyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entities.Chambre;
import tn.esprit.tp_foyer.entities.TypeChambre;
import tn.esprit.tp_foyer.service.IChambreService;

import java.util.List;
@Tag(name = "Gestion Chambre")
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;

    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @Operation(description = "récupérer une chambre de la base de données")
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @Operation(description = "ajouter une chambre a la base de données")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @Operation(description = "supprimer une chambre de la base de données")
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @Operation(description = "modifier une chambre de la base de données")
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
    @GetMapping("/retrieve-chambres-of-universite/{non-universite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable("non-universite") String nomUniversite) {
        List<Chambre> chambres = chambreService.getChambresParNomUniversite(nomUniversite);
        return chambres;
    }
    @GetMapping("/retrieve-chambres-by-bloc-and-typec/{bloc-id}/{type-chambre}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable("bloc-id") Long blocId, @PathVariable("type-chambre") TypeChambre typeChambre) {
        List<Chambre> chambres = chambreService.getChambresParBlocEtType(blocId,typeChambre);
        return chambres;
    }

    @GetMapping("/retrieve-chambres-by-typec-and-bloc/{bloc-id}/{type-chambre}")
    public List<Chambre> findByChambreTypeEtBloc(@PathVariable("bloc-id") Long blocId, @PathVariable("type-chambre") TypeChambre typeChambre) {
        List<Chambre> chambres = chambreService.getByChambreTypeEtBloc(blocId, typeChambre);
        return chambres;
    }

    @GetMapping("/retrieve-chambres/{nom-universite}/{type-c}")
    public List<Chambre> retrieveChambresByNomUniversite(@PathVariable("nom-universite") String nomUniversite, @PathVariable("type-c") TypeChambre typeC) {
        List<Chambre> chambres = chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, typeC);
        return chambres;
    }

}
