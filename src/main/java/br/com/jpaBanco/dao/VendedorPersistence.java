package br.com.jpaBanco.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.jpaBanco.Util.JPAUtil;
import br.com.jpaBanco.entity.Vendedor;

import java.util.List;

public class VendedorPersistence {

    private EntityManager em;

    public VendedorPersistence(){
        em = JPAUtil.getEntityManager();
    }

    public void atualiza(Vendedor vendedor) {
        em.getTransaction().begin();
        Vendedor vendedorParaSerAtualizada = em.find(Vendedor.class, vendedor.getCodigo());
        vendedorParaSerAtualizada.setNome(vendedor.getNome());
        vendedorParaSerAtualizada.setCpf(vendedor.getCpf());
        vendedor.setEnderecos(vendedor.getEnderecos());
        em.getTransaction().commit();
    }

    public List<Vendedor> lista(){
        TypedQuery<Vendedor> qry = em.createQuery("From Vendedor", Vendedor.class);
        return qry.getResultList();
    }


    public Vendedor get(String codigo){
        return em.find(Vendedor.class, codigo);
    }

    public void insere(Vendedor vendedor) {
        em.getTransaction().begin();
        em.persist(vendedor);
        em.getTransaction().commit();
    }

    public void deleta(Long id) {
        em.getTransaction().begin();
        Vendedor v = em.find(Vendedor.class, id);
        em.remove(v);
        em.getTransaction().commit();
    }

}