package com.bizi.file;

import org.junit.Test;

import java.io.File;

public class FileOperator {
    @Test
    public void testMakeDirs(){
        String baseDir = "/home/bishion/Documents/";
        String dirList = "bizi1，bizi2";
        for (String temp :dirList.split(",")){
            if(temp!=null&&temp!=""){
                File file = new File(baseDir+temp);
                file.mkdir();
            }
        }
    }
}
