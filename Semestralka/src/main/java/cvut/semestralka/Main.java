package cvut.semestralka;

import cvut.semestralka.bo.Actor;
import cvut.semestralka.bo.Director;
import cvut.semestralka.bo.DomainEntity;
import cvut.semestralka.bo.Employee;
import cvut.semestralka.bo.Film;
import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dao.ManyToManyDao;
import cvut.semestralka.dto.ActorDTO;
import cvut.semestralka.dto.DirectorDTO;
import cvut.semestralka.dto.EmployeeDTO;
import cvut.semestralka.dto.FilmDTO;
import cvut.semestralka.dto.OrderDTO;
import cvut.semestralka.service.ActorService;
import cvut.semestralka.service.EmployeeService;
import cvut.semestralka.service.FilmService;
import cvut.semestralka.service.OrderService;
import java.security.DomainCombiner;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;

public class Main {

    public static void main(String[] args) {
        //pridani filmu
//        FilmService fs = new FilmService();
//        FilmDTO tmp = new FilmDTO(2014,"Novy film3");
//        fs.saveFilm(tmp);
//        List<FilmDTO> fdto = fs.getAllFilms();
//        for(FilmDTO f : fdto){
//            System.out.println(f.getTitle());
//        }
//        pridani rezisera k filmum
//        Director dir = new Director();
//        dir.setFirst_name("Jan");
//        dir.setLast_name("Novak");
//        GenericDao.getDao().saveOrUpdate(dir);
//        List<FilmDTO> filmsdto = FilmService.getFilmService().getAllFilms();
//        List<Film> films = new ArrayList<Film>();
//        for(FilmDTO f : filmsdto){
//            Film film = new Film();
//            film.setId(f.getId());
//            film.setRelease_year(f.getRelease_year());
//            film.setTitle(f.getTitle());
//            films.add(film);
//            System.out.println(f.getId());
//        }
//        films.remove(0);
//        dir.setFilms(films);
//        for(Film f : films){
//            f.setDirector(dir);
//            GenericDao.getDao().saveOrUpdate(f);
//        }
//          seznam filmu od rezisera 21
        FilmService fs = new FilmService();
        List<FilmDTO> films = fs.getDirectorsFilms(21L);
        for(FilmDTO f : films){
            System.out.println(f.getTitle());
        }
//        sezmam filmu ve kterych hral herec s id 1
//        FilmService fs = new FilmService();
//        List<FilmDTO> films = fs.getActorsFilms(1L);
//        for (FilmDTO f : films) {
//            System.out.println(f.getTitle());
//        }
//          seznam vsech zakazek zpracovanych zamestnancem s id 8
//        OrderService os = new OrderService();
//        List<OrderDTO> orders = os.getAllHandledOrders(8L);
//        for(OrderDTO o : orders){
//            System.out.println(o.getId());
//        }
        //seznam vsech zakazek od zakaznika
//        OrderService os = new OrderService();
//        List<OrderDTO> orders = os.getAllCreatedOrders(10L);
//        for(OrderDTO o : orders){
//            System.out.println(o.getId());
//        }
//        ActorService as = ActorService.getActorService();
//        FilmService fs = FilmService.getFilmService();
//        OrderService os = OrderService.getOrderService();
//        List<OrderDTO> ent= os.getFilmOrders(7L);
//        for(OrderDTO a : ent){
//            System.out.println(a.getId());
//        }
        
    }
}
