package indi.w4xj.pattern.prototype.shallow_and_deep;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.prototype.shallow_and_deep
 * @Classname Cat
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 16:04
 * @Created by IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cat implements Cloneable, Serializable{

    String name;
    Owner owner;

    //方式一：将引用类型变量单独克隆一次
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Cat cat = (Cat)super.clone();
        cat.setOwner((Owner) cat.getOwner().clone());
        return cat;
    }

    //方式二：将对象序列化再反序列化（推荐）
    protected Object deepClone(){
        ByteArrayOutputStream bos ;
        ObjectOutputStream oos ;
        ByteArrayInputStream bis ;
        ObjectInputStream ois ;
        Object object = null;

        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            object = ois.readObject();
            ois.close();
            bis.close();
            oos.close();
            bis.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("message:=="+e.getMessage());
        }

        return object;
    }
}
