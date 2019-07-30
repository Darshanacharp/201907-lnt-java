class App{

	public static void main(String []args){

		//first create the objects
		console.Input keyboard=new console.Input();
		console.PrintWriter screen=new console.PrintWriter();

		furnitures.Chair chair1=new furnitures.Chair();
		furnitures.Chair chair2=new furnitures.Chair();

		furnitures.Bed bed=new furnitures.Bed();
		furnitures.Sofa sofa=new furnitures.Sofa();

		data.List list=new data.List();

		data.Set set =new data.Set();

		data.QuickSort sort=new data.QuickSort();


		screen.write(chair1);
		screen.write(chair2);
		screen.write("cost of chair is "+chair1.getPrice());
		screen.write(bed);
		screen.write(sofa);
		screen.write(list);
		screen.write(set);
		screen.write(sort);

		furnitures.Table table1=new furnitures.Table();

		screen.write(table1);
		screen.write(table1.getPrice());

		data.Table table2=new data.Table();
		screen.write(table2);
		table2.add(1,2,3); //data table function

	}

}