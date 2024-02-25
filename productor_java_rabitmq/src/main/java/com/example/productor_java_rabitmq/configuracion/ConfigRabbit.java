package com.example.productor_java_rabitmq.configuracion;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbit {
    //primero definir las colas
    public static final String cola_sd="Santo_Domingo";
    public static final String cola_otras_ciudad="Otras_ciudades";

    //segundo definir las rutas
    public static final String ROUTING_A="santo-domingo";
    public static final String ROUTING_B = "otra-ciudad";
}
