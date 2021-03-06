package healthcareprovider.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcareprovider.entity.Provider;

@Repository
public class ProviderDAOImpl implements ProviderDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Provider> getProviders(Optional<Integer> max_discharges,
			Optional<Integer> min_discharges,
			Optional<Double> max_average_covered_charges,
			Optional<Double> min_average_covered_charges,
			Optional<Double> max_average_medicare_payments,
			Optional<Double> min_average_medicare_payments,
			Optional<String> state,
			Optional<String[]> fields) {
		
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
		/*Query<Provider> theQuery = 
				currentSession.createQuery("from Provider p where (:maxd is null or p.totalDischarges<= :maxd) and "
						+ "(:mind is null or p.totalDischarges>= :mind) and "
						+ "(:maxacc is null or p.averageCoveredCharges<= :maxacc) and "
						+ "(:minacc is null or p.averageCoveredCharges>= :minacc) and "
						+ "(:maxamp is null or p.averageMedicarePayments<= :maxamp) and "
						+ "(:minamp is null or p.averageMedicarePayments>= :minamp) and "
						+ "(:ps is null or p.providerState= :ps)", Provider.class);
		theQuery.setParameter("maxd",max_discharges );
		theQuery.setParameter("mind",min_discharges);
		theQuery.setParameter("maxacc",max_average_covered_charges);
		theQuery.setParameter("minacc",min_average_covered_charges);
		theQuery.setParameter("maxamp",max_average_medicare_payments);
		theQuery.setParameter("minamp",min_average_medicare_payments);
		theQuery.setParameter("ps",state);
		*/
		//add all criteria to the query
		@SuppressWarnings("deprecation")
		Criteria cr = currentSession.createCriteria(Provider.class);
		if(max_discharges.isPresent() && max_discharges.get()!=null) {
			Criterion maxd = Restrictions.lt("totalDischarges", max_discharges.get());
			Criterion maxde = Restrictions.eq("totalDischarges", max_discharges.get());
			LogicalExpression orExp = Restrictions.or(maxd,maxde);
			cr.add(orExp);
		}
		if(min_discharges.isPresent() && min_discharges.get()!=null) {
			Criterion mind = Restrictions.gt("totalDischarges", min_discharges.get());
			Criterion minde = Restrictions.eq("totalDischarges", min_discharges.get());
			LogicalExpression orExp = Restrictions.or(mind,minde);
			cr.add(orExp);
		}
		if(max_average_covered_charges.isPresent() && max_average_covered_charges.get()!=null) {
			Criterion maxacc = Restrictions.lt("averageCoveredCharges", max_average_covered_charges.get());
			Criterion maxacce = Restrictions.eq("averageCoveredCharges", max_average_covered_charges.get());
			LogicalExpression orExp = Restrictions.or(maxacc,maxacce);
			cr.add(orExp);
		}
		if(min_average_covered_charges.isPresent() && min_average_covered_charges.get()!=null) {
			Criterion minacc = Restrictions.gt("averageCoveredCharges", min_average_covered_charges.get());
			Criterion minacce = Restrictions.eq("averageCoveredCharges", min_average_covered_charges.get());
			LogicalExpression orExp = Restrictions.or(minacc,minacce);
			cr.add(orExp);
		}
		if(max_average_medicare_payments.isPresent() && max_average_medicare_payments.get()!=null) {
			Criterion maxamp = Restrictions.lt("averageMedicarePayments", max_average_medicare_payments.get());
			Criterion maxampe = Restrictions.eq("averageMedicarePayments", max_average_medicare_payments.get());
			LogicalExpression orExp = Restrictions.or(maxamp,maxampe);
			cr.add(orExp);
		}
		if(min_average_medicare_payments.isPresent() && min_average_medicare_payments.get()!=null) {
			Criterion minamp = Restrictions.gt("averageMedicarePayments", min_average_medicare_payments.get());
			Criterion minampe = Restrictions.eq("averageMedicarePayments", min_average_medicare_payments.get());
			LogicalExpression orExp = Restrictions.or(minamp,minampe);
			cr.add(orExp);
		}
		if(state.isPresent() && state.get()!=null) {
			Criterion ps = Restrictions.eq("providerState", state.get());
			cr.add(ps);
		}
				
		//by default, all fields will be selected in query
		//but if needed to add specific fields, we use Projections
		if(fields.isPresent()) {			 
			ProjectionList p1 = Projections.projectionList();
			String[] fields_array= fields.get();
			for(String s: fields_array) {
				p1.add(Projections.property(s).as(s));
			}
			cr.setProjection(p1);
			//result to have alias as key. This shows both key and value in JSON.
			cr.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		}
		
		// execute query and get result list
		List<Provider> providers = (List<Provider>)cr.list();
		
		// return the results		
		return providers;
	}

	

}











