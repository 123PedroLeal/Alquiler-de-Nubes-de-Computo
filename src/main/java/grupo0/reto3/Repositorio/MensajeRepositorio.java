package grupo0.reto3.Repositorio;

import grupo0.reto3.Modelo.Mensaje;
import grupo0.reto3.Repositorio.CRUD.MensajeCRUDRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MensajeRepositorio
{
    @Autowired
    private MensajeCRUDRepositorio mensajeCRUDRepositorio;

    public List<Mensaje> getAll(){return (List<Mensaje>) mensajeCRUDRepositorio.findAll();}

    public Optional<Mensaje> getMensaje(int id) {return mensajeCRUDRepositorio.findById(id);}

    public Mensaje save(Mensaje m) {return mensajeCRUDRepositorio.save(m);}
}
