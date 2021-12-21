package com.example.accessingdata;
//wendel
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class UserController {
   
    @Autowired // faz o starte do nosso objeto
    private UserRepository userRepository;


    @PostMapping(path = "/") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name) {
        User n = new User();
        n.setName(name);
        userRepository.save(n);
        return "Ok ao gravar.";
       
    }

    @GetMapping(path="/")
    public @ResponseBody Iterable<User> getAllUsers() {
      return userRepository.findAll();
        // return uRepository.findAll();
    }
    // PUT atualizar
    @PutMapping(path="/{id}")
    public @ResponseBody String updateUser(@PathVariable int id, @RequestParam String name) {
        User n = userRepository.findById(id);
        n.setName(name);
        userRepository.save(n);
        return "Updated";
    }
    // DELETE apagar
    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "Ok ao apagar.";
    }
}
