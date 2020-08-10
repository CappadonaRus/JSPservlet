package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.TablesPojo.FirstTPoJo;
import core.TablesPojo.JackSonForAll;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

public class TableData {

    private static TableData instance;

    public static TableData getInstance(){
        if(instance == null){
            return new TableData();
        }
        return instance;
    }

    public static Map<String, ArrayList<String>> fin = new HashMap<>();

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


    private TableData() {

    }


    ObjectMapper objectMapper = new ObjectMapper();
    private JackSonForAll jackSonForAll;

    public File testFile(ServletContext con) throws MalformedURLException {

        return new File(con.getResource("/WEB-INF/classes/firstTableJson.json").getFile());
    }


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
        for (Map.Entry<String, Object> pair : parsingJson(con).getClientsMap().entrySet()) {
            FirstTPoJo firstTPoJo = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), FirstTPoJo.class);
            fin.put(pair.getKey(), getData(firstTPoJo));
        }
    }

    public ArrayList<String> getData(FirstTPoJo firstTPoJo) {
        ArrayList<String> result = new ArrayList<>();
        result.add(isNotNull(firstTPoJo.getFio()));
        result.add(isNotNull(firstTPoJo.getLastName()));
        result.add(isNotNull(firstTPoJo.getFirstName()));
        result.add(isNotNull(firstTPoJo.getMiddleName()));
        result.add(isNotNull(firstTPoJo.getBirthDate()));
        result.add(isNotNull(firstTPoJo.getCard()));
        result.add(isNotNull(firstTPoJo.getSessionType()));
        result.add("Document");
        result.add(isNotNull(firstTPoJo.document.getType()));
        result.add(isNotNull(firstTPoJo.document.getSeries()));
        result.add(isNotNull(firstTPoJo.document.getNumber()));
        result.add(isNotNull(firstTPoJo.document.getSeriesNumber()));
        return result;
    }

    public String isNotNull(String string) {
        if(string !=null){
            return string;
        }
        else return "null";
    }
}
