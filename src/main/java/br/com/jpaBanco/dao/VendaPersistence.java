package br.com.jpaBanco.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.jpaBanco.Util.JPAUtil;
import br.com.jpaBanco.entity.FormaPagamento;
import br.com.jpaBanco.entity.Venda;

public class VendaPersistence {

    private EntityManager em;

    public VendaPersistence() {
        em = JPAUtil.getEntityManager();
    }

    public void insere(Venda venda) {
        try {
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
        }
    }

    public Venda get(Long id) {
        return em.find(Venda.class, id);
    }

    public List<Venda> lista() {
        TypedQuery<Venda> qry = em.createQuery("from Venda", Venda.class);
        return qry.getResultList();
    }

    public void atualiza(Venda venda) {
        em.getTransaction().begin();
        Venda vendaParaSerAtualizada = em.find(Venda.class, venda.getId());
        vendaParaSerAtualizada.setValorTotal(new BigDecimal(5000));
        vendaParaSerAtualizada.setFormaPagamento(FormaPagamento.A_VISTA);
        em.getTransaction().commit();
    }

    public void deleta(Long id) {
        em.getTransaction().begin();
        Venda v = em.find(Venda.class, id); //garantindo que o objeto v esteja no estado managed
        em.remove(v);
        em.getTransaction().commit();
    }
}