package br.com.jpaBanco;

import br.com.jpaBanco.dao.VendaPersistence;
import br.com.jpaBanco.entity.FormaPagamento;
import br.com.jpaBanco.entity.Venda;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaMain {

    public static void main(String[] args) {
        VendaPersistence vendaPersistence = new VendaPersistence();

        vendaPersistence.insere(new Venda(LocalDate.now(), new BigDecimal(1400), FormaPagamento.A_PRAZO));

//		List<Venda> lista = vendaPersistence.lista();
//		lista.forEach(v -> System.out.println(v.getData().toString().concat("  " + v.getValorTotal())));

//		Venda v = vendaPersistence.get(2L);
//		System.out.println(v.getData().toString().concat("  " + v.getValorTotal()));

//		Venda venda = new Venda(3L, LocalDate.now(), new BigDecimal(5000), "A PRAZO");
//		vendaPersistence.atualiza(venda);

        //vendaPersistence.deleta(4L);

    }
}
