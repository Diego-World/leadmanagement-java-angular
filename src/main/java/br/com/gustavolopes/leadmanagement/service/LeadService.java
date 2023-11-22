package br.com.gustavolopes.leadmanagement.service;

import br.com.gustavolopes.leadmanagement.model.Lead;
import br.com.gustavolopes.leadmanagement.repository.LeadRepository;
import br.com.gustavolopes.leadmanagement.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;

    // CREATE, READ, UPDATE, DELETE

    // CREATE
    public Lead saveLead(Lead lead){
        var newLead = leadRepository.save(lead);
        return newLead;
    }

    // READ
    public List<Lead> readAllLead(){
        var leadList = leadRepository.findAll();
        return leadList;
    }
    // READ BY ID
    public Lead readById(Long id){
        var lead = leadRepository.findById(id).orElse(null);
        return lead;
    }

    //UPDATE
    public Lead updateLead(Long id , Lead lead){
        var leadBanco = this.leadRepository.findById(id).orElse(null);
        Utils.copyNonNullProperties(lead,leadBanco);
        leadBanco = this.leadRepository.save(leadBanco);
        return leadBanco;
    }

    //DELETE
    public String deletarLead(Long id){
        var leadBanco = this.leadRepository.findById(id).orElse(null);
        this.leadRepository.delete(leadBanco);
        return "Registro deletado";
    }

}
