package grupo0.reto3.Servicio;


import grupo0.reto3.Modelo.Mensaje;
import grupo0.reto3.Repositorio.MensajeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service hace referencia a que la clase va a hacer el servicio.
@Service
public class MensajeServicio
{
    @Autowired
    private MensajeRepositorio mensajeRepositorio;

    //Metodo para obtener todos los objetos de tipo nube en el repositorio.
    public List<Mensaje> getAll(){return mensajeRepositorio.getAll();}

    //Metodo para obtener un solo objeto de tipo nube en el repositorio.
    public Optional<Mensaje> getMensaje(int id) {return mensajeRepositorio.getMensaje(id);}

    //Metodo para guardar un objeto de tipo nube que viene del repositorio.
    public Mensaje save(Mensaje m)
    {
        // Metodo para que en caso de que el objeto enviado no tenga id nulo de todas formas lo guarde.
        if (m.getIdMessage() == null)
        {
            return mensajeRepositorio.save(m);
        } else
        {
            // Metodo para saber que si se obtiene una Nube vacia igual guarde la operacion
            Optional<Mensaje> maux = mensajeRepositorio.getMensaje(m.getIdMessage());
            if (!maux.isPresent()) {
                return mensajeRepositorio.save(m);
            }
            // Sino que guarde la instancia creada.
            else {
                return m;
            }
        }
    }

    public Mensaje update(Mensaje m)
    {
        if (m.getIdMessage() != null)
        {
            Optional<Mensaje> maux = mensajeRepositorio.getMensaje(m.getIdMessage());
            if (maux.isPresent())
            {
                if (m.getMessageText()!=null)
                {
                    maux.get().setMessageText(m.getMessageText());
                }
                if (m.getCloud()!=null)
                {
                    maux.get().setCloud(m.getCloud());
                }
                if (m.getClient()!=null)
                {
                    maux.get().setClient(m.getClient());
                }
                mensajeRepositorio.save(maux.get());
                return maux.get();
            }
            else
            {
                return m;
            }
        }
        else
        {
            return m;
        }
    }
}