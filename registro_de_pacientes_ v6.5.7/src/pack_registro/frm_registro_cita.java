/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_registro;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pack_entidades.cita_medica;
import pack_entidades.doctor;
import pack_entidades.paciente;
import pack_entidades.trabajador;

/**
 *
 * @author magna
 */
public class frm_registro_cita extends javax.swing.JInternalFrame {

       
    
    
    
  DefaultTableModel modelo = new DefaultTableModel();
       Calendar fecha = Calendar.getInstance();
   String ruta="src\\pack_archivos\\citas.txt";
    File fichero = new File(ruta);

    File archivo = new File("src\\pack_archivos\\citas.txt"); 
    
    /*variable fecha*/
    
  int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
    
        
        
    private void ColumnasTabla(){  
        
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");      
        modelo.addColumn("Apellido");
        modelo.addColumn("edad");
        
        modelo.addColumn("codigo");
        modelo.addColumn("nombre");
        modelo.addColumn("apellidos");
        modelo.addColumn("especialidad");
        modelo.addColumn("correo");
        modelo.addColumn("telefono");
        
        modelo.addColumn("codigo cita");
        modelo.addColumn("fecha de cita");
         modelo.addColumn("fecha de atencion");
         
        
        tbl_cita.setModel(modelo);
        
        try{
           File archivo = new File("src\\pack_archivos\\citas.txt");
           
           if(archivo.exists()){
               
               FileReader reader = new FileReader(archivo);
               BufferedReader br = new BufferedReader(reader);
               
               String linea;
               while((linea=br.readLine())!= null){
                   
                   StringTokenizer token = new StringTokenizer(linea,";");
                   
                   
                   String dni_p = token.nextToken().trim();
                   String nombre_p = token.nextToken().trim();
                   String apellido_p = token.nextToken().trim();
                   String sexo_p = token.nextToken().trim();
   
                  
                   
                   String codigo_d= token.nextToken().trim();
                   String nombre_d= token.nextToken().trim();
                   String apellidos_d = token.nextToken().trim();
                   String especialidad_d = token.nextToken().trim();
                   
                   String correo_d = token.nextToken().trim();
                   String telefono_d = token.nextToken().trim();
                   
                   String codigo_c = token.nextToken().trim();
                   String fecha_c = token.nextToken().trim();
                   String atencion_c = token.nextToken().trim();
                   
                    Object[] obj = new Object[]{
                    dni_p,nombre_p,apellido_p,sexo_p,codigo_d,nombre_d,apellidos_d,especialidad_d,correo_d,telefono_d,codigo_c,fecha_c,atencion_c
                   };
                    modelo.addRow(obj);
               }
               br.close();
           }
           else{
               JOptionPane.showMessageDialog(null,"No se encuentra el archivo\n" + archivo.getName());
           }
       
       }

       catch(IOException ex){
           JOptionPane.showMessageDialog(null, "Error al leer el archivo:\n" + ex.getMessage());
       }
       
    }
    
    
     private void buscar(String consulta, JTable jtableBuscar){
        DefaultTableModel dm;
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    
    
     private void guardarArchivo(){
        FileWriter fw = null;
        PrintWriter pw = null;
		try {
			//crea el flujo para escribir en el archivo
			fw = new FileWriter("src\\pack_archivos\\citas.txt",true);
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			pw = new PrintWriter(fw);
                        
                        doctor doctor =new doctor();
                        paciente paciente =new paciente();
                        
                         cita_medica cita =new cita_medica();
                  
                 
                        paciente.setDni(txt_cita_paciente_dni.getText());
                        paciente.setNombre(txt_cita_paciente_nombre.getText());
                        paciente.setApellido_paterno(txt_cita_paciente_apellido.getText());
                        paciente.setSexo(txt_cita_paciente_sexo.getText());
                        
                        doctor.setCodigo(txt_cita_doctor_codigo.getText());
                        doctor.setNombre(txt_cita_doctor_nombre.getText());
                        doctor.setApellido_paterno(txt_cita_doctor_apellido.getText());
                        doctor.setEspecialidad(txt_cita_doctor_especialidad.getText());
                        doctor.setCorreo(txt_cita_doctor_correo.getText());
                        doctor.setTelefono(txt_cita_doctor_telefono.getText());
                        
                        
                        
                        cita.setCod_cita(txt_cita_codigo.getText());
                        cita.setFecha_cita(txt_cita_fecha_actual.getText());
                        cita.setFecha_atencion(txt_cita_fecha_atencion.getText());
                        
                        
                        
               
             
                        
                           pw.println( paciente.getDni()+ 
                                      ";" + paciente.getNombre() + 
                                      ";" + paciente.getApellido_paterno()+ 
                                      ";"+paciente.getSexo()+
                                   
                                      ";"+doctor.getCodigo()+
                                      ";"+doctor.getNombre()+
                                      ";"+doctor.getApellido_paterno()+
                                      ";"+doctor.getEspecialidad()+
                                      ";"+doctor.getCorreo()+
                                      ";"+doctor.getTelefono()+
                                   
                                      ";"+cita.getCod_cita()+
                                      ";"+cita.getFecha_cita()+
                                        ";"+cita.getFecha_atencion());
                          
                        

			//cierra el buffer intermedio
			pw.close();
                        JOptionPane.showMessageDialog(null, "Se Registro Correctamente");
			//System.out.println("Archivo creado satisfactoriamente..");
                }            
		catch (IOException e) {
                      JOptionPane.showMessageDialog(null,e.getMessage());
		}
    
    }
     
    private void llenarFecha(){
        
   
        txt_cita_fecha_actual.setText( dia + "/" + (mes+1)  + "/" + anio);
    }

    
    
    
private void registrarTabla(){
        doctor doctor = new doctor();
        paciente paciente = new paciente();
        cita_medica cita = new cita_medica();
                        
                      
                        
                        paciente.setDni(txt_cita_paciente_dni.getText());
                        paciente.setNombre(txt_cita_paciente_nombre.getText());
                        paciente.setApellido_paterno(txt_cita_paciente_apellido.getText());
                        paciente.setSexo(txt_cita_paciente_sexo.getText());
                        
                       doctor.setCodigo(txt_cita_doctor_codigo.getText());
                        doctor.setNombre(txt_cita_doctor_nombre.getText());
                        doctor.setApellido_paterno(txt_cita_doctor_apellido.getText());
                        doctor.setEspecialidad(txt_cita_doctor_especialidad.getText());
                        doctor.setCorreo(txt_cita_doctor_correo.getText());
                        doctor.setTelefono(txt_cita_doctor_telefono.getText());
                        
                        cita.setCod_cita(txt_cita_codigo.getText());
                        cita.setFecha_cita(txt_cita_fecha_actual.getText());
                        cita.setFecha_atencion(txt_cita_fecha_atencion.getText());
                        
                             
        Object  fila[] = new Object[13];
        fila[0] = paciente.getDni();
        fila[1] = paciente.getNombre();
        fila[2] = paciente.getApellido_paterno();
        fila[3] = paciente.getSexo();
        
        fila[4] = doctor.getCodigo();
        fila[5] = doctor.getNombre();
        fila[6] = doctor.getApellido_paterno();
        
        fila[7] = doctor.getEspecialidad();
        fila[8] = doctor.getCorreo();
        fila[9] = doctor.getTelefono();
        
        fila[10] = cita.getCod_cita();
        fila[11] = cita.getFecha_cita();
        fila[12] = cita.getFecha_atencion();
        
        
        modelo.addRow(fila); // asignar a la fila de la tabla
    }
    
        
private void limpiar(){
    txt_cita_paciente_dni.setText("");
    txt_cita_paciente_nombre.setText("");
    txt_cita_paciente_apellido.setText("");
    txt_cita_paciente_sexo.setText("");
    
    txt_cita_doctor_codigo.setText("");
    txt_cita_doctor_nombre.setText("");
    txt_cita_doctor_apellido.setText("");
  
    txt_cita_doctor_especialidad.setText("");
    txt_cita_doctor_telefono.setText("");
    txt_cita_doctor_correo.setText("");

    
   
     txt_cita_codigo.setText("");
     txt_cita_fecha_actual.setText(dia + "/" + (mes+1)  + "/" + anio);
    txt_cita_fecha_atencion.setText("");
     
 
}
   
     

    private void modificar(){
        int indice = tbl_cita.getSelectedRow();
        System.out.println("Indice  : "+indice);
        
        String cod=modelo.getValueAt(indice, 0).toString();
        System.out.println("Codigo: "+cod);
        
        String rutaTemporal="src\\pack_archivos\\citas2.txt";
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
        paciente paciente = new paciente();
        cita_medica cita = new cita_medica();
            
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             if(cod.equals(datos[0])){
                 
                        paciente.setDni(txt_cita_paciente_dni.getText());
                        modelo.setValueAt(paciente.getDni(), indice, 0);
                        
                        paciente.setNombre(txt_cita_paciente_nombre.getText());
                        modelo.setValueAt(paciente.getNombre(), indice, 1);
                        
                        paciente.setApellido_paterno(txt_cita_paciente_apellido.getText());
                        modelo.setValueAt(paciente.getApellido_paterno(), indice, 2);
                        
                        paciente.setSexo(txt_cita_paciente_sexo.getText());
                        modelo.setValueAt(paciente.getSexo(), indice, 3);
                        
                        
                        
                        doctor.setCodigo(txt_cita_doctor_codigo.getText());
                        modelo.setValueAt(doctor.getCodigo(), indice, 4);
                        
                        doctor.setNombre(txt_cita_doctor_nombre.getText());
                        modelo.setValueAt(doctor.getNombre(), indice, 5);
                        
                        doctor.setApellido_paterno(txt_cita_doctor_apellido.getText());
                        modelo.setValueAt(doctor.getApellido_paterno(), indice, 6);
                        
                         doctor.setEspecialidad(txt_cita_doctor_especialidad.getText());
                        modelo.setValueAt(doctor.getEspecialidad(), indice, 7);
                        
                        doctor.setCorreo(txt_cita_doctor_correo.getText());
                        modelo.setValueAt(doctor.getCorreo(), indice, 8);
                        
                        doctor.setTelefono(txt_cita_doctor_telefono.getText());
                        modelo.setValueAt(doctor.getTelefono(), indice, 9);
                        
                        
                        
                        
                        cita.setCod_cita(txt_cita_codigo.getText());
                        modelo.setValueAt(cita.getCod_cita(), indice, 10);
                        
                        cita.setFecha_cita(txt_cita_fecha_actual.getText());
                        modelo.setValueAt(cita.getFecha_cita(), indice, 11);
                        
                        cita.setFecha_atencion(txt_cita_fecha_atencion.getText());
                        modelo.setValueAt(cita.getFecha_atencion(), indice, 12);
                        
                       
                        
                       
                        contenido = paciente.getDni()+ 
                                      ";" + paciente.getNombre() + 
                                      ";" + paciente.getApellido_paterno()+ 
                                      ";"+paciente.getSexo()+
                                   
                                      ";"+doctor.getCodigo()+
                                      ";"+doctor.getNombre()+
                                      ";"+doctor.getApellido_paterno()+
                                      ";"+doctor.getEspecialidad()+
                                      ";"+doctor.getCorreo()+
                                      ";"+doctor.getTelefono()+
                                   
                                      ";"+cita.getCod_cita()+
                                      ";"+cita.getFecha_cita()+
                                        ";"+cita.getFecha_atencion();
                                
                                
                             
                                      
                       
                   
            }else contenido=linea;
             bw.write(contenido+"\n");
         }
         
         bw.close();
         br.close();
         archivo.delete();
         temporal.renameTo(archivo);
         tbl_cita.setModel(modelo);
         limpiar();
         }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }



/*
        private void ListarEspecialodades(){
        cbo_cita_doctor_especialidad.addItem("Seleccione");
        cbo_cita_doctor_especialidad.addItem("PEDIATRIA");
        cbo_cita_doctor_especialidad.addItem("REUMATOLOGIA");
        cbo_cita_doctor_especialidad.addItem("ENDOCRINOLOGIA");
        cbo_cita_doctor_especialidad.addItem("NEFROLOGIA");
        cbo_cita_doctor_especialidad.addItem("TRAUMATOLOGIA");
        cbo_cita_doctor_especialidad.addItem("CARDIOLOGIA");
        cbo_cita_doctor_especialidad.addItem("OFTALMOLOGIA");
        cbo_cita_doctor_especialidad.addItem("UROLOGIA");
        
    }
  */
    
    
    private void GenerarPDF(){
        String ruta = "src\\pack_registro_pdf\\PDFREGISTRO";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
            Document doc = new Document(); 
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            doc.add(new Paragraph(
                    "\t\t\n=================="+
                    "\t\t\n    CITA MEDICA  "+
                    "\t\t\n=================="+
                            
                    "\t\nCodigo De La Cita:\t\t\t"+ txt_cita_codigo.getText()+
                    "\t\nFecha De La Cita:\t\t"+txt_cita_fecha_actual.getText()+
                    "\t\nFecha De Atencion:\t\t"+txt_cita_fecha_atencion.getText()+ 
                            
                    "\t\nDNI Del Paciente:\t\t"+ txt_cita_paciente_dni.getText()+
                    "\t\nNombre Del Paciente:\t\t"+ txt_cita_paciente_nombre.getText()+
                    "\t\nApellido Del Paciente:\t\t\t"+ txt_cita_paciente_apellido.getText()+
                    "\t\nSexo Del Paciente:\t\t\t"+ txt_cita_paciente_sexo.getText()+
                            
                    "\t\nCodigo Del Doctor:\t\t\t"+ txt_cita_doctor_codigo.getText()+
                    "\t\nNombre Del Doctor:\t\t"+ txt_cita_doctor_nombre.getText()+
                    "\t\nApellido Del Doctor:\t"+ txt_cita_doctor_apellido.getText()+
                    "\t\nEspecialidad Del Doctor:\t\t"+ txt_cita_doctor_especialidad.getText()+
                    "\t\nCorreo Del Doctor:\t\t"+ txt_cita_doctor_correo.getText()+
                    "\t\nTelefono Del Doctor:\t"+ txt_cita_doctor_telefono.getText()
                            
                           
                    ));
            
            doc.close();
        } catch (Exception e) {
        }
        
    } 
  
    
    
      
public void bloquear(){
  txt_cita_paciente_dni.setEditable(false); 
  txt_cita_paciente_nombre.setEditable(false);
  txt_cita_paciente_apellido.setEditable(false);  
  txt_cita_paciente_sexo.setEditable(false); 
  
txt_cita_doctor_codigo.setEditable(false);
txt_cita_doctor_nombre.setEditable(false);
txt_cita_doctor_apellido.setEditable(false);
txt_cita_doctor_especialidad.setEditable(false);
txt_cita_doctor_correo.setEditable(false);
txt_cita_doctor_telefono.setEditable(false);

txt_cita_fecha_actual.setEditable(false);

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
        paciente paciente = new paciente();
        cita_medica cita = new cita_medica();
            
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             if(!cod.equals(datos[0])){
                 
                 paciente.setDni(datos[0]);
                 paciente.setNombre(datos[1]);
                 paciente.setApellido_paterno(datos[2]);
                 paciente.setSexo(datos[3]);
                 
                 doctor.setCodigo(datos[4]);
                 doctor.setNombre(datos[5]);
                 doctor.setApellido_paterno(datos[6]);
                 doctor.setEspecialidad(datos[7]);
            
                 doctor.setCorreo(datos[8]);
                 doctor.setTelefono(datos[9]);
                 
                 
                 cita.setCod_cita(datos[10]);
                 cita.setFecha_cita(datos[11]);
                cita.setFecha_atencion(datos[12]);
                 
                 
                  String contenido = 
                          paciente.getDni()+ 
                                      ";" + paciente.getNombre() + 
                                      ";" + paciente.getApellido_paterno()+ 
                                      ";"+paciente.getSexo()+
                                   
                                      ";"+doctor.getCodigo()+
                                      ";"+doctor.getNombre()+
                                      ";"+doctor.getApellido_paterno()+
                                      ";"+doctor.getEspecialidad()+
                                      ";"+doctor.getCorreo()+
                                      ";"+doctor.getTelefono()+
                                   
                                      ";"+cita.getCod_cita()+
                                      ";"+cita.getFecha_cita()+
                                        ";"+cita.getFecha_atencion();
             
                            
                   
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
    
    
    
    public frm_registro_cita() {
        initComponents();
           ColumnasTabla();
         setResizable(false);
         
         bloquear();
        llenarFecha();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cita = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cita_paciente_apellido = new javax.swing.JTextField();
        txt_cita_paciente_nombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cita_paciente_dni = new javax.swing.JTextField();
        txt_cita_paciente_sexo = new javax.swing.JTextField();
        btn_paciente_buscar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_doctor_buscar = new javax.swing.JButton();
        txt_cita_doctor_codigo = new javax.swing.JTextField();
        txt_cita_doctor_nombre = new javax.swing.JTextField();
        txt_cita_doctor_apellido = new javax.swing.JTextField();
        txt_cita_doctor_especialidad = new javax.swing.JTextField();
        txt_cita_doctor_correo = new javax.swing.JTextField();
        txt_cita_doctor_telefono = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txt_cita_fecha_actual = new javax.swing.JTextField();
        txt_cita_codigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_cita_fecha_atencion = new javax.swing.JTextField();
        btn_importar_pdf = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        btn_DatPaciente_Buscar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE CITA MEDICA");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/actualizar1.0.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/eliminar1.0.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/cerrar1.0.png"))); // NOI18N
        btnCerrar.setText("SALIR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        tbl_cita.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_cita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_citaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cita);

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Paciente"));

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Sexo");

        jLabel9.setText("DNI : ");

        btn_paciente_buscar.setText("BUSCAR");
        btn_paciente_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paciente_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cita_paciente_sexo, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txt_cita_paciente_apellido)
                            .addComponent(txt_cita_paciente_nombre)
                            .addComponent(txt_cita_paciente_dni)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btn_paciente_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btn_paciente_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cita_paciente_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_cita_paciente_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_cita_paciente_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cita_paciente_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        btnGrabar.setBackground(new java.awt.Color(255, 255, 255));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/guardar1.0.png"))); // NOI18N
        btnGrabar.setText("GUARDAR");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Medico(a)"));

        jLabel8.setText("Nombres");

        jLabel16.setText("Apellidos:");

        jLabel17.setText("Especialidad:");

        jLabel18.setText("Correo:");

        jLabel19.setText("Telefono:");

        jLabel12.setText("codigo :");

        btn_doctor_buscar.setText("BUSCAR");
        btn_doctor_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doctor_buscarActionPerformed(evt);
            }
        });

        txt_cita_doctor_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cita_doctor_telefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel16)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel8))
                            .addComponent(jLabel17))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cita_doctor_codigo)
                                    .addComponent(txt_cita_doctor_nombre)
                                    .addComponent(txt_cita_doctor_apellido)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cita_doctor_correo)
                                    .addComponent(txt_cita_doctor_especialidad)
                                    .addComponent(txt_cita_doctor_telefono)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 82, Short.MAX_VALUE)
                .addComponent(btn_doctor_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btn_doctor_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_cita_doctor_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_cita_doctor_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_cita_doctor_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_cita_doctor_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_cita_doctor_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cita_doctor_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos De La Cita Medica"));

        jLabel6.setText("fecha de la cita :");

        jLabel2.setText("Cod.Cita:");

        jLabel11.setText("fecha  de  Atencion :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cita_codigo)
                            .addComponent(txt_cita_fecha_actual)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cita_fecha_atencion, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cita_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_cita_fecha_actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txt_cita_fecha_atencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btn_importar_pdf.setBackground(new java.awt.Color(255, 255, 51));
        btn_importar_pdf.setText("IMPOTAR PDF");
        btn_importar_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importar_pdfActionPerformed(evt);
            }
        });

        btn_DatPaciente_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/buscar1.0.png"))); // NOI18N
        btn_DatPaciente_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatPaciente_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnGrabar)
                        .addGap(69, 69, 69)
                        .addComponent(btnEliminar)
                        .addGap(56, 56, 56)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_importar_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnCerrar)
                        .addGap(67, 67, 67))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_DatPaciente_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_importar_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGrabar))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_DatPaciente_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    
        int indice = tbl_cita.getSelectedRow();
        String codigo = modelo.getValueAt(indice, 0).toString();
        System.out.println("Codigo: "+codigo);
        eliminarRegistroFichero(codigo);
        modelo.removeRow(indice);
        tbl_cita.setModel(modelo);
        limpiar(); 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();    
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
      if(txt_cita_codigo.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else if(txt_cita_paciente_dni.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else if(txt_cita_doctor_codigo.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else if(txt_cita_fecha_atencion.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else{
         
                registrarTabla();
                guardarArchivo();
               GenerarPDF();  
                limpiar(); 
        }
      
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btn_paciente_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paciente_buscarActionPerformed
       
        File archivo = new File("src\\pack_archivos\\pacientes.txt");
       
        try{
           if(archivo.exists())
            {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String codigo = JOptionPane.showInputDialog("Ingrese DNI: ");
                String Linea;
                while((Linea = br.readLine())!=null)
                {
                    String[] datos = Linea.split(";");
                    if(codigo.equals(datos[0]))
                    {
                   txt_cita_paciente_dni.setText(datos[0]);
                        txt_cita_paciente_nombre.setText(datos[1]);
                        txt_cita_paciente_apellido.setText(datos[2]);
                        txt_cita_paciente_sexo.setText(datos[7]);
                      
                    }
                }
                br.close();
            } 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Incorrecto");
        }
        
        
        
    }//GEN-LAST:event_btn_paciente_buscarActionPerformed

    private void btn_doctor_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doctor_buscarActionPerformed
         File archivo = new File("src\\pack_archivos\\doctores.txt");
       
        try{
           if(archivo.exists())
            {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String codigo = JOptionPane.showInputDialog("Ingrese codigo: ");
                String Linea;
                while((Linea = br.readLine())!=null)
                {
                    String[] datos = Linea.split(";");
                    if(codigo.equals(datos[0]))
                    {
                   txt_cita_doctor_codigo.setText(datos[0]);
                        txt_cita_doctor_nombre.setText(datos[1]);
                        txt_cita_doctor_apellido.setText(datos[3]);
                        txt_cita_doctor_especialidad.setText(datos[12]);
                        txt_cita_doctor_correo.setText(datos[9]);
                        txt_cita_doctor_telefono.setText(datos[11]);
                 
              
                      
                    }
                }
                br.close();
            } 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Incorrecto");
        }
    }//GEN-LAST:event_btn_doctor_buscarActionPerformed

    private void tbl_citaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_citaMouseClicked
       
          int indice = tbl_cita.getSelectedRow();

        txt_cita_paciente_dni.setText(modelo.getValueAt(indice, 0).toString());
        txt_cita_paciente_nombre.setText(modelo.getValueAt(indice, 1).toString());
        txt_cita_paciente_apellido.setText(modelo.getValueAt(indice, 2).toString());
        txt_cita_paciente_sexo.setText(modelo.getValueAt(indice, 3).toString());
        
        txt_cita_doctor_codigo.setText(modelo.getValueAt(indice, 4).toString());
        txt_cita_doctor_nombre.setText(modelo.getValueAt(indice, 5).toString());
        txt_cita_doctor_apellido.setText(modelo.getValueAt(indice, 6).toString());
        
        txt_cita_doctor_especialidad.setText(modelo.getValueAt(indice, 7).toString());
        txt_cita_doctor_correo.setText(modelo.getValueAt(indice, 8).toString());
        txt_cita_doctor_telefono.setText(modelo.getValueAt(indice, 9).toString());
        
        txt_cita_codigo.setText(modelo.getValueAt(indice, 10).toString());
        txt_cita_fecha_actual.setText(modelo.getValueAt(indice, 11).toString());
        txt_cita_fecha_atencion.setText(modelo.getValueAt(indice, 12).toString());
       
        
        
        
        
        
    }//GEN-LAST:event_tbl_citaMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(txt_cita_codigo.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else if(txt_cita_paciente_dni.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else if(txt_cita_doctor_codigo.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else if(txt_cita_fecha_atencion.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else{
        
         modificar();
        
        limpiar();
        
    } 
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btn_DatPaciente_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatPaciente_BuscarActionPerformed
        buscar(txt_buscar.getText(), tbl_cita);
    }//GEN-LAST:event_btn_DatPaciente_BuscarActionPerformed

    private void txt_cita_doctor_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cita_doctor_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cita_doctor_telefonoActionPerformed

    private void btn_importar_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_importar_pdfActionPerformed
         // TODO add your handling code here:
        try{
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"src\\pack_registro_pdf\\PDFREGISTRO.PDF");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Check file details");
        }
    }//GEN-LAST:event_btn_importar_pdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btn_DatPaciente_Buscar;
    private javax.swing.JButton btn_doctor_buscar;
    private javax.swing.JButton btn_importar_pdf;
    private javax.swing.JButton btn_paciente_buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cita;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cita_codigo;
    private javax.swing.JTextField txt_cita_doctor_apellido;
    private javax.swing.JTextField txt_cita_doctor_codigo;
    private javax.swing.JTextField txt_cita_doctor_correo;
    private javax.swing.JTextField txt_cita_doctor_especialidad;
    private javax.swing.JTextField txt_cita_doctor_nombre;
    private javax.swing.JTextField txt_cita_doctor_telefono;
    private javax.swing.JTextField txt_cita_fecha_actual;
    private javax.swing.JTextField txt_cita_fecha_atencion;
    private javax.swing.JTextField txt_cita_paciente_apellido;
    private javax.swing.JTextField txt_cita_paciente_dni;
    private javax.swing.JTextField txt_cita_paciente_nombre;
    private javax.swing.JTextField txt_cita_paciente_sexo;
    // End of variables declaration//GEN-END:variables
}
