package grupo0.reto3.Servicio;


import grupo0.reto3.Modelo.Cliente;
import grupo0.reto3.Repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service hace referencia a que la clase va a hacer el servicio.
@Service
public class ClienteServicio
{
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    //Metodo para obtener todos los objetos de tipo nube en el repositorio.
    public List<Cliente> GetAll() {
        return clienteRepositorio.GetAll();
    }

    //Metodo para obtener un solo objeto de tipo nube en el repositorio.
    public Optional<Cliente> getCliente(int id) {
        return clienteRepositorio.getCliente(id);
    }

    //Metodo para guardar un objeto de tipo nube que viene del repositorio.
    public Cliente save(Cliente c)
    {
        // Metodo para que en caso de que el objeto enviado no tenga id nulo de todas formas lo guarde.
        if (c.getIdClient() == null)
        {
            return clienteRepositorio.save(c);
        } else {
            // Metodo para saber que si se obtiene una Nube vacia igual guarde la operacion
            Optional<Cliente> caux = clienteRepositorio.getCliente(c.getIdClient());
            if (!caux.isPresent()) {
                return clienteRepositorio.save(c);
            }
            // Sino que guarde la instancia creada.
            else {
                return c;
            }
        }
    }

    public Cliente update(Cliente c)
    {
        if (c.getIdClient() != null)
        {
            Optional<Cliente> caux = clienteRepositorio.getCliente(c.getIdClient());
            if (caux.isPresent())
            {
                if (c.getEmail()!=null)
                {
                    caux.get().setEmail(c.getEmail());
                }
                if (c.getPassword()!=null)
                {
                    caux.get().setPassword(c.getPassword());
                }
                if (c.getName()!=null)
                {
                    caux.get().setName(c.getName());
                }
                if (c.getAge()!=null)
                {
                    caux.get().setAge(c.getAge());
                }
                if (c.getMessages()!=null)
                {
                    caux.get().setMessages(c.getMessages());
                }
                if (c.getReservations()!=null)
                {
                    caux.get().setReservations(c.getReservations());
                }
                clienteRepositorio.save(caux.get());
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