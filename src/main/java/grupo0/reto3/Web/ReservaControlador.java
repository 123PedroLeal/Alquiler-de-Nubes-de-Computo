package grupo0.reto3.Web;


import grupo0.reto3.Modelo.Reserva;
import grupo0.reto3.Servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservaControlador
{
    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/all")
    public List<Reserva> GetReservas() {return reservaServicio.GetAll();}

    @GetMapping("/{id}")
    public Optional<Reserva> GetReserva(@PathVariable("id")int id)
    {
        return reservaServicio.getReserva(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva r)
    {
        return reservaServicio.save(r);
    }
}
