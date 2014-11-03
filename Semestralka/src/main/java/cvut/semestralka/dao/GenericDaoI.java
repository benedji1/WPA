package cvut.semestralka.dao;

import cvut.semestralka.bo.DomainEntity;
import java.util.List;

public interface GenericDaoI {
    public <E> List<E> getAll(Class<E> clazz);
    public <E extends DomainEntity> E saveOrUpdate(E instance);
    public <E> E save(E instance);
    public <E> E update(E instance);
    public <E> void removeAll(Class<E> clazz);
    public <E> Long remove(Class<E> clazz, Long id);
    public <E> E findBy(Class<E> clazz, String attrName, String attrVal);
    public <E> List<E> getByProperty(String property, Object value, Class<E> clazz);
    public <E> E getById(Long id, Class<E> clazz);
    public <E> List<E> getManyToMany(Long id);
}
