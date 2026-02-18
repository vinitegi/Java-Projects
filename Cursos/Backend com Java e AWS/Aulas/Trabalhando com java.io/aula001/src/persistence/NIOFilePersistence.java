package persistence;

import java.io.*;
import java.nio.ByteBuffer;

public class NIOFilePersistence implements FilePersistence {

    private final String currenteDir = System.getProperty("user.dir");
    private final String storedDir = "/managedFiles/NIO/";
    private final String fileName;

    public NIOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currenteDir + storedDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");

        clearFile();
    }


    @Override
    public String write(String data) {
        try (var file = new RandomAccessFile(new File(currenteDir + storedDir + fileName), "rw")){
            file.seek(file.length());
            file.writeBytes(data);
            file.writeBytes(System.lineSeparator());
        }catch (IOException e){}

        return data;
    }

    @Override
    public boolean remove(String sentence) {
        return false;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        return "";
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try(
                var file = new RandomAccessFile(new File(currenteDir + storedDir + fileName), "r");
                var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip();
                while(buffer.hasRemaining()) {
                    content.append((char) buffer.get());
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        var content = new StringBuilder();

        try(
                var file = new RandomAccessFile(new File(currenteDir + storedDir + fileName), "r");
                var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip();
                while(buffer.hasRemaining()) {
                    while(!content.toString().endsWith(System.lineSeparator())) {
                        content.append((char) buffer.get());
                    }
                    if(content.toString().contains(sentence)) {
                        break;
                    } else {
                        content.setLength(0);
                    }
                    if(!content.isEmpty()) break;

                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return content.toString();
    }

    private void clearFile(){
    try (OutputStream outputStream = new FileOutputStream(currenteDir + storedDir + fileName)){
        }catch (IOException ex){
        ex.printStackTrace();
        }
    }
    }
