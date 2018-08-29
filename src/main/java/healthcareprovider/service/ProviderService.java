package healthcareprovider.service;

import java.util.List;
import java.util.Optional;

import healthcareprovider.entity.Provider;

public interface ProviderService {

	public List<Provider> getProviders(Optional<Integer> max_discharges,
			Optional<Integer> min_discharges,
			Optional<Double> max_average_covered_charges,
			Optional<Double> min_average_covered_charges,
			Optional<Double> max_average_medicare_payments,
			Optional<Double> min_average_medicare_payments,
			Optional<String> state,
			Optional<String[]> fields);
	
}
