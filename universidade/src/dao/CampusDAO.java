package dao;

//imports de anotações
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

//import da classe modelo referente
import model.Campus;

//importaçoes de recursos java
import java.sql.*;
import javax.sql.*;
import java.util.*;

@Repository
public class CampusDAO 
{
	private final Connection con;
	
	@Autowired
	public CampusDAO(DataSource dt)
	{
		try {
		
			con=dt.getConnection();
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Adicionado um campus
	public void adicionar(Campus c)
	{
		String sql;
		//Comando a ser o usado
		sql="INSERT INTO tbcampus VALUES (?,?,?,?)";
		
		try {
			//Preparando o comando a ser executado
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Definindo os valores das interrogação
			ps.setInt(1,c.getCodigo());
			ps.setString(2,c.getNome());
			ps.setString(3,c.getCidade());
			ps.setString(4,c.getEstado());
			
			//Executando o comando
			ps.execute();
			
			//Fechando a conexão
			ps.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Alterando os dados no banco
	public void alterar(Campus c)
	{
		String sql;
		//Comando a ser usado
		sql="UPDATE tbcampus SET cod_campus=?,nome_campus=?,cidade_campus=?,estado_campus=?";
		
		try {
			//Preparando o comando a ser executado
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Executando o comando
			ps.execute();
			
			//Fechando a conexão 
			ps.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//Excuindo os registros
	public void excluir(Campus c)
	{
		String sql;
		//comando a ser usado
		sql="DELETE FROM tbcampus WHERE	cod_campus=?";
		
		try {
			//Preparando o comando a ser executado
			PreparedStatement ps =con.prepareStatement(sql);
			
			//Definido os valores das interrogação
			ps.setInt(1, c.getCodigo());
			
			//executando o comando
			ps.execute();
			
			//Fechando a conexão
			ps.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Listando os campi 
	public List<Campus> getLista()
	{
		String sql;
		//comando a ser usado
		sql="SELECT*FROM tbcampus";
		
		try{
			//Criando o ArrayList de retorno
			List<Campus> campus = new ArrayList<Campus>();
			
			//Preparando o comando a ser executado
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Recuperando os valores do Banco de dados 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				//Criando uma instância de Campus
				Campus c = new Campus(); 
				
				//Povoando a instância
				c.setCodigo(rs.getInt("cod_campus"));
				c.setNome(rs.getString("nome_campus"));
				c.setCidade(rs.getString("cidade_campus"));
				c.setEstado(rs.getString("estado_campus"));
				
				//Adicionado a instância no Array
				campus.add(c);
			}			
			//Fechando a conexão
			rs.close();
			ps.close();
			
			//Retornado o ArrayList para a página
			return campus;
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
