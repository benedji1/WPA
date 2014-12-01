package cvut.semestralka.service;

import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dao.ManyToManyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractService {
    
    @Autowired
    protected GenericDao genericDao;
    @Autowired
    protected ManyToManyDao manyToManyDao;

    public AbstractService() {
    }

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    public ManyToManyDao getManyToManyDao() {
        return manyToManyDao;
    }

    public void setManyToManyDao(ManyToManyDao mdao) {
        this.manyToManyDao = mdao;
    } 
}
