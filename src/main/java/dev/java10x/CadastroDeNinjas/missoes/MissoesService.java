package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Criar Missoes
    public MissoesModel ciarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    // Listar todas as missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Listar missao por ID
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    // Alterar Missao
    public MissoesModel alterarMissao(Long id, MissoesModel missaoAtualizada) {
        if (missoesRepository.existsById(id)) {
            missaoAtualizada.setId(id);
            missoesRepository.save(missaoAtualizada);
        }

        return null;
    }

    //Delete Missao
    public void deletaMissao(Long id) {
        missoesRepository.deleteById(id);
    }


}
