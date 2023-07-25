public class program {
    public static void main(String[] args) {
        Cat barsik = new Cat();
        barsik.name = "Барсик";
        barsik.colour = "Серый";
        barsik.weight = 4;
        barsik.height = 55;
        System.out.printf("Имя: %s;\nЦвет: %s;\nВес: %d кг;\nРост: %d см", barsik.name, barsik.colour, barsik.weight, barsik.height );

        System.out.println("\n");

        Cat murzik = new Cat();
        murzik.name = "Мурзик";
        murzik.colour = "Рыжий";
        murzik.weight = 6;
        murzik.height = 75;
        System.out.printf("Имя: %s;\nЦвет: %s;\nВес: %d кг;\nРост: %d см", murzik.name, murzik.colour, murzik.weight, murzik.height );
        System.out.println("\n");
        barsik.eat();
        System.out.println("\n");
        murzik.makeNoise();
    }
}
