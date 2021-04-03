package br.com.joab.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.joab.cadpessoas.model.Pessoa;
import br.com.joab.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {
    
    @Autowired
    PessoaRepository pessoaRepo;

    @GetMapping("/index.html")
    public String inicio(){
        return "index.html";
    }

    /*@GetMapping("/static/public/noticias.html")
    public String noticias(){
        return "/static/public/noticias.html";
    }*/

    /*@GetMapping("/adicionarPessoa.html")
    public String adcionarPessoa(){
        return "/adicionarPessoa.html";
    }*/

    @GetMapping("/listarPessoa.html")
    public ModelAndView listarPessoas(){
        List<Pessoa> lista = pessoaRepo.findAll();
        ModelAndView mav = new ModelAndView("listarPessoa");
        mav.addObject("pessoas", lista);
        return mav;
    }

    /*@PostMapping("/sobre.html")
    public String sobreSite(){
        return "sobre.html";
    }

    @GetMapping("/public/contato.html")
    public String contato(){
        return "/public/contato.html";
    }

    @GetMapping("/editarPessoa.html")
    public String editarPessoa(){
        return "/editarPessoa.html";
    }*/
}