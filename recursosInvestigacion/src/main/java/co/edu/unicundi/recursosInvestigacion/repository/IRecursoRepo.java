package co.edu.unicundi.recursosInvestigacion.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.edu.unicundi.recursosInvestigacion.entity.Recurso;

@Repository
public interface IRecursoRepo extends JpaRepository<Recurso, Integer>{

	@Transactional
	@Modifying
	@Query(value="DELETE FROM Recurso recu WHERE recu.trecurso.trecId = :trecId")
    public void eliminarRecurso(@Param("trecId") Integer trecId);
	
	@Query(value = "SELECT recu.recuId FROM Recurso recu WHERE recu.trecurso.trecId = :trecId")
    public List<Integer> buscarRecursoList(@Param("trecId")Integer trecId);
	
	public Recurso findByRecuCodigo(Integer recuCodigo);
}
