package net.javacode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javacode.entity.City;
import net.javacode.entity.Client;
import net.javacode.repository.ClientRepository;
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
	public String create(Client client ,Model model) {
		List<City> listCities = iCityService.listCities();
		model.addAttribute("titulo", "Create Client");
		model.addAttribute("client", new Client());
		model.addAttribute("cities", listCities);
		return "/views/clients/formClient";
	}
	
    @PostMapping("/save")
	public String addClient(@Valid Client client, BindingResult bindingResult, Model model) {
    	List<City> listCities = iCityService.listCities();
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("titulo", "Create Client");
    		model.addAttribute("cities", listCities);
			System.out.println("BINDING RESuLT ERROR");
    		return "/views/clients/formClient";
    	}else {
    		
    	model.addAttribute("client", client);
    	iClientService.save(client);
    	System.out.println("*SAVE USER   ***************************************");
    	return "redirect:/views/clients/";
    	}
	}
    
    @GetMapping("/edit/{idclient}")
    public String edit(@PathVariable Long idclient, Model model) {
    	
    	Client client = null;
    	if(idclient > 0) {
    		client = iClientService.findById(idclient);
    		
    		if (client == null) {
				System.out.println("ERROR: Customer ID does not exist");
				return "redirect:/views/clients/";
    		  }
		}else{
		  		System.out.println("ERROR: ERROR Customer with ID");
				return "redirect:/views/clients/";
    	}
    	
    	List<City> listCities = iCityService.listCities();
    	
    	model.addAttribute("titulo","Edit Client");
    	model.addAttribute("client", client);
    	model.addAttribute("cities", listCities);
		return "/views/clients/formClient";
    }
    
    @GetMapping("/delete/{idclient}")
    public String delete(@PathVariable Long idclient) {
    	Client client = null;
    
    	if(idclient > 0) {
    		client = iClientService.findById(idclient);
    		
    		if (client == null){
				System.out.println("ERROR: Customer ID does not exist");
				return "redirect:/views/clients/";
		  	} else {
		  		System.out.println("ERROR: ERROR Customer with ID");
				return "redirect:/views/clients/";
    	}
    }
    	iClientService.delete(idclient);
    	return "redirect:/views/clients/";
    }
}
