import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    //программа для сохранения номеров телефона
    public static final String SYMBOLS = "\\D";
    //сохраняем номера телефонов в TreeSet
    private static Set<String> phoneNumbers = new TreeSet<>();
    public static void main(String[] args) {
        System.out.println("Введите номер телефона");
        while(true){
            //ввод ноиера
            String input = new Scanner(System.in).nextLine();
            //печать ноиеров
            if(input.equalsIgnoreCase("печать")){
                print();
                continue;
            }
            //выход из программы
            if(input.equalsIgnoreCase("выход")){
                return;
            }
            //добавляем номер в список
            addPhoneNumber(input);


        }
    }
    //метод добавления номеров в коллекцию
    public static void addPhoneNumber(String phoneNumber){
        //удаляем все символы, кроме цифр
        phoneNumber=phoneNumber.replaceAll(SYMBOLS,"");
        //если номер ужу существует в базе, выводим сообщение
        if(phoneNumbers.contains(phoneNumber)){
            System.out.println("Такой номер уже существует в базе!");
        }
        //если указан номер без +7 и 8, делаем проверку номера
        else if(phoneNumber.length()==10 && phoneNumber.startsWith("9")){
            phoneNumbers.add(phoneNumber);
            System.out.println("Телефонный номер \""+phoneNumber+"\" добавлен");
        }
        //если указан номер с +7 или 8, делаем проверку
        else if(phoneNumber.length()==11) {
            //удаляем первую цифру
            phoneNumber=phoneNumber.substring(1);
            if(phoneNumber.startsWith("9")) {
                phoneNumbers.add(phoneNumber);
                System.out.println("Телефонный номер \"" + phoneNumber + "\" добавлен");
            }
            else{
                System.out.println("Неправильный ввод!");
            }
        }
        else{
            System.out.println("Неправильный ввод!");
        }

    }
    //метод вывода номеров
    public static void print(){
        if (phoneNumbers.isEmpty()){
            System.out.println("Телефонных номеров нет в списке");
            return;
        }
        for(String s:phoneNumbers){
            //выводим номера в определенном формате
            String num = s.replaceAll("(\\d{3})(\\d{3})(\\d{2})(\\d{2})",
                    "+7($1) $2 $3 $4");
            System.out.println(num);
        }
    }

}