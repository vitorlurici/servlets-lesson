import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculadora/*")
public class Calculadora extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        resposta.setContentType("text/plain");

        PrintWriter saida = resposta.getWriter();

        saida.println("Olá Mundo!");
    }

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        resposta.setContentType("text/plain");
        PrintWriter saida = resposta.getWriter();

        String caminho = requisicao.getPathInfo();
        String operacao = caminho.substring(1);

        double resultado = 0;
        double x = 0;
        double y = 0;

        switch (operacao) {
            case "somar":
                x = Double.parseDouble(requisicao.getParameter("numero1"));
                y = Double.parseDouble(requisicao.getParameter("numero2"));
                resultado = x + y;
                saida.println(resultado);
                break;

            case "subtrair":
                x = Double.parseDouble(requisicao.getParameter("numero1"));
                y = Double.parseDouble(requisicao.getParameter("numero2"));
                resultado = x - y;
                saida.println(resultado);
                break;

            default:
                saida.println("Operação inválida");
        }
    }
}
