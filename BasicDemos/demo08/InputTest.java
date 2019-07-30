class InputTest{

	public static void main(String []args){
		console.Input kb=new console.Input();
		String name=kb.readString("Your name please? ");
		System.out.println("hello "+name);
	}

}