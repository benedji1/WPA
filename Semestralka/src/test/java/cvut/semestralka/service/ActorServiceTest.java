package cvut.semestralka.service;

import cvut.semestralka.bo.Actor;
import cvut.semestralka.bo.Film;
import cvut.semestralka.dto.ActorDTO;
import cvut.semestralka.dto.FilmDTO;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Koulas
 */
public class ActorServiceTest extends AbstractServiceTest {
    @Test
    public void testAddActor() {
        ActorDTO actor1 = new ActorDTO("fn1", "ln1");
        ActorDTO actor2 = new ActorDTO("fn2", "ln2");

        ActorService service = new ActorService();

        Long expActor1 = service.addActor(actor1);
        Long expActor2 = service.addActor(actor2);
        
        service.getAllActors();
        
        assertEquals(service.getDao().getById(expActor1, Actor.class).getFirst_name(), actor1.getFirst_name());
        assertEquals(service.getDao().getById(expActor2, Actor.class).getFirst_name(), actor2.getFirst_name());
    }

    @Test
    public void testDeleteActor() {
        
        ActorDTO actor1 = new ActorDTO("fn1", "ln1");
        ActorDTO actor2 = new ActorDTO("fn2", "ln2");
        ActorDTO actor3 = new ActorDTO("fn3", "ln3");
        
        ActorService service = new ActorService();
        actor1.setId(service.addActor(actor1));
        actor2.setId(service.addActor(actor2));
        actor3.setId(service.addActor(actor3));
        
        
        Long expActor1 = service.deleteActor(actor1);
        Long expActor2 = service.deleteActor(actor2);
        Long expActor3 = service.deleteActor(actor3);
        
        System.out.println(expActor1);
        
        assertEquals(actor1.getId(), expActor1);
        assertEquals(actor2.getId(), expActor2);
        assertEquals(actor3.getId(), expActor3);
    }
    
    @Test
    public void testGetAllActorsFromFilm() {
        FilmDTO film = new FilmDTO(2012, "Terminator");
        ActorDTO actor1 = new ActorDTO("fn1", "ln1");
        ActorDTO actor2 = new ActorDTO("fn2", "ln2");
        ActorDTO actor3 = new ActorDTO("fn3", "ln3");
    
        ActorService as = new ActorService();
        FilmService fs = new FilmService();
        
        film.setId(fs.saveFilm(film));
        actor1.setId(as.addActor(actor1));
        actor2.setId(as.addActor(actor2));
        actor3.setId(as.addActor(actor3));
        fs.addActor(actor1.getId(), film);
        fs.addActor(actor2.getId(), film);
        fs.addActor(actor3.getId(), film);
        
        List<ActorDTO> actorsFromFilm = as.getAllActorsFromFilm(film.getId());
        assertEquals(3, actorsFromFilm.size());
  
    }

    @Test
    public void testAddFilm() {
        FilmDTO updated = new FilmDTO(2012, "Vetrelec");
        ActorDTO actor = new ActorDTO("fn", "lm");
        
        ActorService service = new ActorService();
        FilmService fs = new FilmService();
        
        Film film = fs.getDao().findBy(Film.class, "title", "Terminator");
        updated.setId(film.getId());
        
        actor.setId(service.addActor(actor));
        ActorDTO result = service.addFilm(updated, actor.getId());
        assertEquals(actor, result);
    }
}
