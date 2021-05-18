import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class CRUD extends JFrame{
  private JPanel JPanel_myPanel;
  private JFrame JFrame_myFrame;
  private JTable JTable_myTable;
  private JScrollPane JScrollPane_myJScroll;
  public CRUD(){
    //Creamos el Frame donde estaremos mostrando el crude
    this.setTitle("Estadisticas");
    this.setVisible(true);
    this.setSize(600,600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.dispose();

    //Agregando datos para la tabla
    String[] columnNames = {"Id", "Jugador 1", "Jugador 2", "Ganador"};
    Conectar conectar = new Conectar();
    String[][] data = conectar.consultarTodos();

    //Agreguemos datos de tablas y demas
    JTable JTable_myTable = new JTable(data, columnNames);
    JTable_myTable.setBounds(30,40,200,300);
    JTable_myTable.setCellSelectionEnabled(true);


    //Eventos cada la celda individual
    ListSelectionModel JTable_select = JTable_myTable.getSelectionModel();
    JTable_select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JTable_select.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent event) {
        String Data = null;
        int[] row = JTable_myTable.getSelectedRows();
        int[] columns = JTable_myTable.getSelectedColumns();
        for (int i = 0; i < row.length; i++) {
          for (int j = 0; j < columns.length; j++) {
            Data = (String) JTable_myTable.getValueAt(row[i], columns[j]);
          } }
        System.out.println("Table element selected is: " + Data);
      }
    });

    JScrollPane JScrollPane_myPane = new JScrollPane(JTable_myTable);
    JTable_myTable.setFillsViewportHeight(true);
    add(JScrollPane_myPane);
  }

  public void getData(){
    try{
      Conectar conectar = new Conectar();
      Connection connection = conectar.conexion();

      DefaultTableModel model = new DefaultTableModel();
      model.addColumn("ID");
      model.addColumn("Jugador1");
      model.addColumn("Jugador2");
      model.addColumn("Ganador");
      String[] data = new String[4];

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM juego");
      while (resultSet.next()){
        data[0] = resultSet.getString(1);
        data[1] = resultSet.getString(2);
        data[2] = resultSet.getString(3);
        data[3] = resultSet.getString(4);
        model.addRow(data);
      }
      JTable_myTable.setModel(model);
    }catch(Exception ex){
      System.out.println("Error: "+ ex.getMessage());
      System.out.println("Error a la hora de mostrar los datos");
    }
  }
}
