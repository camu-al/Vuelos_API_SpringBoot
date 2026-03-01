package com.alcama.adt7_practica1.service;

import com.alcama.adt7_practica1.modelo.Vuelo;

import java.util.List;

public interface IVueloService {

    List<Vuelo> listar();
    Vuelo registrar(Vuelo vuelo);
    Vuelo modificar(Vuelo vuelo);
    void eliminar(Integer id);

    // Métodos específicos de esta entidad
    void eliminarPorDestino(String destino);
    boolean existsByDestino(String destino);
    List<Vuelo> listarBusquedaFiltrada1(String origen, String destino, Integer numeroEscalas);
    List<Vuelo> listarBusquedaFiltrada2(String origen, String destino, Integer numeroEscalas);
}
