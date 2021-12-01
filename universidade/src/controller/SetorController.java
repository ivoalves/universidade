package controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;

import dao.SetorDAO;
import model.Setor;

@Controller
public class SetorController 
{
	
	private final SetorDAO dao;
	
	@Autowired
	public SetorController(SetorDAO dao)
	{
		this.dao = dao; 
	}
	
	@RequestMapping("nova")
	public String form()
	{
		return "setor/formulario";
	}
	
	@RequestMapping("adicionarSetor")
	public String adiciona(Setor s)
	{
		dao.adiciona(s);
		return "setor/adicionada";
	}
	
	@RequestMapping("alteraSetor")
	public String alterar(Setor s)
	{
		dao.alterar(s);
		return "redirect:listarSetor";
	}
	
	@RequestMapping("excluirSetor")
	public String excluir(Setor s)
	{
		dao.excluir(s);
		return "redirect:listarSetor";
	}
	
	@RequestMapping("listarSetor")
	public String lista(Model m)
	{
		m.addAttribute("setores",dao.getLista());
		return "setor/lista";
	}
}