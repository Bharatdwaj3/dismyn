class DemoClass<T, U, V, W>{
    T name;
    U clan;
    V age;
    W alive;
    DemoClass(T name, U clan , V age, W alive){
        this.name=name;
        this.clan=clan;
        this.age=age;
        this.alive=alive;
        output();
    }
    void output(){
        System.out.println("Name: "+name+ "Clan: "+clan+"Age: "+age+"Alive: "+alive);
    }
}


public class TypeCoat {
    public static void main(String[] args){
        new DemoClass<String, String, Integer, Boolean>("Rudra", "Bismark", 27, true);
        new DemoClass<String, Double, Integer, String>("Rudra", 456.00, 27, "maybe");
        
    }
}
