package br.com.joab.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.joab.cadpessoas.model.Pessoa;
import br.com.joab.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {
    
    @Autowired
    PessoaRepository pessoaRepo;

    @GetMapping
    public String index(){
        return "index.html";
    }

    @GetMapping("/listarPessoas")
    public ModelAndView listarPessoas(){
        List<Pessoa> lista = pessoaRepo.findAll();
        ModelAndView mav = new ModelAndView("listarPessoas");
        mav.addObject("pessoas", lista);
        return mav;
    }
    
}