package core.TablesPojo;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThirdTableData {

    private static ThirdTableData instance;

    public static ThirdTableData getInstance() {
        if (instance == null) {
            return new ThirdTableData();
        }
        return instance;
    }

    private ThirdTableData() {

    }

    ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, ArrayList<String>> fin = new HashMap<>();


    private  JackSonForAll jackSonForAll;

    public ArrayList<String> getHeaders() {
        ArrayList<String> array = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> pair : fin.entrySet()) {
            array.add(pair.getKey());
        }
        return array;
    }

    public ArrayList<String> getFinData(String value) {
        for (Map.Entry<String, ArrayList<String>> pair : fin.entrySet()) {
            if (pair.getKey().equals(value)) {
                return pair.getValue();
            }
        }
        return null;
    }


    // выбор json файла для парсинга
    public File testFile(ServletContext con) throws MalformedURLException {

        return new File(con.getResource("/WEB-INF/classes/thirdTableJson.json").getFile());
    }

    // первоначальный парсинг в линкедхэшмап
    public JackSonForAll parsingJson(ServletContext con) {
        try {
            jackSonForAll = objectMapper.readValue(testFile(con), JackSonForAll.class);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return jackSonForAll;
    }

    // создает хэшмап данных из json с помощью pojo
    public void finData(ServletContext con) throws IOException {

        for (Map.Entry<String, Object> pair2 : parsingJson(con).getClientsMap().entrySet()) {
            ThirdTPojo thirdTPojo = objectMapper.readValue(objectMapper.writeValueAsString(pair2.getValue()), ThirdTPojo.class);
            fin.put(pair2.getKey(), getData(thirdTPojo));
        }

    }
    public ArrayList<String> getData(ThirdTPojo thirdTPojo) {
        ArrayList<String> result = new ArrayList<>();
        result.add(isNotNull(thirdTPojo.getModality()));
        result.add(isNotNull(thirdTPojo.getDescription()));

        return result;

    }

    public String isNotNull(String string) {
        if(string.equals("")){
            return "null";
        }
        else return string;
    }

}
