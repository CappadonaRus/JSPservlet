package core.TablesPojo;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SecondTableData {

    private static SecondTableData instance;

    public static SecondTableData getInstance() {
        if (instance == null) {
            return new SecondTableData();
        }
        return instance;
    }

    private SecondTableData() {

    }

    ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, ArrayList<String>> fin = new HashMap<>();

    public static Map<String, Object> tempFin = new HashMap<>();

    private JackSonForAll jackSonForAll2;

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

        return new File(con.getResource("/WEB-INF/classes/secondTableJson.json").getFile());
    }

    // первоначальный парсинг в линкедхэшмап
    public JackSonForAll parsingJson(ServletContext con) {
        try {
           JackSonForAll jackSonForAll = objectMapper.readValue(testFile(con), JackSonForAll.class);
            for (HashMap.Entry<String, Object> pair : jackSonForAll.getClientsMap().entrySet()) {
                if(pair.getKey().contains("operators")) {
                    jackSonForAll2 = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), JackSonForAll.class);

                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return jackSonForAll2;
    }

    // создает хэшмап данных из json с помощью pojo
    public void finData(ServletContext con) throws IOException {

        for (Map.Entry<String, Object> pair2 : parsingJson(con).getClientsMap().entrySet()) {
            SecondTPojo secondTPojo = objectMapper.readValue(objectMapper.writeValueAsString(pair2.getValue()), SecondTPojo.class);
            fin.put(pair2.getKey(), getData(secondTPojo));
        }
    }


    public ArrayList<String> getData(SecondTPojo secondTPojo) {
        ArrayList<String> result = new ArrayList<>();
        result.add(isNotNull(secondTPojo.getSelfkey()));
        result.add(isNotNull(secondTPojo.getConfirmKey()));
        result.add(isNotNull(secondTPojo.getLogin()));
        result.add(isNotNull(secondTPojo.getPassword()));
        result.add(isNotNull(secondTPojo.getFullName()));
        result.add(isNotNull(secondTPojo.getBranch()));
        result.add(isNotNull(secondTPojo.getLastName()));
        result.add(isNotNull(secondTPojo.getFirstName()));
        result.add(isNotNull(secondTPojo.getMiddleName()));

        return result;
    }

    public String isNotNull(String string) {
        if(string.equals("")){
            return "null";
        }
        else return string;
    }


}
