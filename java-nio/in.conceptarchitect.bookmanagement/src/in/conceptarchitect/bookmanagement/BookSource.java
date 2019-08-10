package in.conceptarchitect.bookmanagement;



public class BookSource {

	
	public BookSource() {
	}
	
	public void fill(BookList books) {
		addBooks(
				books,
				
				new Book("The Count of Monte Cristo","Alexandre Dumas",400,9.1,"fiction,classic,best-seller,history"),
				new Book("Kane And Abel","Jeffrey Archer",150,7.2,"fiction,best-seller"),
				new Book("Summons","John Grisham",280,9.1,"legal fiction,best-seller"),
				new Book("Sins of Father","Jeffrey Archer",220,8,"fiction,"),
				new Book("Brethren","John Grisham",240,6.1,"fiction,legal,"),
				
				new Book("Harry Potter and Half Blood Prince","J.K.Rowlings",350,9.1,"fantasy,best-seller,fiction"),
				new Book("A Prison of Birth","Jeffrey Archer",250,7,"fiction, retelling, count of monte cristo"),
				new Book("Harry Pottern and the Deathly Hollows","J.K.Rowlings",450,9.0,"fantasy, best-seller,fiction"),
				new Book("A study in Scarlet","Conan Doyle",120,9,"fiction,classic,detective,sherlock holmes"),
				new Book("The Sign of the Four","Conan Doyle",250,8,"fiction,classic, detective, sherlock holmes")
				
				);
		
	}
	
	
	
	
	private void addBooks(BookList bookList,Book ...books) {
		// TODO Auto-generated method stub
		for(Book book : books )
			bookList.add(book);
	}




	public static final BookSource instance=new BookSource();
	
}

