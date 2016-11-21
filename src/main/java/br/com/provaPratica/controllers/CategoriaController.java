package br.com.provaPratica.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import br.com.provaPratica.daos.CategoriaDao;
import br.com.provaPratica.models.CategoriaModel;
import br.com.provaPratica.utils.Utils;

@ManagedBean
@Named(value = "categoriaController")
@RequestScoped
@SessionScoped
public class CategoriaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	CategoriaModel categoriaModel;
	
	@Inject
	CategoriaDao categoriaDao;
	
	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}

	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}

	private List<CategoriaModel> listaCategorias = new ArrayList<CategoriaModel>();

	public void salvar() {
			
		try {
			if (this.categoriaModel.getId() != null) {
				categoriaDao.alter(this.categoriaModel);
			} else {
				categoriaDao.insert(this.categoriaModel);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.categoriaModel = null;
			this.listaCategorias.add(this.categoriaModel);
			Utils.msgInfo("Registro salvo com sucesso!");
		}
	}

	public void excluir(CategoriaModel categoria) {
		CategoriaDao categoriaDao = new CategoriaDao();
		categoriaDao.delete(categoria.getId());
		removerDaLista(categoria);
		this.categoriaModel = null;

		Utils.msgWarning("Registro removido com sucesso!");
	}

	public void removerDaLista(CategoriaModel categoria) {
		this.listaCategorias.remove(categoria);
	}

	public void editar(CategoriaModel categoria) {
		this.categoriaModel = categoria;
	}

	public void listarCategorias() {
		CategoriaDao categoriaDao = new CategoriaDao();
		this.listaCategorias = categoriaDao.findAllCategorias();
	}

	public List<CategoriaModel> getListaCategorias() {
		CategoriaDao categoriaDao = new CategoriaDao();
		this.listaCategorias = categoriaDao.findAllCategorias();
		return listaCategorias;
	}

	public void processFileUpload(FileUploadEvent event) {
		try {
			categoriaModel.setFigura(event.getFile().getContents());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
