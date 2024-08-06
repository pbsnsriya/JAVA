import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class dbConnection {}

class LoginFrame extends JFrame {
    JButton b1, b2;
    JLabel l1;

    public LoginFrame() {
        super("LOGIN PAGE");
        setSize(800, 550);
        setResizable(true);
        setLocation(200, 50);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        b1 = new JButton(" START YOUR REGISTRATION FORM ");
        b1.setBounds(250, 400, 300, 50);
        add(b1);

        l1 = new JLabel();
        l1.setBounds(200, 30, 700, 300);
        l1.setIcon(new ImageIcon("9.jpg"));
        add(l1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame.this.setVisible(false);
                new Frame2();
            }
        });

        setVisible(true);
    }
}
class Frame2 extends JFrame {
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1;
    public Frame2() {
        super("LOGIN PAGE");
        setSize(500, 500);
        setResizable(true);
        setLocation(200, 50);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel("USERNAME: ");
        l1.setBounds(80, 150, 150, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(230, 150, 200, 30);
        add(t1);

        l2 = new JLabel(" PASSWORD: ");
        l2.setBounds(80, 190, 150, 30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(230, 190, 200, 30);
        add(t2);

        b1 = new JButton("LOGIN");
        b1.setBounds(150, 330, 150, 30);
        add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame2.this,
                        "Please Enter USERNAME", "ALERT",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame2.this,
                        "Please Enter PASSWORD", "ALERT",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (t1.getText().equals("admin")
                    && t2.getText().equals("admin1234")) {
                    Frame2.this.setVisible(false);
                    new Frame3();

                } else {
                    JOptionPane.showMessageDialog(Frame2.this,
                        "USERID OR WORNG IS WORNG", "ALERT",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });
        setVisible(true);
    }
}
class Frame3 extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;
    String data;

    public Frame3() {
        super("STUDENT DETAILS");
        setSize(500, 500);
        setResizable(true);
        setLocation(200, 50);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("ENTER FIRST NAME ");
        l1.setBounds(80, 50, 150, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(230, 50, 200, 30);
        add(t1);

        l2 = new JLabel("ENTER LAST NAME ");
        l2.setBounds(80, 100, 150, 30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(230, 100, 200, 30);
        add(t2);

        l3 = new JLabel("SELECT GENDER ");
        l3.setBounds(80, 150, 150, 30);
        add(l3);

        t5 = new JTextField();
        t5.setBounds(230, 150, 200, 30);
        add(t5);

        l4 = new JLabel(" ENTER BRANCH ");
        l4.setBounds(80, 190, 150, 30);
        add(l4);

        t3 = new JTextField();
        t3.setBounds(230, 190, 200, 30);
        add(t3);

        l5 = new JLabel("ENTER ADDRESS ");
        l5.setBounds(80, 230, 150, 30);
        add(l5);

        t4 = new JTextField();
        t4.setBounds(230, 230, 200, 30);
        add(t4);

        b2 = new JButton("SUBMIT DETAILS");
        b2.setBounds(150, 330, 150, 30);
        add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame3.this,
                        "Please Enter FIRST NAME", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                    return;
                } else if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame3.this,
                        "Please Enter LAST NAME", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                } else if (t5.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame3.this,
                        "Please Enter GENDER", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                } else if (t3.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame3.this,
                        "Please Enter DEPARTMENT", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                } else if (t4.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame3.this,
                        "Please Enter ADDRESS", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                } else {
                    String s1 = "STUDENT NAME : " + t1.getText().trim() + " "
                        + t2.getText().trim() + "\n";
                    String s2 = "ADDRESS : " + t4.getText().trim();
                    String s3 = "BRANCH : " + t3.getText().trim();
                    String s4 = "GENDER : " + t5.getText().trim();

                    Frame3.this.setVisible(false);
                    new Frame4(s1, s2, s3, s4,
                        t1.getText().trim() + " " + t2.getText().trim(),
                        t4.getText().trim(), t3.getText().trim(),
                        t5.getText().trim());
                }
            }
        });
        setVisible(true);
    }
}
class Frame4 extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;
    Connection con;
    String data;

    public Frame4(String s1, String s2, String s3, String s4, String d1,
        String d2, String d3, String d4) {
        super("STUDENT DETAILS");
        setSize(500, 500);
        setResizable(true);
        setLocation(200, 50);
        setLayout(null);
        final String s5 = s1;
        final String s6 = s2;
        final String s7 = s3;
        final String s8 = s4;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("ENTER SSC PERCENTAGE: ");
        l1.setBounds(40, 50, 150, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(270, 50, 200, 30);
        add(t1);

        l2 = new JLabel("ENTER INTER PERCENTGE: ");
        l2.setBounds(40, 100, 150, 30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(270, 100, 200, 30);
        add(t2);

        l3 = new JLabel("ENTER YOUR AVERAGE POINTER(CGPA): ");
        l3.setBounds(40, 150, 200, 30);
        add(l3);

        t5 = new JTextField();
        t5.setBounds(270, 150, 200, 30);
        add(t5);

        l4 = new JLabel(" HAVE ENROLED FOR NTPEL: ");
        l4.setBounds(40, 190, 200, 30);
        add(l4);

        t3 = new JTextField();
        t3.setBounds(270, 190, 200, 30);
        add(t3);

        l5 = new JLabel("HAVE YOU JIONED ANY CLUB: ");
        l5.setBounds(40, 230, 200, 30);
        add(l5);

        t4 = new JTextField();
        t4.setBounds(270, 230, 200, 30);
        add(t4);

        b2 = new JButton("CONTINUE");
        b2.setBounds(150, 330, 150, 30);
        add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame4.this,
                        "Please Enter SSC PERCENTAGE", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                    return;
                } else if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame4.this,
                        "Please Enter HSC MARKS", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                } else if (t5.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame4.this,
                        "Please Enter AVERAGE POINTER", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                } else if (t3.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame4.this,
                        "Please Enter COMMITTE NAME", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                } else if (t4.getText().equals("")) {
                    JOptionPane.showMessageDialog(Frame4.this,
                        "Please Enter NTEPL COURSE", "ALERT",
                        JOptionPane.PLAIN_MESSAGE);
                } else {
                    String s9 = "SSC PERCENTAGE " + t1.getText().trim();
                    String s10 =
                        "INTER PERCENTAGE " + t2.getText().trim() + "\n";
                    String s11 = " CLUB: " + t4.getText().trim();
                    String s12 = "NTEPL COURSE NAME : " + t3.getText().trim();
                    String s13 =
                        "AVERAGE POINTER(CGPA) : " + t5.getText().trim();
                    try {
                        connect("Vignesh", "Manager", "B1921117589v");
                        con.createStatement().executeUpdate(
                            "insert into StudentDetails values('" + d1 + "','"
                            + d2 + "','" + d3 + "','" + d4 + "','"
                            + t1.getText().trim() + "','" + t2.getText().trim()
                            + "','" + t4.getText().trim() + "','"
                            + t3.getText().trim() + "','" + t5.getText().trim()
                            + "')");
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    Frame4.this.setVisible(false);
                    new Frame5(s5, s6, s7, s8, s9, s10, s11, s12, s13);
                }
            }
        });
        setVisible(true);
    }
    void connect(String dbName, String user, String pass) throws SQLException {
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/" + dbName, user, pass);
        Statement statement = null;
        try {
            statement = con.createStatement();
            String sql = "CREATE DATABASE SRIYADB";

            statement.executeUpdate(sql);
            System.out.println("Database created!");
        } catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1007) {
                // Database already exists error
                System.out.println(sqlException.getMessage());

            } else {
                // Some other problems, e.g. Server down, no permission, etc
                sqlException.printStackTrace();
            }
        }
        String sqlCreate = "CREATE TABLE IF NOT EXISTS StudentDetails("
            + "  NAME     VARCHAR(25),"
            + "  ADDRESS  VARCHAR(25),"
            + "  BRANCH           VARCHAR(25),"
            + "  GENDER           VARCHAR(25),"
            + "  SSC           VARCHAR(25),"
            + "  INTER           VARCHAR(25),"
            + "  CLUB           VARCHAR(25),"
            + "  NPTEL           VARCHAR(25),"
            + "  CGPA           VARCHAR(25))";
        System.out.println(sqlCreate);
        statement.execute("use SRIYADB");
        statement.execute(sqlCreate);
    }
}
class Frame5 extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JButton b1, b2;

    public Frame5(String s1, String s3, String s2, String s4, String s5,
        String s6, String s7, String s8, String s9) {
        super("STUDENT");
        setSize(1000, 900);
        setResizable(true);
        setLocation(200, 70);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel(s1);
        l1.setBounds(50, 20, 300, 30);
        add(l1);

        l4 = new JLabel(s4);
        l4.setBounds(50, 70, 300, 30);
        add(l4);

        l2 = new JLabel(s2);
        l2.setBounds(50, 120, 300, 30);
        add(l2);

        l3 = new JLabel(s3);
        l3.setBounds(50, 170, 300, 30);
        add(l3);

        l5 = new JLabel(s5);
        l5.setBounds(50, 220, 300, 30);
        add(l5);

        l6 = new JLabel(s6);
        l6.setBounds(50, 270, 300, 30);
        add(l6);

        l7 = new JLabel(s7);
        l7.setBounds(50, 320, 300, 30);
        add(l7);

        l8 = new JLabel(s8);
        l8.setBounds(50, 370, 300, 30);
        add(l8);

        l9 = new JLabel(s9);
        l9.setBounds(50, 420, 300, 30);
        add(l9);

        b1 = new JButton(" MAKE A NEW ENTERY ");
        b1.setBounds(250, 400, 150, 50);
        add(b1);

        b2 = new JButton(" EXIT ");
        b2.setBounds(400, 400, 150, 50);
        add(b2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Frame3();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
public class Studentdetails {
    public static void main(String[] args) {
        new LoginFrame();
    }
}
