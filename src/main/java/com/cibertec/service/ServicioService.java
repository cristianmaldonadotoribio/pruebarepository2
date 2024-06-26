package com.cibertec.service;

import com.cibertec.entity.Servicio;
import java.util.List;

public interface ServicioService {

    public List<Servicio> listarServicios();

    public Servicio registrarServicio(Servicio servicio);

    public Servicio actualizarServicio(Servicio servicio);

    public void eliminarServicio(int id);

    public Servicio obtenerServicio(int id);
    
}
