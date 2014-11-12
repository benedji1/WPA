package cvut.semestralka.service;

import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dao.ManyToManyDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {
    @Autowired
    protected GenericDao dao;
    @Autowired
    protected ManyToManyDao mdao;

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
