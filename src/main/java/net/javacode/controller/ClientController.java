package net.javacode.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javacode.entity.City;
import net.javacode.entity.Client;
import net.javacode.service.ICityService;
import net.javacode.service.IClientService;

@Controller
@RequestMapping("/views/clients")
public class ClientController {
	
	@Autowired
	private IClientService iClientService;
	@Autowired
	private ICityService iCityService;
	
	@GetMapping("/")
	public String listClients(Model model) {
		List<Client> clients = iClientService.findAll(); 
		model.addAttribute("titulo","List of Clients");
		model.addAttribute("clients", clients);
		return "/views/clients/listClients";
	}
	
	@GetMapping("/create")
	public String create(Client client, Model model) {
		List<City> listCities = iCityService.listCities();
		model.addAttribute("titulo", "Create Client");
		model.addAttribute("client", client);
		model.addAttribute("cities", listCities);
		return "/views/clients/formClient";
	}
    @PostMapping("/save")
	public String save(@ModelAttribute Client client) {
    	iClientService.save(client);
    	System.out.println("Save User");
		return "redirect:/views/clients/";
	}
    
    @GetMapping("/edit/{idClient}")
    public String edit(@PathVariable Long idClient, Model model) {
    	Client client = iClientService.findById(idClient);
    	List<City> listCities = iCityService.listCities();
    	
    	model.addAttribute("titulo","Edit Client");
    	model.addAttribute("client", client);
    	model.addAttribute("cities", listCities);
		return "/views/clients/formClient";
    }
    
    @GetMapping("/delete/{idClient}")
    public String delete(@PathVariable Long idClient) {
    	iClientService.delete(idClient);
    	return "redirect:/views/clients/";
    }
}
