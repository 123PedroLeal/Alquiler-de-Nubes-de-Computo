package grupo0.reto3.Servicio;


import grupo0.reto3.Modelo.Calificacion;
import grupo0.reto3.Repositorio.CalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service hace referencia a que la clase va a hacer el servicio.
@Service
public class CalificacionServicio
{
    @Autowired
    private CalificacionRepositorio calificacionRepositorio;

    //Metodo para obtener todos los objetos de tipo nube en el repositorio.
    public List<Calificacion> GetAll() {
        return calificacionRepositorio.GetAll();
    }

    //Metodo para obtener un solo objeto de tipo nube en el repositorio.
    public Optional<Calificacion> getCalificacion(int id) {return calificacionRepositorio.getCalificacion(id);}

    //Metodo para guardar un objeto de tipo nube que viene del repositorio.
    public Calificacion save(Calificacion c)
    {
        // Metodo para que en caso de que el objeto enviado no tenga id nulo de todas formas lo guarde.
        if (c.getIdScore() == null) {
            return calificacionRepositorio.save(c);
        } else {
            // Metodo para saber que si se obtiene una Nube vacia igual guarde la operacion
            Optional<Calificacion> caux = calificacionRepositorio.getCalificacion(c.getIdScore());
            if (!caux.isPresent()) {
                return calificacionRepositorio.save(c);
            }
            // Sino que guarde la instancia creada.
            else {
                return c;
            }
        }
    }

    public Calificacion update(Calificacion c)
    {
        if (c.getIdScore() != null)
        {
            Optional<Calificacion> caux =  calificacionRepositorio.getCalificacion(c.getIdScore());
            if (caux.isPresent())
            {
                if (c.getMessagetext()!=null)
                {
                    caux.get().setMessagetext(c.getMessagetext());
                }
                if (c.getStars()!=null)
                {
                    caux.get().setStars(c.getStars());
                }
                if (c.getReservations()!=null)
                {
                    caux.get().setReservations(c.getReservations());
                }

                calificacionRepositorio.save(caux.get());
                return caux.get();
            }
            else
            {
                return c;
            }
        }
        else
        {
            return c;
        }
    }
}