package grupo0.reto4.Repositorio;


import grupo0.reto4.Modelo.Categoria;
import grupo0.reto4.Repositorio.CRUD.CategoriaCRUDRepositorio;
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

    public void delete(Categoria c) {categoriaCRUDRepositorio.delete(c);}


}
