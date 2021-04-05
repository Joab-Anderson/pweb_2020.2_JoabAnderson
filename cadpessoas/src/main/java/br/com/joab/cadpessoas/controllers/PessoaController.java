package br.com.joab.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    PessoaController(PessoaRepository pessoaRepo){
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping
    public String inicio(){
        return "index.html";
    }

    @GetMapping("/adicionarPessoa")
    public ModelAndView formAdcionarPessoa(){
        ModelAndView modelAndView = new ModelAndView("adicionarPessoa");
        modelAndView.addObject(new Pessoa());
        return modelAndView;
    }

    @PostMapping("/adicionarPessoa")
    public String adicionarPessoa(Pessoa pessoa){
        this.pessoaRepo.save(pessoa);
        return "redirect:/listarPessoa";
    }

    @GetMapping("/listarPessoa")
    public ModelAndView listarPessoas(){
        List<Pessoa> lista = pessoaRepo.findAll();
        ModelAndView mav = new ModelAndView("listarPessoa");
        mav.addObject("pessoas", lista);
        return mav;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView formEditarPessoa (@PathVariable("id") long id){
        Pessoa pessoa = pessoaRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID Invalido: " + id));
        ModelAndView modelAndView = new ModelAndView("editarPessoa");
        modelAndView.addObject(pessoa);
        return modelAndView;
    }


    @PostMapping("/editar/{id}")
    public ModelAndView editarPessoa(@PathVariable("id") long id, Pessoa pessoa){
        this.pessoaRepo.save(pessoa);
        return new ModelAndView("redirect:/listarPessoa");
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerPessoa(@PathVariable("id") long id){
        Pessoa aRemover = pessoaRepo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("ID Invalido: " + id));
        pessoaRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarPessoa");
    }
}