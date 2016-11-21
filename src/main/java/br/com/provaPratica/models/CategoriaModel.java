package br.com.provaPratica.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="categorias")
public class CategoriaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max = 15)
    @Column(name="NomeCategoria")
	private String nomeCategoria;
    
    @Column(name="Descricao")
	private String descricao;
    
    @Lob
    @Column(name="Figura")
	private byte[] figura;
    
    @OneToMany(mappedBy="categoria",
    		cascade = CascadeType.ALL)
    private List<ProdutoModel> itensProduto = new ArrayList<>();

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFigura() {
		return figura;
	}

	public void setFigura(byte[] figura) {
		this.figura = figura;
	}

	public List<ProdutoModel> getItensProduto() {
		return itensProduto;
	}

	public void setItensProduto(List<ProdutoModel> itensProduto) {
		this.itensProduto = itensProduto;
	}
	
	public String toString(){
		return this.nomeCategoria;
	}
}
