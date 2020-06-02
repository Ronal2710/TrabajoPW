package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Bill;


@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
 

}
