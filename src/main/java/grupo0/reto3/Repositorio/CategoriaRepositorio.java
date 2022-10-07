package grupo0.reto3.Repositorio;


import grupo0.reto3.Modelo.Categoria;
import grupo0.reto3.Repositorio.CRUD.CategoriaCRUDRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepositorio
{
    @Autowired
    private CategoriaCRUDRepositorio categoriaCRUDRepositorio;

    public List<Categoria> GetAll(){return (List<Categoria>) categoriaCRUDRepositorio.findAll();}

    public Optional<Categoria> getCategoria(int id) {return categoriaCRUDRepositorio.findById(id);}

    public Categoria save(Categoria c) {return categoriaCRUDRepositorio.save(c);}
}
