package br.com.tickets.tickets.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.tickets.tickets.model.entities.Funcionarios;
import br.com.tickets.tickets.model.entities.Setores;
import br.com.tickets.tickets.model.entities.Status;
import br.com.tickets.tickets.model.entities.Tickets;
import br.com.tickets.tickets.model.repositories.FuncionarioRepository;
import br.com.tickets.tickets.model.repositories.SetoresRepository;
import br.com.tickets.tickets.model.repositories.StatusRepository;
import br.com.tickets.tickets.model.repositories.TicketsRepository;

@Controller
public class TicketController {

    @Autowired
    TicketsRepository ticketRepository;

    @Autowired
    SetoresRepository setoresRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    StatusRepository statusRepository;

    /*PAGINA HOME */
    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @PostMapping(path = "/tickets{titulo}")
    public ModelAndView obterTicketAbertoPorNome(@RequestParam(name = "titulo") String titulo) {
		ModelAndView mv = new ModelAndView("tickets");
		Iterable<Tickets> ticket = ticketRepository.findBytitulo(titulo);
		//Iterable<Lembretes> lembretes = lembreteRepository.findAll();
		mv.addObject("tickets", ticket);
    	//return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    	return mv;
    }

    @PostMapping(path = "/ticketsconcluidos{titulo}")
    public ModelAndView obterTicketConcluidoPorNome(@RequestParam(name = "titulo") String titulo) {
		ModelAndView mv = new ModelAndView("ticketsconcluidos");
		Iterable<Tickets> ticket = ticketRepository.findBytitulo(titulo);
		//Iterable<Lembretes> lembretes = lembreteRepository.findAll();
		mv.addObject("tickets", ticket);
    	//return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    	return mv;
    }

    /*PAGINA QUE MOSTRA TODOS OS TICKETS */
    @GetMapping("/ticketsconcluidos")
    public ModelAndView findAllTickts(){
        ModelAndView mv = new ModelAndView("ticketsconcluidos");
        List<Tickets> tickets = ticketRepository.findByFinish();
        mv.addObject("tickets", tickets);
        return mv;
    }

    @GetMapping("/tickets")
    public ModelAndView findByActive(){
        ModelAndView mv = new ModelAndView("tickets");
        List<Tickets> tickets = ticketRepository.findByActive();
        mv.addObject("tickets", tickets);
        return mv;
    }

    /*GET QUE RETORNA A PAGINA DE CRIAR TICKET */
    @GetMapping("/criarticket")
    public ModelAndView getSaveTicket(){
        ModelAndView mv = new ModelAndView("criarticket");
        Iterable<Setores> setores = setoresRepository.findByStatus("Ativo");
        mv.addObject("setores", setores);
        Iterable<Funcionarios> funcionarios = funcionarioRepository.findByStatus("Ativo");
        mv.addObject("funcionario", funcionarios);
        Iterable<Status> status = statusRepository.findBySituacao("Ativo"); 
        mv.addObject("status", status); 
        return mv;
    }    

    /*COMANDO QUE EFETUARÁ A CRIAÇÃO DO TICKET */ /*NÃO ESTAR PRONTO */
    @PostMapping(path = "/criarticket")
	public String saveTicket(Tickets tickets) {
		ticketRepository.save(tickets);
		return "redirect:/tickets";
	}

    @GetMapping("/criastatus")
    public String getSaveStatus(){
        return"criastatus";
    }

    @PostMapping("/criastatus")
	public String saveStatus(Status status) {
		statusRepository.save(status);
		return "redirect:/home";
	}

    @GetMapping("/criasetor")
    public String getSaveSetor(){
        return"criasetor";
    }
    @PostMapping(path = "/criasetor")
	public String salvarLembrete(Setores setor) {
		setoresRepository.save(setor);
		return "redirect:/home";
	}
 
    @GetMapping("/cadastrafuncionario")
    public ModelAndView getSaveFuncionario(){
        ModelAndView mv = new ModelAndView("cadastrafuncionario");
        Iterable<Setores> setores = setoresRepository.findByStatus("Ativo");
        mv.addObject("setores", setores);
        return mv;
    }

    @PostMapping(path = "/cadastrafuncionario")
	public String saveFuncionario(Funcionarios funcionarios) {
		funcionarioRepository.save(funcionarios);
		return "redirect:/home";
	}



    @GetMapping("/excluir/{id}")
    public String deleteTicket(@PathVariable long id){
    	ticketRepository.deleteById(id);
        return"redirect:/tickets";
    }

    @GetMapping("/editartickets/{id}")
	 public ModelAndView editar( @PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("editartickets");
		Optional<Tickets> tickets = ticketRepository.findById(id);
		mv.addObject("tickets", tickets);
		Iterable<Setores> setores = setoresRepository.findByStatus("Ativo");
        mv.addObject("setores", setores);
        Iterable<Funcionarios> funcionarios = funcionarioRepository.findByStatus("Ativo");
        mv.addObject("funcionario", funcionarios);
        Iterable<Status> status = statusRepository.findBySituacao("Ativo"); 
        mv.addObject("status", status);
		return mv;
	}
}
