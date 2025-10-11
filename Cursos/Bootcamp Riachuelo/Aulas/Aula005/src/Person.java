public class Person {
    private String name = "Jhon";
    private int age = 28;


    /*MODIFICADORES DE ACESSO
    - aumenta a segurança do codigo, possibilitando o uso de validações
    - precisam ser publicos, para poder acessar os metodos externamente
    - modificar -> set
    - retornar -> get
    */

    //altera os valores
    public void setName(String name){
        //o 'this' faz referecia ao atributo principal da classe -> so usar se repetir o nome das variaveis
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //retorno dos valores
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
