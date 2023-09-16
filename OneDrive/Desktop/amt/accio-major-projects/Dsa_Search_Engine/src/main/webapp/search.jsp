<%@page import = "java.util.ArrayList"%>
<%@page import  = "com.accio.SearchResult"%>
<html>
    <head>
              <link rel="stylesheet" type="text/css" href="style.css">
              <title>Goofle A Simple Search Engine</title>
    </head>
    <body>
     <form action = "Search" class="hero">
                <img src="goofle.png" class="logo">
                <input type = "text" name = "Keyword"></input>
                <button type = "Submit">Submit</button>
                <button type = "Submit" formaction="History">History</button>
             </form>
        <table>
            <tr>
                <th>Title</th>
                <th>Link</th>
            </tr>
            <%  ArrayList<SearchResult> results = (ArrayList<SearchResult>)request.getAttribute("results");
                for(SearchResult result : results)
                {
            %>
            <tr>
               <td><%out.println(result.getTitle());%></td>
               <td><a target=_blank; href="<%out.println(result.getLink());%>"><%out.println(result.getLink());%></a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>