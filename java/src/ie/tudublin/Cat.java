package ie.tudublin;
 public class Cat
 {
     private int numLives;
     private String name;

     public Cat(String name)
     {
         this.name = name;
         this.numLives = 9;
     }

     public void setLives(int numLives)
     {
         this.numLives = numLives;
     }

     public int getLives()
     {
         return this.numLives;
     }

     public void kill()
     {
         this.numLives -= 1;
         if (this.numLives > 0)
         {
             System.out.println("Ouch!");
         }
         else
         {
             System.out.println("Dead");
         }
     }
 }