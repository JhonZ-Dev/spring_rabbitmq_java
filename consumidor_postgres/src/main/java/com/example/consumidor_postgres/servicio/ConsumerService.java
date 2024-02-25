package com.example.consumidor_postgres.servicio;

import com.example.consumidor_postgres.modelo.Message;
import com.example.consumidor_postgres.repositorio.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    private ConsumidorRepository consumidorRepository;

    public Message guardar(Message message){return consumidorRepository.save(message);}
}
