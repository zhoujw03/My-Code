package src.Lezione0;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        // 1. 数组的两种创建方式
        // 方式 A：创建的同时直接填入数据，数组长度由元素个数决定（当前长度为 5）
        int[] numeri = {1, 2, 3, 4, 5};

        // 方式 B：先指定数组的固定长度为 5。此时里面没有任何数字，默认全是 0
        int[] numeri2 = new int[5];

        // 2. 传统 for 循环：通过下标（索引 i）来遍历数组
        // numeri.length 自动获取数组长度（这里是 5）。i 从 0 开始，到 4 结束
        for (int i = 0; i < numeri.length; i++)
            System.out.println(numeri[i]); // 依次打印出 1, 2, 3, 4, 5

        // 3. 搬家操作：将固定长度的普通数组，转换成可以自由扩容的“动态列表 (List)”
        // 创建一个空的动态列表，名字叫 numeri3。注意：List 里面必须用 Integer（包装类），不能直接用 int
        List<Integer> numeri3 = new ArrayList<>();

        // 再次使用循环，把 numeri 数组里的每一个数字拿出来，放到 numeri3 动态列表里
        for (int i = 0; i < numeri.length; i++)
            numeri3.add(numeri[i]); // .add() 方法的作用是往列表的末尾追加一个新数字

        // 4. 增强 for 循环（foreach）：更高级、更简洁的遍历方式
        // 意思是：把 numeri3 列表中的每一个数字，依次赋值给临时变量 n，然后执行打印
        for (int n : numeri3)
            System.out.println(n); // 同样会依次打印出 1, 2, 3, 4, 5
    }
}


