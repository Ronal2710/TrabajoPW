package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Person;




public interface IPersonService {

	public void insert(Person person);
	List<Person> list();
}
