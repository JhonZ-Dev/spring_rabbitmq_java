package com.example.consumidor_postgres.controlador;

import com.example.consumidor_postgres.modelo.Message;
import com.example.consumidor_postgres.servicio.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Component
public class MessageControlador {
    @Autowired
    public ConsumerService consumerService;

    @RabbitListener(queues = "Santo-Domingo")
    private void receive(Message message){
        log.info("Mensaje del productor ->{}", message);

        consumerService.guardar(message);
    }
}
