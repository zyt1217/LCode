public class Study {
//    Animal.printAnimal()
    public static void main(String[] args){


    }
}


class Animal{
    public static void printAnimal(){
        System.out.print("Animal");
    }
    private String name = "外部类";
    int age = 10;

    private void run(){
        System.out.print("run");
    }

    private void dogEat(){
        dog d = new dog();
        d.bark();
    }

    class dog{
        private String name = "内部类";
        private String value = "dog";
        public void bark(){
            System.out.print(value +':');
            System.out.print("www");
            run();
        }

    }
}

