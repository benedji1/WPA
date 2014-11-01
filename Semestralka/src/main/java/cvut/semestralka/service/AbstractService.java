package cvut.semestralka.service;

import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dao.GenericDaoI;

public abstract class AbstractService {
    
    protected GenericDaoI dao;

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
