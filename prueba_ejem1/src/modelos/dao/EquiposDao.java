package modelos.dao;

@SuppressWarnings("rawtypes")
public class EquiposDao extends AbstractHibernateDAO{

	@Override
	protected Class<? extends EquiposDao> getDomainClass() {

		return this.getClass();
	}
	
}
