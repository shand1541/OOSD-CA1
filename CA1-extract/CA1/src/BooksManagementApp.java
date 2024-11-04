//imports
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;


public class BooksManagementApp extends JFrame implements ActionListener {

	// Components needed 
    private JTextField txtIsbn, txtTitle, txtYear;
    private JTextArea textArea;
    private JButton btnAddBook, btnClearFields, btnSearch, btnExit , btn1,btn2,btn3;//don't forget to add 
    private JPanel eastPanel;
    
    // ArrayList to add books 
    private ArrayList<Book> bookList = new ArrayList<>();

    public BooksManagementApp() {
        super("Book Management");

        // Set frame close 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 300);

        // Top Panel with Title Border
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));  // flow
        topPanel.setBorder(BorderFactory.createTitledBorder("Book Details"));

        // Labels and TextFields for ISBN, Title, Year
        JLabel lblIsbn = new JLabel("Book Number:");
        txtIsbn = new JTextField(10);  //size 

        JLabel lblTitle = new JLabel("Book Title:");
        txtTitle = new JTextField(10);

        JLabel lblYear = new JLabel("Publication Year:");
        txtYear = new JTextField(5);

        // Buttons in the top panel
        btnAddBook = new JButton("add"); //add books 
        btnSearch = new JButton("search ");//search

        // Register ActionListeners 
        btnAddBook.addActionListener(this);
        btnSearch.addActionListener(this);

        // single line 
        topPanel.add(lblIsbn);
        topPanel.add(txtIsbn);
        topPanel.add(lblTitle);
        topPanel.add(txtTitle);
        topPanel.add(lblYear);
        topPanel.add(txtYear);
        topPanel.add(btnAddBook);
        topPanel.add(btnSearch);
        
        /**bottom panel**/

        // Bottom Panel with Bevel Border Raised- important 
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        // Buttons in the bottom panel
        btnClearFields = new JButton("clear ");//show books in future 
        btnExit = new JButton("Exit");//exit 
      

        // Register ActionListeners 
        btnClearFields.addActionListener(this);; 
        btnExit.addActionListener(this);

        // Add buttons 
        bottomPanel.add(btnClearFields);
        bottomPanel.add(btnExit);

        // displaying book 
        textArea = new JTextArea(8, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add top and bottom panels to the frame
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.WEST);
        this.add(eastPanel , BorderLayout.EAST);
        // Set frame 
        this.setVisible(true);
        
       
        GridLayout grid = new GridLayout(3,1);
        JPanel eastPanel = new JPanel(grid); // grid
        eastPanel.setBorder(BorderFactory.createTitledBorder("category"));//name
        
        btn1 = new JButton("sci fi");
        btn2 = new JButton("business");
        btn3 = new JButton("fantasy"); 
        
        eastPanel.add(btn1);
        eastPanel.add(btn2);
        eastPanel.add(btn2);
        
       
    }
  
    /** actions**/
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnAddBook) {
            // Add book details to the list 
            String isbn = txtIsbn.getText();
            String title = txtTitle.getText();
            String year = txtYear.getText();
            //get
            if (!isbn.isEmpty() && !title.isEmpty() && !year.isEmpty()) {
                try {
                    Integer.parseInt(year);
                    Book book = new Book();
                    bookList.add(book);  // Add book to the list
                    textArea.append(book.toString() + "\n");  // Display book details
                    clear();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);//errors
                }
            } //end if 
            else {
                JOptionPane.showMessageDialog(this, "fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);//ensure all info
            }//end else 
        } 
        else if (e.getSource() == btnClearFields) {
            // Clear 
            clear();
        } 
            else {
                StringBuilder booksDetails = new StringBuilder("Books in the system:\n");
                for (Book book : bookList) {
                    booksDetails.append(book.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(this, booksDetails.toString(), "Book List", JOptionPane.INFORMATION_MESSAGE);//book details
            }
             if  (e.getSource() == btnExit) {//exit
            // Exit
            System.exit(0);}
             
            if (e.getSource()== btnSearch){
            	if (!isbn.isEmpty()){
            		for (Book book : bookList) {
                        booksDetails.append(book.toString()).append("\n");
            		
            	}
            		
            	
            }//end search 
            
        }
  
        
       //end action 

    // Clear text fields 
    private void clear() {
        txtIsbn.setText("");
        txtTitle.setText("");
        txtYear.setText("");
    }//end clear

    // Main method 
    public static void main(String[] args) {
        new BooksManagementApp();
    }//end main
}//end


   
