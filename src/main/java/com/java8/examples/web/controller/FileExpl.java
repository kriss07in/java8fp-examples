package com.java8.examples.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class FileExpl {

    public static void main(String[] args) throws Exception {
        listOfFilesinPath();
        listOfFDirectoriesinPath();
        listJavaFiles();
        listHiddenFiles();
        watchFileChanges();
    }

    private static void listOfFilesinPath() throws IOException {
        //get list of files in a path
        Files.list(Paths.get("."))
                .forEach(System.out::println);
    }

    private static void listOfFDirectoriesinPath() throws IOException {
        //get list of directories in a path
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }

    private static void listJavaFiles() throws IOException {
        //get list of java files in a path
        Files.newDirectoryStream(
            Paths.get("src/main/java/com/java8/examples/example1/controller"), path -> path.toString().endsWith(".java"))
            .forEach(System.out::println);

    }

    private static void listHiddenFiles() throws IOException {
        //get list of hidden files in a path
        final File[] files = new File(".").listFiles(file -> file.isHidden());
        System.out.println("files "+files);
        //OR
        final File[] files2 = new File(".").listFiles(File::isHidden);
        System.out.println("files2 "+files2);
    }

    //watch file changes, get notifications when any file updated in the Path
    private static void watchFileChanges() throws Exception {
        final Path path = Paths.get(".");
        final WatchService watchService = path.getFileSystem().newWatchService();

        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
    
        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
        if(watchKey != null) {
            watchKey.pollEvents()
                .stream()
                .forEach(event -> System.out.println(event.context()));
        }
    }
}