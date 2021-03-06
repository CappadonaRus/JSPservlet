package web;


import core.TableData;
import core.TablesPojo.SecondTableData;
import core.TablesPojo.ThirdTableData;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class webServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            TableData.getInstance().finData(getServletContext());
            SecondTableData.getInstance().finData(getServletContext());
            ThirdTableData.getInstance().finData((getServletContext()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("firstTableHeaders", TableData.getInstance().getHeaders());
        req.setAttribute("secondTableHeaders", SecondTableData.getInstance().getHeaders());
        req.setAttribute("thirdTableHeaders", ThirdTableData.getInstance().getHeaders());
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);

    }
}
