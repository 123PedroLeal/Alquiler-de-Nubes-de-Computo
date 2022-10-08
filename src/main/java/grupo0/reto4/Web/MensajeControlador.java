package grupo0.reto4.Web;


import grupo0.reto4.Modelo.Mensaje;
import grupo0.reto4.Modelo.Nube;
import grupo0.reto4.Servicio.MensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MensajeControlador
{
    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping("/all")
    public List<Mensaje> getMensajes() {return mensajeServicio.getAll();}

    @GetMapping("/{id}")
    public Optional<Mensaje> getMensaje(@PathVariable("id")int id)
    {
        return mensajeServicio.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje m)
    {
        return mensajeServicio.save(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje m)
    {
        return mensajeServicio.update(m);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id)
    {
        return mensajeServicio.deleteMessage(id);
    }
}
