package healthcareprovider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcareprovider.dao.ProviderDAO;
import healthcareprovider.entity.Provider;

@Service
public class ProviderServiceImpl implements ProviderService {

	// need to inject customer dao
	@Autowired
	private ProviderDAO customerDAO;
	
	@Override
	@Transactional
	public List<Provider> getCustomers(int max_discharges,
			int min_discharges,
			double max_average_covered_charges,
			double min_average_covered_charges,
			double max_average_medicare_payments,
			double min_average_medicare_payments,
			String state) {
		return customerDAO.getCustomers(max_discharges,
				min_discharges,
				max_average_covered_charges,
				min_average_covered_charges,
				max_average_medicare_payments,
				min_average_medicare_payments,
				state);
	}

}





