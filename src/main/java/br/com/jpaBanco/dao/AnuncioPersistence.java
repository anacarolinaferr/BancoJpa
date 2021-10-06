package br.com.jpaBanco.dao;

import br.com.jpaBanco.Util.JPAUtil;
import br.com.jpaBanco.entity.Anuncio;
import br.com.jpaBanco.entity.Vendedor;

import javax.persistence.EntityManager;

public class AnuncioPersistence {

    private EntityManager em;

    public AnuncioPersistence(){
        em = JPAUtil.getEntityManager();
    }

    public void insere(Anuncio anuncio) {
        em.getTransaction().begin();
        em.persist(anuncio);
        em.getTransaction().commit();
    }

    public Anuncio get(Long id) {
        return em.find(Anuncio.class, id);
    }

    public void atualiza(Anuncio anuncio) {
        em.getTransaction().begin();
        Anuncio anuncioParaSerAtualizado = em.find(Anuncio.class, anuncio.getId());
        anuncioParaSerAtualizado.setPreco(anuncio.getPreco());
        anuncioParaSerAtualizado.setTitulo(anuncio.getTitulo());
        em.getTransaction().commit();
    }

    public void deleta(Long id) {
        em.getTransaction().begin();
        Anuncio a = em.find(Anuncio.class, id);
        em.remove(a);
        em.getTransaction().commit();
    }
}
