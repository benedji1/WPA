package cvut.semestralka.service;

import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dao.ManyToManyDao;

public abstract class AbstractService {
    
    protected GenericDao dao;
    protected ManyToManyDao mdao;

    public AbstractService() {
        this.dao = GenericDao.getDao();
        this.mdao=ManyToManyDao.getDao();
    }

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }

    public ManyToManyDao getManyToManyDao() {
        return mdao;
    }

    public void setManyToManyDao(ManyToManyDao mdao) {
        this.mdao = mdao;
    }
    
}
