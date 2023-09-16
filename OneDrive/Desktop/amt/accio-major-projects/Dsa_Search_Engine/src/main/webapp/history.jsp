<%@page import = "java.util.ArrayList"%>
<%@page import  = "com.accio.HistoryResult"%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Goofle A Simple Search Engine</title>
    </head>
    <body>
     <form action = "Search">
                <input type = "text" name = "Keyword"></input>
                <button type = "Submit">Submit</button>
            </form>
             <form action = "History">
                <button type = "Submit">History</button>
             </form>
        <table>
            <tr>
                <th>Keyword</th>
                <th>Link</th>
            </tr>
            <%  ArrayList<HistoryResult> results = (ArrayList<HistoryResult>)request.getAttribute("results");
                for(HistoryResult result : results)
                {
            %>
            <tr>
               <td><%out.println(result.getKeyword());%></td>
               <td><a target=_blank; href="<%out.println(result.getLink());%>"><%out.println(result.getLink());%></a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>