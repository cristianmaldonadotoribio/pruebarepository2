package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.cibertec.entity.Servicio;
import com.cibertec.service.ServicioService;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService service;

    @GetMapping("/listar")
    public List<Servicio> listarServicios() {
        return service.listarServicios();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResponseEntity<?> registrarServicio(@RequestBody Servicio servicio) {
        Map<String, Object> mensaje = new HashMap<>();
        try {
            Servicio servicioEntity = service.registrarServicio(servicio);
            if (servicioEntity == null) {
                mensaje.put("mensaje", "Error al registrar servicio");
            }else{
                mensaje.put("mensaje", "Servicio registrado con éxito");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensaje.put("mensaje", "Error al registrar servicio");
        }
        return ResponseEntity.ok(mensaje);
    }

    @PutMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<?> actualizarServicio(@RequestBody Servicio servicio) {
        Map<String, Object> mensaje = new HashMap<>();
        try {
            Servicio servicioEntity = service.actualizarServicio(servicio);
            if (servicioEntity == null) {
                mensaje.put("mensaje", "Error al actualizar el servicio");
            }else{
                mensaje.put("mensaje", "Servicio actualizado con éxito");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensaje.put("mensaje", "Error al actualizar servicio");
        }
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarServicio(@PathVariable("id") int id) {
        Map<String, Object> mensaje = new HashMap<>();
        try {
            service.eliminarServicio(id);
            mensaje.put("mensaje", "Servicio eliminado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
            mensaje.put("mensaje", "Error al eliminar servicio");
        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerServicio(@PathVariable("id") int id) {
        Servicio servicioEntity = service.obtenerServicio(id);
        return ResponseEntity.ok(servicioEntity);
    }

    
    
}
