package co.edu.unicundi.recursosInvestigacion.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.edu.unicundi.recursosInvestigacion.entity.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="Delete FROM Usuario users WHERE users.rolUser.roluId = :roluId")
    public void eliminarUser(@Param("roluId") Integer roluId);
	
	public Usuario findByUserCodigo(Integer userCodigo);
	
	public Usuario findByUserIdentificacion(String userIdentificacion);
	
	public Usuario findByUserUsuario(String userUsuario);
	
	public Usuario findByUserUsuarioAndUserContrasena(String userUsuario, String userContrasena);
	
	@Query(value="SELECT user FROM Usuario user WHERE user.userUsuario = :userUsuario AND user.userContrasena = :userContrasena")
    public Usuario consultarUsuarioAndContrasena(String userUsuario, String userContrasena);
}
