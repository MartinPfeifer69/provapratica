package br.com.provaPratica.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.provaPratica.daos.CategoriaDao;
import br.com.provaPratica.daos.ProdutoDao;
import br.com.provaPratica.models.CategoriaModel;
import br.com.provaPratica.models.ProdutoModel;
import br.com.provaPratica.utils.Utils;

@ManagedBean
@Named(value = "produtoController")
@RequestScoped
@SessionScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoModel produtoModel;

	@Inject
	ProdutoDao produtoDao;

	public ProdutoModel getProdutoModel() {
		return produtoModel;
	}

	public void setProdutoModel(ProdutoModel produtoModel) {
		this.produtoModel = produtoModel;
	}

	private List<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();
	private List<CategoriaModel> listaCategorias = new ArrayList<CategoriaModel>();

	public void salvar() {

		try {
			if (this.produtoModel.getId() != null) {
				produtoDao.alter(this.produtoModel);
			} else {
				produtoDao.insert(this.produtoModel);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.produtoModel = null;
			this.listaProdutos.add(this.produtoModel);
			Utils.msgInfo("Registro salvo com sucesso!");
		}
	}

	public void excluir(ProdutoModel produto) {
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.delete(produto.getId());
		removerDaLista(produto);
		this.produtoModel = null;

		Utils.msgWarning("Registro removido com sucesso!");
	}

	public void removerDaLista(ProdutoModel produto) {
		this.listaProdutos.remove(produto);
	}

	public void editar(ProdutoModel produto) {
		this.produtoModel = produto;
	}

	public void listarProdutos() {
		ProdutoDao produtoDao = new ProdutoDao();
		this.listaProdutos = produtoDao.findAllProdutos();
	}

	public List<ProdutoModel> getListaProdutos() {
		ProdutoDao produtoDao = new ProdutoDao();
		this.listaProdutos = produtoDao.findAllProdutos();
		return listaProdutos;
	}
	
	public void listarCategorias() {
		CategoriaDao categoriaDao = new CategoriaDao();
		this.listaCategorias = categoriaDao.findAllCategorias();
	}

	public List<CategoriaModel> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaModel> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
}
