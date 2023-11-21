package br.com.gustavolopes.leadmanagement.repository;

import br.com.gustavolopes.leadmanagement.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {
}
