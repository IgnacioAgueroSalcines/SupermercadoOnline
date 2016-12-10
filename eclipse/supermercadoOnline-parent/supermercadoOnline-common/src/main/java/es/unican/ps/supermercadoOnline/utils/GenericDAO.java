package es.unican.ps.supermercadoOnline.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public abstract class GenericDAO<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
    public GenericDAO() {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

	public T addElement(T element) {
		em.persist(element);
		return null;
	}

	public T removeElement(T element) {
		em.remove(element);
		return element;
	}

	public T updateElement(T element) {
		return em.merge(element);
	}

	@SuppressWarnings("unchecked")
	public List<T> listaElement() {
		return em.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
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
