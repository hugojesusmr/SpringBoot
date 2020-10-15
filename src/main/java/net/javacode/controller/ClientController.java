package net.javacode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javacode.entity.Client;
import net.javacode.service.IClientService;

@Controller
@RequestMapping("/views/clients")
public class ClientController {
	
	@Autowired
	private IClientService iClientService;
	
	@GetMapping("/")
	public String listClients(Model model) {
		List<Client> clients = iClientService.findAll(); 
		model.addAttribute("titulo","List of Clients");
		model.addAttribute("clients", clients);
		return "/views/clients/listClients";
	}

}
