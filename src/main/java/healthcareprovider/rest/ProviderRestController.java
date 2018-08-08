package healthcareprovider.rest;

import java.util.List;

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
	public List<Provider> getProviders(@RequestParam("max_discharges") Integer max_discharges,
			@RequestParam("min_discharges") Integer min_discharges,
			@RequestParam("max_average_covered_charges") Double max_average_covered_charges,
			@RequestParam("min_average_covered_charges") Double min_average_covered_charges,
			@RequestParam("max_average_medicare_payments") Double max_average_medicare_payments,
			@RequestParam("min_average_medicare_payments") Double min_average_medicare_payments,
			@RequestParam("state") String state,
			@RequestParam("fields") String[] fields){
		
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
