/* Program  Name: StudentAppLoan.java
 * Purpose: software to calculate student loans
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Apr 04, 2020
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import java.text.DecimalFormat;

import person.Student;
import exception.RGG_NegativeValueException;
import payables.RGG_LoanPayable;
import payables.Calculations;


public class StudentAppLoan extends JFrame
{
    // variable decalration
    private static final long serialVersionUID = 1L;

    private JLabel lblTitle, lblPersonalInfo, lblStudentId, lblFirstName, lblMiddleName, lblSurname,
            lblAddressInfo, lblAptNumber, lblStreetNumber, lblStreetName, lblCity, lblProvince, lblPostalCode,
            lblLoanInfo, lblCslLoanAmount, lblOslLoanAmount;
    private JTextField txtStudentId, txtFirstName, txtMiddleName, txtSurname, txtPostalCode, txtAptNumber,
            txtStreetNumber, txtStreetName, txtCity, txtCslLoanAmount, txtOslLoanAmount;
    private JComboBox<String> cbProvince;
    private JButton btnPrev, btnFor, btnAdd, btnDelete, btnRepayCalc;
    private JPanel topPanel, middlePanel, bottomPanel;
    private ArrayList<Student> students = new ArrayList<Student>();
    private final String programTitle = "Ramon Garcia - 0926596";
    private int studentArrayListIndex = 0;
    private JFrame mainFrame;

    // constructor
    public StudentAppLoan()
    {
        new InputForm();
    }

    /*
    * Class Name: InputForm
    * Purpose: this class will buil the main form which is the InputForm
    * Date: Apr 04, 2020
    */
    private class InputForm extends JFrame
    {
        // variable declaration
        private static final long serialVersionUID = 2L;
        private int maxMinWidth = 800, maxMinHeight = 300;

        // constructor zero args
        public InputForm()
        {
            // boiler plate
            super(programTitle);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setMaximumSize(new Dimension(maxMinWidth, maxMinHeight));
            this.setMinimumSize(new Dimension(maxMinWidth, maxMinHeight));
            this.setLayout(new BorderLayout());
            this.setLocationRelativeTo(null);

            buildMainTopPanel();
            buildMainMiddlePanel();
            buildMainBottomPanel();

            this.add(topPanel, BorderLayout.NORTH);
            this.add(middlePanel, BorderLayout.CENTER);
            this.add(bottomPanel, BorderLayout.SOUTH);

            mainFrame = this;

            this.setVisible(true);
        }

        /*
        * Method Name: buildMainTopPanel()
        * Purpose: setup the top part of the form
        * Accepts: nothing
        * Returns: void
        * Date: Apr 04, 2020
        */
        private void buildMainTopPanel()
        {
            lblTitle = new JLabel("This is Ramon Garcia's Student Loan Calculator");
            lblTitle.setFont(new Font("roboto", Font.BOLD, 13));

            topPanel = new JPanel(new FlowLayout());
            topPanel.setBorder(new EmptyBorder(new Insets(0, 0, 15, 0)));
            topPanel.add(lblTitle);
        }

        /*
        * Method Name: buildMainMiddlePanel()
        * Purpose: setup the middle part of the form
        * Accepts: nothing
        * Returns: void
        * Date: Apr 04, 2020
        */
        private void buildMainMiddlePanel()
        {
            //
            //
            // LEFT PANEL
            //
            //
            // lables

            lblPersonalInfo = new JLabel("Personal Info");
            lblPersonalInfo.setBorder(new EmptyBorder(new Insets(0, 0, 15, 0)));
            lblPersonalInfo.setHorizontalAlignment(JLabel.CENTER);
            lblPersonalInfo.setFont(new Font("roboto", Font.ITALIC, 12));

            lblStudentId = new JLabel("Student ID:");
            lblStudentId.setHorizontalAlignment(JLabel.TRAILING);
            lblStudentId.setForeground(Color.DARK_GRAY);

            lblFirstName = new JLabel("First name:");
            lblFirstName.setHorizontalAlignment(JLabel.TRAILING);
            lblFirstName.setForeground(Color.DARK_GRAY);

            lblMiddleName = new JLabel("Middle name:");
            lblMiddleName.setHorizontalAlignment(JLabel.TRAILING);
            lblMiddleName.setForeground(Color.DARK_GRAY);

            lblSurname = new JLabel("Surname:");
            lblSurname.setHorizontalAlignment(JLabel.TRAILING);
            lblSurname.setForeground(Color.DARK_GRAY);

            // text fields

            txtStudentId = new JTextField();
            // limit entry to 7 chars
            txtStudentId.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e)
                {
                    char c = e.getKeyChar();

                    if (txtStudentId.getText().length() >= 7)
                        e.consume();
                    if (!(Character.isDigit(c)))
                        e.consume();
                }
            });

            txtFirstName = new JTextField();
            txtMiddleName = new JTextField();
            txtSurname = new JTextField();

            // creating sub-container
            JPanel leftPanel = new JPanel(new GridLayout(6, 2));

            leftPanel.add(lblStudentId);
            leftPanel.add(txtStudentId);
            leftPanel.add(lblFirstName);
            leftPanel.add(txtFirstName);
            leftPanel.add(lblMiddleName);
            leftPanel.add(txtMiddleName);
            leftPanel.add(lblSurname);
            leftPanel.add(txtSurname);

            // main lef panel
            JPanel mainLeftPanel = new JPanel(new BorderLayout());
            mainLeftPanel.add(lblPersonalInfo, BorderLayout.NORTH);
            mainLeftPanel.add(leftPanel, BorderLayout.CENTER);

            //
            //
            // CENTER PANEL
            //
            //
            // lables

            lblAddressInfo = new JLabel("Address");
            lblAddressInfo.setBorder(new EmptyBorder(new Insets(0, 0, 15, 0)));
            lblAddressInfo.setHorizontalAlignment(JLabel.CENTER);
            lblAddressInfo.setFont(new Font("roboto", Font.ITALIC, 12));

            lblCity = new JLabel("City:");
            lblCity.setHorizontalAlignment(JLabel.TRAILING);
            lblCity.setForeground(Color.DARK_GRAY);

            lblProvince = new JLabel("Province:");
            lblProvince.setHorizontalAlignment(JLabel.TRAILING);
            lblProvince.setForeground(Color.DARK_GRAY);

            lblPostalCode = new JLabel("Postal code:");
            lblPostalCode.setHorizontalAlignment(JLabel.TRAILING);
            lblPostalCode.setForeground(Color.DARK_GRAY);

            lblAptNumber = new JLabel("Apartment number:");
            lblAptNumber.setHorizontalAlignment(JLabel.TRAILING);
            lblAptNumber.setForeground(Color.DARK_GRAY);

            lblStreetNumber = new JLabel("Street number:");
            lblStreetNumber.setHorizontalAlignment(JLabel.TRAILING);
            lblStreetNumber.setForeground(Color.DARK_GRAY);

            lblStreetName = new JLabel("Street name:");
            lblStreetName.setHorizontalAlignment(JLabel.TRAILING);
            lblStreetName.setForeground(Color.DARK_GRAY);

            // text fields

            txtAptNumber = new JTextField();
            txtStreetNumber = new JTextField();
            txtStreetName = new JTextField();
            txtCity = new JTextField();
            txtPostalCode = new JTextField();
            // listener to text postal code
            txtPostalCode.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e)
                {
                    char c = e.getKeyChar();

                    if (txtPostalCode.getText().length() >= 6)
                        e.consume();

                    if (!(Character.isDigit(c)) && !(Character.isLetter(c)))
                        e.consume();
                }
            });
            txtPostalCode.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e) {
                    int pos = txtPostalCode.getCaretPosition();
                    txtPostalCode.setText(txtPostalCode.getText().toUpperCase());
                    txtPostalCode.setCaretPosition(pos);
                }
            });

            // combobox items
            String[] provincesArray = {
                "AB",
                "BC",
                "MB",
                "NB",
                "NL",
                "NT",
                "NS",
                "NU",
                "ON",
                "PE",
                "QC",
                "SK",
                "YT"
            };

            // combobox
            cbProvince = new JComboBox<String>(provincesArray);
            // select none
            cbProvince.setSelectedIndex(-1);

            // creating sub-container
            JPanel centerPanel = new JPanel(new GridLayout(6, 2));

            centerPanel.add(lblCity);
            centerPanel.add(txtCity);
            centerPanel.add(lblProvince);
            centerPanel.add(cbProvince);
            centerPanel.add(lblPostalCode);
            centerPanel.add(txtPostalCode);
            centerPanel.add(lblAptNumber);
            centerPanel.add(txtAptNumber);
            centerPanel.add(lblStreetNumber);
            centerPanel.add(txtStreetNumber);
            centerPanel.add(lblStreetName);
            centerPanel.add(txtStreetName);

            // main lef panel
            JPanel mainCenterPanel = new JPanel(new BorderLayout());
            mainCenterPanel.add(lblAddressInfo, BorderLayout.NORTH);
            mainCenterPanel.add(centerPanel, BorderLayout.CENTER);

            //
            //
            // RIGHT PANEL
            //
            //
            // labels

            lblLoanInfo = new JLabel("Loan Info");
            lblLoanInfo.setBorder(new EmptyBorder(new Insets(0, 0, 15, 0)));
            lblLoanInfo.setHorizontalAlignment(JLabel.CENTER);
            lblLoanInfo.setFont(new Font("roboto", Font.ITALIC, 12));

            lblCslLoanAmount = new JLabel("CSL amount:");
            lblCslLoanAmount.setHorizontalAlignment(JLabel.TRAILING);
            lblCslLoanAmount.setForeground(Color.DARK_GRAY);

            lblOslLoanAmount = new JLabel("OSL amount:");
            lblOslLoanAmount.setHorizontalAlignment(JLabel.TRAILING);
            lblOslLoanAmount.setForeground(Color.DARK_GRAY);

            // text fields

            txtCslLoanAmount = new JTextField();
            txtOslLoanAmount = new JTextField();

            // creating sub-container
            JPanel rightPanel = new JPanel(new GridLayout(6, 2));

            rightPanel.add(lblCslLoanAmount);
            rightPanel.add(txtCslLoanAmount);
            rightPanel.add(lblOslLoanAmount);
            rightPanel.add(txtOslLoanAmount);
            // workaround to get 6 rows to work
            rightPanel.add(new JLabel());
            rightPanel.add(new JLabel());
            rightPanel.add(new JLabel());
            rightPanel.add(new JLabel());

            // main right panel
            JPanel mainRightPanel = new JPanel(new BorderLayout());
            mainRightPanel.add(lblLoanInfo, BorderLayout.NORTH);
            mainRightPanel.add(rightPanel, BorderLayout.CENTER);


            // add sub-containers to the middlePanel
            middlePanel = new JPanel(new GridLayout(0, 3));
            middlePanel.add(mainLeftPanel);
            middlePanel.add(mainCenterPanel);
            middlePanel.add(mainRightPanel);

        }

        /*
        * Method Name: buildMainBottomPanel()
        * Purpose: setup the bottom part of the form
        * Accepts: nothing
        * Returns: void
        * Date: Apr 04, 2020
        */
        private void buildMainBottomPanel()
        {
            // buttons
            btnPrev = new JButton("<<");
            // add button listener
            btnPrev.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (students.size() == 0)
                        return;

                    if (studentArrayListIndex > 0)
                    {
                        cleanUiComponents();
                        --studentArrayListIndex;

                        // call the function to retrieve student's data
                        loadValues(studentArrayListIndex);
                        SwingUtilities.updateComponentTreeUI(topPanel);
                        SwingUtilities.updateComponentTreeUI(middlePanel);
                        SwingUtilities.updateComponentTreeUI(bottomPanel);
                    }
                }
            });

            btnFor = new JButton(">>");
            // add button listener
            btnFor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (students.size() == 0)
                        return;

                    if (studentArrayListIndex < students.size() - 1)
                    {
                        cleanUiComponents();
                        ++studentArrayListIndex;

                        // call the function to retrieve student's data
                        loadValues(studentArrayListIndex);
                        SwingUtilities.updateComponentTreeUI(topPanel);
                        SwingUtilities.updateComponentTreeUI(middlePanel);
                        SwingUtilities.updateComponentTreeUI(bottomPanel);
                    }
                }
            });

            btnAdd = new JButton("Add");
            btnAdd.setForeground(Color.BLUE);
            // add button listener
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    // check if the required fields are filled in
                    if (txtStudentId.getText().isEmpty()  ||
                        txtFirstName.getText().isEmpty()  ||
                        txtSurname.getText().isEmpty()  ||
                        txtCity.getText().isEmpty()  ||
                        cbProvince.getSelectedIndex() == -1 ||
                        txtPostalCode.getText().isEmpty() ||
                        txtStreetNumber.getText().isEmpty()  ||
                        txtStreetName.getText().isEmpty()  ||
                        txtCslLoanAmount.getText().isEmpty()  ||
                        txtOslLoanAmount.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please, fill-in the blanks.", programTitle, JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // invalid postal code
                    if (txtPostalCode.getText().length() != 6)
                    {
                        JOptionPane.showMessageDialog(null, "Postal code must contain 6 chars.", programTitle, JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // check the student id number
                    if (checkStudentIdExistance(txtStudentId.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Student ID already exists.", "Student App", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String tempMiddleName = txtMiddleName.getText() == "" ? "" : txtMiddleName.getText();
                    String tempAptNumber = txtAptNumber.getText() == "" ? "" : txtAptNumber.getText();

                    double tempCsl = 0.0;
                    double tempOsl = 0.0;

                    // try catch finally
                    // to check negative values
                    try
                    {
                        tempCsl = Double.parseDouble(txtCslLoanAmount.getText());
                        tempOsl = Double.parseDouble(txtOslLoanAmount.getText());
                        RGG_NegativeValueException.checkLoanAmount(tempCsl);
                        RGG_NegativeValueException.checkLoanAmount(tempOsl);

                    }
                    catch (RGG_NegativeValueException ex)
                    {
                        JOptionPane.showMessageDialog(null, "You cannot enter negative values for Loan's Amount.\n" +
                                "Then it will be converted to positive.", programTitle, JOptionPane.WARNING_MESSAGE);
                    }
                    finally
                    {
                        tempCsl = Math.abs(tempCsl);
                        tempOsl = Math.abs(tempOsl);
                    }

                    students.add(new Student(txtStudentId.getText(), txtSurname.getText(), tempMiddleName,
                                txtFirstName.getText(), tempAptNumber, txtStreetNumber.getText(),
                                txtStreetName.getText(), txtCity.getText(),
                                cbProvince.getSelectedItem().toString(), txtPostalCode.getText(),
                                tempCsl, tempOsl));

                    // clear ui components
                    cleanUiComponents();

                    // add student index counter
                    studentArrayListIndex = students.size();
                }
            });

            btnDelete = new JButton("Delete");
            btnDelete.setForeground(Color.RED);
            // action listener to delete button
            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (students.size() == 0)
                        return;

                    students.remove(studentArrayListIndex);
                    cleanUiComponents();

                    if (students.size() >= 0)
                        studentArrayListIndex = -1;
                }
            });

            btnRepayCalc = new JButton("Repayment");
            btnRepayCalc.setForeground(Color.ORANGE);
            // add button listener
            btnRepayCalc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // check if the required fields are filled in
                    if (txtStudentId.getText().isEmpty()  ||
                        txtFirstName.getText().isEmpty()  ||
                        txtSurname.getText().isEmpty()  ||
                        txtCity.getText().isEmpty()  ||
                        cbProvince.getSelectedIndex() == -1 ||
                        txtPostalCode.getText().isEmpty() ||
                        txtStreetNumber.getText().isEmpty()  ||
                        txtStreetName.getText().isEmpty()  ||
                        txtCslLoanAmount.getText().isEmpty()  ||
                        txtOslLoanAmount.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please, select a student.", programTitle, JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    else if (students.size() == 0)
                    {
                        JOptionPane.showMessageDialog(null, "You must add at least one user to the catalog.", programTitle, JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    new RepaymentForm(mainFrame, students, studentArrayListIndex);
                }
            });

            // JPanel for buttons
            JPanel btnPanel = new JPanel(new GridLayout(1, 1));
            btnPanel.add(btnPrev);
            btnPanel.add(btnFor);
            btnPanel.add(btnAdd);
            btnPanel.add(btnDelete);
            btnPanel.add(btnRepayCalc);

            bottomPanel = new JPanel(new FlowLayout());
            bottomPanel.add(btnPanel);
        }

        /*
         * Method Name: cleanUiComponents()
         * Purpose: this function cleans all the Ui components
         * Accepts: nothing
         * Returns: void
         * Date: Apr 04, 2020
         */
        private void cleanUiComponents()
        {
            txtStudentId.setText(new String());
            txtFirstName.setText(new String());
            txtMiddleName.setText(new String());
            txtSurname.setText(new String());
            txtCity.setText(new String());
            cbProvince.setSelectedIndex(-1);
            txtPostalCode.setText(new String());
            txtAptNumber.setText(new String());
            txtStreetNumber.setText(new String());
            txtStreetName.setText(new String());
            txtCslLoanAmount.setText(new String());
            txtOslLoanAmount.setText(new String());

        }

        /*
         * Method Name: loadValues()
         * Purpose: this function retrieves values from students' arraylyst
         * Accepts: int
         * Returns: void
         * Date: Apr 04, 2020
         */
        private void loadValues(int studentArrayListIndex)
        {
            txtStudentId.setText(students.get(studentArrayListIndex).getStudentID());
            txtFirstName.setText(students.get(studentArrayListIndex).getFirstName());
            txtMiddleName.setText(students.get(studentArrayListIndex).getMiddleName());
            txtSurname.setText(students.get(studentArrayListIndex).getSurname());
            txtCity.setText(students.get(studentArrayListIndex).getCity());
            cbProvince.setSelectedItem(students.get(studentArrayListIndex).getProvince());
            txtPostalCode.setText(students.get(studentArrayListIndex).getPostalCode());
            txtAptNumber.setText(students.get(studentArrayListIndex).getAptNumber());
            txtStreetNumber.setText(students.get(studentArrayListIndex).getStreetNumber());
            txtStreetName.setText(students.get(studentArrayListIndex).getStreetName());
            txtCslLoanAmount.setText(Double.toString(students.get(studentArrayListIndex).getCslLoanAmount()));
            txtOslLoanAmount.setText(Double.toString(students.get(studentArrayListIndex).getOslLoanAmount()));
        }

        /*
         * Method Name: checkStudentIdExitance()
         * Purpose: check if entered student id is available
         * Accepts: String
         * Returns: boolean
         * Date: Apr 04, 2020
         */
        private boolean checkStudentIdExistance(String studentId)
        {
            for (Student st : students)
            {
                if (st.getStudentID().equals(studentId))
                    return true;
            }

            return false;
        }

    }

    /*
    * Class Name: RepaymentForm
    * Purpose: this class will build the secondary form which is the RepaymentForm
    * Date: Apr 04, 2020
    */
    private class RepaymentForm extends JFrame
    {
        // variable declaration
        private static final long serialVersionUID = 2L;
        private int maxMinWidth = 500, maxMinHeight = 400;
        private JLabel lblTitle, lblStudentId, lblFirstName, lblMiddleName, lblSurname,
                lblAptNumber, lblStreetNumber, lblStreetName, lblCity, lblProvince, lblPostalCode,
                lblCslLoanAmount, lblOslLoanAmount, lblAnualInterestRate, lblAmortPeriod;
        private JLabel lblStudentIdVar, lblFirstNameVar, lblMiddleNameVar, lblSurnameVar, lblAptNumberVar, lblStreetNumberVar,
                lblStreetNameVar, lblCityVar, lblProvinceVar, lblPostalCodeVar, lblCslLoanAmountVar, lblOslLoanAmountVar;
        private JComboBox<String> cbWholeNumbertInterest, cbFractionNumberInterest, cbAmortization;
        private JButton btnPrev, btnFor, btnCalc;
        private JPanel topPanel, middlePanel, bottomPanel;
        private ArrayList<Student> students = new ArrayList<Student>();
        private int studentArrayListIndex = 0;

        // constructor 3 args
        public RepaymentForm(JFrame frame, ArrayList<Student> students, int index)
        {
            // boiler plate
            super("Ramon Garcia - 0926596");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setMaximumSize(new Dimension(maxMinWidth, maxMinHeight));
            this.setMinimumSize(new Dimension(maxMinWidth, maxMinHeight));
            this.setLayout(new BorderLayout());
            this.setLocationRelativeTo(null);

            this.students = students;
            this.studentArrayListIndex = index;

            // build panels
            buildSecondaryTopPanel();
            buildSecondaryMiddlePanel();
            buildSecondaryBottomPanel();
            loadValues(studentArrayListIndex, students);

            // add panels to the main secondary form
            this.add(topPanel, BorderLayout.NORTH);
            this.add(middlePanel, BorderLayout.CENTER);
            this.add(bottomPanel, BorderLayout.SOUTH);

            this.setVisible(true);
        }

        /*
         * Method Name: buildSecondaryTopPanel()
         * Purpose: build the secondary top panel
         * Accepts: nothing
         * Returns: void
         * Date: Apr 04, 2020
         */
        private void buildSecondaryTopPanel()
        {
            lblTitle = new JLabel("Repayment"); 
            lblTitle.setFont(new Font("roboto", Font.BOLD, 13));

            topPanel = new JPanel(new FlowLayout());
            topPanel.setBorder(new EmptyBorder(new Insets(0, 0, 15, 0)));
            topPanel.add(lblTitle);
        }

        /*
         * Method Name: buildSecondaryMiddlePanel()
         * Purpose: build the secondary middle  panel
         * Accepts: nothing
         * Returns: void
         * Date: Apr 04, 2020
         */
        private void buildSecondaryMiddlePanel()
        {
            // lables
            lblStudentId = new JLabel("Student ID:");
            lblStudentId.setHorizontalAlignment(JLabel.LEADING);
            lblStudentId.setForeground(Color.DARK_GRAY);

            lblFirstName = new JLabel("First name:");
            lblFirstName.setHorizontalAlignment(JLabel.LEADING);
            lblFirstName.setForeground(Color.DARK_GRAY);

            lblMiddleName = new JLabel("Middle name:");
            lblMiddleName.setHorizontalAlignment(JLabel.LEADING);
            lblMiddleName.setForeground(Color.DARK_GRAY);

            lblSurname = new JLabel("Surname:");
            lblSurname.setHorizontalAlignment(JLabel.LEADING);
            lblSurname.setForeground(Color.DARK_GRAY);

            lblCity = new JLabel("City:");
            lblCity.setHorizontalAlignment(JLabel.LEADING);
            lblCity.setForeground(Color.DARK_GRAY);

            lblProvince = new JLabel("Province:");
            lblProvince.setHorizontalAlignment(JLabel.LEADING);
            lblProvince.setForeground(Color.DARK_GRAY);

            lblPostalCode = new JLabel("Postal code:");
            lblPostalCode.setHorizontalAlignment(JLabel.LEADING);
            lblPostalCode.setForeground(Color.DARK_GRAY);

            lblAptNumber = new JLabel("Apartment number:");
            lblAptNumber.setHorizontalAlignment(JLabel.LEADING);
            lblAptNumber.setForeground(Color.DARK_GRAY);

            lblStreetNumber = new JLabel("Street number:");
            lblStreetNumber.setHorizontalAlignment(JLabel.LEADING);
            lblStreetNumber.setForeground(Color.DARK_GRAY);

            lblStreetName = new JLabel("Street name:");
            lblStreetName.setHorizontalAlignment(JLabel.LEADING);
            lblStreetName.setForeground(Color.DARK_GRAY);

            lblCslLoanAmount = new JLabel("CSL amount:");
            lblCslLoanAmount.setHorizontalAlignment(JLabel.LEADING);
            lblCslLoanAmount.setForeground(Color.DARK_GRAY);

            lblOslLoanAmount = new JLabel("OSL amount:");
            lblOslLoanAmount.setHorizontalAlignment(JLabel.LEADING);
            lblOslLoanAmount.setForeground(Color.DARK_GRAY);

            // variable labels
            lblStudentIdVar = customJLabel(new JLabel());
            lblFirstNameVar = customJLabel(new JLabel());
            lblMiddleNameVar = customJLabel(new JLabel());
            lblSurnameVar = customJLabel(new JLabel());
            lblCityVar = customJLabel(new JLabel());
            lblProvinceVar = customJLabel(new JLabel());
            lblPostalCodeVar = customJLabel(new JLabel());
            lblAptNumberVar = customJLabel(new JLabel());
            lblStreetNumberVar = customJLabel(new JLabel());
            lblStreetNameVar = customJLabel(new JLabel());
            lblCslLoanAmountVar = customJLabel(new JLabel());
            lblOslLoanAmountVar = customJLabel(new JLabel());

            middlePanel = new JPanel(new GridLayout(12, 2));
            middlePanel.setBackground(Color.WHITE);

            middlePanel.add(lblStudentId);
            middlePanel.add(lblStudentIdVar);
            middlePanel.add(lblFirstName);
            middlePanel.add(lblFirstNameVar);
            middlePanel.add(lblMiddleName);
            middlePanel.add(lblMiddleNameVar);
            middlePanel.add(lblSurname);
            middlePanel.add(lblSurnameVar);
            middlePanel.add(lblCity);
            middlePanel.add(lblCityVar);
            middlePanel.add(lblProvince);
            middlePanel.add(lblProvinceVar);
            middlePanel.add(lblPostalCode);
            middlePanel.add(lblPostalCodeVar);
            middlePanel.add(lblAptNumber);
            middlePanel.add(lblAptNumberVar);
            middlePanel.add(lblStreetNumber);
            middlePanel.add(lblStreetNumberVar);
            middlePanel.add(lblStreetName);
            middlePanel.add(lblStreetNameVar);
            middlePanel.add(lblCslLoanAmount);
            middlePanel.add(lblCslLoanAmountVar);
            middlePanel.add(lblOslLoanAmount);
            middlePanel.add(lblOslLoanAmountVar);

        }

        /*
         * Method Name: buildSecondaryBottomPanel()
         * Purpose: build the secondary bottom panel
         * Accepts: nothing
         * Returns: void
         * Date: Apr 04, 2020
         */
        private void buildSecondaryBottomPanel()
        {
            // labels
            lblAnualInterestRate = new JLabel("Anual Int. Rate:");
            lblAnualInterestRate.setHorizontalAlignment(JLabel.LEADING);
            lblAnualInterestRate.setForeground(Color.DARK_GRAY);

            lblAmortPeriod = new JLabel("Amortization");
            lblAmortPeriod.setHorizontalAlignment(JLabel.LEADING);
            lblAmortPeriod.setForeground(Color.DARK_GRAY);

            String [] intRate = new String[100];
            String [] amortPeriod = new String[97];
            String [] fracNumInt = { "0.00", "0.25", "0.50", "0.75" };

            for (int i = 0; i < 100; ++i)
            {
                intRate[i] = Integer.toString(i);
                if (i < 97)
                {
                    amortPeriod[i] = Integer.toString(i);
                }
            }

            // combo box
            cbWholeNumbertInterest = new JComboBox<String>(intRate);
            cbFractionNumberInterest = new JComboBox<String>(fracNumInt);
            cbAmortization = new JComboBox<String>(amortPeriod);

            // set comboboxes to -1
            resetComboBox(cbWholeNumbertInterest);
            resetComboBox(cbFractionNumberInterest);
            resetComboBox(cbAmortization);


            // temp bottom panel
            JPanel tmpBottomTopPanel = new JPanel(new GridLayout(3, 2));

            // add components to temporary bottom panel
            tmpBottomTopPanel.add(lblAmortPeriod);
            tmpBottomTopPanel.add(cbAmortization);
            tmpBottomTopPanel.add(lblAnualInterestRate);
            tmpBottomTopPanel.add(cbWholeNumbertInterest);
            tmpBottomTopPanel.add(new JLabel(new String()));
            tmpBottomTopPanel.add(cbFractionNumberInterest);

            // buttons
            btnPrev = new JButton("<<");
            // add button listener
            btnPrev.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (students.size() == 0)
                        return;

                    if (studentArrayListIndex > 0)
                    {
                        resetComboBox(cbWholeNumbertInterest);
                        resetComboBox(cbFractionNumberInterest);
                        resetComboBox(cbAmortization);
                        --studentArrayListIndex;
                        loadValues(studentArrayListIndex, students);
                    }
                }
            });

            btnFor = new JButton(">>");
            // add button listener
            btnFor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (students.size() == 0)
                        return;

                    if (studentArrayListIndex < students.size() - 1)
                    {
                        resetComboBox(cbWholeNumbertInterest);
                        resetComboBox(cbFractionNumberInterest);
                        resetComboBox(cbAmortization);
                        ++studentArrayListIndex;
                        loadValues(studentArrayListIndex, students);
                    }
                }
            });

            btnCalc = new JButton("Calculate");
            btnCalc.setForeground(Color.BLUE);
            // add button listener
            btnCalc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    double interestRate = Integer.parseInt((String)cbWholeNumbertInterest.getSelectedItem()) +
                        Double.parseDouble((String)cbFractionNumberInterest.getSelectedItem());
                    int amortization = Integer.parseInt((String)cbAmortization.getSelectedItem());

                    if (cbWholeNumbertInterest.getSelectedIndex() == 0 &&
                            cbAmortization.getSelectedIndex() == 0)
                        return;

                    // some vars
                    double monthlyOsl = (interestRate + 1) * RGG_LoanPayable.ANNUAL_RATE_TO_MONTLY_RATE;
                    double monthlyCsl = (interestRate + 2.5) * RGG_LoanPayable.ANNUAL_RATE_TO_MONTLY_RATE;
                    double cslValue = students.get(studentArrayListIndex).getCslLoanAmount();
                    double oslValue = students.get(studentArrayListIndex).getOslLoanAmount();

                    // calculation obj
                    Calculations calc = new Calculations();

                    double monthlyOslPay = (double)Math.round(calc.calculateLoanPayment(oslValue, monthlyOsl, amortization) * 100) / 100;
                    double monthlyCslPay = (double)Math.round(calc.calculateLoanPayment(cslValue, monthlyCsl, amortization) * 100) / 100;
                    double totalPayment = (double)Math.round(monthlyOslPay + monthlyCslPay);
                    double totalPaymentPlusInterest = (double)Math.round(amortization * totalPayment) * 100 / 100;

                    // messeage box to show loan information to the user
                    JOptionPane.showMessageDialog(null, students.get(studentArrayListIndex).toString()
                            + "\n\nMontlhy CSL payment: $" + String.format("%.2f", monthlyCslPay)
                            + "\nMontlhy OSL payment: $" + String.format("%.2f", monthlyOslPay)
                            + "\nTotal monthly payment: $" + String.format("%.2f", totalPayment)
                            + "\n\nOver " + amortization + " month(s)."
                            + "\nTotal amount that will be repaid $" + String.format("%.2f", totalPaymentPlusInterest)
                            + "\nTotal amount borrowed: $" + String.format("%.2f", cslValue + oslValue)
                            + "\nTotal amount of interest paid: $" + String.format("%.2f", totalPaymentPlusInterest - (cslValue + oslValue)), programTitle, JOptionPane.INFORMATION_MESSAGE);
                }
            });

            // temp bottom bottom panel
            JPanel tmpBottomBottomPanel = new JPanel(new GridLayout(1, 3));

            // add components
            tmpBottomBottomPanel.add(btnPrev);
            tmpBottomBottomPanel.add(btnCalc);
            tmpBottomBottomPanel.add(btnFor);

            // create and addo to main bottom panel
            bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.add(tmpBottomTopPanel, BorderLayout.NORTH);
            bottomPanel.add(tmpBottomBottomPanel, BorderLayout.SOUTH);

        }

        /*
         * Method Name: loadValues()
         * Purpose: this function retrieves values from students' arraylyst
         * Accepts: int, ArrayList<Student>
         * Returns: void
         * Date: Apr 04, 2020
         */
        private void loadValues(int studentArrayListIndex, ArrayList<Student> students)
        {
            lblStudentIdVar.setText(students.get(studentArrayListIndex).getStudentID());
            lblFirstNameVar.setText(students.get(studentArrayListIndex).getFirstName());
            lblMiddleNameVar.setText(students.get(studentArrayListIndex).getMiddleName());
            lblSurnameVar.setText(students.get(studentArrayListIndex).getSurname());
            lblCityVar.setText(students.get(studentArrayListIndex).getCity());
            lblProvinceVar.setText(students.get(studentArrayListIndex).getProvince());
            lblPostalCodeVar.setText(students.get(studentArrayListIndex).getPostalCode());
            lblAptNumberVar.setText(students.get(studentArrayListIndex).getAptNumber());
            lblStreetNumberVar.setText(students.get(studentArrayListIndex).getStreetNumber());
            lblStreetNameVar.setText(students.get(studentArrayListIndex).getStreetName());
            lblCslLoanAmountVar.setText(Double.toString(students.get(studentArrayListIndex).getCslLoanAmount()));
            lblOslLoanAmountVar.setText(Double.toString(students.get(studentArrayListIndex).getOslLoanAmount()));
        }

        /*
         * Method Name: resetComboBox()
         * Purpose: set combobox to index 0 (reset)
         * Accepts: JComboBox
         * Returns: void
         * Date: Apr 04, 2020
         */
        private void resetComboBox(JComboBox cb)
        {
            cb.setSelectedIndex(0);
        }

        /*
         * Method Name: customJLabel()
         * Purpose: customize a Label passed as argument
         * Accepts: JLabel
         * Returns: JLabel
         * Date: Apr 04, 2020
         */
        private JLabel customJLabel(JLabel label)
        {
            label.setForeground(Color.BLACK);
            label.setFont(new Font("roboto", Font.ITALIC, 14));
            label.setHorizontalAlignment(JLabel.LEADING);

            return label;
        }
    }

    // entry point
    public static void main(String []args)
    {
        new StudentAppLoan();

    }//end of main

}//end of class
