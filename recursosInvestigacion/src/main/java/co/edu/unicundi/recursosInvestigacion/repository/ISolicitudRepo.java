package co.edu.unicundi.recursosInvestigacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unicundi.recursosInvestigacion.entity.Solicitudes;

@Repository
public interface ISolicitudRepo extends JpaRepository<Solicitudes, Integer>{

	
}
