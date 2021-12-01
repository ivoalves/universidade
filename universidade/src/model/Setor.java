package model;

public class Setor 
{
	private int codigo;
	private String nome;
	
	public void setCodigo(int cod)
	{
		codigo = cod;
	}
	
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	
	public int getCodigo()
	{
		return codigo;
	}
	
	public String getNome()
	{
		return nome;
	}
}
