package com.w4xj.principle.open_closed;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.open_closed
 * @Classname OpenClosed2
 * @Description 
 * @Date 2022/11/10 22:06
 * @Created by IntelliJ IDEA
 */
public class OpenClosed2 {
    public static void main(String[] args) {
        /**
         * 开闭原则，对扩展开放（提供方），修改关闭（调用方）
         * 本例中，新增一个三角形的图形，调用方的方式不会发生改变
         */
        GraphicEditor2 graphicEditor2 = new GraphicEditor2();
        graphicEditor2.drawShape(new Circle2());
        graphicEditor2.drawShape(new Rectangle2());
        graphicEditor2.drawShape(new Triangle2());
    }
}

//这是一个用于绘图的类 [使用方]
class GraphicEditor2 {
    //接收Shape对象，然后根据type，来绘制不同的图形
    public void drawShape(Shape2 s) {
        s.draw();
    }


}

//Shape类，基类
abstract class Shape2 {
    int m_type;
    public abstract void draw();
}



class Rectangle2 extends Shape2 {
    Rectangle2() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        //  Auto-generated method stub
        System.out.println(" 绘制矩形 ");
    }
}

class Circle2 extends Shape2 {
    Circle2() {
        super.m_type = 2;
    }
    @Override
    public void draw() {
        //  Auto-generated method stub
        System.out.println(" 绘制圆形 ");
    }
}

//新增画三角形
class Triangle2 extends Shape2 {
    Triangle2() {
        super.m_type = 3;
    }
    @Override
    public void draw() {
        //  Auto-generated method stub
        System.out.println(" 绘制三角形 ");
    }
}

//新增一个图形
class OtherGraphic2 extends Shape2 {
    OtherGraphic2() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        //  Auto-generated method stub
        System.out.println(" 绘制其它图形 ");
    }
}
