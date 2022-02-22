package com.mypackage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args){
//        String[] args = new String[5];
//        args[0] = ".html";
//        args[1] = "angularjs";
//        args[2] = "C:\\Users\\talit\\Desktop\\test-hooks-master\\test-hooks-master\\frontend";
//        args[3] = "correct";
//        args[4] = "nomeTag";

        System.out.println("Inizio");
        Path start = Paths.get(args[2]);
        try {
            Stream<Path> streamPath = Files.walk(start, Integer.MAX_VALUE);
            List<String> filePathList = streamPath
                    .map(String::valueOf)
                    .sorted()
                    .collect(Collectors.toList());
            //ottenere lista di file di FE
            List<String> feFilePathList = filePathList
                    .stream()
                    .filter(fileName -> fileName.contains(args[0]))
                    .collect(Collectors.toList());

            System.out.println("La lista dei file di FE è:");
            System.out.println(feFilePathList);
            List<String> commmandList = createHookInjectionShContent(feFilePathList, args[1]);
            System.out.println("La lista dei comandi da inserire nel file hookInjection.sh:");
            System.out.println(commmandList);

            //Creare file hookInjection.sh
            FileWriter myWriter = new FileWriter("hookInjection.sh");
            commmandList.forEach(feFile -> {
                try {
                    myWriter.write(feFile+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("Successfully wrote to the file.");
            myWriter.close();


            //parte di correzione dei file di frontend
            if(args.length>=4 && args[3].equals("correct")){
                feFilePathList.forEach(filePath -> {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                        String line = bufferedReader.readLine();
                        StringBuilder fileContent = new StringBuilder(line);
                        while(line != null) {
                            System.out.println(line);
                            line = bufferedReader.readLine();
                            if(line != null) fileContent.append(line).append("\n");
                        }
                        System.out.println("[Correzione File FE] il valore originale è:");
                        System.out.println(fileContent);
                        System.out.println("[Correzione File FE] il valore con l'aggiunta dei timestamp è:");
                        String newContentFeFile = fileContent.toString();
                        Date date = new Date();
                        long timeMilli = date.getTime();
                        newContentFeFile = newContentFeFile.replaceAll(" x-test"," "+args[4]+"-"+timeMilli+"-x-test");
                        System.out.println(newContentFeFile);
                        //Aggiorare contenuto file
                        FileWriter writerToUpdateFe = new FileWriter(filePath);
                        writerToUpdateFe.write(newContentFeFile);
                        writerToUpdateFe.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    public static List<String> createHookInjectionShContent(List<String> fileFeList, String grammarType){
        List<String> commandList = new ArrayList<>();
        fileFeList.forEach(
                content -> {
                    content = "node main.js inject-hooks "
                            + content
                            + " --grammar "
                            + grammarType;
                    commandList.add(content);
                }
        );
        return commandList;
    }

}
