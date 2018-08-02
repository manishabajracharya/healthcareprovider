package healthcareprovider.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcareprovider.entity.Provider;

@Repository
public class ProviderDAOImpl implements ProviderDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Provider> getCustomers(Integer max_discharges,
			Integer min_discharges,
			Double max_average_covered_charges,
			Double min_average_covered_charges,
			Double max_average_medicare_payments,
			Double min_average_medicare_payments,
			String state) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		/*Query<Provider> theQuery = 
				currentSession.createQuery("from Provider where totalDischarges<= :maxd and "
						+ "totalDischarges>= :mind and averageCoveredCharges<= :maxacc and "
						+ "averageCoveredCharges>= :minacc and "
						+ "averageMedicarePayments<= :maxamp and "
						+ "averageMedicarePayments>= :minamp and "
						+ "providerState= :ps", Provider.class);
		*/
		Query<Provider> theQuery = 
				currentSession.createQuery("from Provider where (:maxd is null or totalDischarges<= :maxd) and "
						+ "(:mind is null or totalDischarges>= :mind) and "
						+ "(:maxacc is null or averageCoveredCharges<= :maxacc) and "
						+ "(:minacc is null or averageCoveredCharges>= :minacc) and "
						+ "(:maxamp is null or averageMedicarePayments<= :maxamp) and "
						+ "(:minamp is null or averageMedicarePayments>= :minamp) and "
						+ "(:ps is null or providerState= :ps)", Provider.class);
		theQuery.setParameter("maxd",max_discharges );
		theQuery.setParameter("mind",min_discharges);
		theQuery.setParameter("maxacc",max_average_covered_charges);
		theQuery.setParameter("minacc",min_average_covered_charges);
		theQuery.setParameter("maxamp",max_average_medicare_payments);
		theQuery.setParameter("minamp",min_average_medicare_payments);
		theQuery.setParameter("ps",state);
		
		// execute query and get result list
		List<Provider> customers = theQuery.getResultList();		
		// return the results		
		return customers;
	}

	

}











