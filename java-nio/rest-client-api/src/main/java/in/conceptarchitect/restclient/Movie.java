package in.conceptarchitect.restclient;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Movie {
		
	public Movie() {
		super();
	}



		public Movie(String imdbID, String title, String year, String poster, double imdbRating, int votes, double rating,
			String description, String tags) {
		super();
		this.imdbID = imdbID;
		this.title = title;
		this.year = year;
		this.poster = poster;
		this.imdbRating = imdbRating;
		this.votes = votes;
		this.rating = rating;
		this.description = description;
		this.tags = tags;
	}



		String imdbID;
		String title;
		String year;
		String poster;
		double imdbRating;
		int votes;
		double rating;
		String description;
		String tags;
	
		
		
		public String getImdbID() {
			return imdbID;
		}



		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}



		public String getTitle() {
			return title;
		}



		public void setTitle(String title) {
			this.title = title;
		}



		public String getYear() {
			return year;
		}



		public void setYear(String year) {
			this.year = year;
		}



		public String getPoster() {
			return poster;
		}



		public void setPoster(String poster) {
			this.poster = poster;
		}



		public double getImdbRating() {
			return imdbRating;
		}



		public void setImdbRating(double imdbRating) {
			this.imdbRating = imdbRating;
		}



		public int getVotes() {
			return votes;
		}



		public void setVotes(int votes) {
			this.votes = votes;
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



		public String getTags() {
			return tags;
		}



		public void setTags(String tags) {
			this.tags = tags;
		}



		@Override
		public String toString() {
			return "Movie [imdbID=" + imdbID + ", title=" + title + ", year=" + year + ", poster=" + poster
					+ ", imdbRating=" + imdbRating + ", votes=" + votes + ", rating=" + rating + ", description="
					+ description + ", tags=" + tags + "]";
		}
		
		
		
}
