package app;

import in.conceptarchitect.animalkingdom.Animal;
import in.conceptarchitect.animalkingdom.BengalTiger;
import in.conceptarchitect.animalkingdom.Bird;
import in.conceptarchitect.animalkingdom.Camel;
import in.conceptarchitect.animalkingdom.Cat;
import in.conceptarchitect.animalkingdom.Cow;
import in.conceptarchitect.animalkingdom.Crocodile;
import in.conceptarchitect.animalkingdom.Dog;
import in.conceptarchitect.animalkingdom.Eagle;
import in.conceptarchitect.animalkingdom.Horse;
import in.conceptarchitect.animalkingdom.Hunter;
import in.conceptarchitect.animalkingdom.Leopard;
import in.conceptarchitect.animalkingdom.Parrot;
import in.conceptarchitect.animalkingdom.Reptile;
import in.conceptarchitect.animalkingdom.Rideable;
import in.conceptarchitect.animalkingdom.Snake;
import in.conceptarchitect.animalkingdom.Tiger;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		testAnimals();
		
//		Tiger t1=new Tiger(); //t1 is a Tiger
//		
//		Animal a=t1 ; //allowed. tiger is an animal
//		
//		Tiger t2=a
		
		Animal a=new Tiger();
		
		a.move(); //calls move from tiger object
		
		//a.hunt();  // java is not sure if current animal can hunt
		
		//Tiger t=a; // java is not sure if a is actually a tiger
		
//		Tiger t= (Tiger) a; //I am sure a is actually a tiger
//		
//		System.out.println(t.hunt());
		
		
		
		
	}

	private static void testAnimals() {
		Animal [] animals= {
				
				new Tiger(), 
				new Horse(),
				new Cow(),
				new Parrot(),
				new BengalTiger(),
				//new Reptile(),
				new Snake(),
				new Eagle(),
				new Horse(),
				new Dog(),
				//new Animal(),
				//new Cat(),
				//new Mammal(),
				new Leopard(),
				new Camel(),
				new Crocodile()
				//new Bird()
		};
		
		for(Animal animal : animals) {
			if (animal.isDomestic())
				System.out.print("***\t");
			System.out.println(animal);
			System.out.println(animal.eat());
			System.out.println(animal.move());
			
			
			
			//System.out.println(animal.hunt());//all animal don't hunt
			//huntIfYouAreATiger(animal);
			
			if(animal instanceof Hunter)
			{
				Hunter h=(Hunter) animal;
				System.out.println(h.hunt());
			}
			
			if(animal instanceof Rideable) {
				Rideable r=(Rideable)animal;
				System.out.println(r.ride());
			}
			
			
			System.out.println(animal.die());
			System.out.println("\n");
		}
	}

	private static void huntIfYouAreATiger(Animal animal) {
		if(animal instanceof Tiger) {
			Tiger tiger=(Tiger) animal; //forced typecasting
			System.out.println(tiger.hunt()); //now can hunt
		}
	}

}
