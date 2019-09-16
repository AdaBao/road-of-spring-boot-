package Test;

public class Family {
    private Person father;
    private Person mother;
    private Person son;
    private String givenName;

    public void print(){
        System.out.println(this.givenName);
        System.out.println("father: "+father.toString());
        System.out.println("mother: "+mother.toString());
        System.out.println("son: "+son.toString());
    }
}
