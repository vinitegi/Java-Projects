public record Person(String name, int age) {
    /*
    Para que serve o record?
        Serve para leitura de dados, visto que uma vez criado, os objetos dentro deles serão imutaveis
     */

    //COMPACT CONSTRUCTOR
    //vai rodar antes do restante do 'record'
    public Person{
        System.out.println("============");
        System.out.println(name);
        System.out.println(age);
        System.out.println("============end");
    }

    //CONSTRUTOR SECUNDARIO
    public Person(String name){
        this(name, 1);
    }
}
