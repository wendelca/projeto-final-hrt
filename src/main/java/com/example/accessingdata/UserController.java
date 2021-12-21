package com.example.accessingdata;
//wendel
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
   
    @Autowired // faz o starte do nosso objeto
    private UserRepository userRepository;

    @PostMapping(path = "/") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String status,
     @RequestParam String local, @RequestParam String iniPrevisto, @RequestParam String iniCirurgia,
      @RequestParam String fimCirurgia, @RequestParam String saidaPrev) {

        if (userRepository.findByName(name) != null) {
            return "O nome digitado já existe.";
        }

        try {

            User n = new User();
            n.setName(name);
            n.setStatus(status);
            n.setLocal(local);
            n.setIniPrevisto(iniPrevisto);
            n.setIniCirurgia(iniCirurgia);
            n.setFimCirurgia(fimCirurgia);
            n.setSaidaPrev(saidaPrev);
            userRepository.save(n);
            return "Ok ao gravar.";

        } catch (Exception e) {
            return e.getMessage();
        }
       
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<User> getAllUsers() {
      return userRepository.findAll();
       
    }
    // PUT atualizar
    @PutMapping(path = "/{id}")
    public @ResponseBody String updateUser(@PathVariable int id, @RequestParam String name, @RequestParam String status, 
    @RequestParam String local, @RequestParam String iniPrevisto, @RequestParam String iniCirurgia,
     @RequestParam String fimCirurgia, @RequestParam String saidaPrev) {
       
        User n = userRepository.findById(id);
        n.setName(name);
        n.setStatus(status);
        n.setLocal(local);
        n.setIniPrevisto(iniPrevisto);
        n.setIniCirurgia(iniCirurgia);
        n.setFimCirurgia(fimCirurgia);
        n.setSaidaPrev(saidaPrev);
        userRepository.save(n);
        return "Ok ao atualizar";
    }
    // DELETE apagar
    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "Ok ao apagar.";
    }
}
