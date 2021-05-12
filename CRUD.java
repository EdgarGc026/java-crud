import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    String[][] data = {
        {"1", "3", "6", "0"},
        {"2", "4", "2", "1"}
    };

    //Agreguemos datos de tablas y demas
    JTable JTable_myTable = new JTable(data, columnNames);
    JTable_myTable.setBounds(30,40,200,300);
    JTable_myTable.setCellSelectionEnabled(true);
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
}
