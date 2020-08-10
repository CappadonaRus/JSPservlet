package core.TablesPojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CompleteJsonToObjects {

    public static HashMap<Date, ArrayList<String>> hashMap = new HashMap<>();


    private static CompleteJsonToObjects instance;

    public static CompleteJsonToObjects getInstance() {
        if (instance == null) {
            return new CompleteJsonToObjects();
        }
        return instance;
    }

    private CompleteJsonToObjects() {

    }


    // создание json файла из полученных данных с фронта
    public String completeJson(String firstValue, String secondValue, String thirdValue, String forthValue)  {
        String json = null;
        try {

        ObjectMapper mapper = new ObjectMapper();
            ObjectNode user = mapper.createObjectNode();
            user.put("firstTableValue", firstValue);
            user.put("secondTableValue", secondValue);
            user.put("thirdTableValue", thirdValue);
            user.put("radioButtonData", forthValue);


            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }
    // создание pojo экземпляра класса + хэшмап с датой для логов
   public FinalDataPojo createPojoObject(String json) {
        FinalDataPojo finalDataPojo = null;
        ObjectMapper objectMapper = new ObjectMapper();
       try {
           finalDataPojo = objectMapper.readValue(objectMapper.writeValueAsString(json), FinalDataPojo.class);
           hashMap.put(new Date(), giveDetails(finalDataPojo));
       } catch (JsonProcessingException e) {
           e.printStackTrace();
       }
       return finalDataPojo;
    }

    //создание аррайлиста с датой для последующего лога
    public ArrayList<String> giveDetails(FinalDataPojo finalDataPojo){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(finalDataPojo.getFirstTableValue());
        arrayList.add(finalDataPojo.getSecondTableValue());
        arrayList.add(finalDataPojo.getThirdTableValue());
        arrayList.add(finalDataPojo.getRadioButtonData());
        return arrayList;
    }




}
