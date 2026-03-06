package org.example.entity;

public class Mang {
    public int tinhTong(int[] array){
        if (array==null || array.length == 0){
            throw new IllegalArgumentException("Mnag k dc trong");
        }
        int sum=0;
        for (int i=0;i<array.length;i++){
            if (array[i]<1 || array[i]>1000){
                throw new IllegalArgumentException("Mang phai trong khaong 1-1000");
            }
            sum+=array[i];
        }
        return sum;
    }
}
