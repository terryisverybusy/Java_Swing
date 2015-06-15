package dao.impl.file;

import utils.Utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;

/**
 * Created by Rico on 6/13/15.
 */
/*
class with default scope, with in
 */
class FileOperations {
    private static int bufferSize = Integer.parseInt(Utils.CONFIG_PROPS.getProperty("buffer-size"));

    static boolean saveRecordToFile(Path file, String record) {
        boolean status = false;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        buffer.clear();

        buffer.put(record.getBytes());
        try (FileChannel fc = FileChannel.open(file, APPEND)) {
            buffer.flip();
            status = fc.write(buffer) > 0 ? true : false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail to insert record into file: " + file.toAbsolutePath().toString());
            status = false;
        }
        return status;
    }

    static List<String> loadRecordsFromFile(Path file, String searchCondition) {
        List<String> ls = new ArrayList<>();
        return ls;
    }

    static List<String> loadAttributeFromFile(Path file, String attr) {
        return null;
    }
}
