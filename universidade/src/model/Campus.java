package model;

public class Campus 
{
	private int codigo;
	private String nome,cidade,estado;
	
	public void setCodigo(int cod)
	{
		codigo=cod;
	}
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	public void setCidade(String cidade)
	{
		this.cidade=cidade;
	}
	public void setEstado(String uf)
	{
		estado=uf;
	}
	
	public int getCodigo()
	{
		return codigo;
	}
	public String getNome()
	{
		return nome;
	}
	public String getCidade()
	{
		return cidade;
	}
	public String getEstado()
	{
		return estado;
	}
}
