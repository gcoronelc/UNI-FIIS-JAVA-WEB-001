/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.service.MateService;

/**
 *
 * @author PCB
 */
@WebServlet(name = "AppController", urlPatterns = {"/AppSumar","/AppRestar"})
public class AppController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String path = req.getServletPath();
//        switch(path){
//            case "/AppSumar":
//                appSumar(req,resp);
//                break;
//            case "/AppRestar":
//                appRestar(req,resp);
//                break;
//        }
            String tipo = req.getParameter("sumar");
            if(tipo == null ) tipo = req.getParameter("restar");
            switch(tipo){
                case "sumar":
                    appSumar(req,resp);
                    break;
                case "restar":
                    appRestar(req,resp);
                    break;
            }
    }
    
    protected void appSumar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Datos
        int n1 = Integer.parseInt(request.getParameter("num1").toString());
        int n2 = Integer.parseInt(request.getParameter("num2").toString());
        //Proceso
        MateService mateService = new MateService();
        int suma = mateService.sumar(n1, n2);
        //Forward
        request.setAttribute("n1", n1);
        request.setAttribute("n2", n2);
        request.setAttribute("suma", suma);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("respuesta.jsp");
        dispatcher.forward(request, response);
    }

    private void appRestar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Datos
        int n1 = Integer.parseInt(request.getParameter("num1").toString());
        int n2 = Integer.parseInt(request.getParameter("num2").toString());
        //Proceso
        MateService mateService = new MateService();
        int resta = mateService.restar(n1, n2);
        //Forward
        request.setAttribute("n1", n1);
        request.setAttribute("n2", n2);
        request.setAttribute("resta", resta);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("respuesta.jsp");
        dispatcher.forward(request, response);
    }

    
}
