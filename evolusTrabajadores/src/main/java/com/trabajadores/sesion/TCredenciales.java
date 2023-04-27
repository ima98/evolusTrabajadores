package com.trabajadores.sesion;


import java.util.Map;
import java.util.UUID;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TCredenciales extends HashMap <String, TSesion> {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static TCredenciales instance;
    
    private TCredenciales() {
    }
    
    public static TCredenciales Instance()
    {
      {
        if (instance == null)
        {
          instance = new TCredenciales();
        }
        
        return instance;
      }
    }
    
    public static String login(String idusuario, String clave) {
        //TO DO: check
        TSesion t=new TSesion(idusuario, clave, new Date(), new Date());
        
        String uuid = UUID.randomUUID().toString(); 
        
        instance.put(uuid, t);
        return uuid;      
    }
    
    public static boolean isLogged(String token) {
        try{
            instance.get(token).setModificacion(new Date());
        }catch(Exception e) {
            
        };
        return instance.containsKey(token);     
    }
    
    public static void logOut(String token) {
        
        try{
            instance.remove(token);
        }catch(Exception e) {
            
        };
    }
    
    public static void check() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        for(Map.Entry<String, TSesion> entry : instance.entrySet()) {
            String key = entry.getKey();
            TSesion value = entry.getValue();
            Date actual=new Date();
            calendar.setTime(actual);
            calendar2.setTime(value.getModificacion());
            calendar3.setTime(value.getCreacion());
            if(calendar.get(Calendar.HOUR_OF_DAY)-calendar2.get(Calendar.HOUR_OF_DAY)>2
                    || calendar.get(Calendar.HOUR_OF_DAY)-calendar3.get(Calendar.HOUR_OF_DAY)>2) {
                instance.remove(key);
            }
          }
    }

}



