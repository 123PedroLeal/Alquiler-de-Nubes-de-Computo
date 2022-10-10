package grupo0.reto5.Web;


import grupo0.reto5.Modelo.DTOs.ConteoCliente;
import grupo0.reto5.Modelo.DTOs.ConteoStatus;
import grupo0.reto5.Modelo.Reserva;
import grupo0.reto5.Servicio.ReservaServicio;
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva r)
    {
        return reservaServicio.update(r);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id)
    {
        return reservaServicio.deleteReservation(id);
    }

    @GetMapping("/report-clients")
    public List <ConteoCliente> getReportTopClients()
    {
        return reservaServicio.getTopClientes();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List <Reserva> getReservationDate(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo)
    {
        return reservaServicio.getPeriodoReserva(dateOne,dateTwo);
    }

    @GetMapping("/report-status")
    public ConteoStatus getReportStatusReservations()
    {
        return reservaServicio.getReservaporestado();
    }
}
