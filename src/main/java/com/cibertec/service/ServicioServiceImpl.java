package com.cibertec.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Servicio;
import com.cibertec.repository.IServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService{

    @Autowired
    private IServicioRepository servicioRepository;

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio registrarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(int id) {
        servicioRepository.deleteById(id);
    }

    @Override
    public Servicio obtenerServicio(int id) {
        return servicioRepository.findById(id).get();
    }
    
}
