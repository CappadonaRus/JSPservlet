package core.TablesPojo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class JackSonForAll {

    private LinkedHashMap<String, Object> clientsData = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getClientsMap() {
        return clientsData;
    }

    @JsonAnySetter
    public void setClientsMap(String name, Object value) {
        clientsData.put(name, value);
    }

    public Map<String, Object> clientsNames() {
        return clientsData;
    }
}

