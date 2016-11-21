package br.com.provaPratica.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.provaPratica.models.ProdutoModel;
import br.com.provaPratica.utils.GenericEntityManager;

public class ProdutoDao {
	
	private GenericEntityManager manager;

	public ProdutoDao(){
		manager = new GenericEntityManager();
	}
	
	public void insert(ProdutoModel produto){
        this.manager.insert(produto);
    }

	public void delete(Integer id){
        this.manager.delete(new ProdutoModel(), id);
    }
     
    public ProdutoModel findOne(Integer id){
        ProdutoModel produto = new ProdutoModel();
        produto = (ProdutoModel) this.manager.find(new ProdutoModel(), id);
        return produto;
    }
     
    public void alter(ProdutoModel produto){
        this.manager.alter(produto);
    }
     
    @SuppressWarnings("unchecked")
    public List<ProdutoModel> findAllProdutos(){
        List<ProdutoModel> listProdutos = new ArrayList<ProdutoModel>();
         
        manager.begin();
        Query query = manager.getManager().createQuery("SELECT p FROM ProdutoModel p");
        listProdutos = query.getResultList();
        manager.close();
         
        return listProdutos;
    }
	
}
