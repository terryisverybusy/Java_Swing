package dao.impl.file;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by Rico on 6/13/15.
 */
/*
class with default scope, with in
 */
class FileOperations {
    /**
     * @param record one line of record
     * @return true for success, false for exceptions
     */
    static boolean saveRecordToFile(Path file,String record){
        return true;
    }

    static List<String> loadRecordsFromFile(Path file, String searchCondition){
        return null;
    }

    static List<String> loadAttributeFromFile(Path file, String attr){
        return null;
    }
}
