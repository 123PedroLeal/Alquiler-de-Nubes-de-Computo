package grupo0.reto4.Repositorio;

import grupo0.reto4.Modelo.Admin;
import grupo0.reto4.Modelo.Categoria;
import grupo0.reto4.Repositorio.CRUD.AdminCRUDRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepositorio
{
    @Autowired
    private AdminCRUDRepositorio adminCRUDRepositorio;

    public List<Admin> GetAll(){return (List<Admin>) adminCRUDRepositorio.findAll();}

    public Optional<Admin> getAdmin(int id) {return adminCRUDRepositorio.findById(id);}

    public Admin save(Admin a) {return adminCRUDRepositorio.save(a);}

    public void delete(Admin a) {adminCRUDRepositorio.delete(a);}
}
