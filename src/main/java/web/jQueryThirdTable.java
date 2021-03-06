package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.TablesPojo.ThirdTableData;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class jQueryThirdTable extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ThirdTableData.getInstance().getFinData(req.getParameter("userName")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().write(json);

    }
}

