package br.com.ifsul.pcbuilder.repository;

import br.com.ifsul.pcbuilder.model.PCComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PCComponentRepository extends JpaRepository<PCComponent, Long>, JpaSpecificationExecutor<PCComponent> {

}
