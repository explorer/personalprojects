package wyw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import wyw.dao.UserDAO;
import wyw.vo.User;

/**
 * Servlet implementation class RankServlet
 */
@WebServlet("/RankServlet")
public class RankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String score = request.getParameter("score");
		String jsonString = null;
//		JSONArray jsonArray = null;
		User user = new User();
		user.setScore(score);
		user.setUsername(username);
		try {
			UserDAO udao = new UserDAO();
			if(udao.insertUser(user)){
				List<User> all = udao.findAll();
				jsonString = JSON.toJSONString(all,true);
//				jsonArray = JSONArray.parseArray(jsonString);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println(e);通过判断e的值向前台发送相应信息 做出相应界面反馈 
		}
		
        out.write(jsonString);
//        System.out.println(jsonArray);
//        System.out.println(jsonString.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
