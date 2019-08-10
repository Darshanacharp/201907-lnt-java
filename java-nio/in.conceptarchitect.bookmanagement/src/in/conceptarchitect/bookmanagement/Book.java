package in.conceptarchitect.bookmanagement;

import java.io.Serializable;

public class Book implements Comparable<Book>
{

	String title;
	String author;
	int price;
	double rating;
	String description;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Book(String title, String author, int price, double rating, String description) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.rating = rating;
		this.description = description;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", rating=" + rating
				+ ", description=" + description + "]";
	}
	
	
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return title.compareToIgnoreCase(o.getTitle());
	}
	
	
	
}
