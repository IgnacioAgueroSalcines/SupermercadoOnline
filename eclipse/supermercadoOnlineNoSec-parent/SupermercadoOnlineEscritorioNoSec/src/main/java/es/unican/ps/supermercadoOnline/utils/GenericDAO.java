package es.unican.ps.supermercadoOnline.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




public abstract class GenericDAO<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="SupermercadoOnlinePU")
	protected EntityManager em;
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
    public GenericDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.persistentClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }
	
	public void setEM(EntityManager em){
		this.em=em;
	}

	public T addElement(T element) {
		em.persist(element);
		return element;
	}

	public T removeElement(T element) {
		em.remove(em.merge(element));
		return element;
	}

	public T updateElement(T element) {
		em.merge(element);
		return element;
	}

	@SuppressWarnings("unchecked")
	public List<T> listaElement() {
		String query= getEntityClass().getSimpleName();
		query="SELECT t FROM " + query + " t";
		Query resQuery=em.createQuery(query);
		List<T> res= resQuery.getResultList();
		return res;
	}

	public T getElement(long id) {
		T res=null;
		
		res= (T) em.find(getEntityClass(), id);
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();

        return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }
}
