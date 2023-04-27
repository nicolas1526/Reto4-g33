package com.grupoG33.reto3.service;

import com.grupoG33.reto3.dbo.ClientDbo;
import com.grupoG33.reto3.dbo.ReportClientDbo;
import com.grupoG33.reto3.dbo.ReportStatusDbo;
import com.grupoG33.reto3.model.ClientModel;
import com.grupoG33.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> obtener(){
        return clientRepository.findAll();
    }

    public void crear(ClientModel client){
        clientRepository.save(client);
    }

    public void eliminar(int id){
        clientRepository.deleteById(id);
    }

    public void actualizar(ClientDbo clientInput) {
        Optional<ClientModel> clientDb = clientRepository.findById(clientInput.getIdClient());
        if(clientDb.isPresent()){
            ClientModel client = clientDb.get();
            if(clientInput.getAge() != null){
                client.setAge(clientInput.getAge());
            }
            if(clientInput.getName() != null){
                client.setName(clientInput.getName());
            }
            if(clientInput.getEmail() != null){
                client.setEmail(clientInput.getEmail());
            }
            if(clientInput.getPassword() != null){
                client.setPassword(clientInput.getPassword());
            }
            if(clientInput.getReservations() != null){
                client.setReservations(clientInput.getReservations());
            }
            if(clientInput.getMessages() != null){
                client.setMessages(clientInput.getMessages());
            }
            clientRepository.save(client);
        }
    }

    public Optional<ClientModel> obtenerPorId(int id) {
        return clientRepository.findById(id);
    }

    public List<ReportClientDbo> reportClients() {
        List<ReportClientDbo> listReporClient = new LinkedList<ReportClientDbo>();
        List<ClientModel> listClient = clientRepository.reportClients("completed");
        for (ClientModel client : listClient) {
            int countReservation = client.getReservations().size();
            listReporClient.add(new ReportClientDbo(countReservation,client));
        }
        return listReporClient;
    }
}
