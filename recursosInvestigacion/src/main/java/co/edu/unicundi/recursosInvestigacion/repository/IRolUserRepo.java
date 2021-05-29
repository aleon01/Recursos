package co.edu.unicundi.recursosInvestigacion.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.edu.unicundi.recursosInvestigacion.entity.RolUser;

@Repository
public interface IRolUserRepo extends JpaRepository<RolUser, Integer>{

	@Transactional
	@Modifying
	@Query(value="Delete FROM RolUser p WHERE p.roluId = :roluId")
    public void consultarDelete(@Param("roluId") Integer roluId);

    
}
