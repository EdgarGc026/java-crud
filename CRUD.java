import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class CRUD extends JFrame{
  private JPanel jpanel;
  private JFrame JFrame_myFrame;
  private JTable JTable_myTable;

  private JLabel labelTitle1, labelHighScore, labelTitle2, labelLastWinner;
 private JScrollPane JScrollPane_myJScroll;
  public CRUD(){
    String ganadorConcurrente = topPlayer();
    String mayorPuntaje = hightScorePlayer();
    //Creamos el Frame donde estaremos mostrando el crude
    this.setTitle("Estadisticas");
    this.setVisible(true);
    this.setSize(600,600);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    //conf panel
    GridLayout grid = new GridLayout(2,2);
    jpanel = new JPanel();
    jpanel.setLayout(grid);
    //jpanel.setBounds(30,380,200,30);
    //Agregando datos para la tabla
    String[] columnNames = {"Id", "Jugador 1", "Jugador 2", "Ganador"};
    Conectar conectar = new Conectar();
    String[][] data = conectar.consultarTodos();
    
    //Agreguemos datos de tablas y demas
    JTable JTable_myTable = new JTable(data, columnNames);
    //JTable_myTable.setBounds(30,40,200,300);
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

    //add(JScrollPane_myPane);

    labelTitle1 = new JLabel("La puntuacion mas alta es:");
    //labelTitle1.setBounds(30,400,200,30);
    jpanel.add(labelTitle1);

    labelHighScore = new JLabel(mayorPuntaje);
    //labelLastWinner.setBounds(30,460,100,30);
    jpanel.add(labelHighScore);

    labelTitle2 = new JLabel("el Jugador que ha ganado mas");
    //labelTitle2.setBounds(30,430,100,30);
    jpanel.add(labelTitle2);

    labelLastWinner = new JLabel(ganadorConcurrente);
    //labelLastWinner.setBounds(30,460,100,30);
    jpanel.add(labelLastWinner);
    JPanel container = new JPanel();
    container.add(JScrollPane_myPane, BorderLayout.CENTER);
    container.add(jpanel, BorderLayout.NORTH);
    add(container);
  }
  public String hightScorePlayer(){
    	Conectar conectar = new Conectar();
	String scorePlayer1 = conectar.consultarPuntaje(1);
	String scorePlayer2 = conectar.consultarPuntaje(2);
	String hightplayer = "";

	if(Integer.valueOf(scorePlayer1) > Integer.valueOf(scorePlayer2))
	   hightplayer = "Jugador 1 con " + scorePlayer1 + " puntos";

	if(Integer.valueOf(scorePlayer2) > Integer.valueOf(scorePlayer1))
	   hightplayer = "Jugador 2 con " + scorePlayer1 + " puntos";
	return hightplayer;
  }

  public String topPlayer(){
    	Conectar conectar = new Conectar();
	String scorePlayer1 = conectar.consultarPartidas(1);
	String scorePlayer2 = conectar.consultarPartidas(0);
	String topplayer = "";

	if(Integer.valueOf(scorePlayer1) > Integer.valueOf(scorePlayer2))
	   topplayer = "Jugador 1 con " + scorePlayer1 + " partidas ganadas";

	if(Integer.valueOf(scorePlayer2) > Integer.valueOf(scorePlayer1))
	   topplayer = "Jugador 2 con " + scorePlayer1 + " partidas ganadas";

	return topplayer;

  }
}