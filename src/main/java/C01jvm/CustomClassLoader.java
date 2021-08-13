package C01jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        CustomClassLoader loader = new CustomClassLoader();
        Class<?> cla = loader.findClass("Hello");
        Method method = cla.getDeclaredMethod("hello");
        method.invoke(cla.newInstance());
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        FileInputStream in = null;
        try {
            in = new FileInputStream("C:\\Users\\Xiamen\\.IntelliJIdea2019.2\\config\\scratches\\Hello.xlass");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[1024];
        boolean notEnd = true;
        int length = 0;
        while(notEnd) {
            try {
                length = in.read(bytes);
                notEnd = length > -1;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (notEnd) {
                for (int i = 0; i < 1024; i++) {
                    bytes[i] = (byte)(255 - bytes[i]);
                }
                out.write(bytes, 0, length);
            }
        }
        byte[] result = out.toByteArray();
        return defineClass("Hello", result, 0, result.length);
    }

}