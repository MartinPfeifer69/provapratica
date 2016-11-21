package br.com.provaPratica.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="produtos")
public class ProdutoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max = 40)
	@Column(name="NomeProduto")
	private String nomeProduto;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private CategoriaModel categoria;
	
	@Size(max = 20)
	@Column(name="QuantidadePorUnidade")
    private String quantidadePorUnidade;
	
    @Column(name="PrecoUnitario", columnDefinition="Decimal(15,2) default '0.00'")
    private Double precoUnitario;
    
    @Column(name="UnidadesEmEstoque", columnDefinition = "SMALLINT")
    private short unidadesEmEstoque;
    
    @Column(name="UnidadesEmOrdem", columnDefinition = "SMALLINT")
    private short unidadesEmOrdem;	
    
    @Column(name="NivelDeReposicao", columnDefinition = "SMALLINT")
    private short nivelDeReposicao;
    
//    private enum descontinuado{
//    	F,
//    	T
//    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public String getQuantidadePorUnidade() {
		return quantidadePorUnidade;
	}

	public void setQuantidadePorUnidade(String quantidadePorUnidade) {
		this.quantidadePorUnidade = quantidadePorUnidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public short getUnidadesEmEstoque() {
		return unidadesEmEstoque;
	}

	public void setUnidadesEmEstoque(short unidadesEmEstoque) {
		this.unidadesEmEstoque = unidadesEmEstoque;
	}

	public short getUnidadesEmOrdem() {
		return unidadesEmOrdem;
	}

	public void setUnidadesEmOrdem(short unidadesEmOrdem) {
		this.unidadesEmOrdem = unidadesEmOrdem;
	}

	public short getNivelDeReposicao() {
		return nivelDeReposicao;
	}

	public void setNivelDeReposicao(short nivelDeReposicao) {
		this.nivelDeReposicao = nivelDeReposicao;
	}
	
}
