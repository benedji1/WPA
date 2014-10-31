package cvut.semestralka.tools;

import cvut.semestralka.bo.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.proxy.HibernateProxy;

public class Tools {
    public static Long getIdentifier(DomainEntity o){
        if(o == null) return null;
        Long id = null;
        if(o instanceof HibernateProxy){
            id = (Long)((HibernateProxy) o).getHibernateLazyInitializer().getIdentifier();
        }else{
            id = o.getId();
        }
        return id;
    }
    
    public static List<Long> getIdentifiers(List<? extends DomainEntity> list) {
        if (list == null) {
            return null;
        }
        List<Long> ids = new ArrayList<Long>();

        for (DomainEntity abo : list) {
            ids.add(abo.getId());
        }
        return ids;
    }
}
