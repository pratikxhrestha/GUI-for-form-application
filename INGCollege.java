/*
 * @Group N5
 * author(Pratik Shrestha)
 * London ID(20049198)
 */

//Importing required packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.util.*;
import javax.swing.table.DefaultTableModel;

//Creating class INGCollege
public class INGCollege{
    //Defining instances of GUI components
    private JFrame mainFrame;
    private Container content;
    private JPanel panelCourse_button,panelCourse_academic,panelCourse_nonAcademic,panelLogo,panelDisplay_academic,panelDisplay_nonAcademic;
    private JButton btnAcademicCourse,btnNonAcademicCourse;

    //Defining instances of GUI components for academic course
    private JLabel lblCourse_academic,lblCourse1_academic,lblCourseID_academic,lblCourseName_academic,lblDuration_academic,lblCourseLeader_academic,lblLecturerName_academic,lblLevel_academic,lblCredit_academic,lblStartingDate_academic,lblCompletionDate_academic,lblNumberOfAssessments_academic;
    private JTextField txtCourseID_academic,txtCourseID1_academic,txtCourseName_academic,txtDuration_academic,txtCourseLeader_academic,txtLecturerName_academic,txtLevel_academic,txtCredit_academic,txtStartingDate_academic,txtCompletionDate_academic,txtNumberOfAssessments_academic;
    private JButton btnAdd_academic,btnRegister_academic,btnDisplay_academic,btnClear_academic,btnBack_academic;

    //Defining instances of GUI components for non academic course
    private JLabel lblCourse_nonAcademic,lblCourse1_nonAcademic,lblCourseID_nonAcademic,lblCourseName_nonAcademic,lblDuration_nonAcademic,lblCourseLeader_nonAcademic,lblInstructorName_nonAcademic,lblStartDate_nonAcademic,lblCompletionDate_nonAcademic,lblExamDate_nonAcademic,lblPrerequisite_nonAcademic;
    private JTextField txtCourseID_nonAcademic,txtCourseID1_nonAcademic,txtCourseName_nonAcademic,txtDuration_nonAcademic,txtCourseLeader_nonAcademic,txtInstructorName_nonAcademic,txtStartDate_nonAcademic,txtCompletionDate_nonAcademic,txtExamDate_nonAcademic,txtPrerequisite_nonAcademic;
    private JButton btnAdd_nonAcademic,btnRegister_nonAcademic,btnRemove_nonAcademic,btnDisplay_nonAcademic,btnClear_nonAcademic,btnBack_nonAcademic;
    
    //Creating array list of course type
    private ArrayList <Course> academicCourseList = new ArrayList();
    private ArrayList <Course> nonAcademicCourseList = new ArrayList();

    //Creating constructor INGCollege()
    public INGCollege(){
        //Creating frame for gui
        mainFrame = new JFrame("Course Registration Form");
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setExtendedState(mainFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

        //Creating container for components
        content = mainFrame.getContentPane();
        content.setBackground(new Color(244, 244, 244));
        
        //Creating menubar and menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu_about = new JMenu("About");
        menuBar.add(menu_about);
        
        //Creating menu item 
        JMenuItem aboutItem_Course = new JMenuItem("Course");
        menu_about.add(aboutItem_Course);
        JMenuItem aboutItem_Copyright = new JMenuItem("Copyright");
        menu_about.add(aboutItem_Copyright);
        
        JMenu menu_help = new JMenu("Help");
        //Method for displaying dialog box for menu help
        menu_help.addMenuListener(new MenuListener(){
            public void menuSelected(MenuEvent e){
                JOptionPane.showMessageDialog(mainFrame,"You can get help from here","Help",JOptionPane.INFORMATION_MESSAGE);
            }
            
            public void menuDeselected(MenuEvent e){
                
            }
            
            public void menuCanceled(MenuEvent e){
            
            }
        });
        
        JMenu menu_exit = new JMenu("Exit");
        //Method for displaying dialog box for menu exitf
        menu_exit.addMenuListener(new MenuListener(){
            public void menuSelected(MenuEvent e){
                int response = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if(response == 0){
                    System.exit(0);   
                }
            }
            
            public void menuDeselected(MenuEvent e){
                
            }
            
            public void menuCanceled(MenuEvent e){
                
            }
        });
        menuBar.add(menu_help);
        menuBar.add(menu_exit);
        mainFrame.setJMenuBar(menuBar);
        
        //Panel for navigation button to switch between courses
        panelCourse_button = new JPanel();
        panelCourse_button.setBounds(0,0,1540,80);
        GridLayout layout = new GridLayout(1,1);
        panelCourse_button.setLayout(layout);
        content.add(panelCourse_button);
        
        //Panel for Academic Course
        panelCourse_academic = new JPanel();
        panelCourse_academic.setBounds(50,120,1440,540);
        panelCourse_academic.setLayout(null);
        panelCourse_academic.setBackground(new Color(235, 235, 235));
        content.add(panelCourse_academic);
        
        //Panel for Non Academic Course
        panelCourse_nonAcademic = new JPanel();
        panelCourse_nonAcademic.setBounds(50,120,1440,540);
        panelCourse_nonAcademic.setLayout(null);
        panelCourse_nonAcademic.setBackground(new Color(235, 235, 235));
        panelCourse_nonAcademic.setVisible(false);
        content.add(panelCourse_nonAcademic);
        
        //Panel for logo
        panelLogo = new JPanel();
        panelLogo.setBounds(600,670,150,95);
        panelLogo.setBackground(new Color(244, 244, 244));
        content.add(panelLogo);
        
        //Panel for academic display
        panelDisplay_academic = new JPanel();
        panelDisplay_academic.setBounds(50,120,1440,540);
        panelDisplay_academic.setLayout(null);
        panelDisplay_academic.setBackground(new Color(235, 235, 235));
        panelDisplay_academic.setVisible(false);
        content.add(panelDisplay_academic);
        
         //Panel for non academic display
        panelDisplay_nonAcademic = new JPanel();
        panelDisplay_nonAcademic.setBounds(50,120,1440,540);
        panelDisplay_nonAcademic.setLayout(null);
        panelDisplay_nonAcademic.setBackground(new Color(235, 235, 235));
        panelDisplay_nonAcademic.setVisible(false);
        content.add(panelDisplay_nonAcademic);
        
        // table for academic course
        //------------------------------------------------------------------------------------------------------------------------------------
        DefaultTableModel model_academic = new DefaultTableModel();
        JTable table_academic = new JTable(model_academic);
                
        JScrollPane sp_academic = new JScrollPane(table_academic);
        sp_academic.setBounds(0,80,1440,460);
        panelDisplay_academic.add(sp_academic);
                
        String[] column_academic = {"Course ID","Course Name","Course Leader","Lecturer Name","Level","Credit","Starting Date","Completion Date","Duration","No Of Assessments"};
        model_academic.setColumnIdentifiers(column_academic);
        table_academic.setModel(model_academic);
        table_academic.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        table_academic.getTableHeader().setOpaque(true);
        table_academic.getTableHeader().setBackground(new Color(32, 136, 203));
        table_academic.getTableHeader().setForeground(new Color(255,255,255));
        table_academic.setRowHeight(25);
        table_academic.setFocusable(false);
        table_academic.setIntercellSpacing(new Dimension(0,0));
        table_academic.setSelectionBackground(new Color(232,57,95));
        table_academic.setShowVerticalLines(false);
                
        Object[] data_academic = new Object[10];
        
        //-------------------------------------------------------------------------------------------------------------------------------------
        
        // table for non academic course
        //-------------------------------------------------------------------------------------------------------------------------------------
        DefaultTableModel model_nonAcademic = new DefaultTableModel();
        JTable table_nonAcademic = new JTable(model_nonAcademic);
                
        JScrollPane sp_nonAcademic = new JScrollPane(table_nonAcademic);
        sp_nonAcademic.setBounds(0,80,1440,460);
        panelDisplay_nonAcademic.add(sp_nonAcademic);
                
        String[] column_nonAcademic = {"Course ID","Course Name","Course Leader","Instructor Name","Prerequisite","Starting Date","Completion Date","Duration"};
        model_nonAcademic.setColumnIdentifiers(column_nonAcademic);
        table_nonAcademic.setModel(model_nonAcademic);
        table_nonAcademic.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        table_nonAcademic.getTableHeader().setOpaque(true);
        table_nonAcademic.getTableHeader().setBackground(new Color(32, 136, 203));
        table_nonAcademic.getTableHeader().setForeground(new Color(255,255,255));
        table_nonAcademic.setRowHeight(25);
        table_nonAcademic.setFocusable(false);
        table_nonAcademic.setIntercellSpacing(new Dimension(0,0));
        table_nonAcademic.setSelectionBackground(new Color(232,57,95));
        table_nonAcademic.setShowVerticalLines(false);
                
        Object[] data_nonAcademic = new Object[8];
        //-------------------------------------------------------------------------------------------------------------------------------------
        
        //Creating imageicon for logo
        ImageIcon logoIcon = new ImageIcon("C:/Users/DELL/Desktop/Java Coursework/20049198 Pratik Shrestha/ing logo.png");
        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(logoIcon.getImage().getScaledInstance(150,85,Image.SCALE_DEFAULT)));
        lblLogo.setBounds(0,0,150,95);
        panelLogo.add(lblLogo); 
        
        //Creating label for copyright information
        Font copyrightFont = new Font("Verdana",Font.BOLD,13);
        JLabel lblCopyright = new JLabel("Designed by Pratik Shrestha");
        lblCopyright.setBounds(760,680,250,20);
        lblCopyright.setFont(copyrightFont);
        JLabel lblCopyright1 = new JLabel("\u00a9 islington college");
        lblCopyright1.setBounds(780,710,250,20);
        lblCopyright1.setFont(copyrightFont);
        content.add(lblCopyright);
        content.add(lblCopyright1);
        
        //Creating navigation button academic course
        Font navFont = new Font("Verdana",Font.BOLD,30);
        btnAcademicCourse = new JButton("Academic Course");
        btnAcademicCourse.setBorder(null);
        btnAcademicCourse.setBackground(new Color(46, 46, 46));
        btnAcademicCourse.setFont(navFont);
        btnAcademicCourse.setFocusable(false);
        btnAcademicCourse.setForeground(Color.white);
        btnAcademicCourse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelCourse_academic.setVisible(true);
                panelCourse_nonAcademic.setVisible(false);
                panelDisplay_academic.setVisible(false);
                btnAcademicCourse.setBackground(new Color(46, 46, 46));
                btnAcademicCourse.setForeground(Color.white);
                btnNonAcademicCourse.setBackground(new Color(82, 82, 82));
                btnNonAcademicCourse.setForeground(Color.white);
            }
        });
        
        //Method to create hover effect on nav button academic course
        btnAcademicCourse.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnAcademicCourse.setForeground(Color.red);
            }
            
            public void mouseExited(MouseEvent e){
                btnAcademicCourse.setForeground(Color.white);
            }
        });
        panelCourse_button.add(btnAcademicCourse);

        //Creating navigation button non academic course
        btnNonAcademicCourse = new JButton("Non Academic Course");
        btnNonAcademicCourse.setBorder(null);
        btnNonAcademicCourse.setFont(navFont);
        btnNonAcademicCourse.setFocusable(false);
        btnNonAcademicCourse.setBackground(new Color(82, 82, 82));
        btnNonAcademicCourse.setForeground(Color.white);
        btnNonAcademicCourse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelCourse_nonAcademic.setVisible(true);
                panelCourse_academic.setVisible(false);
                panelDisplay_academic.setVisible(false);
                btnNonAcademicCourse.setBackground(new Color(46, 46, 46));
                btnNonAcademicCourse.setForeground(Color.white);
                btnAcademicCourse.setBackground(new Color(82, 82, 82));
                btnAcademicCourse.setForeground(Color.white);
            }
        });
        
        btnNonAcademicCourse.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnNonAcademicCourse.setForeground(Color.red);
            }
            
            public void mouseExited(MouseEvent e){
                btnNonAcademicCourse.setForeground(Color.white);
            }
        });
        panelCourse_button.add(btnNonAcademicCourse);

        //-------------------------------------------------------------------------------------------------------------------------------------
        //Creating label for academic course
        Font title = new Font("Verdana",Font.BOLD,25);
        lblCourse_academic = new JLabel("Academic Course");
        lblCourse_academic.setFont(title);
        lblCourse_academic.setBounds(620,10,250,40);
        panelCourse_academic.add(lblCourse_academic);

        Font lblFont = new Font("Verdana",Font.BOLD,20);
        lblCourseID_academic = new JLabel("CourseID:");
        lblCourseID_academic.setBounds(40,90,130,40);
        lblCourseID_academic.setFont(lblFont);
        panelCourse_academic.add(lblCourseID_academic);
        
        lblCourseName_academic = new JLabel("Course Name:");
        lblCourseName_academic.setBounds(500,90,170,40);
        lblCourseName_academic.setFont(lblFont);
        panelCourse_academic.add(lblCourseName_academic);

        lblDuration_academic = new JLabel("Duration:");
        lblDuration_academic.setBounds(1040,90,130,40);
        lblDuration_academic.setFont(lblFont);
        panelCourse_academic.add(lblDuration_academic);

        lblLevel_academic = new JLabel("Level:");
        lblLevel_academic.setBounds(84,160,130,40);
        lblLevel_academic.setFont(lblFont);
        panelCourse_academic.add(lblLevel_academic);

        lblCredit_academic = new JLabel("Credit:");
        lblCredit_academic.setBounds(582,160,130,40);
        lblCredit_academic.setFont(lblFont);
        panelCourse_academic.add(lblCredit_academic);

        lblNumberOfAssessments_academic = new JLabel("No.of.Assessment:");
        lblNumberOfAssessments_academic.setBounds(937,160,210,40);
        lblNumberOfAssessments_academic.setFont(lblFont);
        panelCourse_academic.add(lblNumberOfAssessments_academic);

        lblCourseID_academic = new JLabel("CourseID:");
        lblCourseID_academic.setBounds(40,310,130,40);
        lblCourseID_academic.setFont(lblFont);
        panelCourse_academic.add(lblCourseID_academic);

        lblCourseLeader_academic = new JLabel("Course Leader:");
        lblCourseLeader_academic.setBounds(985,310,200,40);
        lblCourseLeader_academic.setFont(lblFont);
        panelCourse_academic.add(lblCourseLeader_academic);

        lblLecturerName_academic = new JLabel("Lecturer Name:");
        lblLecturerName_academic.setBounds(10,380,200,40);
        lblLecturerName_academic.setFont(lblFont);
        panelCourse_academic.add(lblLecturerName_academic);

        lblStartingDate_academic = new JLabel("Starting Date:");
        lblStartingDate_academic.setBounds(500,380,200,40);
        lblStartingDate_academic.setFont(lblFont);
        panelCourse_academic.add(lblStartingDate_academic);

        lblCompletionDate_academic = new JLabel("Completion Date:");
        lblCompletionDate_academic.setBounds(960,380,210,40);
        lblCompletionDate_academic.setFont(lblFont);
        panelCourse_academic.add(lblCompletionDate_academic);
    
        lblCourse1_academic = new JLabel("Academic Course");
        lblCourse1_academic.setFont(title);
        lblCourse1_academic.setBounds(620,10,250,40);
        panelDisplay_academic.add(lblCourse1_academic);
        //-------------------------------------------------------------------------------------------------------------------------------------
        //Creating text fields for academic course
        Font txtFont = new Font("Verdana",Font.BOLD,15);
        txtCourseID_academic = new JTextField("Enter Course ID");
        txtCourseID_academic.setBounds(190,95,200,30);
        txtCourseID_academic.setFont(txtFont);
        txtCourseID_academic.setForeground(new Color(105, 105, 105));
        txtCourseID_academic.setBackground(new Color(235, 235, 235));
        //Method to display place holder in text fields
        txtCourseID_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCourseID_academic.getText().equals("Enter Course ID")){
                    txtCourseID_academic.setText("");
                    txtCourseID_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCourseID_academic.getText().isEmpty()){
                    txtCourseID_academic.setText("Enter Course ID");
                    txtCourseID_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtCourseID_academic);

        txtCourseName_academic = new JTextField("Enter Course Name");
        txtCourseName_academic.setBounds(690,95,200,30);
        txtCourseName_academic.setFont(txtFont);
        txtCourseName_academic.setForeground(new Color(105, 105, 105));
        txtCourseName_academic.setBackground(new Color(235, 235, 235));
        txtCourseName_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCourseName_academic.getText().equals("Enter Course Name")){
                    txtCourseName_academic.setText("");
                    txtCourseName_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCourseName_academic.getText().isEmpty()){
                    txtCourseName_academic.setText("Enter Course Name");
                    txtCourseName_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtCourseName_academic);

        txtDuration_academic = new JTextField("Enter Course Duration");
        txtDuration_academic.setBounds(1190,95,200,30);
        txtDuration_academic.setFont(txtFont);
        txtDuration_academic.setForeground(new Color(105, 105, 105));
        txtDuration_academic.setBackground(new Color(235, 235, 235));
        txtDuration_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtDuration_academic.getText().equals("Enter Course Duration")){
                    txtDuration_academic.setText("");
                    txtDuration_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtDuration_academic.getText().isEmpty()){
                    txtDuration_academic.setText("Enter Course Duration");
                    txtDuration_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtDuration_academic);

        txtLevel_academic = new JTextField("Enter Course Level");
        txtLevel_academic.setBounds(190,165,200,30);
        txtLevel_academic.setFont(txtFont);
        txtLevel_academic.setForeground(new Color(105, 105, 105));
        txtLevel_academic.setBackground(new Color(235, 235, 235));
        txtLevel_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtLevel_academic.getText().equals("Enter Course Level")){
                    txtLevel_academic.setText("");
                    txtLevel_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtLevel_academic.getText().isEmpty()){
                    txtLevel_academic.setText("Enter Course Level");
                    txtLevel_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtLevel_academic);

        txtCredit_academic = new JTextField("Enter Course Credit");
        txtCredit_academic.setBounds(690,165,200,30);
        txtCredit_academic.setFont(txtFont);
        txtCredit_academic.setForeground(new Color(105, 105, 105));
        txtCredit_academic.setBackground(new Color(235, 235, 235));
        txtCredit_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCredit_academic.getText().equals("Enter Course Credit")){
                    txtCredit_academic.setText("");
                    txtCredit_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCredit_academic.getText().isEmpty()){
                    txtCredit_academic.setText("Enter Course Credit");
                    txtCredit_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtCredit_academic);

        txtNumberOfAssessments_academic = new JTextField("Enter No of Assessments");
        txtNumberOfAssessments_academic.setBounds(1190,165,200,30);
        txtNumberOfAssessments_academic.setFont(txtFont);
        txtNumberOfAssessments_academic.setForeground(new Color(105, 105, 105));
        txtNumberOfAssessments_academic.setBackground(new Color(235, 235, 235));
        txtNumberOfAssessments_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtNumberOfAssessments_academic.getText().equals("Enter No of Assessments")){
                    txtNumberOfAssessments_academic.setText("");
                    txtNumberOfAssessments_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtNumberOfAssessments_academic.getText().isEmpty()){
                    txtNumberOfAssessments_academic.setText("Enter No of Assessments");
                    txtNumberOfAssessments_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtNumberOfAssessments_academic);

        txtCourseID1_academic = new JTextField("Enter Course ID");
        txtCourseID1_academic.setBounds(190,315,200,30);
        txtCourseID1_academic.setFont(txtFont);
        txtCourseID1_academic.setForeground(new Color(105, 105, 105));
        txtCourseID1_academic.setBackground(new Color(235, 235, 235));
        txtCourseID1_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCourseID1_academic.getText().equals("Enter Course ID")){
                    txtCourseID1_academic.setText("");
                    txtCourseID1_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCourseID1_academic.getText().isEmpty()){
                    txtCourseID1_academic.setText("Enter Course ID");
                    txtCourseID1_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtCourseID1_academic);

        txtCourseLeader_academic = new JTextField("Enter Course Leader");
        txtCourseLeader_academic.setBounds(1190,315,200,30);
        txtCourseLeader_academic.setFont(txtFont);
        txtCourseLeader_academic.setForeground(new Color(105, 105, 105));
        txtCourseLeader_academic.setBackground(new Color(235, 235, 235));
        txtCourseLeader_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCourseLeader_academic.getText().equals("Enter Course Leader")){
                    txtCourseLeader_academic.setText("");
                    txtCourseLeader_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCourseLeader_academic.getText().isEmpty()){
                    txtCourseLeader_academic.setText("Enter Course Leader");
                    txtCourseLeader_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtCourseLeader_academic);

        txtLecturerName_academic = new JTextField("Enter Lecturer Name");
        txtLecturerName_academic.setBounds(190,385,200,30);
        txtLecturerName_academic.setFont(txtFont);
        txtLecturerName_academic.setForeground(new Color(105, 105, 105));
        txtLecturerName_academic.setBackground(new Color(235, 235, 235));
        txtLecturerName_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtLecturerName_academic.getText().equals("Enter Lecturer Name")){
                    txtLecturerName_academic.setText("");
                    txtLecturerName_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtLecturerName_academic.getText().isEmpty()){
                    txtLecturerName_academic.setText("Enter Lecturer Name");
                    txtLecturerName_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtLecturerName_academic);

        txtStartingDate_academic = new JTextField("Enter Starting Date");
        txtStartingDate_academic.setBounds(690,385,200,30);
        txtStartingDate_academic.setFont(txtFont);
        txtStartingDate_academic.setForeground(new Color(105, 105, 105));
        txtStartingDate_academic.setBackground(new Color(235, 235, 235));
        txtStartingDate_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtStartingDate_academic.getText().equals("Enter Starting Date")){
                    txtStartingDate_academic.setText("");
                    txtStartingDate_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtStartingDate_academic.getText().isEmpty()){
                    txtStartingDate_academic.setText("Enter Starting Date");
                    txtStartingDate_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtStartingDate_academic);

        txtCompletionDate_academic = new JTextField("Enter Completion Date");
        txtCompletionDate_academic.setBounds(1190,385,200,30);
        txtCompletionDate_academic.setFont(txtFont);
        txtCompletionDate_academic.setForeground(new Color(105, 105, 105));
        txtCompletionDate_academic.setBackground(new Color(235, 235, 235));
        txtCompletionDate_academic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCompletionDate_academic.getText().equals("Enter Completion Date")){
                    txtCompletionDate_academic.setText("");
                    txtCompletionDate_academic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCompletionDate_academic.getText().isEmpty()){
                    txtCompletionDate_academic.setText("Enter Completion Date");
                    txtCompletionDate_academic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_academic.add(txtCompletionDate_academic);
        
        //-------------------------------------------------------------------------------------------------------------------------------------
        //Creating buttons for academic course

        Font btnFont = new Font("Verdana",Font.BOLD,17);
        btnAdd_academic = new JButton("Add");
        btnAdd_academic.setBounds(1297,230,90,40);
        btnAdd_academic.setFont(btnFont);
        btnAdd_academic.setFocusable(false);
        btnAdd_academic.setBackground(new Color(94, 219, 98));
        btnAdd_academic.setForeground(Color.white);
        panelCourse_academic.add(btnAdd_academic);

        
        btnRegister_academic = new JButton("Register");
        btnRegister_academic.setBounds(1260,460,130,40);
        btnRegister_academic.setFont(btnFont);
        btnRegister_academic.setFocusable(false);
        btnRegister_academic.setBackground(new Color(94, 219, 98));
        btnRegister_academic.setForeground(Color.white);
        panelCourse_academic.add(btnRegister_academic);

        btnDisplay_academic = new JButton("Display");
        btnDisplay_academic.setBounds(600,460,110,40);
        btnDisplay_academic.setFont(btnFont);
        btnDisplay_academic.setFocusable(false);
        btnDisplay_academic.setBackground(new Color(232, 144, 93));
        btnDisplay_academic.setForeground(Color.white);
        panelCourse_academic.add(btnDisplay_academic);

        btnClear_academic = new JButton("Clear");
        btnClear_academic.setBounds(760,460,100,40);
        btnClear_academic.setFont(btnFont);
        btnClear_academic.setFocusable(false);
        btnClear_academic.setBackground(new Color(219, 94, 94));
        btnClear_academic.setForeground(Color.white);
        panelCourse_academic.add(btnClear_academic);
        
        btnBack_academic = new JButton("<----");
        btnBack_academic.setBounds(1300,10,90,40);
        btnBack_academic.setFont(btnFont);
        btnBack_academic.setFocusable(false);
        btnBack_academic.setBackground(new Color(94, 219, 98));
        btnBack_academic.setForeground(Color.white);
        //Method to switch between academic course and display panel
        btnBack_academic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelCourse_academic.setVisible(true);
                panelCourse_nonAcademic.setVisible(false);
                panelDisplay_academic.setVisible(false);
                btnAcademicCourse.setBackground(new Color(46, 46, 46));
                btnAcademicCourse.setForeground(Color.white);
                btnNonAcademicCourse.setBackground(new Color(82, 82, 82));
                btnNonAcademicCourse.setForeground(Color.white);
            }
        });
        panelDisplay_academic.add(btnBack_academic);
        
        //-------------------------------------------------------------------------------------------------------------------------------------
        //Creating labels for non academic course
        lblCourse_nonAcademic = new JLabel("Non Academic Course");
        lblCourse_nonAcademic.setFont(title);
        lblCourse_nonAcademic.setBounds(600,10,330,40);
        panelCourse_nonAcademic.add(lblCourse_nonAcademic);
        
        lblCourseID_nonAcademic = new JLabel("CourseID:");
        lblCourseID_nonAcademic.setBounds(40,90,130,40);
        lblCourseID_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblCourseID_nonAcademic);
        
        lblCourseName_nonAcademic = new JLabel("Course Name:");
        lblCourseName_nonAcademic.setBounds(990,90,170,40);
        lblCourseName_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblCourseName_nonAcademic);
        
        lblDuration_nonAcademic = new JLabel("Duration:");
        lblDuration_nonAcademic.setBounds(46,160,130,40);
        lblDuration_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblDuration_nonAcademic);
        
        lblPrerequisite_nonAcademic = new JLabel("Prerequisite:");
        lblPrerequisite_nonAcademic.setBounds(1002,160,170,40);
        lblPrerequisite_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblPrerequisite_nonAcademic);
        
        lblCourseID_nonAcademic = new JLabel("CourseID:");
        lblCourseID_nonAcademic.setBounds(40,310,130,40);
        lblCourseID_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblCourseID_nonAcademic);
        
        lblCourseLeader_nonAcademic = new JLabel("Course Leader:");
        lblCourseLeader_nonAcademic.setBounds(480,310,170,40);
        lblCourseLeader_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblCourseLeader_nonAcademic);
        
        lblInstructorName_nonAcademic = new JLabel("Instructor Name:");
        lblInstructorName_nonAcademic.setBounds(954,310,200,40);
        lblInstructorName_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblInstructorName_nonAcademic);
        
        lblStartDate_nonAcademic = new JLabel("Starting Date:");
        lblStartDate_nonAcademic.setBounds(10,380,200,40);
        lblStartDate_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblStartDate_nonAcademic);
        
        lblExamDate_nonAcademic = new JLabel("Exam Date:");
        lblExamDate_nonAcademic.setBounds(520,380,200,40);
        lblExamDate_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblExamDate_nonAcademic);
        
        lblCompletionDate_nonAcademic = new JLabel("Completion Date:");
        lblCompletionDate_nonAcademic.setBounds(954,380,210,40);
        lblCompletionDate_nonAcademic.setFont(lblFont);
        panelCourse_nonAcademic.add(lblCompletionDate_nonAcademic);
        
        lblCourse1_nonAcademic = new JLabel("Non Academic Course");
        lblCourse1_nonAcademic.setFont(title);
        lblCourse1_nonAcademic.setBounds(600,10,330,40);
        panelDisplay_nonAcademic.add(lblCourse1_nonAcademic);
        
        //-------------------------------------------------------------------------------------------------------------------------------------
        //Creating text fields for non academic course
        txtCourseID_nonAcademic = new JTextField("Enter Course ID");
        txtCourseID_nonAcademic.setBounds(190,95,200,30);
        txtCourseID_nonAcademic.setFont(txtFont);
        txtCourseID_nonAcademic.setForeground(new Color(105, 105, 105));
        txtCourseID_nonAcademic.setBackground(new Color(235, 235, 235));
        txtCourseID_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCourseID_nonAcademic.getText().equals("Enter Course ID")){
                    txtCourseID_nonAcademic.setText("");
                    txtCourseID_nonAcademic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCourseID_nonAcademic.getText().isEmpty()){
                    txtCourseID_nonAcademic.setText("Enter Course ID");
                    txtCourseID_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtCourseID_nonAcademic);
        
        txtCourseName_nonAcademic = new JTextField("Enter Course Name");
        txtCourseName_nonAcademic.setBounds(1190,95,200,30);
        txtCourseName_nonAcademic.setFont(txtFont);
        txtCourseName_nonAcademic.setForeground(new Color(105, 105, 105));
        txtCourseName_nonAcademic.setBackground(new Color(235, 235, 235));
        txtCourseName_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCourseName_nonAcademic.getText().equals("Enter Course Name")){
                    txtCourseName_nonAcademic.setText("");
                    txtCourseName_nonAcademic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCourseName_nonAcademic.getText().isEmpty()){
                    txtCourseName_nonAcademic.setText("Enter Course Name");
                    txtCourseName_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtCourseName_nonAcademic);
        
        txtDuration_nonAcademic = new JTextField("Enter Course Duration");
        txtDuration_nonAcademic.setBounds(190,165,200,30);
        txtDuration_nonAcademic.setFont(txtFont);
        txtDuration_nonAcademic.setForeground(new Color(105, 105, 105));
        txtDuration_nonAcademic.setBackground(new Color(235, 235, 235));
        txtDuration_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtDuration_nonAcademic.getText().equals("Enter Course Duration")){
                    txtDuration_nonAcademic.setText("");
                    txtDuration_nonAcademic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtDuration_nonAcademic.getText().isEmpty()){
                    txtDuration_nonAcademic.setText("Enter Course Duration");
                    txtDuration_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtDuration_nonAcademic);
        
        txtPrerequisite_nonAcademic = new JTextField("Enter Course Prerequisite");
        txtPrerequisite_nonAcademic.setBounds(1190,165,200,30);
        txtPrerequisite_nonAcademic.setFont(txtFont);
        txtPrerequisite_nonAcademic.setForeground(new Color(105, 105, 105));
        txtPrerequisite_nonAcademic.setBackground(new Color(235, 235, 235));
        txtPrerequisite_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtPrerequisite_nonAcademic.getText().equals("Enter Course Prerequisite")){
                    txtPrerequisite_nonAcademic.setText("");
                    txtPrerequisite_nonAcademic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtPrerequisite_nonAcademic.getText().isEmpty()){
                    txtPrerequisite_nonAcademic.setText("Enter Course Prerequisite");
                    txtPrerequisite_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtPrerequisite_nonAcademic);
        
        txtCourseID1_nonAcademic = new JTextField("Enter Course ID");
        txtCourseID1_nonAcademic.setBounds(190,315,200,30);
        txtCourseID1_nonAcademic.setFont(txtFont);
        txtCourseID1_nonAcademic.setForeground(new Color(105, 105, 105));
        txtCourseID1_nonAcademic.setBackground(new Color(235, 235, 235));
        txtCourseID1_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCourseID1_nonAcademic.getText().equals("Enter Course ID")){
                    txtCourseID1_nonAcademic.setText("");
                    txtCourseID1_nonAcademic.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(txtCourseID1_nonAcademic.getText().isEmpty()){
                    txtCourseID1_nonAcademic.setText("Enter Course ID");
                    txtCourseID1_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtCourseID1_nonAcademic);
        
        txtCourseLeader_nonAcademic = new JTextField("Enter Course Leader");
        txtCourseLeader_nonAcademic.setBounds(680,315,200,30);
        txtCourseLeader_nonAcademic.setFont(txtFont);
        txtCourseLeader_nonAcademic.setForeground(new Color(105, 105, 105));
        txtCourseLeader_nonAcademic.setBackground(new Color(235, 235, 235));
        txtCourseLeader_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCourseLeader_nonAcademic.getText().equals("Enter Course Leader")){
                    txtCourseLeader_nonAcademic.setText("");
                    txtCourseLeader_nonAcademic.setForeground(Color.black);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(txtCourseLeader_nonAcademic.getText().isEmpty()){
                    txtCourseLeader_nonAcademic.setText("Enter Course Leader");
                    txtCourseLeader_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtCourseLeader_nonAcademic);
        
        txtInstructorName_nonAcademic = new JTextField("Enter Instructor Name");
        txtInstructorName_nonAcademic.setBounds(1190,315,200,30);
        txtInstructorName_nonAcademic.setFont(txtFont);
        txtInstructorName_nonAcademic.setForeground(new Color(105, 105, 105));
        txtInstructorName_nonAcademic.setBackground(new Color(235, 235, 235));
        txtInstructorName_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtInstructorName_nonAcademic.getText().equals("Enter Instructor Name")){
                    txtInstructorName_nonAcademic.setText("");
                    txtInstructorName_nonAcademic.setForeground(Color.black);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(txtInstructorName_nonAcademic.getText().isEmpty()){
                    txtInstructorName_nonAcademic.setText("Enter Instructor Name");
                    txtInstructorName_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtInstructorName_nonAcademic);
        
        txtStartDate_nonAcademic = new JTextField("Enter Start Date");
        txtStartDate_nonAcademic.setBounds(190,385,200,30);
        txtStartDate_nonAcademic.setFont(txtFont);
        txtStartDate_nonAcademic.setForeground(new Color(105, 105, 105));
        txtStartDate_nonAcademic.setBackground(new Color(235, 235, 235));
        txtStartDate_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtStartDate_nonAcademic.getText().equals("Enter Start Date")){
                    txtStartDate_nonAcademic.setText("");
                    txtStartDate_nonAcademic.setForeground(Color.black);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(txtStartDate_nonAcademic.getText().isEmpty()){
                    txtStartDate_nonAcademic.setText("Enter Start Date");
                    txtStartDate_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtStartDate_nonAcademic);
        
        txtExamDate_nonAcademic = new JTextField("Enter Exam Date");
        txtExamDate_nonAcademic.setBounds(680,385,200,30);
        txtExamDate_nonAcademic.setFont(txtFont);
        txtExamDate_nonAcademic.setForeground(new Color(105, 105, 105));
        txtExamDate_nonAcademic.setBackground(new Color(235, 235, 235));
        txtExamDate_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtExamDate_nonAcademic.getText().equals("Enter Exam Date")){
                    txtExamDate_nonAcademic.setText("");
                    txtExamDate_nonAcademic.setForeground(Color.black);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(txtExamDate_nonAcademic.getText().isEmpty()){
                    txtExamDate_nonAcademic.setText("Enter Exam Date");
                    txtExamDate_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtExamDate_nonAcademic);
        
        txtCompletionDate_nonAcademic = new JTextField("Enter Completion Date");
        txtCompletionDate_nonAcademic.setBounds(1190,385,200,30);
        txtCompletionDate_nonAcademic.setFont(txtFont);
        txtCompletionDate_nonAcademic.setForeground(new Color(105, 105, 105));
        txtCompletionDate_nonAcademic.setBackground(new Color(235, 235, 235));
        txtCompletionDate_nonAcademic.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if(txtCompletionDate_nonAcademic.getText().equals("Enter Completion Date")){
                    txtCompletionDate_nonAcademic.setText("");
                    txtCompletionDate_nonAcademic.setForeground(Color.black);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(txtCompletionDate_nonAcademic.getText().isEmpty()){
                    txtCompletionDate_nonAcademic.setText("Enter Completion Date");
                    txtCompletionDate_nonAcademic.setForeground(new Color(105, 105, 105));
                }
            }
        });
        panelCourse_nonAcademic.add(txtCompletionDate_nonAcademic);
        
        //-------------------------------------------------------------------------------------------------------------------------------------
        //Creating buttons for non academi course
        btnAdd_nonAcademic = new JButton("Add");
        btnAdd_nonAcademic.setBounds(1297,230,90,40);
        btnAdd_nonAcademic.setFont(btnFont);
        btnAdd_nonAcademic.setBackground(new Color(94, 219, 98));
        btnAdd_nonAcademic.setForeground(Color.white);
        btnAdd_nonAcademic.setFocusable(false);
        panelCourse_nonAcademic.add(btnAdd_nonAcademic);
        
        btnRegister_nonAcademic = new JButton("Register");
        btnRegister_nonAcademic.setBounds(1260,430,130,40);
        btnRegister_nonAcademic.setFont(btnFont);
        btnRegister_nonAcademic.setBackground(new Color(94, 219, 98));
        btnRegister_nonAcademic.setForeground(Color.white);
        btnRegister_nonAcademic.setFocusable(false);
        panelCourse_nonAcademic.add(btnRegister_nonAcademic);
        
        btnRemove_nonAcademic = new JButton("Remove");
        btnRemove_nonAcademic.setBounds(1260,480,130,40);
        btnRemove_nonAcademic.setFont(btnFont);
        btnRemove_nonAcademic.setBackground(new Color(219, 94, 94));
        btnRemove_nonAcademic.setForeground(Color.white);
        btnRemove_nonAcademic.setFocusable(false);
        panelCourse_nonAcademic.add(btnRemove_nonAcademic);
        
        btnDisplay_nonAcademic = new JButton("Display");
        btnDisplay_nonAcademic.setBounds(600,460,110,40);
        btnDisplay_nonAcademic.setFont(btnFont);
        btnDisplay_nonAcademic.setBackground(new Color(232, 144, 93));
        btnDisplay_nonAcademic.setForeground(Color.white);
        btnDisplay_nonAcademic.setFocusable(false);
        panelCourse_nonAcademic.add(btnDisplay_nonAcademic);
        
        btnClear_nonAcademic = new JButton("Clear");
        btnClear_nonAcademic.setBounds(760,460,100,40);
        btnClear_nonAcademic.setFont(btnFont);
        btnClear_nonAcademic.setBackground(new Color(219, 94, 94));
        btnClear_nonAcademic.setForeground(Color.white);
        btnClear_nonAcademic.setFocusable(false);
        panelCourse_nonAcademic.add(btnClear_nonAcademic);
        
        btnBack_nonAcademic = new JButton("<----");
        btnBack_nonAcademic.setBounds(1300,10,90,40);
        btnBack_nonAcademic.setFont(btnFont);
        btnBack_nonAcademic.setFocusable(false);
        btnBack_nonAcademic.setBackground(new Color(94, 219, 98));
        btnBack_nonAcademic.setForeground(Color.white);
        btnBack_nonAcademic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelCourse_nonAcademic.setVisible(true);
                panelCourse_academic.setVisible(false);
                panelDisplay_nonAcademic.setVisible(false);
                btnNonAcademicCourse.setBackground(new Color(46, 46, 46));
                btnNonAcademicCourse.setForeground(Color.white);
                btnAcademicCourse.setBackground(new Color(82, 82, 82));
                btnAcademicCourse.setForeground(Color.white);
            }
        });
        panelDisplay_nonAcademic.add(btnBack_nonAcademic);
        
        //-------------------------------------------------------------------------------------------------------------------------------------
        //Event listeners for buttons of academic course
        //Method to add the given input to the array list academicCourseList
        btnAdd_academic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(txtCourseID_academic.getText().isEmpty() || txtCourseID_academic.getText().equals("Enter Course ID") || txtCourseName_academic.getText().isEmpty() || txtCourseName_academic.getText().equals("Enter Course Name") || 
                txtDuration_academic.getText().isEmpty() || txtDuration_academic.getText().equals("Enter Course Duration") || txtLevel_academic.getText().isEmpty() || txtLevel_academic.getText().equals("Enter Course Level") || 
                txtCredit_academic.getText().isEmpty() || txtCredit_academic.getText().equals("Enter Course Credit") || txtNumberOfAssessments_academic.getText().isEmpty() || txtNumberOfAssessments_academic.getText().equals("Enter No of Assessments")){
                    JOptionPane.showMessageDialog(mainFrame,"All the fields are required","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                String courseID = txtCourseID_academic.getText();
                for(Course c : academicCourseList){
                    if(c.getCourseID().equals(courseID)){
                        JOptionPane.showMessageDialog(mainFrame,"The given course id already exist","Information",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                    
                String courseName = txtCourseName_academic.getText();
                String level = txtLevel_academic.getText();
                String credit = txtCredit_academic.getText();
                int duration = 0, numberOfAssessments = 0;
                       
                try{
                        duration = Integer.parseInt(txtDuration_academic.getText());
                        numberOfAssessments = Integer.parseInt(txtNumberOfAssessments_academic.getText());
                    }
                    
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(mainFrame,"Please input valid values","Warning",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                
                AcademicCourse academicCourse = new AcademicCourse(courseID,courseName,duration,level,credit,numberOfAssessments);
                academicCourseList.add(academicCourse);
                JOptionPane.showMessageDialog(mainFrame,"Course added successfully ","Information",JOptionPane.INFORMATION_MESSAGE);
            }
        });
           
        //Method to clear all the textfields of academic course
        btnClear_academic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtCourseID_academic.setText("");
                txtCourseName_academic.setText("");
                txtDuration_academic.setText("");
                txtLevel_academic.setText("");
                txtCredit_academic.setText("");
                txtNumberOfAssessments_academic.setText("");
                txtCourseID1_academic.setText("");
                txtCourseLeader_academic.setText("");
                txtLecturerName_academic.setText("");
                txtStartingDate_academic.setText("");
                txtCompletionDate_academic.setText("");
            }
        });
        
        //Method to register given course id
        btnRegister_academic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(txtCourseID1_academic.getText().isEmpty() || txtCourseID1_academic.getText().equals("Enter Course ID") || txtCourseLeader_academic.getText().isEmpty() || txtCourseLeader_academic.getText().equals("Enter Course Leader") || 
                txtLecturerName_academic.getText().isEmpty() || txtLecturerName_academic.getText().equals("Enter Lecturer Name") || txtStartingDate_academic.getText().isEmpty() || txtStartingDate_academic.getText().equals("Enter Starting Date") || 
                txtCompletionDate_academic.getText().isEmpty() || txtCompletionDate_academic.getText().equals("Enter Completion Date")){
                    JOptionPane.showMessageDialog(mainFrame,"All the fields are required","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                String courseLeader = txtCourseLeader_academic.getText();
                String lecturerName = txtLecturerName_academic.getText();
                String startingDate = txtStartingDate_academic.getText();
                String completionDate = txtCompletionDate_academic.getText();
                boolean flag = false;
                
                for(int i = 0; i < academicCourseList.size(); i++){
                    if(academicCourseList.get(i).getCourseID().equals(txtCourseID1_academic.getText())){
                        flag = true;
                        AcademicCourse ac = (AcademicCourse)(academicCourseList.get(i));
                        if(!ac.getIsRegistered()){
                            ac.register(courseLeader,lecturerName,startingDate,completionDate); 
                            JOptionPane.showMessageDialog(mainFrame,"Course registered successfully","Information",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }else{
                            JOptionPane.showMessageDialog(mainFrame,"The given course id has already been registered","Information",JOptionPane.INFORMATION_MESSAGE);
                            return;   
                        }
                    }else{
                        flag = false;
                    }
                }
                
                if(flag == false){
                   JOptionPane.showMessageDialog(mainFrame,"The given course id doesn't exist","Information",JOptionPane.INFORMATION_MESSAGE);
                   return;
                }
            }
        });
        
        //-------------------------------------------------------------------------------------------------------------------------------------
        //Event listeners for buttons of non academic course
        //Method to add given input to array list nonAcademicCourseList
        btnAdd_nonAcademic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(txtCourseID_nonAcademic.getText().isEmpty() || txtCourseID_nonAcademic.getText().equals("Enter Course ID") || txtCourseName_nonAcademic.getText().isEmpty() || txtCourseName_nonAcademic.getText().equals("Enter Course Name") ||
                txtDuration_nonAcademic.getText().isEmpty() || txtDuration_nonAcademic.getText().equals("Enter Course Duration") || txtPrerequisite_nonAcademic.getText().isEmpty() || txtPrerequisite_nonAcademic.getText().equals("Enter Course Prerequisite")){
                    JOptionPane.showMessageDialog(mainFrame,"All the fields are required","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                String courseID = txtCourseID_nonAcademic.getText();
                for(Course c: nonAcademicCourseList){
                    if(c.getCourseID().equals(courseID)){
                        JOptionPane.showMessageDialog(mainFrame,"The given course id already exist","Information",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                    
                String courseName = txtCourseName_nonAcademic.getText();
                String prerequisite = txtPrerequisite_nonAcademic.getText();
                int duration = 0;
                    
                try{
                    duration = Integer.parseInt(txtDuration_nonAcademic.getText());
                }
        
                catch(Exception ex){
                    JOptionPane.showMessageDialog(mainFrame,"Please input valid values","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                    
                NonAcademicCourse nonAcademicCourse = new NonAcademicCourse(courseID,courseName,duration,prerequisite);
                nonAcademicCourseList.add(nonAcademicCourse);
                JOptionPane.showMessageDialog(mainFrame,"Course added successfully","Information",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        //Method to clear all the textfields of non academic course
        btnClear_nonAcademic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtCourseID_nonAcademic.setText("");
                txtCourseName_nonAcademic.setText("");
                txtDuration_nonAcademic.setText("");
                txtPrerequisite_nonAcademic.setText("");
                txtCourseID1_nonAcademic.setText("");
                txtCourseLeader_nonAcademic.setText("");
                txtInstructorName_nonAcademic.setText("");
                txtStartDate_nonAcademic.setText("");
                txtExamDate_nonAcademic.setText("");
                txtCompletionDate_nonAcademic.setText("");
            }
        });
        
        //Method to register non academic course id
        btnRegister_nonAcademic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(txtCourseID_nonAcademic.getText().isEmpty() || txtCourseID_nonAcademic.getText().equals("Enter Course ID") || txtCourseLeader_nonAcademic.getText().isEmpty() || txtCourseLeader_nonAcademic.getText().equals("Enter Course Leader") ||  
                txtInstructorName_nonAcademic.getText().isEmpty() || txtInstructorName_nonAcademic.getText().equals("Enter Instructor Name") || txtStartDate_nonAcademic.getText().isEmpty() || txtStartDate_nonAcademic.getText().equals("Enter Start Date") ||  
                txtExamDate_nonAcademic.getText().isEmpty() || txtExamDate_nonAcademic.getText().equals("Enter Exam Date") || txtCompletionDate_nonAcademic.getText().isEmpty() || txtCompletionDate_nonAcademic.getText().equals("Enter Completion Date")){
                    JOptionPane.showMessageDialog(mainFrame,"All the fields are required","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                String courseLeader = txtCourseLeader_nonAcademic.getText();
                String instructorName = txtInstructorName_nonAcademic.getText();
                String startDate = txtStartDate_nonAcademic.getText();
                String examDate = txtExamDate_nonAcademic.getText();
                String completionDate = txtCompletionDate_nonAcademic.getText();
                boolean flag = false;
                
                for(int i = 0; i < nonAcademicCourseList.size(); i++){
                    if(nonAcademicCourseList.get(i).getCourseID().equals(txtCourseID1_nonAcademic.getText())){
                        flag = true;
                        NonAcademicCourse nac = (NonAcademicCourse)(nonAcademicCourseList.get(i));
                        if(!nac.getIsRegistered()){
                            nac.register(courseLeader,instructorName,startDate,completionDate,examDate); 
                            JOptionPane.showMessageDialog(mainFrame,"Course registered successfully","Information",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(mainFrame,"The given course id has already been registered","Information",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }else{
                        flag = false;
                    }
                }
                
                if (flag == false){
                        JOptionPane.showMessageDialog(mainFrame,"The given course id doesn't exist","Information",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
            }
        });
        
        //Method to remove non academic course id
        btnRemove_nonAcademic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e_){
                if(txtCourseID1_nonAcademic.getText().isEmpty() || txtCourseID1_nonAcademic.getText().equals("Enter Course ID")){
                    JOptionPane.showMessageDialog(mainFrame,"Please enter course id","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
            }
                
            int response = JOptionPane.showConfirmDialog(mainFrame,"Are you sure you want to remove this id","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                
                if(response == 0){
                boolean flag = false;
                String courseID = txtCourseID1_nonAcademic.getText();
                Iterator <Course> itr = nonAcademicCourseList.iterator();
                while(itr.hasNext()){
                    Course c = itr.next();
                    if(c.getCourseID().equals(courseID)){
                        flag = true;
                        NonAcademicCourse nac = (NonAcademicCourse)c;
                        if(!nac.getIsRemoved()){
                            nac.remove();
                            JOptionPane.showMessageDialog(mainFrame,"Course removed successfully","Information",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(mainFrame,"The given course id has already been removed","Information",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        flag = false;
                    }
                }
                
                if(flag == false){
                    JOptionPane.showMessageDialog(mainFrame,"The given course id doesn't exist","Warning",JOptionPane.WARNING_MESSAGE);
                    return;   
                }
            }
        }
        });
        
        //Method to display contents or data of array academicCourseList
        btnDisplay_academic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){            
                model_academic.setRowCount(0);
                
                for( int i = 0; i < academicCourseList.size(); i++){
                    AcademicCourse acDisplay = (AcademicCourse)academicCourseList.get(i);
                    
                    data_academic[0] = acDisplay.getCourseID();
                    data_academic[1] = acDisplay.getCourseName();
                    data_academic[2] = acDisplay.getCourseLeader();
                    data_academic[3] = acDisplay.getLecturerName();
                    data_academic[4] = acDisplay.getLevel();
                    data_academic[5] = acDisplay.getCredit();
                    data_academic[6] = acDisplay.getStartingDate();
                    data_academic[7] = acDisplay.getCompletionDate();
                    data_academic[8] = acDisplay.getDuration();
                    data_academic[9] = acDisplay.getNumberOfAssessments();
                    
                    model_academic.addRow(data_academic);
                }
                
                panelCourse_academic.setVisible(false);
                panelCourse_nonAcademic.setVisible(false);
                panelDisplay_academic.setVisible(true);
            }
        });
        
        //Method to display the contents or data of array list nonAcademicCourseList
        btnDisplay_nonAcademic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                model_nonAcademic.setRowCount(0);
                
                for( int i = 0; i < nonAcademicCourseList.size(); i++){
                    NonAcademicCourse nacDisplay = (NonAcademicCourse)nonAcademicCourseList.get(i);
                    
                    data_nonAcademic[0] = nacDisplay.getCourseID();
                    data_nonAcademic[1] = nacDisplay.getCourseName();
                    data_nonAcademic[2] = nacDisplay.getCourseLeader();
                    data_nonAcademic[3] = nacDisplay.getInstructorName();
                    data_nonAcademic[4] = nacDisplay.getPrerequisite();
                    data_nonAcademic[5] = nacDisplay.getStartDate();
                    data_nonAcademic[6] = nacDisplay.getCompletionDate();
                    data_nonAcademic[7] = nacDisplay.getDuration();
                    
                    model_nonAcademic.addRow(data_nonAcademic);
                }
                
                panelCourse_academic.setVisible(false);
                panelCourse_nonAcademic.setVisible(false);
                panelDisplay_nonAcademic.setVisible(true);
            }
        });
        
        mainFrame.setVisible(true);
    }

    //Main method of the program
    public static void main(String[] args) {
        new INGCollege();
    }
}