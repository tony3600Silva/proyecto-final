/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_registro;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pack_entidades.doctor;
import pack_entidades.persona;
import pack_entidades.trabajador;

/**
 *
 * @author UPN
 */
public class frm_registro_doctor extends javax.swing.JInternalFrame {

    
     String ruta="src\\pack_archivos\\doctores.txt";
    File fichero = new File(ruta);
    DefaultTableModel modelo = new DefaultTableModel();
    File archivo = new File("src\\pack_archivos\\doctores.txt");
    
    
    
     private void llenarTabla(){
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido paterno");
        modelo.addColumn("Apellido materno");
        modelo.addColumn("N_dia");
        modelo.addColumn("N_mes");
        modelo.addColumn("N_año");
        modelo.addColumn("Sexo");
        
      
        modelo.addColumn("DNI");
        modelo.addColumn("Correo");
        modelo.addColumn("Dirección");
        modelo.addColumn("Telefono");
        modelo.addColumn("Especialidad");
        
        modelo.addColumn("Lunes");
        modelo.addColumn("Marte");
        modelo.addColumn("Miercoles");
        modelo.addColumn("Jueves");
        modelo.addColumn("Viernes");
        modelo.addColumn("Sabado");
        modelo.addColumn("Domingo");
        

        tbl_doctor.setModel(modelo);
    }
      
    private void llenarDia(){
        cbo_DatDoctor_Dia.addItem("Día");
        for (int i =1; i <=31; i++) {
            cbo_DatDoctor_Dia.addItem(String.valueOf(i));
        }
    }
    private void llenarMes(){
        cbo_DatDoctor_Mes.addItem("Mes");
        for (int i =1; i <=12; i++) {
            cbo_DatDoctor_Mes.addItem(String.valueOf(i));
        }
    }
    private void llenarAnio(){
        cbo_DatDoctor_Anio.addItem("Año");
        for (int i =1970; i <=2019; i++) {
            cbo_DatDoctor_Anio.addItem(String.valueOf(i));
        }
    }
    
     private void especialidad(){
        cbo_DatDoctor_Especialidad.addItem("SELECCIONE");
       cbo_DatDoctor_Especialidad.addItem("Pediatria");
       cbo_DatDoctor_Especialidad.addItem("Reumatologia");
       cbo_DatDoctor_Especialidad.addItem("Endocrinologia");
       cbo_DatDoctor_Especialidad.addItem("Nefrologia");  
       cbo_DatDoctor_Especialidad.addItem("Traumatologia"); 
       cbo_DatDoctor_Especialidad.addItem("Cardiologia"); 
       cbo_DatDoctor_Especialidad.addItem("Oftalmologia"); 
       cbo_DatDoctor_Especialidad.addItem("Urologia");
       cbo_DatDoctor_Especialidad.addItem("Anastesiologia");
       cbo_DatDoctor_Especialidad.addItem("Oncologia");
       cbo_DatDoctor_Especialidad.addItem("Medicina Fisica");
       cbo_DatDoctor_Especialidad.addItem("Enfermedades Infecciosas y Tropicales");
       cbo_DatDoctor_Especialidad.addItem("Dermatologia");
       cbo_DatDoctor_Especialidad.addItem("Gastroentereologia");
       cbo_DatDoctor_Especialidad.addItem("Hematologia");
       cbo_DatDoctor_Especialidad.addItem("Neumologia");
       cbo_DatDoctor_Especialidad.addItem("Obstetricia");
       cbo_DatDoctor_Especialidad.addItem("Ginecologia");
       cbo_DatDoctor_Especialidad.addItem("Ginecologia");
       cbo_DatDoctor_Especialidad.addItem("Ginecologia");
       
       
    }
     
       private void lunes(){
        cbo_DatDoctor_HorLunes.addItem("SELECCIONE");
        cbo_DatDoctor_HorLunes.addItem("8:00am - 12:00pm");
        cbo_DatDoctor_HorLunes.addItem("10:00am - 2:00pm");
        cbo_DatDoctor_HorLunes.addItem("2:00pm - 6:00pm");
        cbo_DatDoctor_HorLunes.addItem("4:00pm - 8:00pm");       
    }
         private void martes(){
        cbo_DatDoctor_HorMartes.addItem("SELECCIONE");
        cbo_DatDoctor_HorMartes.addItem("8:00am - 12:00pm");
        cbo_DatDoctor_HorMartes.addItem("10:00am - 2:00pm");
        cbo_DatDoctor_HorMartes.addItem("2:00pm - 6:00pm");
        cbo_DatDoctor_HorMartes.addItem("4:00pm - 8:00pm");   
    }
           private void miercoles(){
        cbo_DatDoctor_HorMiercoles.addItem("SELECCIONE");
        cbo_DatDoctor_HorMiercoles.addItem("8:00am - 12:00pm");
        cbo_DatDoctor_HorMiercoles.addItem("10:00am - 2:00pm");
        cbo_DatDoctor_HorMiercoles.addItem("2:00pm - 6:00pm");
        cbo_DatDoctor_HorMiercoles.addItem("4:00pm - 8:00pm");     
    }
             private void jueves(){
        cbo_DatDoctor_HorJueves.addItem("SELECCIONE");
        cbo_DatDoctor_HorJueves.addItem("8:00am - 12:00pm");
        cbo_DatDoctor_HorJueves.addItem("10:00am - 2:00pm");
        cbo_DatDoctor_HorJueves.addItem("2:00pm - 6:00pm");
        cbo_DatDoctor_HorJueves.addItem("4:00pm - 8:00pm");       
    }
               private void viernes(){
        cbo_DatDoctor_HorViernes.addItem("SELECCIONE");
        cbo_DatDoctor_HorViernes.addItem("8:00am - 12:00pm");
        cbo_DatDoctor_HorViernes.addItem("10:00am - 2:00pm");
        cbo_DatDoctor_HorViernes.addItem("2:00pm - 6:00pm");
        cbo_DatDoctor_HorViernes.addItem("4:00pm - 8:00pm");   
    }
                 private void sabado(){
        cbo_DatDoctor_HorSabado.addItem("SELECCIONE");
        cbo_DatDoctor_HorSabado.addItem("8:00am - 12:00pm");
        cbo_DatDoctor_HorSabado.addItem("10:00am - 2:00pm");
        cbo_DatDoctor_HorSabado.addItem("2:00pm - 6:00pm");
        cbo_DatDoctor_HorSabado.addItem("4:00pm - 8:00pm");       
    }
                   private void domingo(){
        cbo_DatDoctor_HorDomingo.addItem("SELECCIONE");
        cbo_DatDoctor_HorDomingo.addItem("8:00am - 12:00pm");
        cbo_DatDoctor_HorDomingo.addItem("10:00am - 2:00pm");  
    }
     
    
    
    
    private void registrarTabla(){
      doctor doctor = new doctor();
                        
                         doctor.setCodigo(txt_DatDoctor_Codigo.getText());
                        doctor.setNombre(txt_DatDoctor_Nombres.getText());
                        doctor.setApellido_paterno(txt_DatDoctor_ApePaterno.getText());
                        doctor.setApellido_materno(txt_DatDoctor_ApeMaterno.getText());
                 
                        doctor.setFecha_nacimiento_dia(cbo_DatDoctor_Dia.getSelectedItem().toString());
                        doctor.setFecha_nacimiento_mes(cbo_DatDoctor_Mes.getSelectedItem().toString());
                        doctor.setFecha_nacimiento_anio(cbo_DatDoctor_Anio.getSelectedItem().toString());
                             
                        doctor.setDni(txt_DatDoctor_Dni.getText());
                        doctor.setCorreo(txt_DatDoctor_Correo.getText());
                        doctor.setDireccion(txt_DatDoctor_Direccion.getText());
                        doctor.setTelefono(txt_DatDoctor_Telefono.getText());
                        doctor.setEspecialidad(cbo_DatDoctor_Especialidad.getSelectedItem().toString());
                        
                        
                        doctor.setHorario_lunes(cbo_DatDoctor_HorLunes.getSelectedItem().toString());
                        doctor.setHorario_martes(cbo_DatDoctor_HorMartes.getSelectedItem().toString());
                        doctor.setHorario_miercoles(cbo_DatDoctor_HorMiercoles.getSelectedItem().toString());
                        doctor.setHorario_jueves(cbo_DatDoctor_HorJueves.getSelectedItem().toString());
                        doctor.setHorario_viernes(cbo_DatDoctor_HorViernes.getSelectedItem().toString());
                        doctor.setHorario_sabado(cbo_DatDoctor_HorSabado.getSelectedItem().toString());
                        doctor.setHorario_domingo(cbo_DatDoctor_HorDomingo.getSelectedItem().toString());
                
        Object  fila[] = new Object[20];
        fila[0] = doctor.getCodigo();
        fila[1] = doctor.getNombre();
        fila[2] = doctor.getApellido_paterno();
        fila[3] = doctor.getApellido_materno();
        fila[4] = doctor.getFecha_nacimiento_dia();
        fila[5] = doctor.getFecha_nacimiento_mes();
        fila[6] = doctor.getFecha_nacimiento_anio(); 
        fila[7] = doctor.Sexo(rb_doctor_maculino.isSelected(),rb_doctor_femenino.isSelected());
        fila[8] = doctor.getDni();
        
        
        fila[9] = doctor.getCorreo();
        fila[10] = doctor.getDireccion();
        
        fila[11] = doctor.getTelefono();
        fila[12] = doctor.getEspecialidad();
        
        fila[13] = doctor.getHorario_lunes();
        fila[14] = doctor.getHorario_martes();
        fila[15] = doctor.getHorario_miercoles();
        fila[16] = doctor.getHorario_jueves();
        fila[17] = doctor.getHorario_viernes();
        fila[18] = doctor.getHorario_sabado();
        fila[19] = doctor.getHorario_domingo();


        modelo.addRow(fila); // asignar a la fila de la tabla
  
    }
    
    
     private void guardarArchivo(){
        FileWriter fw = null;
        PrintWriter pw = null;
		try {
			//crea el flujo para escribir en el archivo
			fw = new FileWriter("src\\pack_archivos\\doctores.txt",true);
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			pw = new PrintWriter(fw);
                        
                         doctor doctor = new doctor();
                        
                         doctor.setCodigo(txt_DatDoctor_Codigo.getText());
                        doctor.setNombre(txt_DatDoctor_Nombres.getText());
                        doctor.setApellido_paterno(txt_DatDoctor_ApePaterno.getText());
                        doctor.setApellido_materno(txt_DatDoctor_ApeMaterno.getText());
                 
                        doctor.setFecha_nacimiento_dia(cbo_DatDoctor_Dia.getSelectedItem().toString());
                        doctor.setFecha_nacimiento_mes(cbo_DatDoctor_Mes.getSelectedItem().toString());
                        doctor.setFecha_nacimiento_anio(cbo_DatDoctor_Anio.getSelectedItem().toString());
                             
                        doctor.setDni(txt_DatDoctor_Dni.getText());
                        doctor.setCorreo(txt_DatDoctor_Correo.getText());
                        doctor.setDireccion(txt_DatDoctor_Direccion.getText());
                        doctor.setTelefono(txt_DatDoctor_Telefono.getText());
                        doctor.setEspecialidad(cbo_DatDoctor_Especialidad.getSelectedItem().toString());
                        
                        
                        doctor.setHorario_lunes(cbo_DatDoctor_HorLunes.getSelectedItem().toString());
                        doctor.setHorario_martes(cbo_DatDoctor_HorMartes.getSelectedItem().toString());
                        doctor.setHorario_miercoles(cbo_DatDoctor_HorMiercoles.getSelectedItem().toString());
                        doctor.setHorario_jueves(cbo_DatDoctor_HorJueves.getSelectedItem().toString());
                        doctor.setHorario_viernes(cbo_DatDoctor_HorViernes.getSelectedItem().toString());
                        doctor.setHorario_sabado(cbo_DatDoctor_HorSabado.getSelectedItem().toString());
                        doctor.setHorario_domingo(cbo_DatDoctor_HorDomingo.getSelectedItem().toString());
                     
                        
                        
                           pw.println(doctor.getCodigo() + 
                                   
                                      ";" + doctor.getNombre()+ 
                                   
                                      ";" + doctor.getApellido_paterno() +   
                                      ";" + doctor.getApellido_materno() + 
                                      ";" + doctor.getFecha_nacimiento_dia()+ 
                                   
                                      ";" + doctor.getFecha_nacimiento_mes()+ 
                                      ";" + doctor.getFecha_nacimiento_anio()+ 
                                      ";" + doctor.Sexo(rb_doctor_maculino.isSelected(),rb_doctor_femenino.isSelected()) + 
                                      ";" + doctor.getDni()+
                                     
                                      ";" + doctor.getDireccion() +
                                      ";" + doctor.getCorreo() +
                                      ";" + doctor.getTelefono()+
                                      ";" + doctor.getEspecialidad()+
                                   
                                    ";" + doctor.getHorario_lunes() +
                                    ";" + doctor.getHorario_martes()+
                                    ";" + doctor.getHorario_miercoles()+
                                    ";" + doctor.getHorario_jueves()+
                                    ";" + doctor.getHorario_viernes() +
                                    ";" + doctor.getHorario_sabado()+
                                    ";" + doctor.getHorario_domingo()
                                     
                                   
                          
                           ); 
                        

			//cierra el buffer intermedio
			pw.close();
                        JOptionPane.showMessageDialog(null, "Se Registro Correctamente");
			//System.out.println("Archivo creado satisfactoriamente..");
                }            
		catch (IOException e) {
                      JOptionPane.showMessageDialog(null,e.getMessage());
		}
    
    }
    
    
    
     
    private boolean validarCodigo(){
       boolean encontrado = false;
        try{
           if(archivo.exists())
            {
                
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String codigo = txt_DatDoctor_Codigo.getText();
                //String codigo = JOptionPane.showInputDialog("Ingrese codigo: ");
                String Linea;
                while((Linea = br.readLine())!=null)
                {
                    String[] datos = Linea.split(";");
                    if(codigo.equals(datos[0]))
                    {
                        JOptionPane.showMessageDialog(null,"El código ya existe, ingresa otro ensalada");
                        encontrado = true;
                    }
                }
                br.close();
            } 
        }catch(HeadlessException | IOException ex){
            JOptionPane.showMessageDialog(null,"Incorrecto"+ex);
        }
        return encontrado;
    }
    
    

    
    private void limpiar(){
        txt_DatDoctor_Codigo.setText("");
        txt_DatDoctor_Nombres.setText("");
        txt_DatDoctor_ApePaterno.setText("");
        txt_DatDoctor_ApeMaterno.setText("");  
        cbo_DatDoctor_Dia.setSelectedIndex(0);
        cbo_DatDoctor_Mes.setSelectedIndex(0);
        cbo_DatDoctor_Anio.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        txt_DatDoctor_Dni.setText("");
        txt_DatDoctor_Correo.setText("");
        txt_DatDoctor_Direccion.setText("");
        txt_DatDoctor_Telefono.setText("");
        cbo_DatDoctor_Especialidad.setSelectedIndex(0);
        
        
        cbo_DatDoctor_HorLunes.setSelectedIndex(0);
        cbo_DatDoctor_HorMartes.setSelectedIndex(0);
        cbo_DatDoctor_HorMiercoles.setSelectedIndex(0);
        cbo_DatDoctor_HorJueves.setSelectedIndex(0);
        cbo_DatDoctor_HorViernes.setSelectedIndex(0);
        cbo_DatDoctor_HorSabado.setSelectedIndex(0);
        cbo_DatDoctor_HorDomingo.setSelectedIndex(0);
        
        txt_DatDoctor_Codigo.requestFocus();
    }
    
    
    
    
    
    private void modificar(){
         int indice = tbl_doctor.getSelectedRow();
           
        System.out.println("Indice  : "+indice);
        
        String cod=modelo.getValueAt(indice, 0).toString();
        System.out.println("Codigo: "+cod);
        
        String rutaTemporal="src\\pack_archivos\\doctor2.txt";
        File temporal = new File(rutaTemporal);
        
        try {
            FileOutputStream fo= new FileOutputStream(rutaTemporal,true);//edici[on del fichero 
            OutputStreamWriter ow = new OutputStreamWriter(fo);
            BufferedWriter bw = new BufferedWriter(ow);
            String contenido="";
            
        if(archivo.exists()){
            BufferedReader br=new BufferedReader(new FileReader(archivo));
            String linea;
          doctor doctor = new doctor();
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             if(cod.equals(datos[0])){
                 
                        doctor.setCodigo(txt_DatDoctor_Codigo.getText());
                        modelo.setValueAt(doctor.getCodigo(), indice, 0);
                        
                        doctor.setNombre(txt_DatDoctor_Nombres.getText());
                        modelo.setValueAt(doctor.getNombre(), indice, 1);
                        
                        doctor.setApellido_paterno(txt_DatDoctor_ApePaterno.getText());
                        modelo.setValueAt(doctor.getApellido_paterno(), indice, 2);
                        
                        doctor.setApellido_materno(txt_DatDoctor_ApeMaterno.getText());
                        modelo.setValueAt(doctor.getApellido_materno(), indice, 3);
                        
                         doctor.setFecha_nacimiento_dia(cbo_DatDoctor_Dia.getSelectedItem().toString());    
                        modelo.setValueAt(doctor.getFecha_nacimiento_dia(), indice, 4);
                        
                        doctor.setFecha_nacimiento_mes(cbo_DatDoctor_Mes.getSelectedItem().toString());                      
                        modelo.setValueAt(doctor.getFecha_nacimiento_mes(), indice, 5);
                        
                        doctor.setFecha_nacimiento_anio(cbo_DatDoctor_Anio.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getFecha_nacimiento_anio(), indice, 6);
                        
                        String sexo=null;
                            if(rb_doctor_maculino.isSelected())
                                sexo = "Masculino";
                            else if(rb_doctor_femenino.isSelected()){
                                sexo ="Femenino";
                            }
                       
                        modelo.setValueAt(sexo, indice, 7);
                        
                        
                                
                       doctor.setDni(txt_DatDoctor_Dni.getText());
                        modelo.setValueAt(doctor.getDni(), indice, 8);
                        
                    doctor.setCorreo(txt_DatDoctor_Correo.getText());
                        modelo.setValueAt(doctor.getCorreo(), indice, 9);
                        
                        doctor.setDireccion(txt_DatDoctor_Direccion.getText());
                        modelo.setValueAt(doctor.getDireccion(), indice, 10);
                        
                        
                        doctor.setTelefono(txt_DatDoctor_Telefono.getText());
                        modelo.setValueAt(doctor.getTelefono(), indice,11);
                        
                        doctor.setEspecialidad(cbo_DatDoctor_Especialidad.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getEspecialidad(), indice,12);
                        
                        
                         doctor.setHorario_lunes(cbo_DatDoctor_HorLunes.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getHorario_lunes(), indice,13);
                        
                        doctor.setHorario_martes(cbo_DatDoctor_HorMartes.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getHorario_martes(), indice,14);
                        
                        doctor.setHorario_miercoles(cbo_DatDoctor_HorMiercoles.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getHorario_miercoles(), indice,15);
                        
                        doctor.setHorario_jueves(cbo_DatDoctor_HorJueves.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getHorario_jueves(), indice,16);
                        
                        doctor.setHorario_viernes(cbo_DatDoctor_HorViernes.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getHorario_viernes(), indice,17);
                        
                        doctor.setHorario_sabado(cbo_DatDoctor_HorSabado.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getHorario_sabado(), indice,18);
                        
                        doctor.setHorario_domingo(cbo_DatDoctor_HorDomingo.getSelectedItem().toString());
                        modelo.setValueAt(doctor.getHorario_domingo(), indice,19);
                        
                        
                       
                      
                       
                        
                       
                        contenido = doctor.getCodigo()+ 
                           ";" + doctor.getNombre()+ 
                                   
                                      ";" + doctor.getApellido_paterno() +   
                                      ";" + doctor.getApellido_materno() + 
                                      ";" + doctor.getFecha_nacimiento_dia()+ 
                                   
                                      ";" + doctor.getFecha_nacimiento_mes()+ 
                                      ";" + doctor.getFecha_nacimiento_anio()+ 
                                      ";" + sexo+
                                      ";" + doctor.getDni()+
                                     
                                      ";" + doctor.getDireccion() +
                                      ";" + doctor.getCorreo() +
                                      ";" + doctor.getTelefono()+
                                      ";" + doctor.getEspecialidad()+
                                   
                                    ";" + doctor.getHorario_lunes() +
                                    ";" + doctor.getHorario_martes()+
                                    ";" + doctor.getHorario_miercoles()+
                                    ";" + doctor.getHorario_jueves()+
                                    ";" + doctor.getHorario_viernes() +
                                    ";" + doctor.getHorario_sabado()+
                                    ";" + doctor.getHorario_domingo();
                                     
         
          }else contenido=linea;
             bw.write(contenido+"\n");
         }
         
         bw.close();
         br.close();
         archivo.delete();
         temporal.renameTo(archivo);
         tbl_doctor.setModel(modelo);
         limpiar();
         }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        
    }
    
    
    
     private void buscar(String consulta, JTable jtableBuscar){
        DefaultTableModel dm;
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    
    
      
     
     private void eliminarRegistroFichero(String cod){
        String rutaTemporal="src\\pack_archivos\\temporal.txt";
        File temporal = new File(rutaTemporal);
        try {
            FileOutputStream fo= new FileOutputStream(rutaTemporal,true);//edici[on del fichero 
            OutputStreamWriter ow = new OutputStreamWriter(fo);
            BufferedWriter bw = new BufferedWriter(ow);
        if(fichero.exists()){
            BufferedReader br=new BufferedReader(new FileReader(fichero));
            String linea;
              doctor doctor = new doctor();
          
            
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             if(!cod.equals(datos[0])){
                 
                 doctor.setCodigo(datos[0]);
                 doctor.setNombre(datos[1]);
                 doctor.setApellido_paterno(datos[2]);
                 doctor.setApellido_materno(datos[3]);
                 
                 doctor.setFecha_nacimiento_dia(datos[4]);
                 doctor.setFecha_nacimiento_mes(datos[5]);
                 doctor.setFecha_nacimiento_anio(datos[6]);
                 doctor.setSexo(datos[7]);
                 doctor.setDni(datos[8]);
                 doctor.setCorreo(datos[9]);
                 doctor.setDireccion(datos[10]);
                 
                 doctor.setTelefono(datos[11]);
                 doctor.setEspecialidad(datos[12]);
                 
                 doctor.setHorario_lunes(datos[13]);
                 doctor.setHorario_martes(datos[14]);
                 doctor.setHorario_miercoles(datos[15]);
                 doctor.setHorario_jueves(datos[16]);
                 doctor.setHorario_viernes(datos[17]);
                 doctor.setHorario_sabado(datos[18]);
                 doctor.setHorario_domingo(datos[19]);
         

                  String contenido =doctor.getCodigo()+";"
                                     + doctor.getNombre()+ 
                                   
                                      ";" + doctor.getApellido_paterno() +   
                                      ";" + doctor.getApellido_materno() + 
                                      ";" + doctor.getFecha_nacimiento_dia()+ 
                                   
                                      ";" + doctor.getFecha_nacimiento_mes()+ 
                                      ";" + doctor.getFecha_nacimiento_anio()+ 
                                      ";" +doctor.getSexo()+
                                      ";" + doctor.getDni()+
                                     
                                      ";" + doctor.getDireccion() +
                                      ";" + doctor.getCorreo() +
                                      ";" + doctor.getTelefono()+
                                      ";" + doctor.getEspecialidad()+
                                   
                                    ";" + doctor.getHorario_lunes() +
                                    ";" + doctor.getHorario_martes()+
                                    ";" + doctor.getHorario_miercoles()+
                                    ";" + doctor.getHorario_jueves()+
                                    ";" + doctor.getHorario_viernes() +
                                    ";" + doctor.getHorario_sabado()+
                                    ";" + doctor.getHorario_domingo();
             
                            
                   
                    bw.write(contenido+"\n");
             }
         }
        
         bw.close();
         br.close();
         fichero.delete();
         temporal.renameTo(fichero);
         }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
     
   
    private void cargarRegistroEnLaTabla(){
        try {
            Object[] fila = new Object[20];
        if(archivo.exists()){
            BufferedReader br=new BufferedReader(new FileReader(archivo));
            //String cod=JOptionPane.showInputDialog("Ingrese codigo :");
            String linea;
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             fila[0]=datos[0];
             fila[1]=datos[1];
             fila[2]=datos[2];
             fila[3]=datos[3];
             fila[4]=datos[4];
             fila[5]=datos[5];
             fila[6]=datos[6];
             fila[7]=datos[7];
             fila[8]=datos[8];
             fila[9]=datos[9];
             
             fila[10]=datos[10];
             fila[11]=datos[11];
             fila[12]=datos[12];
             
             fila[13]=datos[13];
             fila[14]=datos[14];
             fila[15]=datos[15];
             fila[16]=datos[16];
             fila[17]=datos[17];
             fila[18]=datos[18];
             fila[19]=datos[19];
             
             
      
             /*
             fila[13]=datos[13];
             */
             modelo.addRow(fila);
             
         }
         tbl_doctor.setModel(modelo);
         br.close();
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        } 
    }
     
     
     
     
    public frm_registro_doctor() {
       initComponents();
        llenarTabla();
        llenarDia();
        llenarMes();
        llenarAnio();
       especialidad();
       lunes();
       martes();
       miercoles();
       jueves();
       viernes();
       sabado();
       domingo();
        cargarRegistroEnLaTabla();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_DatDoctor_ApeMaterno = new javax.swing.JTextField();
        txt_DatDoctor_Direccion = new javax.swing.JTextField();
        cbo_DatDoctor_Especialidad = new javax.swing.JComboBox<String>();
        cbo_DatDoctor_Dia = new javax.swing.JComboBox<String>();
        jPanel3 = new javax.swing.JPanel();
        rb_doctor_maculino = new javax.swing.JRadioButton();
        rb_doctor_femenino = new javax.swing.JRadioButton();
        txt_DatDoctor_Dni = new javax.swing.JTextField();
        txt_DatDoctor_Telefono = new javax.swing.JTextField();
        cbo_DatDoctor_Anio = new javax.swing.JComboBox<String>();
        txt_DatDoctor_Codigo = new javax.swing.JTextField();
        cbo_DatDoctor_Mes = new javax.swing.JComboBox<String>();
        txt_DatDoctor_ApePaterno = new javax.swing.JTextField();
        txt_DatDoctor_Correo = new javax.swing.JTextField();
        txt_DatDoctor_Nombres = new javax.swing.JTextField();
        btn_DatDoctor_Registrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbo_DatDoctor_HorLunes = new javax.swing.JComboBox<String>();
        cbo_DatDoctor_HorMartes = new javax.swing.JComboBox<String>();
        cbo_DatDoctor_HorMiercoles = new javax.swing.JComboBox<String>();
        cbo_DatDoctor_HorJueves = new javax.swing.JComboBox<String>();
        cbo_DatDoctor_HorViernes = new javax.swing.JComboBox<String>();
        cbo_DatDoctor_HorSabado = new javax.swing.JComboBox<String>();
        cbo_DatDoctor_HorDomingo = new javax.swing.JComboBox<String>();
        btn_DatDoctor_Modificar = new javax.swing.JButton();
        btn_DatDoctor_Eliminar = new javax.swing.JButton();
        btn_DatDoctor_Salir = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        btn_DatDoctor_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_doctor = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Registro de doctor");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "DATOS DEL DOCTOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 24))); // NOI18N

        jLabel1.setText("Nombres :");

        jLabel2.setText("Apellido Paterno:");

        jLabel7.setText("Fecha de Nacimiento :");

        jLabel3.setText("Telefono :");

        jLabel8.setText("Apellido Materno:");

        jLabel4.setText("DNI :");

        jLabel5.setText("Correo :");

        jLabel9.setText("Codigo :");

        jLabel10.setText("Direccion :");

        jLabel11.setText("Sexo :");

        jLabel12.setText("Especialidad:");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        rb_doctor_maculino.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(rb_doctor_maculino);
        rb_doctor_maculino.setText("Masculino");

        rb_doctor_femenino.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(rb_doctor_femenino);
        rb_doctor_femenino.setText("Femenino");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_doctor_maculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(rb_doctor_femenino)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_doctor_maculino)
                    .addComponent(rb_doctor_femenino)))
        );

        txt_DatDoctor_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DatDoctor_CodigoActionPerformed(evt);
            }
        });

        cbo_DatDoctor_Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_DatDoctor_MesActionPerformed(evt);
            }
        });

        txt_DatDoctor_Nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DatDoctor_NombresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_DatDoctor_Especialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cbo_DatDoctor_Dia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_DatDoctor_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_DatDoctor_Anio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txt_DatDoctor_ApeMaterno)
                            .addComponent(txt_DatDoctor_ApePaterno)
                            .addComponent(txt_DatDoctor_Nombres, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_DatDoctor_Dni)
                            .addComponent(txt_DatDoctor_Correo)
                            .addComponent(txt_DatDoctor_Direccion)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txt_DatDoctor_Codigo))
                            .addComponent(txt_DatDoctor_Telefono))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(60, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_DatDoctor_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DatDoctor_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DatDoctor_ApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DatDoctor_ApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_DatDoctor_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_DatDoctor_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_DatDoctor_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DatDoctor_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DatDoctor_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DatDoctor_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DatDoctor_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_DatDoctor_Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btn_DatDoctor_Registrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_DatDoctor_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/guardar1.0.png"))); // NOI18N
        btn_DatDoctor_Registrar.setText("GUARDAR");
        btn_DatDoctor_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatDoctor_RegistrarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "HORARIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 24))); // NOI18N

        jLabel13.setText("LUNES:");

        jLabel14.setText("MARTES:");

        jLabel15.setText("MIERCOLES:");

        jLabel16.setText("JUEVES:");

        jLabel17.setText("VIERNES:");

        jLabel18.setText("SABADO:");

        jLabel19.setText("DOMINGO:");

        cbo_DatDoctor_HorLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_DatDoctor_HorLunesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbo_DatDoctor_HorLunes, 0, 171, Short.MAX_VALUE)
                    .addComponent(cbo_DatDoctor_HorMartes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_DatDoctor_HorMiercoles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_DatDoctor_HorJueves, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_DatDoctor_HorViernes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_DatDoctor_HorSabado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_DatDoctor_HorDomingo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbo_DatDoctor_HorLunes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbo_DatDoctor_HorMartes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbo_DatDoctor_HorMiercoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbo_DatDoctor_HorJueves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbo_DatDoctor_HorViernes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbo_DatDoctor_HorSabado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbo_DatDoctor_HorDomingo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_DatDoctor_Modificar.setBackground(new java.awt.Color(255, 255, 255));
        btn_DatDoctor_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/modificar1.0.png"))); // NOI18N
        btn_DatDoctor_Modificar.setText("MODIFICAR");
        btn_DatDoctor_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatDoctor_ModificarActionPerformed(evt);
            }
        });

        btn_DatDoctor_Eliminar.setBackground(new java.awt.Color(255, 255, 255));
        btn_DatDoctor_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/eliminar1.0.png"))); // NOI18N
        btn_DatDoctor_Eliminar.setText("ELIMINAR");
        btn_DatDoctor_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatDoctor_EliminarActionPerformed(evt);
            }
        });

        btn_DatDoctor_Salir.setBackground(new java.awt.Color(255, 255, 255));
        btn_DatDoctor_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/cerrar1.0.png"))); // NOI18N
        btn_DatDoctor_Salir.setText("SALIR");
        btn_DatDoctor_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatDoctor_SalirActionPerformed(evt);
            }
        });

        btn_DatDoctor_Buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_DatDoctor_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/buscar1.0.png"))); // NOI18N
        btn_DatDoctor_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatDoctor_BuscarActionPerformed(evt);
            }
        });

        tbl_doctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_doctorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_doctor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_DatDoctor_Buscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_DatDoctor_Registrar)
                                            .addComponent(btn_DatDoctor_Eliminar))
                                        .addGap(69, 69, 69)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_DatDoctor_Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_DatDoctor_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_DatDoctor_Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_DatDoctor_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_DatDoctor_Eliminar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_DatDoctor_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_DatDoctor_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DatDoctor_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatDoctor_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_DatDoctor_SalirActionPerformed

    private void cbo_DatDoctor_HorLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_DatDoctor_HorLunesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_DatDoctor_HorLunesActionPerformed

    private void cbo_DatDoctor_MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_DatDoctor_MesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_DatDoctor_MesActionPerformed

    private void btn_DatDoctor_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatDoctor_RegistrarActionPerformed
     
       if(txt_DatDoctor_Codigo.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese Codigo");
            txt_DatDoctor_Codigo.requestFocus();
        }else if(txt_DatDoctor_Nombres.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
            txt_DatDoctor_Nombres.requestFocus();
        }else if(txt_DatDoctor_ApePaterno.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese apellido paterno");
            txt_DatDoctor_ApePaterno.requestFocus();
        }else if(txt_DatDoctor_Dni.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese DNI");
            txt_DatDoctor_Dni.requestFocus();
        }
       else if(cbo_DatDoctor_Especialidad.getSelectedItem().toString()=="SELECCIONE"){
            JOptionPane.showMessageDialog(null, "Seleciones Especialidad)");
            cbo_DatDoctor_Especialidad.setSelectedIndex(0);
        }
        else if(txt_DatDoctor_ApeMaterno.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Ingrese apellido materno");
            txt_DatDoctor_ApeMaterno.requestFocus();

        }else if(txt_DatDoctor_Direccion.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Ingrese Dirección");
            txt_DatDoctor_Direccion.requestFocus();
        }else if(txt_DatDoctor_Telefono.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese telefono");
            txt_DatDoctor_Telefono.requestFocus();
        }
        else if(txt_DatDoctor_Correo.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese Correo");
            txt_DatDoctor_Correo.requestFocus();
        }
        else if(cbo_DatDoctor_Dia.getSelectedItem().toString()=="Día"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(día)");
            cbo_DatDoctor_Dia.setSelectedIndex(0);
        }
        else if(cbo_DatDoctor_Mes.getSelectedItem().toString()=="Mes"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(mes)");
            cbo_DatDoctor_Mes.setSelectedIndex(0);
        }
        
        else if(cbo_DatDoctor_Anio.getSelectedItem().toString()=="Año"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(año)");
            cbo_DatDoctor_Anio.setSelectedIndex(0);
        }
        else if(rb_doctor_maculino.isSelected()==false && rb_doctor_femenino.isSelected()==false){
            JOptionPane.showMessageDialog(null,"Selecciones una opcion");
            buttonGroup1.clearSelection();
        }
        
        
        else{
            if(validarCodigo()){
               txt_DatDoctor_Codigo.setText("");
                txt_DatDoctor_Codigo.requestFocus();
           }
            else{
              registrarTabla();
                guardarArchivo();
                limpiar();
            }
        }   
        /*
        registrarTabla();
                guardarArchivo();
                limpiar();*/
    }//GEN-LAST:event_btn_DatDoctor_RegistrarActionPerformed

    private void btn_DatDoctor_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatDoctor_ModificarActionPerformed
          modificar();
    }//GEN-LAST:event_btn_DatDoctor_ModificarActionPerformed

    private void btn_DatDoctor_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatDoctor_EliminarActionPerformed
         int indice = tbl_doctor.getSelectedRow();
        String codigo = modelo.getValueAt(indice, 0).toString();
        System.out.println("Codigo: "+codigo);
        eliminarRegistroFichero(codigo);
        modelo.removeRow(indice);
        tbl_doctor.setModel(modelo);
    }//GEN-LAST:event_btn_DatDoctor_EliminarActionPerformed

    private void tbl_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_doctorMouseClicked
       
        
    int indice = tbl_doctor.getSelectedRow();

        txt_DatDoctor_Codigo.setText(modelo.getValueAt(indice, 0).toString());
         txt_DatDoctor_Nombres.setText(modelo.getValueAt(indice, 1).toString());
         txt_DatDoctor_ApePaterno.setText(modelo.getValueAt(indice, 2).toString());
        txt_DatDoctor_ApeMaterno.setText(modelo.getValueAt(indice, 3).toString());
        cbo_DatDoctor_Dia.setSelectedItem(modelo.getValueAt(indice, 4).toString());
        cbo_DatDoctor_Mes.setSelectedItem(modelo.getValueAt(indice, 5).toString());
        cbo_DatDoctor_Anio.setSelectedItem(modelo.getValueAt(indice, 6).toString());
        
        String sex = modelo.getValueAt(indice, 7).toString();
        if(sex.equals("Masculino"))
        rb_doctor_maculino.setSelected(true);
        else
        rb_doctor_femenino.setSelected(true);

        txt_DatDoctor_Dni.setText(modelo.getValueAt(indice, 8).toString());
         txt_DatDoctor_Correo.setText(modelo.getValueAt(indice, 9).toString());
        txt_DatDoctor_Direccion.setText(modelo.getValueAt(indice, 10).toString());
       
        txt_DatDoctor_Telefono.setText(modelo.getValueAt(indice, 11).toString());
         cbo_DatDoctor_Especialidad.setSelectedItem(modelo.getValueAt(indice, 12).toString());
         
         cbo_DatDoctor_HorLunes.setSelectedItem(modelo.getValueAt(indice, 13).toString());
         cbo_DatDoctor_HorMartes.setSelectedItem(modelo.getValueAt(indice, 14).toString());
         cbo_DatDoctor_HorMiercoles.setSelectedItem(modelo.getValueAt(indice, 15).toString());
         cbo_DatDoctor_HorJueves.setSelectedItem(modelo.getValueAt(indice, 16).toString());
         cbo_DatDoctor_HorViernes.setSelectedItem(modelo.getValueAt(indice, 17).toString());
         cbo_DatDoctor_HorSabado.setSelectedItem(modelo.getValueAt(indice, 18).toString());
         cbo_DatDoctor_HorDomingo.setSelectedItem(modelo.getValueAt(indice, 19).toString());
        
    }//GEN-LAST:event_tbl_doctorMouseClicked

    private void btn_DatDoctor_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatDoctor_BuscarActionPerformed
         buscar(txt_buscar.getText(), tbl_doctor);   
    }//GEN-LAST:event_btn_DatDoctor_BuscarActionPerformed

    private void txt_DatDoctor_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DatDoctor_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DatDoctor_CodigoActionPerformed

    private void txt_DatDoctor_NombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DatDoctor_NombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DatDoctor_NombresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DatDoctor_Buscar;
    private javax.swing.JButton btn_DatDoctor_Eliminar;
    private javax.swing.JButton btn_DatDoctor_Modificar;
    private javax.swing.JButton btn_DatDoctor_Registrar;
    private javax.swing.JButton btn_DatDoctor_Salir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_DatDoctor_Anio;
    private javax.swing.JComboBox<String> cbo_DatDoctor_Dia;
    private javax.swing.JComboBox<String> cbo_DatDoctor_Especialidad;
    private javax.swing.JComboBox<String> cbo_DatDoctor_HorDomingo;
    private javax.swing.JComboBox<String> cbo_DatDoctor_HorJueves;
    private javax.swing.JComboBox<String> cbo_DatDoctor_HorLunes;
    private javax.swing.JComboBox<String> cbo_DatDoctor_HorMartes;
    private javax.swing.JComboBox<String> cbo_DatDoctor_HorMiercoles;
    private javax.swing.JComboBox<String> cbo_DatDoctor_HorSabado;
    private javax.swing.JComboBox<String> cbo_DatDoctor_HorViernes;
    private javax.swing.JComboBox<String> cbo_DatDoctor_Mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rb_doctor_femenino;
    private javax.swing.JRadioButton rb_doctor_maculino;
    private javax.swing.JTable tbl_doctor;
    private javax.swing.JTextField txt_DatDoctor_ApeMaterno;
    private javax.swing.JTextField txt_DatDoctor_ApePaterno;
    private javax.swing.JTextField txt_DatDoctor_Codigo;
    private javax.swing.JTextField txt_DatDoctor_Correo;
    private javax.swing.JTextField txt_DatDoctor_Direccion;
    private javax.swing.JTextField txt_DatDoctor_Dni;
    private javax.swing.JTextField txt_DatDoctor_Nombres;
    private javax.swing.JTextField txt_DatDoctor_Telefono;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
