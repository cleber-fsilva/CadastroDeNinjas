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


    // Alterar Missao -- UPDATE
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada";
    }

    // Deletar Missao -- DELETE
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada";
    }
}
