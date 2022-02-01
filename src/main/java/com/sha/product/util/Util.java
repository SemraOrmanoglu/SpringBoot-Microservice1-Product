package com.sha.product.util;

public class Util
{
    private Util(){}

    public static  void showExceptionInfo(Exception e)
    {
        System.err.println(e.getClass().getSimpleName()
                +"is occured.Exception message:"+e.getMessage());
    }
}
