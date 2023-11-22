package br.com.gustavolopes.leadmanagement.controller;

import br.com.gustavolopes.leadmanagement.model.Lead;
import br.com.gustavolopes.leadmanagement.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lead")
@CrossOrigin("*")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PostMapping("")
    public ResponseEntity<Lead> create(@RequestBody Lead lead){
        Lead newLead = this.leadService.saveLead(lead);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLead);
    }

    //READ
    @GetMapping("")
    public ResponseEntity<List<Lead>> getAll(){
        var leadList = this.leadService.readAllLead();
        return ResponseEntity.status(HttpStatus.OK).body(leadList);
    }

    //READ
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getById(@PathVariable Long id){
        var lead = this.leadService.readById(id);
        return ResponseEntity.status(HttpStatus.OK).body(lead);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Lead lead){
        try {
            var leadBanco = this.leadService.updateLead(id,lead);
            return ResponseEntity.status(HttpStatus.OK).body(leadBanco);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lead não encontrado");
        }
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        var leadBanco = this.leadService.deletarLead(id);
        return ResponseEntity.status(HttpStatus.OK).body(leadBanco);
    }

}
