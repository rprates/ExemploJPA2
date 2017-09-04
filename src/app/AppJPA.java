package app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelos.Cliente;
import modelos.ClienteJpaController;
import modelos.Endereco;
import modelos.Pedido;

public class AppJPA {

    public static void main(String[] args) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA2PU");
        ClienteJpaController clienteDAO = new ClienteJpaController(emf);
        
        Cliente cli = clienteDAO.findCliente(1);
        System.out.println("Nome do cliente " + cli.getNome() );
        
        Cliente novoCliente = new Cliente();
        novoCliente.setId(6);
        novoCliente.setNome("Gustavo Felizola");
        novoCliente.setEnderecoId(3);
        clienteDAO.create(novoCliente);

        Cliente justCreatedCliente = clienteDAO.findCliente(5);
        System.out.println("Nome do cliente " + justCreatedCliente.getNome() );
    }
    
}
