package model;

//import javax.validation.constraints.*;

public class Usuario 
{
	//@NotNull(message="Este campo deve ser preenchido")
	private String login, senha;
	
	public void setLogin(String username)
	{
		login = username;
	}
	
	public void setSenha(String password)
	{
		senha = password;
	}
	
	public String getLogin()
	{
		return login; 
	}
	
	public String getSenha()
	{
		return senha;
	}
}