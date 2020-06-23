package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entity.TypeCard;


public interface ITypeCardRepository extends JpaRepository<TypeCard, Integer>{
		
	@Query("select count(c.nameTypeCard) from TypeCard c where c.nameTypeCard=LOWER(:nameTypeCard) or c.nameTypeCard=UPPER(:nameTypeCard)")
	public int searchTypeCard(@Param("nameTypeCard")String nombre);
	
	@Query("from TypeCard c where c.nameTypeCard like %:busqueda%")
	List<TypeCard> search(@Param("busqueda") String busqueda);
}
