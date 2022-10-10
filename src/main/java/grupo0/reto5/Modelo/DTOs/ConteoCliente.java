package grupo0.reto5.Modelo.DTOs;

import grupo0.reto5.Modelo.Cliente;

public class ConteoCliente
{
    private Long total;
    private Cliente client;

    public ConteoCliente(Long total,Cliente client)
    {
        this.total=total;
        this.client=client;
    }

    public Long getTotal()
    {
        return total;
    }

    public void setTotal(Long total)
    {
        this.total = total;
    }

    public Cliente getCliente()
    {
        return client;
    }

    public void setCliente(Cliente client)
    {
        this.client = client;
    }
}
