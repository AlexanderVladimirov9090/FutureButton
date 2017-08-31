package server.query;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created on 07-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class QueryTest {
    private Mockery mockContext = new Mockery();

    @Test
    public void getQuery() throws IOException {
        final HttpServletRequest mockRequest = mockContext.mock(HttpServletRequest.class);
        final HttpServletResponse mockResponse = mockContext.mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        final PrintWriter writer = new PrintWriter(stringWriter);
        mockContext.checking(new Expectations() {{
            oneOf(mockRequest).setAttribute("query", "");
            oneOf(mockRequest).getParameter("query");
            will(returnValue(""));
            oneOf(mockResponse).getWriter();
            will(returnValue(writer));
        }});
        mockRequest.setAttribute("query", "");
        new Query().doGet(mockRequest, mockResponse);
        mockContext.assertIsSatisfied();
    }
}