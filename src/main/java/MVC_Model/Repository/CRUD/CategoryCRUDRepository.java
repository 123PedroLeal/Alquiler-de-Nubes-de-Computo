package MVC_Model.Repositorio.CRUD;


import MVC_Model.Model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCRUDRepository extends CrudRepository<Category,Integer>
{
}
