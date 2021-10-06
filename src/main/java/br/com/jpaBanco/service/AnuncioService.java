package br.com.jpaBanco.service;

import br.com.jpaBanco.dao.AnuncioPersistence;
import br.com.jpaBanco.entity.Anuncio;

import java.math.BigDecimal;

public class AnuncioService {

    private AnuncioPersistence anuncioPersistence;

    public AnuncioService(AnuncioPersistence anuncioPersistence) {
        this.anuncioPersistence = anuncioPersistence;
    }

    public void salva(Anuncio anuncio) {
        if(anuncio.getId() == null || anuncio.getId().toString().isEmpty()) {
            anuncioPersistence.insere(anuncio);
        }else{
            Anuncio anuncioExistente = anuncioPersistence.get(anuncio.getId());
            if(anuncioExistente == null){
                throw new RuntimeException("Algo de muito errado aconteceu");
            }

            anuncioExistente.setPreco(new BigDecimal(28000));
            anuncioExistente.setTitulo("MacBook");

            anuncioPersistence.atualiza(anuncioExistente);
        }
    }

    public void deleta(Long id) {
        anuncioPersistence.deleta(id);
    }
}
