package com.github.jryoo;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jryoo on 6/29/15.
 */
public class ServerTwo {
    public static void main(String[] args) throws Exception {
        try {
            Server server = new Server(Integer.valueOf(System.getenv("PORT")));
            server.setHandler(new HelloHandler());
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class HelloHandler extends AbstractHandler {
        final String greeting;
        final String body;

        public HelloHandler()
        {
            this("Hello From Server Two");
        }

        public HelloHandler( String greeting )
        {
            this(greeting, null);
        }

        public HelloHandler( String greeting, String body )
        {
            this.greeting = greeting;
            this.body = body;
        }

        public void handle( String target,
            Request baseRequest,
            HttpServletRequest request,
            HttpServletResponse response ) throws IOException, ServletException
        {
            response.setContentType("text/html; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();

            out.println("<h1>" + greeting + "</h1>");
            if (body != null)
            {
                out.println(body);
            }

            baseRequest.setHandled(true);
        }
    }
}
