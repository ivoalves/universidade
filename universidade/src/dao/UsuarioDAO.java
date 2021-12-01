package dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.*;
import java.sql.*;
import model.Usuario;

@Repository
public class UsuarioDAO 
{
	private final Connection con;
	
	@Autowired
	public UsuarioDAO(DataSource dt)
	{
		try {
			
			con = dt.getConnection();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public boolean existeUsuario(Usuario u)
	{
		String sql;
		sql="SELECT*FROM usuario WHERE login=? and senha=?";
		
		try {
			//Preparando o comando a ser executado
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Definindo os valores das interrogações
			ps.setString(1,u.getLogin());
			ps.setString(2,u.getSenha());
			
			//Recuperando os valores do Banco de dados
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				ps.close();
				return true;
			}else {
				ps.close();
				return false;
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}