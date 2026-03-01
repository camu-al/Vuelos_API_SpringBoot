package com.alcama.adt7_practica1.controller;

import com.alcama.adt7_practica1.modelo.Vuelo;
import com.alcama.adt7_practica1.service.IVueloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
@Tag(name = "Vuelos", description = "Controlador de los vuelos")
public class VueloController {

    @Autowired
    private IVueloService service;

    // Listar
    @Operation(summary = "Ver todos los vuelos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La lista de los vuelos se ha obtinido correctamente",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Vuelo.class)))),
    })

    @GetMapping
    public ResponseEntity<List<Vuelo>> listar() {
        List<Vuelo> lista = service.listar();

        // Código 200 OK para select
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // Registrar
    @Operation(summary = "Añadir un vuelo")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "El vuelo se ha registrado correctamente",
                    content = @Content(schema = @Schema(implementation = Vuelo.class)))
    })

    @PostMapping
    public ResponseEntity<Vuelo> registrar(@RequestBody Vuelo vuelo) {
        Vuelo obj = service.registrar(vuelo);

        // Código 201 CREATED para insert
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    // Modificar
    @Operation(summary = "Actualizar un vuelo")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El vuelo se ha actualizado correctamente",
                    content = @Content(schema = @Schema(implementation = Vuelo.class)))
    })
    @PutMapping
    public ResponseEntity<Vuelo> modificar(@RequestBody Vuelo vuelo) {
        Vuelo obj = service.modificar(vuelo);

        // Código 200 OK para update
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    // Eliminar 1
    @Operation(summary = "Elimina un vuelo por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "El vuelo se ha eliminado correctamente",
                    content = @Content(schema = @Schema(implementation = ResponseEntity.class)))
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);

        // Código 204 NOT CONTENT para delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // METODOS ESPECIFICOS
    // Eliminar 2
    @Operation(summary = "Elimina vuelos por destino")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Los vuelos se han eliminado correctamente",
                    content = @Content(schema = @Schema(implementation = ResponseEntity.class)))
    })

    @DeleteMapping("/eliminarDestino")
    public ResponseEntity<Void> eliminarPorDestino(@RequestParam(value = "destino") String destino) {

        if (!service.existsByDestino(destino)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        service.eliminarPorDestino(destino);

        // Código 204 NOT CONTENT para delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Buscar 1
    @Operation(summary = "Buscar vuelos por filtro")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado vuelos que coinciden con los filtros",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Vuelo.class)))),
    })

    // Opción 1 - Búsqueda filtrada con métodos específicos
    @GetMapping("/busquedaFiltrada1")
    public ResponseEntity<List<Vuelo>> buscarVuelos1(
            @RequestParam(required = false) String origen,
            @RequestParam(required = false) String destino,
            @RequestParam(required = false) Integer numeroEscalas) {

        List<Vuelo> vuelos = service.listarBusquedaFiltrada1(origen, destino, numeroEscalas);

        if(vuelos.isEmpty()) {
            // Código 204 NoData para select
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            // Código 200 OK para select
            return new ResponseEntity<>(vuelos, HttpStatus.OK);
        }
    }

    // Buscar 2
    @Operation(summary = "Buscar vuelos con parámetros obligatorios")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Resultados obtenidos correctamente",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Vuelo.class)))),
    })

    // Opción 2 - Búsqueda filtrada sin métodos específicos
    @GetMapping("/busquedaFiltrada2")
    public ResponseEntity<List<Vuelo>> buscarVuelos2(
            @RequestParam(value = "origen", required = true) String origen,
            @RequestParam(value = "destino", required = true) String destino,
            @RequestParam(value = "escalas", required = true) Integer escalas) {

        // Obtengo todos los vuelos filtrados
        List<Vuelo> resultados  = service.listarBusquedaFiltrada2(origen, destino, escalas);

        if(resultados.isEmpty()) {
            // Código 204 NoData para select
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            // Código 200 OK para select
            return new ResponseEntity<>(resultados, HttpStatus.OK);
        }

    }

}
