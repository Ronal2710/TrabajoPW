package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Brand;

public interface IBrandService {
	
	public int insert(Brand brand);

	List<Brand> list();

	public void delete(int idBrand);

	List<Brand> findNameBrandFull(String nameBrand);

	Optional<Brand> searchId(int idBrand);
}
