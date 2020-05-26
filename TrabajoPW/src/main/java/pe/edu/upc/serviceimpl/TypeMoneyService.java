package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.TypeMoney;
import pe.edu.upc.repository.ITypeMoneyRepository;

import pe.edu.upc.serviceinterface.ITypeMoneyService;

@Service
public class TypeMoneyService implements ITypeMoneyService{

	@Autowired
	private ITypeMoneyRepository mR;

	@Transactional
	@Override
	public void insert(TypeMoney typeMoney) {
		// TODO Auto-generated method stub
		mR.save(typeMoney);	
	}

	@Override
	public List<TypeMoney> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

}
