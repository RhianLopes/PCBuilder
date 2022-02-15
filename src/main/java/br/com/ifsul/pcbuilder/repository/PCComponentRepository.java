package br.com.ifsul.pcbuilder.repository;

import br.com.ifsul.pcbuilder.model.Compatibility;
import br.com.ifsul.pcbuilder.model.PCComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PCComponentRepository extends JpaRepository<PCComponent, Long>, JpaSpecificationExecutor<PCComponent> {

    List<PCComponent> findAllByCompatibility(Compatibility compatibility);

}
