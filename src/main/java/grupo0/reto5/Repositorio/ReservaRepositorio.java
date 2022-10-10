package grupo0.reto5.Repositorio;


import grupo0.reto5.Modelo.Cliente;
import grupo0.reto5.Modelo.DTOs.ConteoCliente;
import grupo0.reto5.Modelo.Reserva;
import grupo0.reto5.Repositorio.CRUD.ReservaCRUDRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepositorio
{
    @Autowired
    private ReservaCRUDRepositorio reservaCRUDRepositorio;

    public List<Reserva> GetAll(){return (List<Reserva>) reservaCRUDRepositorio.findAll();}

    public Optional<Reserva> getReserva(int id) {return reservaCRUDRepositorio.findById(id);}

    public Reserva save(Reserva r) {return reservaCRUDRepositorio.save(r);}

    public void delete(Reserva r) {reservaCRUDRepositorio.delete(r);}

    //Reto5 (Estudiar mas a fondo).

    //1er punto

    public List<Reserva> getReservaporestado(String status)
    {
        return reservaCRUDRepositorio.findAllByStatus(status);
    }

    //2do punto

    public List<Reserva> getPeriodoReserva(Date a, Date b)
    {
        return reservaCRUDRepositorio.findAllByStartDateAfterAndDevolutionDateBefore(a,b);
    }

    //3er punto
    public List<ConteoCliente> getTopClientes()
    {
        List<ConteoCliente> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservaCRUDRepositorio.TotalReservasporClientes();

        for(int i=0; i<reporte.size();i++)
        {
            //[client,total] ->  [total,client]
            respuesta.add(new ConteoCliente((Long)reporte.get(i)[1], (Cliente) reporte.get(i)[0]));
        }
        return respuesta;
    }
}
