package views;

import model.Manager;
import model.Student;
import model.bank_accounts.CreditApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class viewAllCreditApp extends JFrame{


    private JPanel contentPane;
    private JTable table; // table
    private List<CreditApplication> creditApp = new ArrayList<>(); //holds all students
    private DefaultTableModel dtm = new DefaultTableModel(0, 0); //default table model


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    viewAllCreditApp frame = new viewAllCreditApp(); //create frame
                    frame.setVisible(true); //show frame
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public viewAllCreditApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 941, 613);
        contentPane = new JPanel(); //create Jpanel
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel(); //create panel to insert the jtable into
        panel.setBounds(10, 117, 1099, 249);
        contentPane.add(panel); //put panel into the Jpanel

        DefaultTableModel tableModel = new DefaultTableModel(); //create table
        table = new JTable(tableModel);
        String header[] =  new String[] {"ID", "First Name", "Last Name", "Address", "City", "State", "Email" , "Phone",
                "SSN", "Credit Score", "Income", "Password" , "Student ID", "Status", "Date Applied"}; // columns name
        dtm.setColumnIdentifiers(header); //set column names to column
        table.setModel(dtm); //set table to default table model
        //for (int count = 1; count <= 2; count++) {
        dtm.addRow(new Object[] { null, null, null,
                null, null, });
        //}

        table.setBounds(9, 5, 503, 284); //set table to certain size

        //set the width of cells to certain size
        table.getColumnModel().getColumn(0).setPreferredWidth(130);
        table.getColumnModel().getColumn(1).setPreferredWidth(116);
        table.getColumnModel().getColumn(2).setPreferredWidth(96);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(135);
        table.getColumnModel().getColumn(5).setPreferredWidth(135);
        table.getColumnModel().getColumn(6).setPreferredWidth(135);
        table.getColumnModel().getColumn(7).setPreferredWidth(135);
        table.getColumnModel().getColumn(8).setPreferredWidth(160);
        table.getColumnModel().getColumn(9).setPreferredWidth(135);
        table.getColumnModel().getColumn(10).setPreferredWidth(135);
        table.getColumnModel().getColumn(11).setPreferredWidth(135);
        table.getColumnModel().getColumn(12).setPreferredWidth(160);
        table.getColumnModel().getColumn(13).setPreferredWidth(135);
        table.getColumnModel().getColumn(14).setPreferredWidth(190);
        panel.setLayout(null);
        JScrollPane pane = new JScrollPane(table); // create scroll if table becomes too big
        pane.setBounds(0, 0, 690, 200);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setEnabled(false);
        panel.add(pane); // add scroll to jtable pane

        // create label view students
        JLabel lblNewLabel = new JLabel("View All Credit Applications");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(195, 52, 276, 41);
        contentPane.add(lblNewLabel);

        // create exit button
        JButton btnNewButton = new JButton("Exit");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {

                    dispose(); //close screen
                    dispose();

                } catch (Exception ex) {

                }

            }
        });
        btnNewButton.setBounds(714, 439, 180, 82);
        contentPane.add(btnNewButton);
        creditApp = Manager.getCreditApplication();
        //students = Manager.getStudents(); //get students and put it into students array list
        updateTable(); // put students into table

        // may be implemented later
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) { // reacts to clicking on the Jtable by double clicking
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                int column = table.getSelectedColumn();
                int dialogButton = JOptionPane.YES_NO_OPTION;

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) { // double click to trigger
                    // maybe double click to show password of user but have manager enter their own password to access this information
                    //System.out.println(row);
                    //System.out.println(column);
                    //String value = table.getModel().getValueAt(row, column).toString();
                    //System.out.println(value);
                    //Point point = mouseEvent.getPoint();
                    //int row = table.rowAtPoint(point); //get row
                    //int row = table.getModel().getRowCount();
                    //System.out.println(	students.get(row).getFname());
                    int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Note First?","Warning",dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION){
                        // Saving code here
                    }

                    //User student = students.get(row);
                    //String password = students.get(row).getPassword();
                    //System.out.println(password);
                    //String fName = students.get(row).getFname();
                    //System.out.println(fName);

                    //table.getModel().setValueAt(password,row,4);



                    // maybe open account view when double click on the table

                    //

                }

                // int column = table.getSelectedColumn();
                // int row = table.getSelectedRow();
                // String value = table.getModel().getValueAt(row, column).toString();
                // System.out.println(value);
            }
        });







        // frame.add(panel);
        // JScrollPane pane = new JScrollPane(table);
        // panel.setLayout(null);

        // scroll_table = new JScrollPane(table);

        // panel.add(table);

        // Scrollbar scrollbar = new Scrollbar();
        // scrollbar.setBounds(486, 5, 34, 214);
        // panel.add(scrollbar);
    }







    //update table with students
    public void updateTable(){
        int size = creditApp.size(); //how many students in list

        // put user info into table
        for(int i = 0; i < size; i++){
            table.getModel().setValueAt(creditApp.get(i).getId(),i,0);
            table.getModel().setValueAt(creditApp.get(i).getFirstName(),i,1);
            table.getModel().setValueAt(creditApp.get(i).getLastName(),i,2);
            table.getModel().setValueAt(creditApp.get(i).getAddress(),i,3);
            table.getModel().setValueAt(creditApp.get(i).getCity(),i,4);
            table.getModel().setValueAt(creditApp.get(i).getState(),i,5);
            table.getModel().setValueAt(creditApp.get(i).getEmail(),i,6);
            table.getModel().setValueAt(creditApp.get(i).getPhone().toString(),i,7);
            table.getModel().setValueAt(creditApp.get(i).getSSN(),i,8);
            table.getModel().setValueAt(creditApp.get(i).getCreditSore(),i,9);
            table.getModel().setValueAt(creditApp.get(i).getIncome(),i,10);
            table.getModel().setValueAt(creditApp.get(i).getPassword(),i,11);
            table.getModel().setValueAt(creditApp.get(i).getStudentId(),i,12);
            table.getModel().setValueAt(creditApp.get(i).getStatus(),i,13);
            table.getModel().setValueAt(creditApp.get(i).getDateApplied(),i,14);


           // table.getModel().setValueAt("******",i,5); //password is hidden
            //table.getModel().setValueAt(creditApp.get(i).getDateApplied(),i,6);


            dtm.addRow(new Object[]{ null, null, null, null, null }); // create a empty row
        }


    }





}
