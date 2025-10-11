public class Main {
    public static void main(String[] args) {
        var person1 = new Person();

        //valores iniciais, antes do modificador 'set'
        System.out.println(person1.getName());
        System.out.println(person1.getAge());

        //vai atribuir o valor aos metodos da instância da classe
        person1.setName("Vinicius C. Tegi");
        person1.setAge(19);

        //vai retornar o valor dos metodos da instância da classe, atribuidos pelos metodos 'set'
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
    }
}
