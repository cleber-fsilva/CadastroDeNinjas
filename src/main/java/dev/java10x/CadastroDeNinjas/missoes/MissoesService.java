package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // Criar Missoes
    public MissoesDTO ciarMissao(MissoesDTO missaoDTO) {
        MissoesModel missao = new MissoesMapper().map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    // Listar todas as missoes
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes
                .stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }


    // Listar missao por ID
    public MissoesDTO listarMissoesPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    // Alterar Missao
    public MissoesDTO alterarMissao(Long id, MissoesDTO missaoDto) {
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);
        if (missaoExiste.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDto);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

    //Delete Missao
    public void deletaMissao(Long id) {
        missoesRepository.deleteById(id);
    }


}
