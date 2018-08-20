package healthcareprovider.service;

import java.util.List;
import java.util.Optional;

import healthcareprovider.entity.Provider;

public interface ProviderService {

	public List<Provider> getProviders(Integer max_discharges,
			Integer min_discharges,
			Double max_average_covered_charges,
			Double min_average_covered_charges,
			Double max_average_medicare_payments,
			Double min_average_medicare_payments,
			String state,
			Optional<String[]> fields);
	
}
