package ie.tudublin;
public class Animal
{
	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }
	public static void main(String[] args)
	{
		System.out.println("Hello world");
 		Dog penny = new Dog();
 		penny.setName("Penny");
 		penny.speak();

 		Cat ginger = new Cat("Ginger");
 		while (ginger.getLives() > 0)
 		{
 			ginger.kill();
 		}
 	}

 }