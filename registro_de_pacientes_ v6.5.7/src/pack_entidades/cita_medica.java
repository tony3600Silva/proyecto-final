/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_entidades;


public class cita_medica {
    
 private String Cod_cita;
 private String fecha_cita;
 private String fecha_atencion;

    public cita_medica() {
    }

    public cita_medica(String Cod_cita, String fecha_cita, String fecha_atencion) {
        this.Cod_cita = Cod_cita;
        this.fecha_cita = fecha_cita;
        this.fecha_atencion = fecha_atencion;
    }
    
   
    

    public String getCod_cita() {
        return Cod_cita;
    }

    public void setCod_cita(String Cod_cita) {
        this.Cod_cita = Cod_cita;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(String fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }
 

  
        
}
