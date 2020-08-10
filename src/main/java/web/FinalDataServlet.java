package web;

import core.TablesPojo.CompleteJsonToObjects;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinalDataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // настройки ответа
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // метод получения параметров пришедших с фронта
        req.getParameter("firstTableV");
        req.getParameter("secondTableV");
        req.getParameter("thirdTableV");
        req.getParameter("radioButtonsV");

        // метод конвертации данных в json
        CompleteJsonToObjects.getInstance().completeJson(
                req.getParameter("firstTableV"),
                req.getParameter("secondTableV"),
                req.getParameter("thirdTableV"),
                req.getParameter("radioButtonsV"));


        // создание экземпляра pojo. Передаем джисон который собрали выше, получаем обьект с 4 полями.
        CompleteJsonToObjects.getInstance().createPojoObject("json");



        // в write помещаешь то что нужно отобразить в текстареа на фронте
        resp.getWriter().write("");
    }
}

