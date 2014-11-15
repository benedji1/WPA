package cvut.semestralka.service;

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
        ActorDTO actor1 = new ActorDTO("fn1", "ln1", 1L);
        ActorDTO actor2 = new ActorDTO("fn2", "ln2", 2L);

        ActorService service = new ActorService();

        ActorDTO expActor1 = service.addActor(actor1);
        ActorDTO expActor2 = service.addActor(actor2);
        List<ActorDTO> actors = service.getAllActors();
        
        assertEquals(expActor1, actor1);
        assertEquals(expActor2, actor2);
    }

    @Test
    public void testDeleteActor() {
        
        ActorDTO actor1 = new ActorDTO("fn1", "ln1", 1L);
        ActorDTO actor2 = new ActorDTO("fn2", "ln2", 2L);
        ActorDTO actor3 = new ActorDTO("fn3", "ln3", 3L);
        
        ActorService service = new ActorService();
        service.addActor(actor1);
        service.addActor(actor2);
        service.addActor(actor3);
        
        Long expActor1 = service.deleteActor(actor1);
        Long expActor2 = service.deleteActor(actor2);
        Long expActor3 = service.deleteActor(actor3);
        
        assertEquals((Long)1L, expActor1);
        assertEquals((Long)2L, expActor2);
        assertEquals((Long)3L, expActor3);
    }
    
    @Test
    public void testGetAllActorsFromFilm() {
        FilmDTO film = new FilmDTO(2012, "Terminator", 1L);
        ActorDTO actor1 = new ActorDTO("fn1", "ln1", 1L);
        ActorDTO actor2 = new ActorDTO("fn2", "ln2", 2L);
        ActorDTO actor3 = new ActorDTO("fn3", "ln3", 3L);
        
        ActorService as = new ActorService();
        FilmService fs = new FilmService();
        
        fs.saveFilm(film);
        fs.addActor(1L, film);
        fs.addActor(2L, film);
        fs.addActor(3L, film);
        
        List<ActorDTO> actorsFromFilm = as.getAllActorsFromFilm(film.getId());
        assertEquals(3, actorsFromFilm.size());
  
    }

    @Test
    public void testAddFilm() {
        FilmDTO updated = new FilmDTO(2012, "Vetrelec", 12L);
        ActorDTO actor = new ActorDTO("fn", "lm", 20L);
        
        Long actorId = actor.getId();
        ActorService service = new ActorService();
        
        service.addActor(actor);
        ActorDTO result = service.addFilm(updated, actor.getId());
        assertEquals(actor, result);
    }
}
