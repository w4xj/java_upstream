package indi.w4xj.string;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.string
 * @Classname RuntimeConstantPoolOOM
 * @Description 运行时常量池
 * @Date 2021/2/28 16:57
 * @Created by IntelliJ IDEA
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);


        /**
         运行结果：
         true
         false

         R大在知乎回应了周志明的《深入理解java虚拟机》第二版中对String.intern()方法的讲解中所举的例子，在第三版中修正
         https://www.zhihu.com/question/51102308/answer/124441115


         深入理解java虚拟机》第三版
         2.4.3　方法区和运行时常量池溢出
         由于运行时常量池是方法区的一部分，所以这两个区域的溢出测试可以放到一起进行。前面曾经
         提到HotSpot从JDK 7开始逐步“去永久代”的计划，并在JDK 8中完全使用元空间来代替永久代的背景
         故事，在此我们就以测试代码来观察一下，使用“永久代”还是“元空间”来实现方法区，对程序有什么
         实际的影响。
         String::intern()是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的
         字符串，则返回代表池中这个字符串的String对象的引用；否则，会将此String对象包含的字符串添加
         到常量池中，并且返回此String对象的引用。在JDK 6或更早之前的HotSpot虚拟机中，常量池都是分配
         在永久代中，我们可以通过-XX：PermSize和-XX：MaxPermSize限制永久代的大小，即可间接限制其
         中常量池的容量，具体实现如代码清单2-7所示，请读者测试时首先以JDK 6来运行代码。

         ...
         这段代码在JDK 6中运行，会得到两个false，而在JDK 7中运行，会得到一个true和一个false。产
         生差异的原因是，在JDK 6中，intern()方法会把首次遇到的字符串实例复制到永久代的字符串常量池
         中存储，返回的也是永久代里面这个字符串实例的引用，而由StringBuilder创建的字符串对象实例在
         Java堆上，所以必然不可能是同一个引用，结果将返回false。
         而JDK 7（以及部分其他虚拟机，例如JRockit）的intern()方法实现就不需要再拷贝字符串的实例
         到永久代了，既然字符串常量池已经移到Java堆中，那只需要在常量池里记录一下首次出现的实例引
         用即可，因此intern()返回的引用和由StringBuilder创建的那个字符串实例就是同一个。而对str2比较返
         回false，这是因为“java” [2] 这个字符串在执行String-Builder.toString()之前就已经出现过了，字符串常量
         池中已经有它的引用，不符合intern()方法要求“首次遇到”的原则，“计算机软件”这个字符串则是首次
         出现的，因此结果返回true。

         [2] 它是在加载sun.misc.Version这个类的时候进入常量池的。本书第2版并未解释java这个字符串此前是
         哪里出现的，所以被批评“挖坑不填了”（无奈地摊手）。如读者感兴趣是如何找出来的，可参考Red-
         naxelaFX的知乎回答（https://www.zhihu.com/question/51102308/answer/124441115）。




         */

    }
}
