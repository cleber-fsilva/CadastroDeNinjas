package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {


    MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setMissao(missoesDTO.getMissao());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setMissao(missoesModel.getMissao());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }
}
