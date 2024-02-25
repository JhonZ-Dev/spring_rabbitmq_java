package com.example.productor_java_rabitmq.controlador;

import com.example.productor_java_rabitmq.model.UsuarioModelo;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colas")
public class UsuarioControlador {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange exchange;

    @PostMapping("/productor")
    public String usuarioProductor(@RequestBody UsuarioModelo usuario){
        String ciudad = usuario.getCiudad_residencia();
        if ("Santo Domingo".equalsIgnoreCase(ciudad)) {
            rabbitTemplate.convertAndSend(exchange.getName(), "santo-domingo", usuario);
            return "Usuarios enviado a la cola de Santo Domingo";
        } else {
            rabbitTemplate.convertAndSend(exchange.getName(), "otra-ciudad", usuario);
            return "Usuarios enviado a la cola de Otra Ciudad";
        }
    }
}
