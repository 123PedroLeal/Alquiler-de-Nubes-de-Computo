package grupo0.reto3.Servicio;


import grupo0.reto3.Modelo.Categoria;
import grupo0.reto3.Repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio
{
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> GetAll()
    {
        return categoriaRepositorio.GetAll();
    }

    public Optional<Categoria> getCategoria(int id)
    {
        return categoriaRepositorio.getCategoria(id);
    }

    public Categoria save(Categoria c)
    {
        if (c.getId()==null)
        {
            return categoriaRepositorio.save(c);
        }
        else
        {
            Optional<Categoria> caux=categoriaRepositorio.getCategoria(c.getId());
            if(!caux.isPresent())
            {
                return categoriaRepositorio.save(c);
            }
            else
            {
                return c;
            }
        }
    }

    public Categoria update(Categoria c)
    {
        if (c.getId() != null)
        {
            Optional<Categoria> caux = categoriaRepositorio.getCategoria(c.getId());
            if (caux.isPresent())
            {
                if (c.getName()!=null)
                {
                    caux.get().setName(c.getName());
                }
                if (c.getDescription()!=null)
                {
                    caux.get().setDescription(c.getDescription());
                }
                if (c.getClouds()!=null)
                {
                    caux.get().setClouds(c.getClouds());
                }

                categoriaRepositorio.save(caux.get());
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
