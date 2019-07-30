class App{

	public static void main(String []args){

		//first create the objects
		Input keyboard=new Input();
		PrintWriter screen=new PrintWriter();

		//now use the objects
		int value=keyboard.readInt("n?");

		screen.write("Square of "+value+" is "+(value*value));



	}

}