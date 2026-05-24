package com.example.Venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Venta.model.Venta;
@Repository

public interface VentaRepository extends JpaRepository<Venta, Long> {

    

}
