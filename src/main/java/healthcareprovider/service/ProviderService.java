package healthcareprovider.service;

import java.util.List;

import healthcareprovider.entity.Provider;

public interface ProviderService {

	public List<Provider> getCustomers(int max_discharges,
			int min_discharges,
			double max_average_covered_charges,
			double min_average_covered_charges,
			double max_average_medicare_payments,
			double min_average_medicare_payments,
			String state);
	
}
