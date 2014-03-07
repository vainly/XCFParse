package com.cl.xiachufang;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 上午9:42
 */
public class UrlSplitTest {
    public static void main(String[] args) {
        String url = "http://www.xiachufang.com/recipe/1064357/";
        String[] strs = url.split("\\/");
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            System.out.println(i+":"+str);
        }
        System.out.println("the last nuber "+strs[strs.length-1]);
    }
}
