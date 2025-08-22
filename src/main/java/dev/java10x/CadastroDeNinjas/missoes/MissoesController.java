package dev.java10x.CadastroDeNinjas.missoes;

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
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.ciarMissao(missao);
    }

    // Listar todas as missoes -- READ
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // Listar Missoes por ID -- READ
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);
    }


    // Alterar Missao -- UPDATE
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id,@RequestBody MissoesModel missaoAtualizada) {
        missoesService.alterarMissao(id, missaoAtualizada);
        return missoesService.listarMissoesPorId(id);
    }

    // Deletar Missao -- DELETE
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletaMissao(id);
    }
}
