package grupo0.reto5.Servicio;
import grupo0.reto5.Modelo.DTOs.ConteoCliente;
import grupo0.reto5.Modelo.DTOs.ConteoStatus;
import grupo0.reto5.Modelo.Reserva;
import grupo0.reto5.Repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public boolean deleteReservation(int id)
    {
        Boolean r = getReserva(id).map(Reserva-> {reservaRepositorio.delete(Reserva);
            return true;
        }).orElse(false);
        return r;
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

    //Reto5 (Estudiar mas a fondo).

    //1er Punto

    public ConteoStatus getReservaporestado()
    {
        List<Reserva> completed = reservaRepositorio.getReservaporestado("completed");
        List<Reserva> cancelled = reservaRepositorio.getReservaporestado("cancelled");

        return new ConteoStatus((long) completed.size(), (long) cancelled.size());
    }

    //2do Punto
    public List<Reserva> getPeriodoReserva(String DateA, String DateB)
    {
        SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd"); //2022-01-01
        Date a = new Date();
        Date b = new Date();
        try
        {
            a = parseador.parse(DateA);
            b = parseador.parse(DateB);

        }catch (ParseException e)
        {
            e.printStackTrace();
        }
        if(a.before(b))
        {
            return reservaRepositorio.getPeriodoReserva(a,b);
        }
        else
        {
            return new ArrayList<>();
        }
    }
    //3er Punto
    public List<ConteoCliente> getTopClientes()
    {
        return reservaRepositorio.getTopClientes();
    }
}