public class LinearEquation {
    private int x1,x2,y1,y2;

    public LinearEquation(int x1,int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    private double roundedToHundredth(double num){
        return Math.round(num*100)/100.0;
    }

    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
    }
    public double slope(){
        return roundedToHundredth((double)(y1-y2)/(x1-x2));
    }
    public double yIntercept(){
        return y1-(x1*slope());
    }
    public String equation(){
        double slope = slope();
        String ret = "y =";
        String yInt,y;
        if(yIntercept()%1==0){
            y = ""+(int)yIntercept();
        }else{
            y = ""+yIntercept();
        }
        if(yIntercept()>0){
            yInt = " + "+y;
        } else if(yIntercept()==0){
            yInt = "";
        } else {
            yInt = " - "+Math.abs(Integer.parseInt(y));
        }
        if(x1==x2){
            return "The points are on a vertical line, x = "+x1;
        }else{
            if (slope==0) {
                if(yIntercept()>0) {
                    ret += " "+yInt.substring(yInt.indexOf("+")+1);
                }else {
                    ret += yInt;
                }
                return ret;
            }else if(slope<0){
                ret+=" -";
            }else{
                ret += " ";
            }
            if(Math.abs(slope)==1){
                ret+="x"+yInt;
                return ret;
            }else if(slope%1==0) {
                ret+= Math.abs((int)slope);
            } else{
                ret+= +Math.abs((y1-y2))+"/"+Math.abs((x1-x2));
            }
        }
        ret+="x"+yInt;
        return ret;
    }
    public String coordinateForX(double x){
        return "("+x+", "+((x*slope())+yIntercept())+")";
    }
    public String lineInfo(){
        return "The two points are: "+coordinateForX(x1)+" and "+coordinateForX(x2)+"\n"+
                "The equation of the line between these points is: "+equation()+"\n"+
                "The slope of this line is "+slope()+"\n"+
                "The y-intercept of this line is: "+yIntercept()+"\n"+
                "The distance between these points is: "+distance()+"\n"+"\n";
    }
}
