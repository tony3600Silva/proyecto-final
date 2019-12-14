
package pack_entidades;


public class persona {
  
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_nacimiento_dia;
    private String fecha_nacimiento_mes;
    private String fecha_nacimiento_anio;
    private String dni;
    private String telefono;
    private String sexo;

    public persona() {
    }

    public persona(String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimiento_dia, String fecha_nacimiento_mes, String fecha_nacimiento_anio, String dni, String telefono, String sexo) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento_dia = fecha_nacimiento_dia;
        this.fecha_nacimiento_mes = fecha_nacimiento_mes;
        this.fecha_nacimiento_anio = fecha_nacimiento_anio;
        this.dni = dni;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getFecha_nacimiento_dia() {
        return fecha_nacimiento_dia;
    }

    public void setFecha_nacimiento_dia(String fecha_nacimiento_dia) {
        this.fecha_nacimiento_dia = fecha_nacimiento_dia;
    }

    public String getFecha_nacimiento_mes() {
        return fecha_nacimiento_mes;
    }

    public void setFecha_nacimiento_mes(String fecha_nacimiento_mes) {
        this.fecha_nacimiento_mes = fecha_nacimiento_mes;
    }

    public String getFecha_nacimiento_anio() {
        return fecha_nacimiento_anio;
    }

    public void setFecha_nacimiento_anio(String fecha_nacimiento_anio) {
        this.fecha_nacimiento_anio = fecha_nacimiento_anio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String Clave(){
        String cad1=nombre.substring(0,1);
        String cad2=apellido_paterno.substring(0,1);
        String cad3=apellido_materno.substring(0,1);
        return cad1.concat(cad2).concat(cad3).concat(fecha_nacimiento_dia).concat(fecha_nacimiento_mes).concat(fecha_nacimiento_anio);
    }
   
    
    
    
    
}


