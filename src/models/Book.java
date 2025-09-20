package models;

 public class Book{
     public static void main (String args[]){
        Books b=new Books(1, "1984", "George Orwell");
        // System.out.println("Book Details: " + b);
        
     }
 }
 class Books{
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    
    public Books( int id,String title,String author){
        this.id=id;
        this.title=title;
        this.author=author;
        this.isIssued=false;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean getIssued(){
        return isIssued;
    }

    public void setIssued(boolean issued){
        this.isIssued=issued;
    }
    @Override
    public String toString() {
        return id + ". " + title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    
 }
}