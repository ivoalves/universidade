package controller;
//imports das anotações
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;

import model.Campus;
import dao.CampusDAO;

@Controller
public class CampusController 
{
	private final CampusDAO dao;
	
	@Autowired
	public CampusController(CampusDAO dao)
	{
		this.dao=dao;
	}
	
	@RequestMapping("adicionarCampus")
	public String adiciona(Campus c)
	{
		dao.adicionar(c);
		return "campus/adicionado"; 
	}
	
	@RequestMapping("alterarCampus")
	public String alterar(Campus c)
	{
		dao.alterar(c);
		return "redirect:listarCampus";
	}
	
	@RequestMapping("excluirCampus")
	public String excluir(Campus c)
	{
		dao.excluir(c);
		return "redirect:listarCampus";
	}
	
	@RequestMapping("listarCampus")
	public String Listar(Model m)
	{
		m.addAttribute("campu",dao.getLista());
		return "campus/lista";
	}
}
