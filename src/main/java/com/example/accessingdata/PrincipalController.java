package com.example.accessingdata;
//wendel
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Isso significa que esta classe é um Controlador
@RequestMapping(path = "/user") // Isso significa que os URLs começam com / Demo (após o caminho do aplicativo)
@CrossOrigin(origins = "*")
public class PrincipalController {
   
    @Autowired // faz o starte do nosso objeto
    private UsuarioRepository uRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNovoUsuario(@RequestParam String nome, @RequestParam String local/*,
    @RequestParam String status, , @RequestParam String iniPrevisto, @RequestParam String iniCirurgia,
    @RequestParam String fimCirurgia, @RequestParam String saidaPrev*/) {
       
           Usuario u = new Usuario();
           u.setNome(nome);
           u.setLocal(local);
           /*
           u.setStatus(status);
           u.setIniPrevisto(iniPrevisto);
           u.setIniCirurgia(iniCirurgia);
           u.setFimCirurgia(fimCirurgia);
           u.setSaidaPrev(saidaPrev);*/
            uRepository.save(u);
            return "Ok ao gravar.";
       
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Usuario> getAllUsuarios() {
        return uRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        // return uRepository.findAll();
    }
    // PUT atualizar
    @PutMapping(path = "/{id}")
    public @ResponseBody String updateUsuario(@PathVariable int id, @RequestParam String nome, @RequestParam String local
    /*, @RequestParam String status,
              @RequestParam String iniPrevisto, 
            @RequestParam String iniCirurgia, @RequestParam String fimCirurgia, @RequestParam String saidaPrev*/) {
        Usuario u = uRepository.findById(id);
        u.setNome(nome);
        u.setLocal(local);
        /*u.setStatus(status);
        u.setIniPrevisto(iniPrevisto);
        u.setIniCirurgia(iniCirurgia);
        u.setFimCirurgia(fimCirurgia);
        u.setSaidaPrev(saidaPrev);*/
        uRepository.save(u);
        return "Ok ao atualizar.";
    }
    // DELETE apagar
    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteUsuario(@PathVariable int id) {
        uRepository.deleteById(id);
        return "Ok ao apagar.";
    }
}
