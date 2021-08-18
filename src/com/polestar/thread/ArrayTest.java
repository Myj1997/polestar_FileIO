package com.polestar.thread;

public class ArrayTest {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};

        String path = System.getProperty("user.dir");
        System.out.println(path);


        for(int i : arr1){
            System.out.println(i);
            // 향상된 for 문은 배열에 존재하는 값을 가져오는 것을 해준다
        }

    }
}
