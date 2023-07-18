package ch11.Ex08;

public class FileWriterExample {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("file.txt")){
            fw.write("Java");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
