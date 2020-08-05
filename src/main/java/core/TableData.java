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
        Iterator<Map.Entry<String, ArrayList<String>>> iterator = fin.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = iterator.next();
            array.add(pair.getKey());
        }
        return array;
    }

    public ArrayList<String> getFinData(String value) {
        Iterator<Map.Entry<String, ArrayList<String>>> iterator = fin.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = iterator.next();
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

    public void finData(ServletContext con) throws IOException {
        Iterator<Map.Entry<String, Object>> iterator = parsingJson(con).getClientsMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            FirstTPoJo firstTPoJo = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), FirstTPoJo.class);
            fin.put(pair.getKey(), getData(firstTPoJo));
        }
    }

    public ArrayList<String> getData(FirstTPoJo firstTPoJo) {
        ArrayList<String> result = new ArrayList<>();
        result.add(firstTPoJo.getFio());
        result.add(firstTPoJo.getLastName());
        result.add(firstTPoJo.getFirstName());
        result.add(firstTPoJo.getMiddleName());
        result.add(firstTPoJo.getBirthDate());
        if(firstTPoJo.getCard()!=null){
            result.add(firstTPoJo.getCard());
        }
        else result.add("null");
        result.add(firstTPoJo.getSessionType());
        result.add("Document");
        //result.add(String.valueOf(firstTPoJo.getDocument()).toLowerCase());
        result.add(firstTPoJo.document.getType());
        result.add(firstTPoJo.document.getSeries());
        result.add(firstTPoJo.document.getNumber());
        result.add(firstTPoJo.document.getSeriesNumber());
        return result;
    }
}
