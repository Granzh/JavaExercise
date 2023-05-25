package org.example;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public boolean findUsingRecursion(String dir, String fileName) {
        File file = new File(dir);
        File[] files = file.listFiles();
        try {
            for (File file1 : files) {
                if (file1.isFile() && file1.getName().equals(fileName)) {
                    return true;
                } else if (!file1.isFile()){
                    findUsingRecursion(file1.getAbsolutePath(), fileName);
                }
            }
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return false;
    }
    boolean findUsingQueue(String dir, String fileName) {
        Queue<File> files = new LinkedList<>();
        final File INITIAL_FILE = new File(dir);
        files.offer(INITIAL_FILE);
        while (!files.isEmpty()){
            try {
                File file = files.poll();
                if (file.isFile() && file.getName().equals(fileName)) {
                    return true;
                } else {
                    File[] subDirectories = file.listFiles();
                    for (File f : subDirectories) {
                        files.offer(f);
                    }
                }
            } catch (NullPointerException e) {
                e.fillInStackTrace();
            }
        }
        return false;
    }
}