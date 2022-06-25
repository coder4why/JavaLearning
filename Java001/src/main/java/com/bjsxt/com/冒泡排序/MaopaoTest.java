package com.bjsxt.com.冒泡排序;

import java.math.BigInteger;
import java.util.Arrays;

public class MaopaoTest {

    public static void main(String[] args) {

        int[] numbers = {3,4,1,6,5,10,7,4};

        int temp = 0;
        for (int i = 0; i < numbers.length-1 ; i++) {
            boolean change = true;
            for (int j = 0; j < numbers.length-1-i ; j++) {
                if (numbers[j]>numbers[j+1]){
                    temp =  numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    change = false;
                }
            }
            if (change){
                System.out.println("冒泡优化");
                break;
            }
            System.out.println(Arrays.toString(numbers));
        }

        System.out.println("---------------------");
        System.out.println(Arrays.toString(numbers));

    }


}
