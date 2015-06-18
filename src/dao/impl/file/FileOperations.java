package dao.impl.file;

import utils.Utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.nio.file.StandardOpenOption.APPEND;

class FileOperations {

    static boolean saveRecordToFile(Path file, String record) {
        boolean status;
        ByteBuffer buffer = ByteBuffer.allocate(Utils.BUFFER_SIZE);
        buffer.clear();

        buffer.put((record + "\n").getBytes());
        try (FileChannel fc = FileChannel.open(file, APPEND)) {
            buffer.flip();
            status = fc.write(buffer) > 0 ? true : false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail to insert record into file: " + file.toAbsolutePath());
            status = false;
        }
        return status;
    }

    static List<String> loadRecordsFromFile(Path file, String searchCondition) {
        List<String> ls = new ArrayList<>();
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String str = s.nextLine();
                String[] ss = str.split(Utils.regex);
                Arrays.asList(ss).forEach(temp->{
                    if (temp.equals(searchCondition))
                        ls.add(str);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail to seach" + file.toAbsolutePath());
        }
        return ls;
    }

    static boolean deleteRecordFromFile(Path file, String id) {
        boolean status;
        ByteBuffer buffer = ByteBuffer.allocate(Utils.BUFFER_SIZE);
        Path temp = null;

        try {
            temp = Files.createTempFile("~tempFile", ".temp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileChannel fc = FileChannel.open(temp, APPEND)) {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                buffer.clear();
                String str = s.nextLine() + "\n";
                if (!str.contains(id)) {
                    buffer.put(str.getBytes());
                    buffer.flip();
                    fc.write(buffer);
                }
            }
            Files.delete(file);
            Files.move(temp, file);
            status = true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail to delete record: " + id + file.toAbsolutePath());
            status = false;
        }
        return status;
    }

}
