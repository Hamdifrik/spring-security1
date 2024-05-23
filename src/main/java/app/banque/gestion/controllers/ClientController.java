package app.banque.gestion.controllers;

import app.banque.gestion.entities.Client;
import app.banque.gestion.repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Client client = clientRepository.findById(id).orElse(null);
        model.addAttribute("client", client);
        return "index";
    }
    @GetMapping("/all")
    public String getAllClients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("client", clients);
        return "index";
    }




}
