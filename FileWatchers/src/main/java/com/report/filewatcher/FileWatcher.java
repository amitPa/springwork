/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.report.filewatcher;

import java.io.BufferedReader;
import java.io.FileInputStream;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Properties;

/**
 * This program demonstrates how to use the Watch Service API to monitor change
 * events for a specific directory.
 *
 * @author AmitPandey
 */
public class FileWatcher {

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;
       // CatchLatestFile catchLatestFile=new CatchLatestFile();
       // Process p = null;
        //ProcessBuilder pb = new ProcessBuilder("mvn exec:exec -Dexec.mainClass=\"com.emailService.runProcess.RunProcess");
//        pb.command("mvn.bat exec:exec -Dexec.mainClass=\"com.emailService.runProcess.RunProcess");

        try {

            input = new FileInputStream("config.properties");
            System.out.println("file");
            // load a properties file
            prop.load(input);
            System.out.println("file2");
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get(prop.getProperty("location"));
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

           // System.out.println("Watch Service registered for dir: " + dir.getFileName());

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();

                   // System.out.println(kind.name() + ": " + fileName);

                    if (kind == ENTRY_MODIFY
                            && fileName.toString().equals("Edit.txt")) {
                        System.out.println("My source file has changed!!!");
                       // pb.start();
                    }

                    if (kind == ENTRY_CREATE) {
                        System.out.println("New File Created!!!");
                        catchLatestFile.getFile();
                        System.out.println("New File Created Amit!!!");
                        
                    }

                   // p = Runtime.getRuntime().exec(" mvn.bat exec:java -Dexec.mainClass=\"com.emailService.runProcess.RunProcess\"");
//                    BufferedReader in = new BufferedReader(
//                            new InputStreamReader(p.getInputStream()));

//                    OutputStream out = p.getOutputStream();
//                    String line = null;
//                    line = in.readLine();
                   // pb.start();
                   // System.out.println(pb);

                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
