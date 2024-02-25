package com.example.productor_java_rabitmq.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioModelo {
    private String nombre, apellido, identificacion, correo, ciudad_residencia,direccion;
    private String fecha_nacimiento;

}
