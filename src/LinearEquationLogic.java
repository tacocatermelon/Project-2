import java.util.Scanner;

public class LinearEquationLogic {

    private int x1,x2,y1,y2;
    private String coord1,coord2;

    Scanner scan = new Scanner(System.in);
    public LinearEquationLogic () {}

    public void start(){
        System.out.println("\n"+"Welcome to the linear equation calculator!");
        System.out.print("Enter coordinate 1: ");
        coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        coord2 = scan.nextLine();
        System.out.println();
        getCoords(coord1,coord2);
        LinearEquation test = new LinearEquation(x1,x2,y1,y2);
        if(x1==x2){
            System.out.println(test.equation());
            System.out.println();
        }else{
            System.out.print(test.lineInfo());
            if(y2!=y1) {
                System.out.print("Enter a value for x: ");
                System.out.println("\n" + "The point on the line is " + test.coordinateForX(scan.nextDouble()) + "\n");
                scan.nextLine();
            }
        }
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        if(scan.nextLine().equals("y")){
            start();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }

    public void getCoords(String a,String b){
        x1 = Integer.parseInt(a.substring(1,a.indexOf(",")));
        y1 = Integer.parseInt(a.substring(a.indexOf(" ")+1,a.indexOf(")")));
        x2 = Integer.parseInt(b.substring(1,b.indexOf(",")));
        y2 = Integer.parseInt(b.substring(b.indexOf(" ")+1,b.indexOf(")")));
    }
}
