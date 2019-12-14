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
import pack_entidades.persona;
import pack_entidades.trabajador;

/**
 *
 * @author JHONNY BRYAN
 */
public class frm_trabajador extends javax.swing.JInternalFrame {

    
    
     String ruta="src\\pack_archivos\\trabajadores.txt";
    File fichero = new File(ruta);
    DefaultTableModel modelo = new DefaultTableModel();
    File archivo = new File("src\\pack_archivos\\trabajadores.txt");
    
    
    
    
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
        modelo.addColumn("Direccion");
        modelo.addColumn("Correo");
        
        modelo.addColumn("Telefono");
         modelo.addColumn("Contraseña");

        tbl_trabajador_Reporte.setModel(modelo);
    }
    
    
    
    
    
    private void llenarDia(){
        cbo_trabajador_Dia.addItem("Día");
        for (int i =1; i <=31; i++) {
            cbo_trabajador_Dia.addItem(String.valueOf(i));
        }
    }
    private void llenarMes(){
        cbo_trabajador_Mes.addItem("Mes");
        for (int i =1; i <=12; i++) {
            cbo_trabajador_Mes.addItem(String.valueOf(i));
        }
    }
    private void llenarAnio(){
        cbo_trabajador_Anio.addItem("Año");
        for (int i =1970; i <=2019; i++) {
            cbo_trabajador_Anio.addItem(String.valueOf(i));
        }
    }
    
    
    
    private void registrarTabla(){
      trabajador   trabajador = new trabajador();
                        
                         trabajador.setCodigo(txt_trabajador_codigo.getText());
                        trabajador.setNombre(txt_trabajador_nombre.getText());
                        trabajador.setApellido_paterno(txt_trabajador_ape_pat.getText());
                        trabajador.setApellido_materno(txt_trabajador_ape_mat.getText());
                 
                        trabajador.setFecha_nacimiento_dia(cbo_trabajador_Dia.getSelectedItem().toString());
                        trabajador.setFecha_nacimiento_mes(cbo_trabajador_Mes.getSelectedItem().toString());
                        trabajador.setFecha_nacimiento_anio(cbo_trabajador_Anio.getSelectedItem().toString());
                             
                        trabajador.setDni(txt_trabajador_DNI.getText());
                        trabajador.setCorreo(txt_trabajador_correo.getText());
                        trabajador.setDireccion(txt_trabajador_direccion.getText());
                        
                        trabajador.setTelefono(txt_trabajador_telefono.getText());
                        trabajador.setClave(txt_trabajador_contra.getText());
                        
                        
                           
        Object  fila[] = new Object[13];
        fila[0] = trabajador.getCodigo();
        fila[1] = trabajador.getNombre();
        fila[2] = trabajador.getApellido_paterno();
        fila[3] = trabajador.getApellido_materno();
        fila[4] = trabajador.getFecha_nacimiento_dia();
        fila[5] = trabajador.getFecha_nacimiento_mes();
        fila[6] = trabajador.getFecha_nacimiento_anio(); 
        fila[7] = trabajador.Sexo(rb_trabajador_maculino.isSelected(),rb_trabajador_femenino.isSelected());
        fila[8] = trabajador.getDni();
        
        
        fila[9] = trabajador.getCorreo();
        fila[10] = trabajador.getDireccion();
        
        fila[11] = trabajador.getTelefono();
         fila[12] = trabajador.getClave();


        modelo.addRow(fila); // asignar a la fila de la tabla
  
    }
    
    
     private void guardarArchivo(){
        FileWriter fw = null;
        PrintWriter pw = null;
		try {
			//crea el flujo para escribir en el archivo
			fw = new FileWriter("src\\pack_archivos\\trabajadores.txt",true);
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			pw = new PrintWriter(fw);
                        
                        trabajador trabajador = new trabajador();
                        
                        trabajador.setCodigo(txt_trabajador_codigo.getText());
                        trabajador.setNombre(txt_trabajador_nombre.getText());
                        trabajador.setApellido_paterno(txt_trabajador_ape_pat.getText());
                        trabajador.setApellido_materno(txt_trabajador_ape_mat.getText());
                 
                        trabajador.setFecha_nacimiento_dia(cbo_trabajador_Dia.getSelectedItem().toString());
                        trabajador.setFecha_nacimiento_mes(cbo_trabajador_Mes.getSelectedItem().toString());
                        trabajador.setFecha_nacimiento_anio(cbo_trabajador_Anio.getSelectedItem().toString());
                             
                        trabajador.setDni(txt_trabajador_DNI.getText());
                        trabajador.setCorreo(txt_trabajador_correo.getText());
                        trabajador.setDireccion(txt_trabajador_direccion.getText());
                        
                        trabajador.setTelefono(txt_trabajador_telefono.getText());
                        trabajador.setClave(txt_trabajador_contra.getText());
                     
                        
                        
                           pw.println(trabajador.getCodigo() + 
                                   
                                      ";" + trabajador.getNombre()+ 
                                   
                                      ";" + trabajador.getApellido_paterno() +   
                                      ";" + trabajador.getApellido_materno() + 
                                    ";" + trabajador.getFecha_nacimiento_dia()+ 
                                   
                                      ";" + trabajador.getFecha_nacimiento_mes()+ 
                                      ";" + trabajador.getFecha_nacimiento_anio()+ 
                                      ";" + trabajador.Sexo(rb_trabajador_maculino.isSelected(),rb_trabajador_femenino.isSelected()) + 
                                   ";" + trabajador.getDni()+
                                     
                                      ";" + trabajador.getDireccion() +
                                      ";" + trabajador.getCorreo() +
                                      ";" + trabajador.getTelefono()+
                                      ";" + trabajador.Clave()
                          
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
                String codigo = txt_trabajador_codigo.getText();
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
        txt_trabajador_codigo.setText("");
        txt_trabajador_nombre.setText("");
        txt_trabajador_ape_pat.setText("");
        txt_trabajador_ape_mat.setText("");  
        cbo_trabajador_Dia.setSelectedIndex(0);
        cbo_trabajador_Mes.setSelectedIndex(0);
        cbo_trabajador_Anio.setSelectedIndex(0);
        buttonGroup1_sexo.clearSelection();
        txt_trabajador_DNI.setText("");
        txt_trabajador_correo.setText("");
        txt_trabajador_direccion.setText("");
        txt_trabajador_telefono.setText("");
        txt_trabajador_contra.setText("");
        txt_trabajador_nombre.requestFocus();
    }
    
    
      
    
    private void modificar(){
         int indice = tbl_trabajador_Reporte.getSelectedRow();
           
        System.out.println("Indice  : "+indice);
        
        String cod=modelo.getValueAt(indice, 0).toString();
        System.out.println("Codigo: "+cod);
        
        String rutaTemporal="src\\pack_archivos\\trabajador2.txt";
        File temporal = new File(rutaTemporal);
        
        try {
            FileOutputStream fo= new FileOutputStream(rutaTemporal,true);//edici[on del fichero 
            OutputStreamWriter ow = new OutputStreamWriter(fo);
            BufferedWriter bw = new BufferedWriter(ow);
            String contenido="";
            
        if(archivo.exists()){
            BufferedReader br=new BufferedReader(new FileReader(archivo));
            String linea;
            trabajador trabajador = new trabajador();
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             if(cod.equals(datos[0])){
                 
                        trabajador.setCodigo(txt_trabajador_codigo.getText());
                        modelo.setValueAt(trabajador.getCodigo(), indice, 0);
                        
                        trabajador.setNombre(txt_trabajador_nombre.getText());
                        modelo.setValueAt(trabajador.getNombre(), indice, 1);
                        
                        trabajador.setApellido_paterno(txt_trabajador_ape_pat.getText());
                        modelo.setValueAt(trabajador.getApellido_paterno(), indice, 2);
                        
                        trabajador.setApellido_materno(txt_trabajador_ape_mat.getText());
                        modelo.setValueAt(trabajador.getApellido_materno(), indice, 3);
                        
                         trabajador.setFecha_nacimiento_dia(cbo_trabajador_Dia.getSelectedItem().toString());    
                        modelo.setValueAt(trabajador.getFecha_nacimiento_dia(), indice, 4);
                        
                        trabajador.setFecha_nacimiento_mes(cbo_trabajador_Mes.getSelectedItem().toString());                      
                        modelo.setValueAt(trabajador.getFecha_nacimiento_mes(), indice, 5);
                        
                        trabajador.setFecha_nacimiento_anio(cbo_trabajador_Anio.getSelectedItem().toString());
                        modelo.setValueAt(trabajador.getFecha_nacimiento_anio(), indice, 6);
                        
                        String sexo=null;
                            if(rb_trabajador_maculino.isSelected())
                                sexo = "Masculino";
                            else if(rb_trabajador_femenino.isSelected()){
                                sexo ="Femenino";
                            }
                       
                        modelo.setValueAt(sexo, indice, 7);
                        
                        
                                
                       trabajador.setDni(txt_trabajador_DNI.getText());
                        modelo.setValueAt(trabajador.getDni(), indice, 8);
                        
                    trabajador.setCorreo(txt_trabajador_correo.getText());
                        modelo.setValueAt(trabajador.getCorreo(), indice, 9);
                        
                        trabajador.setDireccion(txt_trabajador_direccion.getText());
                        modelo.setValueAt(trabajador.getDireccion(), indice, 10);
                        
                        
                        trabajador.setTelefono(txt_trabajador_telefono.getText());
                        modelo.setValueAt(trabajador.getTelefono(), indice,11);
                        
                         trabajador.setClave(txt_trabajador_contra.getText());
                        modelo.setValueAt(trabajador.getClave(), indice,12);
                       
                      
                       
                        
                       
                        contenido = trabajador.getCodigo()+ 
                            ";" + trabajador.getNombre()+ 
                                   
                            ";" + trabajador.getApellido_paterno() +   
                            ";" + trabajador.getApellido_materno() + 
                            ";" + trabajador.getFecha_nacimiento_dia()+ 
                            ";" + trabajador.getFecha_nacimiento_mes()+ 
                            ";" + trabajador.getFecha_nacimiento_anio()+ 
                            ";" + sexo + 
                            ";" + trabajador.getDni()+
                            ";" + trabajador.getDireccion() +
                            ";" + trabajador.getCorreo() +
                            ";" + trabajador.getTelefono()+
                            ";" + trabajador.Clave();
         
          }else contenido=linea;
             bw.write(contenido+"\n");
         }
         
         bw.close();
         br.close();
         archivo.delete();
         temporal.renameTo(archivo);
         tbl_trabajador_Reporte.setModel(modelo);
         limpiar();
         }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        
    }
    
    
    
        private void contra(){
        String letra_nombre=txt_trabajador_nombre.getText().substring(0, 1);
        String letra_apellido_paterno=txt_trabajador_ape_pat.getText().substring(0, 1);
        String letra_apellido_materno=txt_trabajador_ape_mat.getText().substring(0, 1);
        txt_trabajador_contra.setText(letra_nombre+letra_apellido_paterno+letra_apellido_materno+cbo_trabajador_Dia.getSelectedItem().toString()+cbo_trabajador_Mes.getSelectedItem().toString()+cbo_trabajador_Anio.getSelectedItem().toString());
        
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
            persona persona = new persona();
            trabajador trabajador=new trabajador();
            
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             if(!cod.equals(datos[0])){
                 
                 trabajador.setCodigo(datos[0]);
                 trabajador.setNombre(datos[1]);
                 trabajador.setApellido_paterno(datos[2]);
                 trabajador.setApellido_materno(datos[3]);
                 
                 trabajador.setFecha_nacimiento_dia(datos[4]);
                 trabajador.setFecha_nacimiento_mes(datos[5]);
                 trabajador.setFecha_nacimiento_anio(datos[6]);
                 trabajador.setSexo(datos[7]);
                 trabajador.setDni(datos[8]);
                 trabajador.setCorreo(datos[9]);
                 trabajador.setDireccion(datos[10]);
                 
                 trabajador.setTelefono(datos[11]);
                 trabajador.setClave(datos[12]);
         

                  String contenido =trabajador.getCodigo()+";"
                                    +trabajador.getNombre()+";"
                                    +trabajador.getApellido_paterno()+";"
      
                                    +trabajador.getApellido_materno()+";"
                                    +trabajador.getFecha_nacimiento_dia()+";"
                                    +trabajador.getFecha_nacimiento_mes()+";" 
                                    +trabajador.getFecha_nacimiento_anio()+";"
                                    +trabajador.getSexo()+";"
                                    +trabajador.getDni()+";"
                                    +trabajador.getCorreo()+";"
                          
//+persona.getFecha_nacimiento()+";"  
                                    +trabajador.getDireccion()+";"
                                    
                                    +trabajador.getTelefono()+";"

                 
                 
                 +trabajador.getClave();
             
                            
                   
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
            Object[] fila = new Object[13];
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
      
             /*
             fila[13]=datos[13];
             */
             modelo.addRow(fila);
             
         }
         tbl_trabajador_Reporte.setModel(modelo);
         br.close();
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        } 
    }
    
     
     
     
     
    
    public frm_trabajador() {
        initComponents();
        llenarTabla();
        llenarDia();
        llenarMes();
        llenarAnio();

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

        buttonGroup1_sexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbo_trabajador_Dia = new javax.swing.JComboBox<>();
        cbo_trabajador_Mes = new javax.swing.JComboBox<>();
        cbo_trabajador_Anio = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rb_trabajador_maculino = new javax.swing.JRadioButton();
        rb_trabajador_femenino = new javax.swing.JRadioButton();
        txt_trabajador_contra = new javax.swing.JTextField();
        btn_trabajador_generar_contra = new javax.swing.JButton();
        txt_trabajador_codigo = new javax.swing.JTextField();
        txt_trabajador_nombre = new javax.swing.JTextField();
        txt_trabajador_ape_pat = new javax.swing.JTextField();
        txt_trabajador_ape_mat = new javax.swing.JTextField();
        txt_trabajador_DNI = new javax.swing.JTextField();
        txt_trabajador_correo = new javax.swing.JTextField();
        txt_trabajador_direccion = new javax.swing.JTextField();
        txt_trabajador_telefono = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_trabajador_Reporte = new javax.swing.JTable();
        btn_trabajador_Registrar = new javax.swing.JButton();
        btn_trabajador_modificar = new javax.swing.JButton();
        btn_trabajador_eliminar = new javax.swing.JButton();
        btn_trabajador_salir = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        btn_trabajador_buscar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "DATOS DEL TRABAJADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 24))); // NOI18N

        jLabel1.setText("Nombres :");

        jLabel2.setText("Apellido Paterno:");

        jLabel7.setText("Fecha de Nacimiento :");

        jLabel3.setText("Telefono :");

        jLabel8.setText("Apellido Materno:");

        jLabel4.setText("DNI :");

        jLabel5.setText("Correo :");

        jLabel6.setText("Contraseña :");

        jLabel9.setText("Codigo :");

        cbo_trabajador_Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trabajador_MesActionPerformed(evt);
            }
        });

        jLabel10.setText("Direccion :");

        jLabel11.setText("Sexo :");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        rb_trabajador_maculino.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1_sexo.add(rb_trabajador_maculino);
        rb_trabajador_maculino.setText("Masculino");

        rb_trabajador_femenino.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1_sexo.add(rb_trabajador_femenino);
        rb_trabajador_femenino.setText("Femenino");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rb_trabajador_maculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(rb_trabajador_femenino)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_trabajador_maculino)
                    .addComponent(rb_trabajador_femenino)))
        );

        btn_trabajador_generar_contra.setBackground(new java.awt.Color(255, 255, 102));
        btn_trabajador_generar_contra.setText("GENERAR CONTRASEÑA");
        btn_trabajador_generar_contra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabajador_generar_contraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_trabajador_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trabajador_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trabajador_ape_pat, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trabajador_ape_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbo_trabajador_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_trabajador_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_trabajador_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_trabajador_generar_contra, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_trabajador_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_trabajador_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_trabajador_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_trabajador_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txt_trabajador_contra, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_trabajador_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_trabajador_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_trabajador_ape_pat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_trabajador_ape_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbo_trabajador_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_trabajador_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_trabajador_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_trabajador_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_trabajador_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_trabajador_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_trabajador_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(btn_trabajador_generar_contra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_trabajador_contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );

        tbl_trabajador_Reporte.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_trabajador_Reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_trabajador_ReporteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_trabajador_Reporte);

        btn_trabajador_Registrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_trabajador_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/guardar1.0.png"))); // NOI18N
        btn_trabajador_Registrar.setText("REGISTRAR");
        btn_trabajador_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabajador_RegistrarActionPerformed(evt);
            }
        });

        btn_trabajador_modificar.setBackground(new java.awt.Color(255, 255, 255));
        btn_trabajador_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/modificar1.0.png"))); // NOI18N
        btn_trabajador_modificar.setText("MODIFICAR");
        btn_trabajador_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabajador_modificarActionPerformed(evt);
            }
        });

        btn_trabajador_eliminar.setBackground(new java.awt.Color(255, 255, 255));
        btn_trabajador_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/eliminar1.0.png"))); // NOI18N
        btn_trabajador_eliminar.setText("ELIMINAR");
        btn_trabajador_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabajador_eliminarActionPerformed(evt);
            }
        });

        btn_trabajador_salir.setBackground(new java.awt.Color(255, 255, 255));
        btn_trabajador_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/cerrar1.0.png"))); // NOI18N
        btn_trabajador_salir.setText("SALIR");
        btn_trabajador_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabajador_salirActionPerformed(evt);
            }
        });

        btn_trabajador_buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_trabajador_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/buscar1.0.png"))); // NOI18N
        btn_trabajador_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabajador_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_trabajador_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_trabajador_Registrar)
                                .addGap(39, 39, 39)
                                .addComponent(btn_trabajador_modificar)
                                .addGap(52, 52, 52)
                                .addComponent(btn_trabajador_eliminar)))
                        .addGap(68, 68, 68)
                        .addComponent(btn_trabajador_salir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_trabajador_modificar)
                    .addComponent(btn_trabajador_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_trabajador_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_trabajador_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_trabajador_buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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

    private void cbo_trabajador_MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trabajador_MesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_trabajador_MesActionPerformed

    private void btn_trabajador_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabajador_RegistrarActionPerformed

        
            if(txt_trabajador_codigo.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese Codigo");
            txt_trabajador_codigo.requestFocus();
        }else if(txt_trabajador_nombre.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
            txt_trabajador_nombre.requestFocus();
        }else if(txt_trabajador_ape_pat.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese apellido paterno");
            txt_trabajador_ape_pat.requestFocus();
        }else if(txt_trabajador_DNI.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese DNI");
            txt_trabajador_DNI.requestFocus();
        }
       
        else if(txt_trabajador_ape_mat.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Ingrese apellido materno");
            txt_trabajador_ape_mat.requestFocus();

        }else if(txt_trabajador_direccion.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Ingrese Dirección");
            txt_trabajador_direccion.requestFocus();
        }else if(txt_trabajador_telefono.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese telefono");
            txt_trabajador_telefono.requestFocus();
        }
        else if(txt_trabajador_correo.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese Correo");
            txt_trabajador_correo.requestFocus();
        }
        else if(cbo_trabajador_Dia.getSelectedItem().toString()=="Día"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(día)");
            cbo_trabajador_Dia.setSelectedIndex(0);
        }
        else if(cbo_trabajador_Mes.getSelectedItem().toString()=="Mes"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(mes)");
            cbo_trabajador_Mes.setSelectedIndex(0);
        }
        
        else if(cbo_trabajador_Anio.getSelectedItem().toString()=="Año"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(año)");
            cbo_trabajador_Anio.setSelectedIndex(0);
        }
        else if(rb_trabajador_maculino.isSelected()==false && rb_trabajador_femenino.isSelected()==false){
            JOptionPane.showMessageDialog(null,"Selecciones una opcion");
            buttonGroup1_sexo.clearSelection();
        }
        
        
        else{
            if(validarCodigo()){
               txt_trabajador_codigo.setText("");
                txt_trabajador_codigo.requestFocus();
           }
            else{
              registrarTabla();
                guardarArchivo();
                limpiar();
            }
        }   
    }//GEN-LAST:event_btn_trabajador_RegistrarActionPerformed

    private void btn_trabajador_generar_contraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabajador_generar_contraActionPerformed
         contra();
        
    }//GEN-LAST:event_btn_trabajador_generar_contraActionPerformed

    private void btn_trabajador_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabajador_modificarActionPerformed
         modificar();
    }//GEN-LAST:event_btn_trabajador_modificarActionPerformed

    private void btn_trabajador_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabajador_eliminarActionPerformed
         int indice = tbl_trabajador_Reporte.getSelectedRow();
        String codigo = modelo.getValueAt(indice, 0).toString();
        System.out.println("Codigo: "+codigo);
        eliminarRegistroFichero(codigo);
        modelo.removeRow(indice);
        tbl_trabajador_Reporte.setModel(modelo);
    }//GEN-LAST:event_btn_trabajador_eliminarActionPerformed

    private void btn_trabajador_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabajador_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_trabajador_salirActionPerformed

    private void tbl_trabajador_ReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_trabajador_ReporteMouseClicked
        
        
    int indice = tbl_trabajador_Reporte.getSelectedRow();

        txt_trabajador_codigo.setText(modelo.getValueAt(indice, 0).toString());
        txt_trabajador_nombre.setText(modelo.getValueAt(indice, 1).toString());
        txt_trabajador_ape_pat.setText(modelo.getValueAt(indice, 2).toString());
        txt_trabajador_ape_mat.setText(modelo.getValueAt(indice, 3).toString());
        cbo_trabajador_Dia.setSelectedItem(modelo.getValueAt(indice, 4).toString());
        cbo_trabajador_Mes.setSelectedItem(modelo.getValueAt(indice, 5).toString());
        cbo_trabajador_Anio.setSelectedItem(modelo.getValueAt(indice, 6).toString());
        
        String sex = modelo.getValueAt(indice, 7).toString();
        if(sex.equals("Masculino"))
        rb_trabajador_maculino.setSelected(true);
        else
        rb_trabajador_femenino.setSelected(true);

        txt_trabajador_DNI.setText(modelo.getValueAt(indice, 8).toString());
         txt_trabajador_correo.setText(modelo.getValueAt(indice, 9).toString());
        txt_trabajador_direccion.setText(modelo.getValueAt(indice, 10).toString());
       
        txt_trabajador_telefono.setText(modelo.getValueAt(indice, 11).toString());
        txt_trabajador_contra.setText(modelo.getValueAt(indice, 12).toString());
        
        
        
    }//GEN-LAST:event_tbl_trabajador_ReporteMouseClicked

    private void btn_trabajador_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabajador_buscarActionPerformed
           buscar(txt_buscar.getText(), tbl_trabajador_Reporte);      

    }//GEN-LAST:event_btn_trabajador_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_trabajador_Registrar;
    private javax.swing.JButton btn_trabajador_buscar;
    private javax.swing.JButton btn_trabajador_eliminar;
    private javax.swing.JButton btn_trabajador_generar_contra;
    private javax.swing.JButton btn_trabajador_modificar;
    private javax.swing.JButton btn_trabajador_salir;
    private javax.swing.ButtonGroup buttonGroup1_sexo;
    private javax.swing.JComboBox<String> cbo_trabajador_Anio;
    private javax.swing.JComboBox<String> cbo_trabajador_Dia;
    private javax.swing.JComboBox<String> cbo_trabajador_Mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rb_trabajador_femenino;
    private javax.swing.JRadioButton rb_trabajador_maculino;
    private javax.swing.JTable tbl_trabajador_Reporte;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_trabajador_DNI;
    private javax.swing.JTextField txt_trabajador_ape_mat;
    private javax.swing.JTextField txt_trabajador_ape_pat;
    private javax.swing.JTextField txt_trabajador_codigo;
    private javax.swing.JTextField txt_trabajador_contra;
    private javax.swing.JTextField txt_trabajador_correo;
    private javax.swing.JTextField txt_trabajador_direccion;
    private javax.swing.JTextField txt_trabajador_nombre;
    private javax.swing.JTextField txt_trabajador_telefono;
    // End of variables declaration//GEN-END:variables
}
