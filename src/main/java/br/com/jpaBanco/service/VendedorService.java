package br.com.jpaBanco.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import br.com.jpaBanco.dao.VendedorPersistence;
import br.com.jpaBanco.entity.Vendedor;

public class VendedorService {

    private VendedorPersistence vendedorPersistence;

    public VendedorService(VendedorPersistence vendedorPersistence) {
        this.vendedorPersistence = vendedorPersistence;
    }

    private String codigoUnico() {
        return "MLB" + ThreadLocalRandom.current().nextInt(100, 999);
    }

    public void salva(Vendedor vendedor) {
        if(vendedor.getCodigo()==null || vendedor.getCodigo().isEmpty()) {
            vendedor.setCodigo(codigoUnico());
            vendedorPersistence.insere(vendedor);
        }else{
            Vendedor vendedorExistente = vendedorPersistence.get(vendedor.getCodigo());
            if(vendedorExistente == null){
                throw new RuntimeException("Algo de muito errado aconteceu");
            }
            vendedorExistente.setCpf(vendedor.getCpf());
            vendedorExistente.setNome(vendedor.getNome());
            vendedorExistente.setEnderecos(vendedor.getEnderecos());
            vendedorPersistence.atualiza(vendedorExistente);
        }
    }

    /**
     *
     * @return uma lista de vendedores ordenada (em ordem crescente) pelo nome
     */
    public List<Vendedor> listagem(){
        List<Vendedor> lista = vendedorPersistence.lista();
        lista.sort((Vendedor v1, Vendedor v2) -> v1.getNome().compareToIgnoreCase(v2.getNome()));
        return lista;
    }

    public Vendedor obtem(String codigo) {
        return vendedorPersistence.get(codigo);
    }

    public void deleta(Long id) {
        vendedorPersistence.deleta(id);
    }
}