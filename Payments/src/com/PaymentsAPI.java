package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet implementation class PaymentsAPI
 */
@WebServlet("/PaymentsAPI")
public class PaymentsAPI extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Payments payments;

    /**
     * Default constructor.
     */
    public PaymentsAPI() {
        payments = new Payments();
    }

    private static Map getParasMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
            String queryString = scanner.hasNext() ?
                    scanner.useDelimiter("\\A").next() : "";
            scanner.close();
            String[] params = queryString.split("&");
            for (String param : params) {
                String[] p = param.split("=");
                map.put(p[0], p[1]);
            }
        } catch (Exception e) {
        }
        return map;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
		String output = payments.getPayments();
		response.getWriter().write(output);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentDTO paymentDTO = new PaymentDTO(request.getParameter("patientName"),
                Double.parseDouble(request.getParameter("amout")), request.getParameter("type"),
                request.getParameter("date"));

        String output = payments.create(paymentDTO);
        response.getWriter().write(output);
//		doGet(request, response);
    }

    /**
     * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
     */
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map paras = getParasMap(request);

//        PaymentDTO paymentDTO = new PaymentDTO(Integer.parseInt(paras.get("paymentId").toString()), paras.get("patientName").toString(),
//                Integer.parseInt(paras.get("amout").toString()), paras.get("type").toString(),
//				paras.get("date").toString());
		PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(Integer.parseInt(paras.get("paymentId").toString()));
        paymentDTO.setPatientName(paras.get("patientName").toString());
        paymentDTO.setAmout(Double.parseDouble(paras.get("amout").toString()));
        paymentDTO.setType(paras.get("type").toString());
        paymentDTO.setDate(paras.get("date").toString());

        String output = payments.update(paymentDTO);
        response.getWriter().write(output);
    }

    /**
     * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		System.out.println(paras.get("paymentId").toString());
        String output = payments.delete(Integer.parseInt(paras.get("paymentId").toString()));
        response.getWriter().write(output);
    }

}
