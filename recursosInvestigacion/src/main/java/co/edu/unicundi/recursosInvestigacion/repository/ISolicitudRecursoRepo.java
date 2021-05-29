package co.edu.unicundi.recursosInvestigacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.recursosInvestigacion.entity.SolicitudRecurso;

@Repository
public interface ISolicitudRecursoRepo extends JpaRepository<SolicitudRecurso, Integer>{

	@Query(value = "SELECT soliRecu FROM SolicitudRecurso soliRecu WHERE soliRecu.solicitud.soliId = :idSolicitud")
    public List<SolicitudRecurso> buscarPorIdSolicitud(@Param("idSolicitud")Integer idSolicitud);
	
	@Query(value = "SELECT soliRecu.recurso.recuId FROM SolicitudRecurso soliRecu WHERE soliRecu.solicitud.soliId = :soliId")
    public List<Integer> buscarRecursossoli(@Param("soliId")Integer soliId);
	
	@Transactional
    @Modifying
    @Query(value = "INSERT INTO solicitudrecurso(recu_id, soli_id) VALUES(:recu_id, :soli_id)", nativeQuery = true)
    public void guardar(@Param("recu_id") Integer recu_id, @Param("soli_id") Integer soli_id);
	
	@Transactional
    @Modifying
    @Query(value = "UPDATE solicitudrecurso SET recu_id = :recu_id WHERE soli_id = :soli_id ", nativeQuery = true)
    public void editar(@Param("soli_id") Integer soli_id, @Param("recu_id") Integer recu_id);

	@Transactional
	@Modifying
	@Query(value="Delete FROM SolicitudRecurso soliRecu WHERE soliRecu.solicitud.soliId = :soliId")
    public void eliminarSolicitud(@Param("soliId") Integer soliId);
	
	@Transactional
	@Modifying
	@Query(value="Delete FROM SolicitudRecurso soliRecu WHERE soliRecu.recurso.recuId = :recuId")
    public void eliminarRecurso(@Param("recuId") Integer recuId);
	
}
