
package pack_entidades;

/**
 *
 * @author JHONNY BRYAN
 */
public class doctor extends persona{
    
    private String codigo;
    private String correo;
    private String Direccion;
    private String especialidad;
    
    private String horario_lunes;
    private String horario_martes;
    private String horario_miercoles;
    private String horario_jueves;
    private String horario_viernes;
    private String horario_sabado;
    private String horario_domingo;

    public doctor() {
    }

    public doctor(String codigo, String correo, String Direccion, String especialidad, String horario_lunes, String horario_martes, String horario_miercoles, String horario_jueves, String horario_sabado, String horario_domingo) {
        this.codigo = codigo;
        this.correo = correo;
        this.Direccion = Direccion;
        this.especialidad = especialidad;
        this.horario_lunes = horario_lunes;
        this.horario_martes = horario_martes;
        this.horario_miercoles = horario_miercoles;
        this.horario_jueves = horario_jueves;
        this.horario_sabado = horario_sabado;
        this.horario_domingo = horario_domingo;
    }

    public doctor(String codigo, String correo, String Direccion, String especialidad, String horario_lunes, String horario_martes, String horario_miercoles, String horario_jueves, String horario_viernes, String horario_sabado, String horario_domingo, String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimiento_dia, String fecha_nacimiento_mes, String fecha_nacimiento_anio, String dni, String telefono, String sexo) {
        super(nombre, apellido_paterno, apellido_materno, fecha_nacimiento_dia, fecha_nacimiento_mes, fecha_nacimiento_anio, dni, telefono, sexo);
        this.codigo = codigo;
        this.correo = correo;
        this.Direccion = Direccion;
        this.especialidad = especialidad;
        this.horario_lunes = horario_lunes;
        this.horario_martes = horario_martes;
        this.horario_miercoles = horario_miercoles;
        this.horario_jueves = horario_jueves;
        this.horario_viernes = horario_viernes;
        this.horario_sabado = horario_sabado;
        this.horario_domingo = horario_domingo;
    }

    public String getHorario_domingo() {
        return horario_domingo;
    }

    public void setHorario_domingo(String horario_domingo) {
        this.horario_domingo = horario_domingo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorario_lunes() {
        return horario_lunes;
    }

    public void setHorario_lunes(String horario_lunes) {
        this.horario_lunes = horario_lunes;
    }

    public String getHorario_martes() {
        return horario_martes;
    }

    public void setHorario_martes(String horario_martes) {
        this.horario_martes = horario_martes;
    }

    public String getHorario_miercoles() {
        return horario_miercoles;
    }

    public void setHorario_miercoles(String horario_miercoles) {
        this.horario_miercoles = horario_miercoles;
    }

    public String getHorario_jueves() {
        return horario_jueves;
    }

    public void setHorario_jueves(String horario_jueves) {
        this.horario_jueves = horario_jueves;
    }

    public String getHorario_viernes() {
        return horario_viernes;
    }

    public void setHorario_viernes(String horario_viernes) {
        this.horario_viernes = horario_viernes;
    }

    public String getHorario_sabado() {
        return horario_sabado;
    }

    public void setHorario_sabado(String horario_sabado) {
        this.horario_sabado = horario_sabado;
    }

    
    
    public String Sexo(boolean m,boolean f){
         if(m==true)
             return "Masculino";
         else if(f==true){
             return "Femenino";
         }
         else
             return "";
    }
    
    
    
    
    
    
    
}
