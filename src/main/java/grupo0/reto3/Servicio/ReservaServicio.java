package grupo0.reto3.Servicio;


import grupo0.reto3.Modelo.Reserva;
import grupo0.reto3.Repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service hace referencia a que la clase va a hacer el servicio.
@Service
public class ReservaServicio
{
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    //Metodo para obtener todos los objetos de tipo nube en el repositorio.
    public List<Reserva> GetAll() {
        return reservaRepositorio.GetAll();
    }

    //Metodo para obtener un solo objeto de tipo nube en el repositorio.
    public Optional<Reserva> getReserva(int id) {return reservaRepositorio.getReserva(id);}

    //Metodo para guardar un objeto de tipo nube que viene del repositorio.
    public Reserva save(Reserva r) {
        // Metodo para que en caso de que el objeto enviado no tenga id nulo de todas formas lo guarde.
        if (r.getIdReservation() == null) {
            return reservaRepositorio.save(r);
        } else {
            // Metodo para saber que si se obtiene una Nube vacia igual guarde la operacion
            Optional<Reserva> raux = reservaRepositorio.getReserva(r.getIdReservation());
            if (!raux.isPresent()) {
                return reservaRepositorio.save(r);
            }
            // Sino que guarde la instancia creada.
            else {
                return r;
            }
        }
    }

    public Reserva update(Reserva r)
    {
        if (r.getIdReservation() != null)
        {
            Optional<Reserva> raux = reservaRepositorio.getReserva(r.getIdReservation());
            if (raux.isPresent())
            {
                if (r.getStartDate()!=null)
                {
                    raux.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate()!=null)
                {
                    raux.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus()!=null)
                {
                    raux.get().setStatus(r.getStatus());
                }
                if (r.getCloud()!=null)
                {
                    raux.get().setCloud(r.getCloud());
                }

                if (r.getClient()!=null)
                {
                    raux.get().setClient(r.getClient());
                }

                reservaRepositorio.save(raux.get());
                return raux.get();
            }
            else
            {
                return r;
            }
        }
        else
        {
            return r;
        }
    }
}