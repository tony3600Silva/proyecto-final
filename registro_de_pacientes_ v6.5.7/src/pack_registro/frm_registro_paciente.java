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
import pack_entidades.paciente;
import pack_entidades.persona;

/**
 *
 * @author UPN
 */
public class frm_registro_paciente extends javax.swing.JInternalFrame {

    
      String ruta="src\\pack_archivos\\pacientes.txt";
    File fichero = new File(ruta);
    DefaultTableModel modelo = new DefaultTableModel();
    File archivo = new File("src\\pack_archivos\\pacientes.txt");
    
     private void llenarTabla(){
        modelo.addColumn("Dni");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido paterno");
        modelo.addColumn("Apellido materno");
        modelo.addColumn("N_dia");
        modelo.addColumn("N_mes");
        modelo.addColumn("N_año");
        modelo.addColumn("Sexo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Peso");
        modelo.addColumn("Altura");
        modelo.addColumn("Tipo Sangre");
        modelo.addColumn("Alergias");

        tbl_paciente.setModel(modelo);
    }
    
    
    
    private void llenarDia(){
        cbo_DatPac_Dia.addItem("Día");
        for (int i =1; i <=31; i++) {
            cbo_DatPac_Dia.addItem(String.valueOf(i));
        }
    }
    private void llenarMes(){
        cbo_DatPac_Mes.addItem("Mes");
        for (int i =1; i <=12; i++) {
            cbo_DatPac_Mes.addItem(String.valueOf(i));
        }
    }
    private void llenarAnio(){
        cbo_DatPac_Anio.addItem("Año");
        for (int i =1970; i <=2019; i++) {
            cbo_DatPac_Anio.addItem(String.valueOf(i));
        }
    }
    
    private void tipoSangre(){
        cbo_DatPaciente_TipSangre.addItem("Seleccione");
        cbo_DatPaciente_TipSangre.addItem("O+");
        cbo_DatPaciente_TipSangre.addItem("O-");
        cbo_DatPaciente_TipSangre.addItem("A+");
        cbo_DatPaciente_TipSangre.addItem("A-");
        cbo_DatPaciente_TipSangre.addItem("B+");
        cbo_DatPaciente_TipSangre.addItem("B-");
        cbo_DatPaciente_TipSangre.addItem("AB+");
        cbo_DatPaciente_TipSangre.addItem("AB-");
        
    }
    
    
    
    
    private void registrarTabla(){
        paciente paciente= new paciente();
                        
                        paciente.setDni(txt_DatPaciente_Dni.getText());
                        paciente.setNombre(txt_DatPaciente_Nombre.getText());
                        paciente.setApellido_paterno(txt_DatPaciente_ApePaterno.getText());
                        paciente.setApellido_materno(txt_DatPaciente_ApeMaterno.getText());
                 
                        paciente.setFecha_nacimiento_dia(cbo_DatPac_Dia.getSelectedItem().toString());
                        paciente.setFecha_nacimiento_mes(cbo_DatPac_Mes.getSelectedItem().toString());
                        paciente.setFecha_nacimiento_anio(cbo_DatPac_Anio.getSelectedItem().toString());

                        paciente.setTelefono(txt_DatPaciente_Telefono.getText());
                        paciente.setPeso(Double.parseDouble(txt_DatPaciente_Peso.getText()));
                        paciente.setAltura(Double.parseDouble(txt_DatPaciente_altura.getText()));
                        paciente.setTipo_sangre(cbo_DatPaciente_TipSangre.getSelectedItem().toString());
                        paciente.setAlergias(txt_DatPaciente_Alergias.getText());
                        
                           
        Object  fila[] = new Object[13];
        fila[0] = paciente.getDni();
        fila[1] = paciente.getNombre();
        fila[2] = paciente.getApellido_paterno();
        fila[3] = paciente.getApellido_materno();
        fila[4] = paciente.getFecha_nacimiento_dia();
        fila[5] = paciente.getFecha_nacimiento_mes();
        fila[6] = paciente.getFecha_nacimiento_anio(); 
        fila[7] = paciente.Sexo(rbn_DatPac_Masculina.isSelected(),rbn_DatPac_Femenino.isSelected());
        fila[8] = paciente.getTelefono();
        fila[9] = paciente.getPeso();
        fila[10] = paciente.getAltura();
        fila[11] = paciente.getTipo_sangre();
        fila[12] = paciente.getAlergias();


        modelo.addRow(fila); // asignar a la fila de la tabla
  
    }
    
    
    
    
    
    
    private void guardarArchivo(){
        FileWriter fw = null;
        PrintWriter pw = null;
		try {
			//crea el flujo para escribir en el archivo
			fw = new FileWriter("src\\pack_archivos\\pacientes.txt",true);
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			pw = new PrintWriter(fw);
                        
                        paciente paciente= new paciente();
                        
                        paciente.setDni(txt_DatPaciente_Dni.getText());
                        paciente.setNombre(txt_DatPaciente_Nombre.getText());
                        paciente.setApellido_paterno(txt_DatPaciente_ApePaterno.getText());
                        paciente.setApellido_materno(txt_DatPaciente_ApeMaterno.getText());
                 
                        paciente.setFecha_nacimiento_dia(cbo_DatPac_Dia.getSelectedItem().toString());
                        paciente.setFecha_nacimiento_mes(cbo_DatPac_Mes.getSelectedItem().toString());
                        paciente.setFecha_nacimiento_anio(cbo_DatPac_Anio.getSelectedItem().toString());

                        paciente.setTelefono(txt_DatPaciente_Telefono.getText());
                        paciente.setPeso(Double.parseDouble(txt_DatPaciente_Peso.getText()));
                        paciente.setAltura(Double.parseDouble(txt_DatPaciente_altura.getText()));
                        paciente.setTipo_sangre(cbo_DatPaciente_TipSangre.getSelectedItem().toString());
                        paciente.setAlergias(txt_DatPaciente_Alergias.getText());
                     
                        
                        
                           pw.println(paciente.getDni() + 
                                      ";" + paciente.getNombre()+ 
                                      ";" + paciente.getApellido_paterno() +   
                                      ";" + paciente.getApellido_materno() + 
                                      ";" + paciente.getFecha_nacimiento_dia()+ 
                                      ";" + paciente.getFecha_nacimiento_mes()+ 
                                      ";" + paciente.getFecha_nacimiento_anio()+ 
                                      ";" + paciente.Sexo(rbn_DatPac_Masculina.isSelected(),rbn_DatPac_Femenino.isSelected()) + 
                                      ";" + paciente.getTelefono()+
                                      ";" + paciente.getPeso() +
                                      ";" + paciente.getAltura() +
                                      ";" + paciente.getTipo_sangre()+
                                      ";" + paciente.getAlergias()
                          
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
    
    
    private void limpiar(){
        txt_DatPaciente_Dni.setText("");
        txt_DatPaciente_Nombre.setText("");
        txt_DatPaciente_ApePaterno.setText("");
        txt_DatPaciente_ApeMaterno.setText("");  
        cbo_DatPac_Dia.setSelectedIndex(0);
        cbo_DatPac_Mes.setSelectedIndex(0);
        cbo_DatPac_Anio.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        txt_DatPaciente_Telefono.setText("");
        txt_DatPaciente_Peso.setText("");
        txt_DatPaciente_altura.setText("");
        cbo_DatPaciente_TipSangre.setSelectedIndex(0);
        txt_DatPaciente_Alergias.setText("");
        txt_DatPaciente_Dni.requestFocus();
    }
    
    private void modificar(){
         int indice = tbl_paciente.getSelectedRow();
           
        System.out.println("Indice  : "+indice);
        
        String dni=modelo.getValueAt(indice, 0).toString();
        System.out.println("Dni: "+dni);
        
        String rutaTemporal="src\\pack_archivos\\pacientes2.txt";
        File temporal = new File(rutaTemporal);
        
        try {
            FileOutputStream fo= new FileOutputStream(rutaTemporal,true);//edici[on del fichero 
            OutputStreamWriter ow = new OutputStreamWriter(fo);
            BufferedWriter bw = new BufferedWriter(ow);
            String contenido="";
            
        if(archivo.exists()){
            BufferedReader br=new BufferedReader(new FileReader(archivo));
            String linea;
            paciente paciente= new paciente();
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             if(dni.equals(datos[0])){
                 
                        paciente.setDni(txt_DatPaciente_Dni.getText());
                        modelo.setValueAt(paciente.getDni(), indice, 0);
                        
                        paciente.setNombre(txt_DatPaciente_Nombre.getText());
                        modelo.setValueAt(paciente.getNombre(), indice, 1);
                        
                        paciente.setApellido_paterno(txt_DatPaciente_ApePaterno.getText());
                        modelo.setValueAt(paciente.getApellido_paterno(), indice, 2);
                        
                        paciente.setApellido_materno(txt_DatPaciente_ApeMaterno.getText());
                        modelo.setValueAt(paciente.getApellido_materno(), indice, 3);
                        
                         paciente.setFecha_nacimiento_dia(cbo_DatPac_Dia.getSelectedItem().toString());    
                        modelo.setValueAt(paciente.getFecha_nacimiento_dia(), indice, 4);
                        
                        paciente.setFecha_nacimiento_mes(cbo_DatPac_Mes.getSelectedItem().toString());                      
                        modelo.setValueAt(paciente.getFecha_nacimiento_mes(), indice, 5);
                        
                        paciente.setFecha_nacimiento_anio(cbo_DatPac_Anio.getSelectedItem().toString());
                        modelo.setValueAt(paciente.getFecha_nacimiento_anio(), indice, 6);
                        
                        String sexo=null;
                            if(rbn_DatPac_Masculina.isSelected())
                                sexo = "Masculino";
                            else if(rbn_DatPac_Femenino.isSelected()){
                                sexo ="Femenino";
                            }
                       
                        modelo.setValueAt(sexo, indice, 7);
                        
                        
                                
                       paciente.setTelefono(txt_DatPaciente_Telefono.getText());
                        modelo.setValueAt(paciente.getTelefono(), indice, 8);
                        
                    paciente.setPeso(Double.parseDouble(txt_DatPaciente_Peso.getText()));
                        modelo.setValueAt(paciente.getPeso(), indice, 9);
                        
                        paciente.setAltura(Double.parseDouble(txt_DatPaciente_altura.getText()));
                        modelo.setValueAt(paciente.getAltura(), indice, 10);
                        
                        
                        paciente.setTipo_sangre(cbo_DatPaciente_TipSangre.getSelectedItem().toString());
                        modelo.setValueAt(paciente.getTipo_sangre(), indice,11);
                        
                         paciente.setAlergias(txt_DatPaciente_Alergias.getText());
                        modelo.setValueAt(paciente.getAlergias(), indice,12);
                       
                      
                       
                        
                       
                        contenido = paciente.getDni()+ 
                            ";" + paciente.getNombre()+ 
                                   
                            ";" + paciente.getApellido_paterno() +   
                            ";" + paciente.getApellido_materno() + 
                            ";" + paciente.getFecha_nacimiento_dia()+ 
                            ";" + paciente.getFecha_nacimiento_mes()+ 
                            ";" + paciente.getFecha_nacimiento_anio()+ 
                            ";" + sexo + 
                            ";" + paciente.getTelefono()+
                            ";" + paciente.getPeso() +
                            ";" + paciente.getAltura() +
                            ";" + paciente.getTipo_sangre()+
                            ";" + paciente.getAlergias();
         
          }else contenido=linea;
             bw.write(contenido+"\n");
         }
         
         bw.close();
         br.close();
         archivo.delete();
         temporal.renameTo(archivo);
         tbl_paciente.setModel(modelo);
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
            persona persona = new persona();
            paciente paciente=new paciente();
            
         while((linea=br.readLine())!=null){
             String[] datos=linea.split(";");
             if(!cod.equals(datos[0])){
                 
                 paciente.setDni(datos[0]);
                 paciente.setNombre(datos[1]);
                 paciente.setApellido_paterno(datos[2]);
                 paciente.setApellido_materno(datos[3]);
                 paciente.setFecha_nacimiento_dia(datos[4]);
                 paciente.setFecha_nacimiento_mes(datos[5]);
                 paciente.setFecha_nacimiento_anio(datos[6]);
                 paciente.setSexo(datos[7]);
                 paciente.setTelefono(datos[8]);
                 paciente.setPeso(Double.parseDouble(datos[9]));
                 paciente.setAltura(Double.parseDouble(datos[10]));
                 paciente.setTipo_sangre(datos[11]);
                 paciente.setAlergias(datos[12]);
         

                  String contenido =paciente.getDni()+";"
                                    +paciente.getNombre()+";"
                                    +paciente.getApellido_paterno()+";"
                                    +paciente.getApellido_materno()+";"
                                    +paciente.getFecha_nacimiento_dia()+";"
                                    +paciente.getFecha_nacimiento_mes()+";" 
                                    +paciente.getFecha_nacimiento_anio()+";"
                                    +paciente.getSexo()+";"
                                    +paciente.getTelefono()+";"
                                    +paciente.getPeso()+";"
                                    +paciente.getAltura()+";"
                                    +paciente.getTipo_sangre()+";"
                                    +paciente.getAlergias();
             
                            
                   
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
         tbl_paciente.setModel(modelo);
         br.close();
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        } 
    }
    
    
    
    
    private boolean validardni(){
       boolean encontrado = false;
        try{
           if(archivo.exists())
            {
                
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String codigo = txt_DatPaciente_Dni.getText();
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
    
    
    
    
    public frm_registro_paciente() {
      initComponents();
        llenarTabla();
        llenarDia();
        llenarMes();
        llenarAnio();
        tipoSangre();
        
        cargarRegistroEnLaTabla();
    }

    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField8 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_DatPaciente_Peso = new javax.swing.JTextField();
        txt_DatPaciente_altura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_DatPaciente_Alergias = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_DatPaciente_Dni = new javax.swing.JTextField();
        txt_DatPaciente_Nombre = new javax.swing.JTextField();
        txt_DatPaciente_ApeMaterno = new javax.swing.JTextField();
        txt_DatPaciente_ApePaterno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_DatPaciente_Telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbo_DatPac_Dia = new javax.swing.JComboBox<String>();
        cbo_DatPac_Mes = new javax.swing.JComboBox<String>();
        cbo_DatPac_Anio = new javax.swing.JComboBox<String>();
        jPanel4 = new javax.swing.JPanel();
        rbn_DatPac_Masculina = new javax.swing.JRadioButton();
        rbn_DatPac_Femenino = new javax.swing.JRadioButton();
        cbo_DatPaciente_TipSangre = new javax.swing.JComboBox<String>();
        btn_DatPaciente_Registrar = new javax.swing.JButton();
        btn_DatPaciente_Modificar = new javax.swing.JButton();
        btn_DatPaciente_Eliminar = new javax.swing.JButton();
        btn_DatPaciente_Salir = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        btn_DatPaciente_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_paciente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Registro de pacientes");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Datos del Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 24))); // NOI18N

        jLabel8.setText("Telefono:");

        jLabel1.setText("Nombre:");

        jLabel4.setText("Peso:");

        txt_DatPaciente_Alergias.setColumns(20);
        txt_DatPaciente_Alergias.setRows(5);
        txt_DatPaciente_Alergias.setText("(NINGUNO)");
        jScrollPane1.setViewportView(txt_DatPaciente_Alergias);

        jLabel2.setText("Apellido Paterno:");

        jLabel9.setText("Altura:");

        jLabel3.setText("Apellido Materno:");

        jLabel10.setText("Tipo de sangre:");

        jLabel5.setText("DNI:");

        jLabel11.setText("Alergias:");

        jLabel6.setText("Fecha de nacimiento:");

        jLabel7.setText("Sexo:");

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        buttonGroup1.add(rbn_DatPac_Masculina);
        rbn_DatPac_Masculina.setText("Masculino");

        buttonGroup1.add(rbn_DatPac_Femenino);
        rbn_DatPac_Femenino.setText("Femenino");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(rbn_DatPac_Masculina, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(rbn_DatPac_Femenino))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbn_DatPac_Masculina)
                    .addComponent(rbn_DatPac_Femenino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_DatPaciente_Nombre)
                            .addComponent(txt_DatPaciente_Dni)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(txt_DatPaciente_ApePaterno))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(txt_DatPaciente_ApeMaterno))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_DatPaciente_Telefono)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbo_DatPac_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_DatPac_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbo_DatPac_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 36, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbo_DatPaciente_TipSangre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_DatPaciente_altura, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(txt_DatPaciente_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(txt_DatPaciente_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DatPaciente_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(txt_DatPaciente_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DatPaciente_altura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txt_DatPaciente_ApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_DatPaciente_TipSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(txt_DatPaciente_ApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbo_DatPac_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_DatPac_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_DatPac_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_DatPaciente_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_DatPaciente_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/guardar1.0.png"))); // NOI18N
        btn_DatPaciente_Registrar.setText("REGISTRAR");
        btn_DatPaciente_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatPaciente_RegistrarActionPerformed(evt);
            }
        });

        btn_DatPaciente_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/modificar1.0.png"))); // NOI18N
        btn_DatPaciente_Modificar.setText("MODIFICAR");
        btn_DatPaciente_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatPaciente_ModificarActionPerformed(evt);
            }
        });

        btn_DatPaciente_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/eliminar1.0.png"))); // NOI18N
        btn_DatPaciente_Eliminar.setText("ELIMINAR");
        btn_DatPaciente_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatPaciente_EliminarActionPerformed(evt);
            }
        });

        btn_DatPaciente_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/cerrar1.0.png"))); // NOI18N
        btn_DatPaciente_Salir.setText("SALIR");
        btn_DatPaciente_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatPaciente_SalirActionPerformed(evt);
            }
        });

        btn_DatPaciente_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack_imabotones/buscar1.0.png"))); // NOI18N
        btn_DatPaciente_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatPaciente_BuscarActionPerformed(evt);
            }
        });

        tbl_paciente.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pacienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_paciente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_DatPaciente_Registrar)
                                .addGap(35, 35, 35)
                                .addComponent(btn_DatPaciente_Modificar)
                                .addGap(39, 39, 39)
                                .addComponent(btn_DatPaciente_Eliminar)
                                .addGap(32, 32, 32)
                                .addComponent(btn_DatPaciente_Salir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_DatPaciente_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_DatPaciente_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_DatPaciente_Eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_DatPaciente_Modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btn_DatPaciente_Registrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_DatPaciente_Buscar)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DatPaciente_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatPaciente_RegistrarActionPerformed
      
        
        
        
          if(txt_DatPaciente_Dni.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese DNI");
            txt_DatPaciente_Dni.requestFocus();
        }else if(txt_DatPaciente_Nombre.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
            txt_DatPaciente_Nombre.requestFocus();
        }else if(txt_DatPaciente_ApePaterno.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese apellido paterno");
            txt_DatPaciente_ApePaterno.requestFocus();
        }
       
        else if(txt_DatPaciente_ApeMaterno.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Ingrese apellido materno");
            txt_DatPaciente_ApeMaterno.requestFocus();

        }else if(txt_DatPaciente_Peso.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Ingrese Peso");
            txt_DatPaciente_Peso.requestFocus();
        }else if(txt_DatPaciente_Telefono.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese telefono");
            txt_DatPaciente_Telefono.requestFocus();
        }
        else if(txt_DatPaciente_altura.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Ingrese altura");
            txt_DatPaciente_altura.requestFocus();
        }
        else if(cbo_DatPac_Dia.getSelectedItem().toString()=="Día"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(día)");
            cbo_DatPac_Dia.setSelectedIndex(0);
        }
        else if(cbo_DatPac_Mes.getSelectedItem().toString()=="Mes"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(mes)");
            cbo_DatPac_Mes.setSelectedIndex(0);
        }
        
        else if(cbo_DatPac_Anio.getSelectedItem().toString()=="Año"){
            JOptionPane.showMessageDialog(null, "Seleciones una fecha(año)");
            cbo_DatPac_Anio.setSelectedIndex(0);
        }
        else if(rbn_DatPac_Masculina.isSelected()==false && rbn_DatPac_Femenino.isSelected()==false){
            JOptionPane.showMessageDialog(null,"Selecciones una opcion");
            buttonGroup1.clearSelection();
        }else if(cbo_DatPaciente_TipSangre.getSelectedItem().toString()=="Seleccione"){
            JOptionPane.showMessageDialog(null, "Selecione tipo de sangre");
            cbo_DatPaciente_TipSangre.setSelectedIndex(0);
        }
        
        
        else{
            if(validardni()){
               txt_DatPaciente_Dni.setText("");
                txt_DatPaciente_Dni.requestFocus();
           }
            else{
              registrarTabla();
                guardarArchivo();
                limpiar();
            }
        }   
    }//GEN-LAST:event_btn_DatPaciente_RegistrarActionPerformed

    private void btn_DatPaciente_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatPaciente_ModificarActionPerformed
       modificar();
    }//GEN-LAST:event_btn_DatPaciente_ModificarActionPerformed

    private void btn_DatPaciente_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatPaciente_EliminarActionPerformed
        int indice = tbl_paciente.getSelectedRow();
        String dni = modelo.getValueAt(indice, 0).toString();
        System.out.println("Dni: "+dni);
        eliminarRegistroFichero(dni);
        modelo.removeRow(indice);
        tbl_paciente.setModel(modelo);
    }//GEN-LAST:event_btn_DatPaciente_EliminarActionPerformed

    private void btn_DatPaciente_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatPaciente_SalirActionPerformed
         this.dispose();
    }//GEN-LAST:event_btn_DatPaciente_SalirActionPerformed

    private void tbl_pacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pacienteMouseClicked
        int indice = tbl_paciente.getSelectedRow();

        txt_DatPaciente_Dni.setText(modelo.getValueAt(indice, 0).toString());
        txt_DatPaciente_Nombre.setText(modelo.getValueAt(indice, 1).toString());
        txt_DatPaciente_ApePaterno.setText(modelo.getValueAt(indice, 2).toString());
        txt_DatPaciente_ApeMaterno.setText(modelo.getValueAt(indice, 3).toString());
        cbo_DatPac_Dia.setSelectedItem(modelo.getValueAt(indice, 4).toString());
        cbo_DatPac_Mes.setSelectedItem(modelo.getValueAt(indice, 5).toString());
        cbo_DatPac_Anio.setSelectedItem(modelo.getValueAt(indice, 6).toString());
        
        String sex = modelo.getValueAt(indice, 7).toString();
        if(sex.equals("Masculino"))
        rbn_DatPac_Masculina.setSelected(true);
        else
        rbn_DatPac_Femenino.setSelected(true);

        txt_DatPaciente_Telefono.setText(modelo.getValueAt(indice, 8).toString());
        txt_DatPaciente_Peso.setText(modelo.getValueAt(indice, 9).toString());
        txt_DatPaciente_altura.setText(modelo.getValueAt(indice, 10).toString());
       
        cbo_DatPaciente_TipSangre.setSelectedItem(modelo.getValueAt(indice, 11).toString());
        txt_DatPaciente_Alergias.setText(modelo.getValueAt(indice, 12).toString());
    }//GEN-LAST:event_tbl_pacienteMouseClicked

    private void btn_DatPaciente_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatPaciente_BuscarActionPerformed
        buscar(txt_buscar.getText(), tbl_paciente); 
    }//GEN-LAST:event_btn_DatPaciente_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DatPaciente_Buscar;
    private javax.swing.JButton btn_DatPaciente_Eliminar;
    private javax.swing.JButton btn_DatPaciente_Modificar;
    private javax.swing.JButton btn_DatPaciente_Registrar;
    private javax.swing.JButton btn_DatPaciente_Salir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_DatPac_Anio;
    private javax.swing.JComboBox<String> cbo_DatPac_Dia;
    private javax.swing.JComboBox<String> cbo_DatPac_Mes;
    private javax.swing.JComboBox<String> cbo_DatPaciente_TipSangre;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JRadioButton rbn_DatPac_Femenino;
    private javax.swing.JRadioButton rbn_DatPac_Masculina;
    private javax.swing.JTable tbl_paciente;
    private javax.swing.JTextArea txt_DatPaciente_Alergias;
    private javax.swing.JTextField txt_DatPaciente_ApeMaterno;
    private javax.swing.JTextField txt_DatPaciente_ApePaterno;
    private javax.swing.JTextField txt_DatPaciente_Dni;
    private javax.swing.JTextField txt_DatPaciente_Nombre;
    private javax.swing.JTextField txt_DatPaciente_Peso;
    private javax.swing.JTextField txt_DatPaciente_Telefono;
    private javax.swing.JTextField txt_DatPaciente_altura;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
