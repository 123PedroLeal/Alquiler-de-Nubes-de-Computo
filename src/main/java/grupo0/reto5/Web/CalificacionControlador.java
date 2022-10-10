package grupo0.reto5.Web;


import grupo0.reto5.Modelo.Calificacion;
import grupo0.reto5.Modelo.Categoria;
import grupo0.reto5.Servicio.CalificacionServicio;
import grupo0.reto5.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CalificacionControlador
{
    @Autowired
    private CalificacionServicio calificacionServicio;

    @GetMapping("/all")
    public List<Calificacion> GetCalificaciones() {return calificacionServicio.GetAll();}

    @GetMapping("/{id}")
    public Optional<Calificacion> GetCalificacion(@PathVariable("id")int id){return calificacionServicio.getCalificacion(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion save(@RequestBody Calificacion c){return calificacionServicio.save(c);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion update(@RequestBody Calificacion c)
    {
        return calificacionServicio.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id) {return calificacionServicio.deleteScore(id);}
}
