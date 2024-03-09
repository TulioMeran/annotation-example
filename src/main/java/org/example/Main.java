package org.example;

import org.example.annotations.ImportantString;
import org.example.annotations.Runimmediately;
import org.example.annotations.VeryImportant;
import org.example.entities.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat cat = new Cat("Gatito");

       if (cat.getClass().isAnnotationPresent(VeryImportant.class)){
           System.out.println("This is very important");
           for (Method method: cat.getClass().getMethods()){
               if (method.isAnnotationPresent(Runimmediately.class)){
                   Runimmediately runimmediately = method.getAnnotation(Runimmediately.class);
                   for (int i = 0; i < runimmediately.times(); i++){
                       method.invoke(cat);
                   }

               }
           }

           for (Field field : cat.getClass().getDeclaredFields()) {
               if(field.isAnnotationPresent(ImportantString.class)){
                   field.setAccessible(true);
                  Object objectValue = field.get(cat);
                  if(objectValue instanceof String ocjectString){
                      System.out.println(ocjectString.toUpperCase());
                  }
               }
           }

       } else {
           System.out.println("This is no very important");
       }

    }
}