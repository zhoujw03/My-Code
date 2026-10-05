package Lezione0;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // 1. 基本数据类型赋值与打印
        int x = 10;
        System.out.println(x); // 输出 10

        // 2. 通过 new 关键字在堆内存中创建了两个不同的字符串对象
        String test1 = new String("Hello");
        String test2 = new String("Hello");

        System.out.println(test1); // 输出 Hello

        // 字符串拼接：test1 本身的值并没有改变（仍然是 "Hello"），
        // 这里只是把拼接后的新字符串 "HelloWorld" 打印了出来（体现了 String 的不可变性）
        System.out.println(test1 + "World");

        // 3. 字符串的比对方式
        // 方式 A：.equals() 方法比较的是【内容】。
        // 因为两个字符串里面的文本都是 "Hello"，所以这里结果为 true，会执行 if 分支
        if (test1.equals(test2)) {
            System.out.println("Le stringhe sono uguali"); // 打印：字符串相等
        } else
            System.out.println("Le stringhe NON sono uguali");

        // 方式 B：== 操作符比较的是【内存地址（指针）】。
        // 因为是用 new 分别创建的，它们在内存里的位置不同，所以结果为 false，会执行 else 分支
        if (test1 == test2)
            System.out.println("Le stringhe sono uguali");
        else
            System.out.println("Le stringhe NON sono uguali"); // 打印：字符串不相等

        // 4. 用户交互与循环控制
        Scanner s = new Scanner(System.in); // 创建扫描器，准备接收控制台的用户输入
        String input_utente; // 声明一个变量，用来临时存放用户输入的文本

        boolean continua = true; // 循环控制开关，true 代表继续循环

        // 当 continua 为 true 时，循环体会一直重复执行
        while (continua){
            x *= 2; // 等同于 x = x * 2，每次循环把 x 的值翻倍
            System.out.println(x);

            input_utente = s.nextLine(); // 程序会在这里暂停，等待用户在控制台输入一行文本并回车
            System.out.println("hai inserito: " + input_utente); // 打印：你输入了 xxx

            // 退出机制：判断用户输入的文本是否【不等于】"esci"。
            // 如果用户输入了 "esci"，input_utente.equals("esci") 结果为 true，
            // 前面加个感叹号取反 !true 变成 false。continua 变成 false 后，下一次循环就会自动终止。
            continua = !input_utente.equals("esci");
        }
    }
}

