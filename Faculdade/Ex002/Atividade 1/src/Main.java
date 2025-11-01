public class Main {
    public static void main(String[] args) {
        Carro[] carros = new Carro[10];

        carros[0] = new Carro("Toyota", "Corolla", "Preto", 125000.0,2022);
        carros[1] = new Carro("Honda", "Civic", "Branco", 118000.0, 2021);
        carros[2] = new Carro("Ford", "Ka", "Prata", 48000.0, 2019);
        carros[3] = new Carro("Chevrolet", "Onix", "Vermelho", 67000.0, 2020);
        carros[4] = new Carro("Volkswagen", "Gol", "Azul", 55000.0, 2018);
        carros[5] = new Carro("Fiat", "Argo", "Cinza", 72000.0, 2023);
        carros[6] = new Carro("Hyundai", "HB20", "Branco", 80000.0, 2022);
        carros[7] = new Carro("Nissan", "Kicks", "Preto", 95000.0, 2020);
        carros[8] = new Carro("Renault", "Sandero", "Prata", 52000.0, 2019);
        carros[9] = new Carro("Jeep", "Compass", "Verde", 180000.0, 2023);

        System.out.println("Lista de Carros:\n");
        for (Carro c : carros) {
            System.out.println(c); // usa automaticamente o toString()
        }

        System.out.println("\nComparando dois carros:");
        System.out.println("carros[0] == carros[1]? " + carros[0].equals(carros[1]));
        System.out.println("carros[0] == carros[0]? " + carros[0].equals(carros[0]));
    }
}
