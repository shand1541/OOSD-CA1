
public class books {
	// Attributes
    private String isbn;
    private String title;
    private int year;
    private String Category;

    // Constructor
    public void Book(String isbn, String title, int year ,String Category)
    {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.Category = Category;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
    
    public String category(){
    	return Category;
    }

    // Setters
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public void setCategory (String Category){
    	this.Category = Category;
    }

    // toString method
    public String toString() {
        return "Book [ISBN=" + isbn + ", Title=" + title + ", Year=" + year + " , category=" + Category + ",]";
    }//end
}//end all

