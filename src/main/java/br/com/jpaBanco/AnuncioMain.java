package br.com.jpaBanco;

import br.com.jpaBanco.dao.AnuncioPersistence;
import br.com.jpaBanco.dao.VendedorPersistence;
import br.com.jpaBanco.entity.Anuncio;
import br.com.jpaBanco.entity.Endereco;
import br.com.jpaBanco.entity.Vendedor;
import br.com.jpaBanco.service.AnuncioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AnuncioMain {

    public static void main(String[] args) {
        //insereAnuncio();
        //atualizaAnuncio();
        deleta();
    }

    private static void insereAnuncio(){
        AnuncioPersistence anuncioPersistence = new AnuncioPersistence();
        Vendedor vendedor = new Vendedor("MLB984", "000.999.000-00", "Ana");

        List<Endereco> enderecos = Arrays.asList(new Endereco("88888-000", "logradouro do ana", "", 4005, "ES", "Vitória", vendedor)
                ,new Endereco("12345-678", "logradouro do ana no piauí", "", 12, "PI", "Terezina", vendedor));

        vendedor.setEnderecos(enderecos);

        Anuncio anuncio = new Anuncio("MLB857","Notebook", new BigDecimal(2000), LocalDate.now(),5,vendedor);

        anuncioPersistence.insere(anuncio);
    }

    private static void atualizaAnuncio(){
        AnuncioPersistence anuncioPersistence = new AnuncioPersistence();
        AnuncioService anuncioService =  new AnuncioService(anuncioPersistence);
        Vendedor vendedor = new Vendedor("MLB984", "000.999.000-00", "Ana");

        List<Endereco> enderecos = Arrays.asList(new Endereco("88888-000", "logradouro do ana", "", 4005, "ES", "Vitória", vendedor)
                ,new Endereco("12345-678", "logradouro do ana no piauí", "", 12, "PI", "Terezina", vendedor));

        vendedor.setEnderecos(enderecos);

        Anuncio anuncio = new Anuncio(1L,"MLB857","macbook", new BigDecimal(15000), LocalDate.now(),2,vendedor);

        anuncioService.salva(anuncio);
    }

    private static void deleta() {
        AnuncioPersistence anuncioPersistence = new AnuncioPersistence();
        anuncioPersistence.deleta(1L);
    }

}
