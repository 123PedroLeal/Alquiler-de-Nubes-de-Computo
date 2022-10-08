package grupo0.reto4.Repositorio;

import grupo0.reto4.Modelo.Categoria;
import grupo0.reto4.Modelo.Nube;
import grupo0.reto4.Repositorio.CRUD.NubeCRUDRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*@Repository hace referencia a que es la clase que va a recibir los datos de la interfaz
CRUDRepossitorio y va a entonces a recibir los codigos Get,Post,Put y Delete*/
@Repository
public class NubeRepositorio
{
    @Autowired
    private NubeCRUDRepositorio nubeCRUDRepositorio;

    // Metodo para obtener todos los objetos de tipo nube o hacer la peticion Get de todos los objetos.
    public List<Nube> GetAll()
    {
        return (List<Nube>) nubeCRUDRepositorio.findAll();
    }
    // Metodo para obtener un objeto de tipo nube o solo hacer una peticion Get a un solo objeto.
    public Optional<Nube> getNube(int id)
    {
        return nubeCRUDRepositorio.findById(id);
    }
    // Metodo para guardar el objeto nube o hacer la peticion Post.
    public Nube save(Nube n)
    {
        return nubeCRUDRepositorio.save(n);
    }

    public void delete(Nube n) {nubeCRUDRepositorio.delete(n);}
}
