import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;

public class Customer implements ActionListener {

    // All the essential container and components of the swing UI
    JFrame frame;

    JButton AddBtn, SearchBtn, DisplayBtn;
    JLabel Title, CustomerName, CustomerNumber, City, State, Pincode, ResultSection, SearchSection, SearchCustomerNumber;
    JTextField CustomerNameT, CustomerNumberT, CityT, StateT, PincodeT, SearchCustomerNumberT;
    JTextArea ResultsArea;
    JScrollPane scrollPane;
    ArrayList<CustomerManagement> CustomerData = new ArrayList<CustomerManagement>();
    

    public Customer(){

        // Added all the required fields for the UI
        frame = new JFrame("Java Lab Swing Application");

        Title = new JLabel("ABC Corporation Customer Data");
        frame.add(Title);
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setBounds(250, 10, 300, 50);
        Title.setFont(new Font("Calibri", Font.BOLD, 18));

        CustomerName = new JLabel("Customer Name:  ");
        frame.add(CustomerName);
        CustomerName.setBounds(50, 65, 150, 25);
        CustomerNameT = new JTextField();
        frame.add(CustomerNameT);
        CustomerNameT.setBounds(190, 65, 150, 25);

        CustomerNumber = new JLabel("Customer Number:  ");
        frame.add(CustomerNumber);
        CustomerNumber.setBounds(50, 95, 150, 25);
        CustomerNumberT = new JTextField();
        frame.add(CustomerNumberT);
        CustomerNumberT.setBounds(190, 95, 150, 25);

        City = new JLabel("City:  ");
        frame.add(City);
        City.setBounds(50, 125, 150, 25);
        CityT = new JTextField();
        frame.add(CityT);
        CityT.setBounds(190, 125, 150, 25);

        State = new JLabel("State:  ");
        frame.add(State);
        State.setBounds(50, 155, 150, 25);
        StateT = new JTextField();
        frame.add(StateT);
        StateT.setBounds(190, 155, 150, 25);

        Pincode = new JLabel("Pincode:  ");
        frame.add(Pincode);
        Pincode.setBounds(50, 185, 150, 25);
        PincodeT = new JTextField();
        frame.add(PincodeT);
        PincodeT.setBounds(190, 185, 150, 25);

        AddBtn =new JButton("Add Customer");
        frame.add(AddBtn);
        AddBtn.setBounds(50,215,150,30);
        AddBtn.addActionListener(this);

        DisplayBtn =new JButton("Display Customers");
        frame.add(DisplayBtn);
        DisplayBtn.setBounds(190,215,150,30);
        DisplayBtn.addActionListener(this);

        SearchSection = new JLabel("Search Customer Data");
        frame.add(SearchSection);
        SearchSection.setBounds(100, 275, 200, 25);
        SearchSection.setFont(new Font("Calibri", Font.BOLD, 15));

        SearchCustomerNumber = new JLabel("Customer Number:  ");
        frame.add(SearchCustomerNumber);
        SearchCustomerNumber.setBounds(50, 305, 150, 25);
        SearchCustomerNumberT = new JTextField();
        frame.add(SearchCustomerNumberT);
        SearchCustomerNumberT.setBounds(190, 305, 150, 25);

        SearchBtn =new JButton("Search Customer");
        frame.add(SearchBtn);
        SearchBtn.setBounds(120,335,130,30);
        SearchBtn.addActionListener(this);

        ResultSection = new JLabel("Results");
        frame.add(ResultSection);
        ResultSection.setBounds(400, 65, 200, 25);
        ResultSection.setFont(new Font("Calibri", Font.BOLD, 15));

        ResultsArea = new JTextArea();
        frame.add(ResultsArea);
        ResultsArea.setBounds(400, 95, 350, 250);

        scrollPane = new JScrollPane(ResultsArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);
        scrollPane.setBounds(400, 95, 350, 250);

        // Essential options set for the created frame container
        frame.setSize(800,420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e){   

        if(e.getSource() == AddBtn){

            // Unique customer number is first check with the available data on the list
            // If the data is absent, then the given data is added to the Arraylist
            String SearchingNumber = CustomerNumberT.getText();
            int flag;
            flag = 0;
            for(CustomerManagement data:CustomerData){

                if(data.number.equals(SearchingNumber)){

                    ResultsArea.setText("");
                    ResultsArea.append("Customer Number Already Exists !\nCould not add the data");
                    flag = 1;
                }

            }

            if(flag != 1){

                CustomerManagement obj = new CustomerManagement(CustomerNameT.getText(), CustomerNumberT.getText(), CityT.getText(), StateT.getText(), PincodeT.getText());
                CustomerData.add(obj);
                String message = "Given data has been added to the list.";
                ResultsArea.setText(message);

            }

        }

        if(e.getSource() == DisplayBtn){

            // For loop is used for displaying all the available data
            ResultsArea.setText("");
            for(CustomerManagement data:CustomerData){

                ResultsArea.append("Customer Name: "+data.name+"\n");
                ResultsArea.append("Customer Number: "+data.number+"\n");
                ResultsArea.append("Customer City: "+data.city+"\n");
                ResultsArea.append("Customer State: "+data.state+"\n");
                ResultsArea.append("Customer Pincode: "+data.pincode+"\n");
                ResultsArea.append("\n\n");

            }

        }

        if(e.getSource() == SearchBtn){

            // Equals method is used to compare the given and available data
            // If it gets matched, the data is sent for displaying
            String SearchingNumber = SearchCustomerNumberT.getText();
            for(CustomerManagement data:CustomerData){

                if(data.number.equals(SearchingNumber)){

                    ResultsArea.setText("");
                    ResultsArea.append("Customer Name: "+data.name+"\n");
                    ResultsArea.append("Customer Number: "+data.number+"\n");
                    ResultsArea.append("Customer City: "+data.city+"\n");
                    ResultsArea.append("Customer State: "+data.state+"\n");
                    ResultsArea.append("Customer Pincode: "+data.pincode+"\n");
                    
                }

            }

        }

    }

    public static void main (String[] args) {

        // Swing Class is added to the main function
        new Customer();

    }

}

class CustomerManagement {  

    // A Class for holding the customer infomation datas.
    String name, city, state, number, pincode;

    CustomerManagement(String name, String number, String city, String state, String pincode){
         this.name=name;
         this.number=number;
         this.city=city;
         this.state=state;
         this.pincode=pincode;
    }
}