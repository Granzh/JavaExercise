package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findUsingQueue("C:\\Users\\kbolo\\IdeaProjects\\Exercises", "txt.txt"));
    }
    public boolean findUsingRecursion(String dir, String fileName) {
        File file = new File(dir);
        if (file.isFile()) {
            return file.getName().equals(fileName);
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (findUsingRecursion(file1.getAbsolutePath(), fileName)) {
                return true;
            }
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