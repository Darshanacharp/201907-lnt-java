
import console.*; //get all class from console [NOT RECOMMEDED]
import furnitures.*;
import data.*;

//avoid confusion
import furnitures.Table; //RECOMMENDED


class App{

	public static void main(String []args){

		//first create the objects
		Input keyboard=new Input();
		PrintWriter screen=new PrintWriter();
		screen.write(keyboard);
		screen.write(screen);

		Chair chair1=new Chair();
		Chair chair2=new Chair();

		Bed bed=new Bed();
		Sofa sofa=new Sofa();

		List list=new List();

		Set set =new Set();

		QuickSort sort=new QuickSort();


		screen.write(chair1);
		screen.write(chair2);
		screen.write("cost of chair is "+chair1.getPrice());
		screen.write(bed);
		screen.write(sofa);
		screen.write(list);
		screen.write(set);
		screen.write(sort);

		Table table1=new Table();

		screen.write(table1);
		screen.write(table1.getPrice());

		data.Table table2=new data.Table();
		screen.write(table2);
		table2.add(1,2,3); //data table function

	}

}