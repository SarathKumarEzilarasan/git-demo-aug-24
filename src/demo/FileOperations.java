package demo;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileOperations {
    private static final String FILE_PATH = "files/file_examples.txt";
    private static final String FOLDER_PATH = "files";
    // copy all the files from 1 folder to another

    public static void main(String[] args) {
        FileOperations fileOperations = new FileOperations();
//        fileOperations.createFile("hello world");
//        String content = fileOperations.readFromFile();
//        System.out.println("Content from file:" + content);
//        fileOperations.updateFile("hello world");
//        fileOperations.deleteFile();

        fileOperations.createFileUsingFiles("hello world");
        fileOperations.readFileUsingFiles();
        fileOperations.updateFileUsingFiles("hello world");
        fileOperations.readFileUsingFiles();
        fileOperations.deleteFile();
    }


    public void readFolder() {
        Path path = Paths.get(FOLDER_PATH);

        if (Files.exists(path) && Files.isDirectory(path)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                for (Path file : stream) {
                    System.out.println(Files.readString(file));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createFileUsingFiles(String content) {
        try {
            Files.writeString(Paths.get(FILE_PATH), content, StandardOpenOption.CREATE);
            System.out.println("Successfully created file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateFileUsingFiles(String content) {
        try {
            Files.writeString(Paths.get(FILE_PATH), content, StandardOpenOption.APPEND);
            System.out.println("Successfully updated the file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUsingFiles() {
        try {
            Files.delete(Paths.get(FILE_PATH));
            System.out.println("Deleted successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFileUsingFiles() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("Successfully created and written to the file.....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAndWriteToFile(String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(content);
            System.out.println("Successfully created and written to the file.....");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public String readFromFile() {
        BufferedReader reader = null;
        String content = "";
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
            String line = reader.readLine();
            while (line != null) {
                content = content + line;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return content;
    }

    public void updateFile(String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.newLine();
            writer.write(content);
            System.out.println("Successfully updated the file.....");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void deleteFile() {
        File file = new File(FILE_PATH);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }

}
