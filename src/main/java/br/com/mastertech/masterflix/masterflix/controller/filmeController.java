package br.com.mastertech.masterflix.masterflix.controller;
import br.com.mastertech.masterflix.masterflix.model.Filme;
import br.com.mastertech.masterflix.masterflix.service.filmeService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class filmeController{
    @Autowired
    private filmeService service;

    @GetMapping
    public String mostrarHome(){
        return "index";
    }

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "cadastroFilme";
    }

    @PostMapping("/cadastrar")
    public String cadastroFilme (Filme filme){
        service.cadastrarFilme(filme);
        return "index";
    }

    @GetMapping("/filmes")
    public ModelAndView listarFilmes(){
        ModelAndView pagina = new ModelAndView("listarFilmes");
        Iterable<Filme> filmes = service.listarFilmes();
        pagina.addObject("filmes", filmes);

        return pagina;
    }
    @GetMapping("/buscar")
    public String buscarFilme(){
        return "buscarFilme";
    }

    @GetMapping("/filme")
    public String listarFilme(@RequestParam("nome")String nome, Model model) {
        Filme filme = service.listarFilme(nome);
        if (filme != null) {
            model.addAttribute("filme", filme);
            return "listarFilme";
        }
        else {
            model.addAttribute("msg", filme + " Filme não encontrado");
            return "buscarFilme";
        }
    }

    @GetMapping("filme/{nome}")
    public String listarFilmeNome(@PathVariable("nome")String nome, Model model) {
        Filme filme = service.listarFilme(nome);
        if (filme != null) {
            model.addAttribute("filme", filme);
            return "listarFilme";
        } else {
            model.addAttribute("msg", filme + " Filme não encontrado");
            return "listarFilme ";
        }
    }
}
