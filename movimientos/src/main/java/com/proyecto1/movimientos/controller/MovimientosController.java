package com.proyecto1.movimientos.controller;

import com.proyecto1.movimientos.dto.MovimientosDto;
import com.proyecto1.movimientos.entity.Movimientos;
import com.proyecto1.movimientos.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

    @Autowired
    private MovimientosService service;
    
    
    /*Creditos crud inicio */
    @GetMapping(value = "/creditos/listar",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovimientosDto> getMovimientosCredito(){
        return service.getMovimientoscreditos();
    }

    @GetMapping("/creditos/{id}")
    public Mono<MovimientosDto> getMovimientoCredito(@PathVariable String id){
        return service.getMovimientocredito(id);
    }

    @PostMapping("/creditos/create")
    public Mono<ResponseEntity<Movimientos>> saveMovimientoCredito(@RequestBody MovimientosDto movimientosDtoMono){
      
    	
        return service.findIdCreditos(movimientosDtoMono.getIdProducto().getId()).flatMap(product->{
            movimientosDtoMono.setIdProducto(product);
            return service.saveMovimientoCredito(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    @PutMapping("/creditos/update/{id}")
    public Mono<ResponseEntity<Movimientos>> updateMovimientoCredito(@RequestBody MovimientosDto movimientosDtoMono){
        return service.findIdCreditos(movimientosDtoMono.getIdProducto().getId()).flatMap(client->{
            movimientosDtoMono.setIdProducto(client);
            return service.updateMovimientoCredito(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    
    @DeleteMapping("/credito/delete/{id}")
    public Mono<Void> deleteMovimiento(@PathVariable String id){
        return service.deleteMovimientoCredito(id);
    }
    /*Creditos crud fin */
    
  
    
    /*Creditos crud inicio */
    @GetMapping(value = "/tarjetasCredito/listar",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovimientosDto> getMovimientosTarjetasCredito(){
        return service.getMovimientoscreditos();
    }

    @GetMapping("/tarjetasCredito/{id}")
    public Mono<MovimientosDto> getMovimientoTrajetaCredito(@PathVariable String id){
        return service.getMovimientoTarjetacredito(id);
    }
    
    @PostMapping("/tarjetasCredito/create")
    public Mono<ResponseEntity<Movimientos>> saveMovimientoTarjetasCredito(@RequestBody MovimientosDto movimientosDtoMono){
       
        return service.findIdTarjetasCreditos(movimientosDtoMono.getIdProducto().getId()).flatMap(product->{
            movimientosDtoMono.setIdProducto(product);
            
            return service.saveMovimientoTarjetascreditos(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    
    

    @PutMapping("/tarjetasCredito/update/{id}")
    public Mono<ResponseEntity<Movimientos>> updateMovimientoTarjetasCredito(@RequestBody MovimientosDto movimientosDtoMono){
        return service.findIdTarjetasCreditos(movimientosDtoMono.getIdProducto().getId()).flatMap(client->{
            movimientosDtoMono.setIdProducto(client);
            return service.updateMovimientoTarjetascreditos(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/tarjetacredito/delete/{id}")
    public Mono<Void> deleteMovimientoTarjetaCredito(@PathVariable String id){
        return service.deleteMovimientoTarjetascreditos(id);
    }
    /*Creditos crud fin*/

    
    
    /*cuenta bancaria*/
    
    @GetMapping(value = "/cuentabancaria/listar",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovimientosDto> getMovimientosCuentaBancaria(){
        return service.getMovimientosCuentasBancarias();
    }

    @GetMapping("/cuentabancaria/{id}")
    public Mono<MovimientosDto> getMovimientoCuentaBancaria(@PathVariable String id){
        return service.getMovimientoCuentaBancaria(id);
    }
    
    @PostMapping("/cuentabancaria/create")
    public Mono<ResponseEntity<Movimientos>> saveMovimientoCuentaBancaria(@RequestBody MovimientosDto movimientosDtoMono){
       
        return service.findIdCuentaBancaria(movimientosDtoMono.getIdProducto().getId()).flatMap(product->{
            movimientosDtoMono.setIdProducto(product);
            
            return service.saveMovimientoCuentaBancaria(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    
    

    @PutMapping("/cuentabancaria/update/{id}")
    public Mono<ResponseEntity<Movimientos>> updateMovimientoCuentaBancaria(@RequestBody MovimientosDto movimientosDtoMono){
        return service.findIdCuentaBancaria(movimientosDtoMono.getIdProducto().getId()).flatMap(client->{
            movimientosDtoMono.setIdProducto(client);
            return service.updateMovimientoCuentaBancaria(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/cuentabancaria/delete/{id}")
    public Mono<Void> deleteMovimientoCuentaBancaria(@PathVariable String id){
        return service.deleteMovimientoCuentaBancaria(id);
    }

}
