package grupo0.reto3.Repositorio.CRUD;


import grupo0.reto3.Modelo.Calificacion;
import org.springframework.data.repository.CrudRepository;

//Interfaz encargada de recibir los datos de las entidades para realizar los servicios CRUD.
public interface CalificacionCRUDRepositorio extends CrudRepository<Calificacion,Integer>
{
}
