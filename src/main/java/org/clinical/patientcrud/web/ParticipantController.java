package org.clinical.patientcrud.web;

import org.clinical.patientcrud.dao.ParticipantRepository;
import org.clinical.patientcrud.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParticipantController {
	@Autowired
	private ParticipantRepository participantRepository;
	@GetMapping(path="/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(path= "/participants")
	public String list(Model model, 
			@RequestParam(name="page",defaultValue = "0")int page, 
			@RequestParam(name="size",defaultValue = "5")int size,
	        @RequestParam(name="keyword",defaultValue = "")String mc){
		Page<Participant> pageParticipants= participantRepository.findByNomContains(mc, PageRequest.of(page, size));
		//Ajout dans le model
		model.addAttribute("participants", pageParticipants.getContent());
		model.addAttribute("pages", new int[pageParticipants.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", mc);
		return "participants";
	}
	
	@GetMapping(path="/deleteParticipant")
	public String delete(Long PatientID, String keyword,int page) {
		participantRepository.deleteById(PatientID);
		return "redirect:/participants?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping(path="/formParticipant")
	public String formParticipant(Model model){
		model.addAttribute("participant", new Participant());
		return "formParticipant";
		
	}
	
	@PostMapping(path="/saveParticipant")
	public String saveParticipant(Participant participant) {
		participantRepository.save(participant);
		return "formParticipant";
	}

}
