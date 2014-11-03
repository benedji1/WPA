package cvut.semestralka.service;

import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dao.GenericDaoI;
import cvut.semestralka.dao.ManyToManyDaoI;

public abstract class AbstractService {
    
    protected GenericDaoI dao;
    private ManyToManyDaoI mdao;

    public AbstractService() {
        this.dao = GenericDao.getDao();
    }

    public GenericDaoI getDao() {
        return dao;
    }

    public void setDao(GenericDaoI dao) {
        this.dao = dao;
    }
}
