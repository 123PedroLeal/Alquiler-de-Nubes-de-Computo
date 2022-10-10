package grupo0.reto5.Web;


import grupo0.reto5.Modelo.Categoria;
import grupo0.reto5.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoriaControlador
{
    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("/all")
    public List<Categoria> GetCategorias() {return categoriaServicio.GetAll();}

    @GetMapping("/{id}")
    public Optional<Categoria> GetCategoria(@PathVariable("id")int id)
    {
        return categoriaServicio.getCategoria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria c)
    {
        return categoriaServicio.save(c);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria c)
    {
        return categoriaServicio.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id)
    {
        return categoriaServicio.deleteCategory(id);
    }
}
