package controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
//import org.springframework.validation.*;

import javax.servlet.http.*;
//import javax.validation.*;
import model.Usuario;
import dao.UsuarioDAO;

@Controller
public class LoginController 
{
	private final UsuarioDAO dao;
	
	@Autowired
	public LoginController(UsuarioDAO dao)
	{
		this.dao = dao; 
	}
	
	@RequestMapping("loginForm")
	public String loginForm()
	{
		return "login/formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(/*@Valid*/ Usuario u,HttpSession s/*,BindingResult rs*/)
	{
		/*if(rs.hasErrors()) 
		{
			return "redirect:loginForm";
		}
		*/
		if(dao.existeUsuario(u))
		{
			s.setAttribute("usuarioLogado",u);
			return "login/menu";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:loginForm";
	}
}
