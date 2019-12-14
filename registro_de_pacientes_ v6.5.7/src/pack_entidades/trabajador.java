
package pack_entidades;

public class trabajador extends persona{
   
    private String codigo;
    private String correo;
    private String direccion;

    private String contraseña;
    private String user;
    private String clave;

    public trabajador() {
    }

    
    public trabajador(String codigo, String correo, String direccion, String contraseña, String user, String clave) {
        this.codigo = codigo;
        this.correo = correo;
        this.direccion = direccion;
      
        this.contraseña = contraseña;
        this.user = user;
        this.clave = clave;
    }

    public trabajador(String codigo, String correo, String direccion, String contraseña, String user, String clave, String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimiento_dia, String fecha_nacimiento_mes, String fecha_nacimiento_anio, String dni, String telefono, String sexo) {
        super(nombre, apellido_paterno, apellido_materno, fecha_nacimiento_dia, fecha_nacimiento_mes, fecha_nacimiento_anio, dni, telefono, sexo);
        this.codigo = codigo;
        this.correo = correo;
        this.direccion = direccion;
       
        this.contraseña = contraseña;
        this.user = user;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
    
    
