package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    public MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // CRUD de Missoes
    // Criar nova missao  -- CREATE
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.ciarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão: " + novaMissao.getMissao() + " com dificuldade: " + novaMissao.getDificuldade() + " criada com sucesso!");
    }

    // Listar todas as missoes -- READ
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes =  missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    // Listar Missoes por ID -- READ
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID " + id + " não encontrada!");
        }
    }


    // Alterar Missao -- UPDATE
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id,@RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.alterarMissao(id, missaoAtualizada);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID " + id + " não encontrada!");
        }
    }

    // Deletar Missao -- DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletaMissao(id);
            return ResponseEntity.ok("Missao com ID " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com ID " + id + " não encontrado!");
        }
    }
}
