package com.proyecto1.servicios.Entidad;

import com.proyecto1.servicios.Dto.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tarjetacredito")
public class TarjetaCredito {
    @Id
    private String id;
    private double limiteCredito;
    private Date fechaapertura;
    private ClienteDto cliente;
    private Date fechaPago;
    private String firmante;//dni de cliente adicional

}
