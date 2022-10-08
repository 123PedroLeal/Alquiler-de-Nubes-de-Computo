package grupo0.reto4.Servicio;

import grupo0.reto4.Modelo.Admin;
import grupo0.reto4.Repositorio.AdminRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service hace referencia a que la clase va a hacer el servicio.
@Service
public class AdminServicio
{
    @Autowired
    private AdminRepositorio adminRepositorio;

    //Metodo para obtener todos los objetos de tipo nube en el repositorio.
    public List<Admin> GetAll() {
        return adminRepositorio.GetAll();
    }

    //Metodo para obtener un solo objeto de tipo nube en el repositorio.
    public Optional<Admin> getAdmin(int id) {return adminRepositorio.getAdmin(id);}

    //Metodo para guardar un objeto de tipo nube que viene del repositorio.
    public Admin save(Admin a) {
        // Metodo para que en caso de que el objeto enviado no tenga id nulo de todas formas lo guarde.
        if (a.getIdAdmin() == null) {
            return adminRepositorio.save(a);
        } else {
            // Metodo para saber que si se obtiene una Nube vacia igual guarde la operacion
            Optional<Admin> aaux = adminRepositorio.getAdmin(a.getIdAdmin());
            if (!aaux.isPresent()) {
                return adminRepositorio.save(a);
            }
            // Sino que guarde la instancia creada.
            else {
                return a;
            }
        }
    }
    public boolean deleteAdmin(int id)
    {
        Boolean a = getAdmin(id).map(Admin-> {adminRepositorio.delete(Admin);
            return true;
        }).orElse(false);
        return a;
    }

    public Admin update(Admin a)
    {
        if (a.getIdAdmin() != null)
        {
            Optional<Admin> aaux = adminRepositorio.getAdmin(a.getIdAdmin());
            if (aaux.isPresent())
            {
                if (a.getEmail()!=null)
                {
                    aaux.get().setEmail(a.getEmail());
                }
                if (a.getPassword()!=null)
                {
                    aaux.get().setPassword(a.getPassword());
                }
                if (a.getName()!=null)
                {
                    aaux.get().setName(a.getName());
                }

                adminRepositorio.save(aaux.get());
                return aaux.get();
            }
            else
            {
                return a;
            }
        }
        else
        {
            return a;
        }
    }
}