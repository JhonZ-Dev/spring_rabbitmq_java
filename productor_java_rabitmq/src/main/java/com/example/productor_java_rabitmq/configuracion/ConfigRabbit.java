package com.example.productor_java_rabitmq.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class ConfigRabbit {
    //primero definir las colas
    public static final String cola_sd="Santo_Domingo";
    public static final String cola_otras_ciudad="Otras_ciudades";

    //segundo definir las rutas
    public static final String ROUTING_A="santo-domingo";
    public static final String ROUTING_B = "otra-ciudad";

    //definir las colas
    @Bean
    public Queue colaSantoDomingo(){
        return new Queue(cola_sd,false);
    }
    @Bean
    public Queue colaOtraCiudad(){
        return new Queue(cola_otras_ciudad,false);
    }

    //configurar método direct, fanaout, etc.
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange("exchange-estudiantes");
    }

    //configuracion de los bindigns
    @Bean
    public Binding bindingSantoDomingo(Queue colaSantoDomingo, DirectExchange exchange){
        return BindingBuilder.bind(colaSantoDomingo).to(exchange).with(ROUTING_A);

    }
    @Bean
    public Binding bindingOtraCiudad(Queue colaOtraCiudad, DirectExchange exchange){
        return BindingBuilder.bind(colaOtraCiudad).to(exchange).with(ROUTING_B);

    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }



}
