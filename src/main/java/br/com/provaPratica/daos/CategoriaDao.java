package br.com.provaPratica.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.provaPratica.models.CategoriaModel;
import br.com.provaPratica.utils.GenericEntityManager;

public class CategoriaDao {
	
	private GenericEntityManager manager;
	
	public CategoriaDao(){
		manager = new GenericEntityManager();
	}
	
	public void insert(CategoriaModel categoria){
        this.manager.insert(categoria);
    }

	public void delete(Integer id){
        this.manager.delete(new CategoriaModel(), id);
    }
     
    public CategoriaModel findOne(Integer id){
        CategoriaModel categoria = new CategoriaModel();
        categoria = (CategoriaModel) this.manager.find(new CategoriaModel(), id);
        return  categoria;
    }
     
    public void alter(CategoriaModel categoria){
        this.manager.alter(categoria);
    }
     
    @SuppressWarnings("unchecked")
    public List<CategoriaModel> findAllCategorias(){
        List<CategoriaModel> listCategorias = new ArrayList<CategoriaModel>();
         
        manager.begin();
        Query query = manager.getManager().createQuery("SELECT c FROM CategoriaModel c");
        listCategorias = query.getResultList();
        manager.close();
         
        return listCategorias;
    }
}	
