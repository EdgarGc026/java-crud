import javax.swing.*;

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

    //Agreguemos datos de tablas y demas
    JTable JTable_myTable = new JTable();
    JScrollPane JScrollPane_myPane = new JScrollPane(JTable_myTable);
    JTable_myTable.setFillsViewportHeight(true);
    add(JScrollPane_myPane);


  }
}
