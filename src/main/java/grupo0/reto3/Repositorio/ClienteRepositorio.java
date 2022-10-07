package grupo0.reto3.Repositorio;


import grupo0.reto3.Modelo.Cliente;
import grupo0.reto3.Repositorio.CRUD.ClienteCRUDRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*@Repository hace referencia a que es la clase que va a recibir los datos de la interfaz
CRUDRepositorio y va a entonces a recibir los codigos Get,Post,Put y Delete*/
@Repository
public class ClienteRepositorio
{
    @Autowired
    private ClienteCRUDRepositorio clienteCRUDRepositorio;

    // Metodo para obtener todos los objetos de tipo nube o hacer la petición Get de todos los objetos.
    public List<Cliente> GetAll()
    {
        return (List<Cliente>) clienteCRUDRepositorio.findAll();
    }
    // Metodo para obtener un objeto de tipo nube o solo hacer una petición Get a un solo objeto.
    public Optional<Cliente> getCliente(int id)
    {
        return clienteCRUDRepositorio.findById(id);
    }
    // Metodo para guardar el objeto nube o hacer la petición Post.
    public Cliente save(Cliente c)
    {
        return clienteCRUDRepositorio.save(c);
    }
}
