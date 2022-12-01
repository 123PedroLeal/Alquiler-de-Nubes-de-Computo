package MVC_Model.Repositorio.CRUD;


import MVC_Model.Model.Message;
import org.springframework.data.repository.CrudRepository;

//Interfaz encargada de recibir los datos de las entidades para realizar los servicios CRUD.
public interface MessageCRUDRepository extends CrudRepository<Message,Integer>
{
}
