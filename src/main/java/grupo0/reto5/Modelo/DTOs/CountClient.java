package grupo0.reto5.Modelo.DTOs;

import grupo0.reto5.Modelo.Client;

public class CountClient
{
    private Long total;
    private Client client;

    public CountClient(Long total, Client client)
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

    public Client getCliente()
    {
        return client;
    }

    public void setCliente(Client client)
    {
        this.client = client;
    }
}
