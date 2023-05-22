package Laptops;

import java.util.*;

public class LaptopsSet {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, String> searchCriteria = new HashMap<>();

//        карта моделей
        Map<Integer, String> mapModel = new HashMap<>();
        {
            mapModel.put(1, "DEXP");
            mapModel.put(2, "Irbis");
            mapModel.put(3, "ASUS");
        }

//        карта гарантий
        Map<Integer, Integer> mapGuarantee = new HashMap<>();
        {
            mapGuarantee.put(1, 3);
            mapGuarantee.put(2, 5);
        }

//        карта OS
        Map<Integer, String> mapOS = new HashMap<>();
        {
            mapOS.put(1, "Windows 11 Pro");
            mapOS.put(2, "без ОС");
        }

//        карта цветов
        Map<Integer, String> mapColor = new HashMap<>();
        {
            mapColor.put(1, "Black");
            mapColor.put(2, "Silver");
            mapColor.put(3, "Red");
        }

//        карта диагональ экрана
        Map<Integer, Double> mapDiagonal = new HashMap<>();
        {
            mapDiagonal.put(1, 14.0);
            mapDiagonal.put(2, 15.0);
            mapDiagonal.put(3, 15.6);
        }

//          карта разрешение экрана

        Map<Integer, String> mapScreenResolution = new HashMap<>();
        {
            mapScreenResolution.put(1, "Full HD (1920x1080)");
            mapScreenResolution.put(2, "HD (1366x768)");
        }

//          карта процессор

        Map<Integer, String> mapCPU = new HashMap<>();
        {
            mapCPU.put(1, "Intel Celeron N4020");
            mapCPU.put(2, "Intel Celeron 3350");
        }

//          карта объем оперативной памяти
        Map<Integer, String> mapAmountOfRAM = new HashMap<>();
        {
            mapAmountOfRAM.put(1, "4 ГБ");
            mapAmountOfRAM.put(2, "2 ГБ");
        }

//          карта объем жесткого диска

        Map<Integer, String> mapHardDiskCapacity = new HashMap<>();
        {
            mapHardDiskCapacity.put(1, "128 ГБ");
            mapHardDiskCapacity.put(2, "256 ГБ");
        }


//        множество ноутбуков
        Laptops laptop1 = new Laptops(
                mapModel.get(1),
                mapGuarantee.get(1),
                mapOS.get(1),
                mapColor.get(2),
                mapDiagonal.get(1),
                mapScreenResolution.get(1),
                mapCPU.get(1),
                mapAmountOfRAM.get(1),
                mapHardDiskCapacity.get(2)
        );
        Laptops laptop2 = new Laptops(
                mapModel.get(2),
                mapGuarantee.get(2),
                mapOS.get(1),
                mapColor.get(1),
                mapDiagonal.get(2),
                mapScreenResolution.get(2),
                mapCPU.get(2),
                mapAmountOfRAM.get(2),
                mapHardDiskCapacity.get(1)
        );
        Laptops laptop3 = new Laptops(
                mapModel.get(3),
                mapGuarantee.get(1),
                mapOS.get(2),
                mapColor.get(3),
                mapDiagonal.get(3),
                mapScreenResolution.get(1),
                mapCPU.get(1),
                mapAmountOfRAM.get(1),
                mapHardDiskCapacity.get(1)
        );

        ArrayList<Laptops> laptopsList = new ArrayList<>();
        {
            laptopsList.add(laptop1);
            laptopsList.add(laptop2);
            laptopsList.add(laptop3);
        }



        criterion(searchCriteria, mapModel, mapGuarantee, mapDiagonal);
        System.out.println("Вы выбрали характеристики: ");
        for (Map.Entry entry : searchCriteria.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //        Выводим ноутбуки
        requiredLaptop (searchCriteria, laptopsList);

    }

//ввод
    private static int getInt(){
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }
//    получаем карту характеристик

    private static void criterion(
            Map<String, String> searchCriteria,
            Map<Integer, String> mapModel,
            Map<Integer, Integer> mapGuarantee,
            Map<Integer, Double> mapDiagonal
    )
    {
//        модель
        System.out.println("Введите цифру, соответствующую необходимомой модели:");
        System.out.println("0 - не важно");
        for (Map.Entry entry : mapModel.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        int choiceModel = getInt();
        if (choiceModel <= mapModel.size() && choiceModel > 0) {
            searchCriteria.put("модель", mapModel.get(choiceModel));
        } else {
            searchCriteria.put("модель", "нет");
        }


//        гарантия
        System.out.println("Введите цифру, соответствующую необходимомой гарантии:");
        System.out.println("0 - не важно");
        for (Map.Entry entry : mapGuarantee.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " лет");
        }
        int choiceGuarant = getInt();
        if (choiceGuarant <= mapGuarantee.size() && choiceGuarant > 0) {
            searchCriteria.put("гарантия", mapGuarantee.get(choiceGuarant).toString());
        } else {
            searchCriteria.put("гарантия", "нет");
        }

//        диагональ экрана
        System.out.println("Введите цифру, соответствующую необходимомой гарантии:");
        System.out.println("0 - не важно");
        for (Map.Entry entry : mapDiagonal.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " дюймов");
        }
        int choiceDiagonal = getInt();
        if (choiceDiagonal <= mapDiagonal.size() && choiceDiagonal > 0) {
            searchCriteria.put("диагональ", mapGuarantee.get(choiceDiagonal).toString());
        } else {
            searchCriteria.put("диагональ", "нет");
        }

    }



//    выводим нужный ноут
    private static void requiredLaptop (
            HashMap<String, String> searchCriteria,
            ArrayList<Laptops> laptopsList
    )
    {
        boolean search = false;
        for (Laptops Laptop: laptopsList) {
            if (
                 (searchCriteria.get("модель") == Laptop.getModel() || searchCriteria.get("модель").equals("нет")) &&
                 (searchCriteria.get("гарантия").equals(Laptop.getGuarantee().toString()) ||
                         searchCriteria.get("гарантия").equals("нет")) &&
                 (searchCriteria.get("диагональ").equals(Laptop.getDiagonal().toString()) ||
                                 searchCriteria.get("диагональ").equals("нет"))
            ) {
                System.out.print("По запросу найден ноутбук: " + Laptop);
                search = true;
            }
        }
        if (!search) System.out.print("По запросу ничего не найдено");
    }

}
