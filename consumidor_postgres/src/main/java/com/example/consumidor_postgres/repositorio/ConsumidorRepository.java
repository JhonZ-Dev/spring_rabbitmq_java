package com.example.consumidor_postgres.repositorio;

import com.example.consumidor_postgres.modelo.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumidorRepository extends JpaRepository<Message, Long> {
}
