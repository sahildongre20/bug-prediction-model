package com.accio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Search")
public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("Keyword");
        response.setContentType("text/html");

        //Connecting to the database
        Connection connection = DatabaseConnection.getConnection();
        try {
            //Storing the keyword and link to history database
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into history values(?,?);");
            preparedStatement.setString(1, keyword);
            preparedStatement.setString(2, "http://localhost:8080/Dsa_Search_Engine/Search?Keyword="+keyword);
            preparedStatement.executeUpdate();
            ResultSet resultSet = connection.createStatement().executeQuery("select pageTitle, pageLink, (length(lower(pageText))-length(replace(lower(pageText), '" + keyword.toLowerCase() + "', '')))/length('" + keyword.toLowerCase() + "') as countKeywords from pages order by countKeywords desc limit 30;");
            ArrayList<SearchResult> results = new ArrayList<>();
            while (resultSet.next()) {
                SearchResult searchResult = new SearchResult();
                searchResult.setTitle(resultSet.getString("pageTitle"));
                searchResult.setLink(resultSet.getString("pageLink"));
                results.add(searchResult);
            }
            for(SearchResult result: results ){
                System.out.println(result.getTitle()+"\n"+result.getLink());
            }
            PrintWriter out = response.getWriter();
            request.setAttribute("results", results);
            request.getRequestDispatcher("search.jsp").forward(request, response);
            out.println("<h2>The KeyWord is </h2>"+keyword);
        }
        catch (SQLException | ServletException sqlException){
            sqlException.printStackTrace();
        }


    }
}
