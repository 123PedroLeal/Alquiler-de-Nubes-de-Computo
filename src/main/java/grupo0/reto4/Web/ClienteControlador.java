package grupo0.reto4.Web;


import grupo0.reto4.Modelo.Categoria;
import grupo0.reto4.Modelo.Cliente;
import grupo0.reto4.Modelo.Nube;
import grupo0.reto4.Servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClienteControlador
{
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/all")
    public List<Cliente> GetClientes() {return clienteServicio.GetAll();}

    @GetMapping("/{id}")
    public Optional<Cliente> GetCliente(@PathVariable("id")int id)
    {
        return clienteServicio.getCliente(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente c)
    {
        return clienteServicio.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente c)
    {
        return clienteServicio.update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id)
    {
        return clienteServicio.deleteClient(id);
    }
}
