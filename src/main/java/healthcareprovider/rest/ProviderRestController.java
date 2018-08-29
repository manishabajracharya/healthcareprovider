package healthcareprovider.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import healthcareprovider.entity.Provider;
import healthcareprovider.service.ProviderService;

@RestController
@RequestMapping("/api")
public class ProviderRestController {

	//autowire the CustomerService
	@Autowired
	private ProviderService providerService;
	
	//add mapping for GET / customers
	@RequestMapping(value="/providers", method=RequestMethod.GET)
	@ResponseBody
	public List<Provider> getProviders(@RequestParam("max_discharges") Optional<Integer> max_discharges,
			@RequestParam("min_discharges") Optional<Integer> min_discharges,
			@RequestParam("max_average_covered_charges") Optional<Double> max_average_covered_charges,
			@RequestParam("min_average_covered_charges") Optional<Double> min_average_covered_charges,
			@RequestParam("max_average_medicare_payments") Optional<Double> max_average_medicare_payments,
			@RequestParam("min_average_medicare_payments") Optional<Double> min_average_medicare_payments,
			@RequestParam("state") Optional<String> state,
			@RequestParam("fields") Optional<String[]> fields){
		
		return providerService.getProviders(max_discharges,
				min_discharges,
				max_average_covered_charges,
				min_average_covered_charges,
				max_average_medicare_payments,
				min_average_medicare_payments,
				state,
				fields);
	}
		
}
