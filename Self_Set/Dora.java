class DemoClass{
    String name, clan;
    int age;
    boolean alive;
    DemoClass(String name, String clan, int age, boolean alive){
        this.name=name;
        this.clan=clan;
        this.age=age;
        this.alive=alive;
        output();
    }
    void output(){
        System.out.println(name+clan+age+alive);
    }
}

public class Dora{
    public static void main(String[] args){
        new DemoClass("John","Ballo",12,false);
    }
}

