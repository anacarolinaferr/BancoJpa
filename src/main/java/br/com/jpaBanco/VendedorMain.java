package br.com.jpaBanco;

import br.com.jpaBanco.dao.AnuncioPersistence;
import br.com.jpaBanco.dao.VendedorPersistence;
import br.com.jpaBanco.entity.Anuncio;
import br.com.jpaBanco.entity.Endereco;
import br.com.jpaBanco.entity.Vendedor;
import br.com.jpaBanco.service.AnuncioService;
import br.com.jpaBanco.service.VendedorService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class VendedorMain {

    public static void main(String[] args) {
        insere();
        //atualiza();
        //lista();
        //exclui();
    }

    private static void insere() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();

        Vendedor vendedor = new Vendedor("MLB984", "000.999.000-00", "Ana");
        List<Endereco> enderecos = Arrays.asList(new Endereco("88888-000", "logradouro do ana", "", 4005, "ES", "Vitória", vendedor)
                ,new Endereco("12345-678", "logradouro do ana no piauí", "", 12, "PI", "Terezina", vendedor));

        vendedor.setEnderecos(enderecos);

        vendedorPersistence.insere(vendedor);
    }

    private static void exclui() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        vendedorPersistence.deleta(1L);
    }

    private static void lista() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence(); //like a mock :)
        VendedorService service = new VendedorService(vendedorPersistence);
        service.listagem().forEach(v -> System.out.println(v));
    }

    private static void atualiza() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence(); //like a mock :)
        VendedorService service = new VendedorService(vendedorPersistence);
        Vendedor vendedor = new Vendedor("MLB984", "000.999.000-00", "Ana Ferreira");

        List<Endereco> enderecos = Arrays.asList(new Endereco("88888-000", "logradouro do ana", "", 4005, "ES", "Vitória", vendedor)
                ,new Endereco("12345-678", "logradouro do ana no piauí", "", 12, "PI", "Terezina", vendedor));

        vendedor.setEnderecos(enderecos);

        service.salva(vendedor);
    }
}