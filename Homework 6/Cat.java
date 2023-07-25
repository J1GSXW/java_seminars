// Реализуйте класс Cat, включающий в себя от трех полей
// и от двух методов, определяющих базовый функционал класса(за основу можно взять наработки с семинара).
// Создать два экземпляра класса Cat и вывести информацию о них на экран.
/**
 * Cat
 */
public class Cat {
    String name;
    String colour;
    int weight;
    int height;

    public void eat(){
        System.out.printf("%s покушал", name);
    }

    public void makeNoise(){
        System.out.println("Мяу");
    }
}