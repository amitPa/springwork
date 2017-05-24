/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.report.filewatcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author AmitPandey
 */
public class CatchLatestFile {
    
    public void getFile() throws IOException
    {
        File file=getLatestFilefromDir();
        System.out.println(file.toString());
    }
    private File getLatestFilefromDir() throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        InputStream input = null;
        input = new FileInputStream("config.properties");
        prop.load(input);
        File dir = new File(prop.getProperty("location"));
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }
}
