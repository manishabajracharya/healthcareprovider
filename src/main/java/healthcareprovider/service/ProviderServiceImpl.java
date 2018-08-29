package healthcareprovider.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcareprovider.dao.ProviderDAO;
import healthcareprovider.entity.Provider;

@Service
public class ProviderServiceImpl implements ProviderService {

	// need to inject customer dao
	@Autowired
	private ProviderDAO providerDAO;
	
	@Override
	@Transactional
	public List<Provider> getProviders(Optional<Integer> max_discharges,
			Optional<Integer> min_discharges,
			Optional<Double> max_average_covered_charges,
			Optional<Double> min_average_covered_charges,
			Optional<Double> max_average_medicare_payments,
			Optional<Double> min_average_medicare_payments,
			Optional<String> state,
			Optional<String[]> fields) {
		return providerDAO.getProviders(max_discharges,
				min_discharges,
				max_average_covered_charges,
				min_average_covered_charges,
				max_average_medicare_payments,
				min_average_medicare_payments,
				state,
				fields);
	}

}





