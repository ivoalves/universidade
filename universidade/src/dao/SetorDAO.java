package dao;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.sql.*;
import javax.sql.*;
import model.Setor;
import java.util.*;


@Repository
public class SetorDAO 
{
	private final Connection con;
	
	@Autowired
	public SetorDAO(DataSource dt)
	{
		try {
			con = dt.getConnection();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Setor s)
	{
		String sql;
		sql="INSERT INTO tbsetor VALUES(?,?)";
		
		try {
			
			//Preparando o comando a ser executado
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Definindo os valores das interrogações
			ps.setInt(1,s.getCodigo());
			ps.setString(2,s.getNome());
			
			//Executando o comando 
			ps.execute();
			
			//Fechando a conexão 
			ps.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Setor s)
	{
		String sql;
		sql="UPDATE tbsetor SET cod_nome=?,nome_setor=?";
		
		try {
			
			//Preparando o comando a ser executado
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Definindo os valores das interrogações
			ps.setInt(1,s.getCodigo());
			ps.setString(2,s.getNome());
			
			//Executando o comando
			ps.execute();
			
			//Fechando a conexão
			ps.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(Setor s)
	{
		String sql;
		sql="DELETE FROM tbsetor WHERE cod_setor=?";
		
		try {
			
			//Preparando o comando a ser executado
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Definindo o valor referente a interrogação
			ps.setInt(1,s.getCodigo());
			
			//Executando o comando
			ps.execute();
			
			//Fechando a conexão
			ps.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Setor> getLista()
	{
		String sql;
		sql="SELECT*FROM tbsetor";
		
		try {
			
			//Criando um arrayList de retorno
			List<Setor> setor = new ArrayList<Setor>();

			//Preparando o comando a ser executado
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Recuperando os valores do Banco de Dados
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				//Criando uma instância de Setor
				Setor s = new Setor();
				
				//Povoando a instância
				s.setCodigo(rs.getInt("cod_setor"));
				s.setNome(rs.getString("nome_setor"));
				
				//Adicionando a instância no arrayList
				setor.add(s);
			}
			
			//Fechando as conexões 
			rs.close();
			ps.close();
			
			//Retornando o arrayLista para a página
			return setor;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	} 
}
