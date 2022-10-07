package grupo0.reto3.Servicio;


import grupo0.reto3.Modelo.Nube;
import grupo0.reto3.Repositorio.NubeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service hace referencia a que la clase va a hacer el servicio.
@Service
public class NubeServicio
{
    @Autowired
    private NubeRepositorio nubeRepositorio;

    //Metodo para obtener todos los objetos de tipo nube en el repositorio.
    public List<Nube> GetAll() {
        return nubeRepositorio.GetAll();
    }

    //Metodo para obtener un solo objeto de tipo nube en el repositorio.
    public Optional<Nube> getNube(int id) {
        return nubeRepositorio.getNube(id);
    }

    //Metodo para guardar un objeto de tipo nube que viene del repositorio.
    public Nube save(Nube n) {
        // Metodo para que en caso de que el objeto enviado no tenga id nulo de todas formas lo guarde.
        if (n.getId() == null) {
            return nubeRepositorio.save(n);
        } else {
            // Metodo para saber que si se obtiene una Nube vacia igual guarde la operacion
            Optional<Nube> naux = nubeRepositorio.getNube(n.getId());
            if (!naux.isPresent()) {
                return nubeRepositorio.save(n);
            }
            // Sino que guarde la instancia creada.
            else {
                return n;
            }
        }
    }

    public Nube update(Nube n)
    {
        if (n.getId() != null)
        {
            Optional<Nube> naux = nubeRepositorio.getNube(n.getId());
            if (naux.isPresent())
            {
                if (n.getName()!=null)
                {
                    naux.get().setName(n.getName());
                }
                if (n.getBrand()!=null)
                {
                    naux.get().setBrand(n.getBrand());
                }
                if (n.getYear()!=null)
                {
                    naux.get().setYear(n.getYear());
                }
                if (n.getDescription()!=null)
                {
                    naux.get().setDescription(n.getDescription());
                }
                if (n.getCategory()!=null)
                {
                    naux.get().setCategory(n.getCategory());
                }
                if (n.getMessages()!=null)
                {
                    naux.get().setMessages(n.getMessages());
                }
                if (n.getReservations()!=null)
                {
                    naux.get().setReservations(n.getReservations());
                }
                nubeRepositorio.save(naux.get());
                return naux.get();
            }
            else
            {
                return n;
            }
        }
        else
        {
            return n;
        }
    }
}