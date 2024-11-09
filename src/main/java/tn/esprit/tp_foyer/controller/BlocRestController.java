package tn.esprit.tp_foyer.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entities.Bloc;
import tn.esprit.tp_foyer.service.IBlocService;

import java.util.List;

@Tag(name="Gestion Bloc")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    @Operation(description="récuperer tout les blocs de la base de données")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return blocService.retrieveAllBlocs();
    }

    @Operation(description="récuperer un bloc spécifique par id de la BD")
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }

    @Operation(description="ajouter un bloc dans la BD")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @Operation(description="supprimer un bloc de la BD")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    @Operation(description="modifier un bloc dans la BD")
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc) {
        return blocService.modifyBloc(bloc);
    }

    @Operation(description="ajouter des chambres à un bloc")
    @PutMapping("/assign-chambres-bloc/{bloc-id}")
    public Bloc addChambreBloc(@RequestBody List<Long> numChambre, @PathVariable("bloc-id") Long idBloc) {
        return blocService.affecterChambresABloc(numChambre,idBloc);
    }
}
