
package pack_entidades;

public class paciente extends persona{
    
    private double peso;
    private double altura;
    private String tipo_sangre;
    private String alergias;

    public paciente() {
    }

    public paciente(double peso, double altura, String tipo_sangre, String alergias) {
        this.peso = peso;
        this.altura = altura;
        this.tipo_sangre = tipo_sangre;
        this.alergias = alergias;
    }

    public paciente(double peso, double altura, String tipo_sangre, String alergias, String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimiento_dia, String fecha_nacimiento_mes, String fecha_nacimiento_anio, String dni, String telefono, String sexo) {
        super(nombre, apellido_paterno, apellido_materno, fecha_nacimiento_dia, fecha_nacimiento_mes, fecha_nacimiento_anio, dni, telefono, sexo);
        this.peso = peso;
        this.altura = altura;
        this.tipo_sangre = tipo_sangre;
        this.alergias = alergias;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
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
