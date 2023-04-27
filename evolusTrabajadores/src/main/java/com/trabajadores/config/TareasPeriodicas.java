package com.trabajadores.config;

import org.springframework.scheduling.annotation.Scheduled;

import com.trabajadores.sesion.*;

public class TareasPeriodicas {
    
    @Scheduled(fixedRate=1000)
    public void work() {
        TCredenciales.Instance();
        TCredenciales.check();
    }

}
