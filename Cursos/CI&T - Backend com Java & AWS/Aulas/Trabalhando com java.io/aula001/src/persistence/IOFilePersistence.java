package persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class IOFilePersistence implements FilePersistence{

    private final String currenteDir = System.getProperty("user.dir");
    private final String storedDir = "/managedFiles/IO/";
    private final String fileName;

    public IOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currenteDir + storedDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");

        clearFile();
    }


    @Override
    public String write(String data) {
        try (
                var fileWriter = new FileWriter(currenteDir + storedDir + fileName, true);
                var bufferedWriter = new BufferedWriter(fileWriter);
                var printWriter = new PrintWriter(bufferedWriter);
        ) {
            printWriter.println(data); // <<< AQUI
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return data;
    }


    @Override
    public boolean remove(String sentence) {
        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(sentence))) return false;

        clearFile();
        contentList.stream()
                .filter(c -> !c.contains(sentence))
                .forEach(this::write);

        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(oldContent))) {
            return null;
        }

        clearFile();

        contentList.stream()
                .map(c -> c.contains(oldContent)
                        ? c.replace(oldContent, newContent)
                        : c)
                .forEach(this::write);

        return newContent;
    }



    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(currenteDir + storedDir + fileName))) {
            String line;
            do {
                line = reader.readLine();
                if (line != null) content.append(line)
                        .append(System.lineSeparator());
            } while (line != null);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return content.toString();    }

    @Override
    public String findBy(String sentence) {
        String found = null;
        try (var reader = new BufferedReader(new FileReader(currenteDir + storedDir + fileName))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(sentence)){
                    found = line;
                    break;
                }
                line = reader.readLine();
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
        return found;
    }


    private void clearFile(){
        try (OutputStream outputStream = new FileOutputStream(currenteDir + storedDir + fileName)){
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }


    private ArrayList<String> toListString() {
        var content = findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
        return contentList;
    }
}
