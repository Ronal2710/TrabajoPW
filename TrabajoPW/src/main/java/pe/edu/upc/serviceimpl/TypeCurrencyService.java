package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypeCurrency;
import pe.edu.upc.repository.ITypeCurrencyRepository;
import pe.edu.upc.serviceinterface.ITypeCurrencyService;

@Service
public class TypeCurrencyService implements ITypeCurrencyService{

	@Autowired
	private ITypeCurrencyRepository cR;

	@Transactional
	@Override
	public int insert(TypeCurrency typecurrency) {
		int rpta=cR.searchTypeCurrency(typecurrency.getNameTypeCurrency());
		if(rpta==0)
		{
			cR.save(typecurrency);
		}
		return rpta;
	}

	@Override
	public List<TypeCurrency> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
