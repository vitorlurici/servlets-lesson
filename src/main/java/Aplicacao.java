import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import recursos.Calculadora;
import recursos.CategoriaRecurso;

public class Aplicacao {
    public static void main(String[] args) throws Exception {
        Server servidor = new Server(8080);

        ServletContextHandler contexto = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contexto.setContextPath("/api");
        contexto.addServlet(new ServletHolder(new Calculadora()), "/calculadora/*");
        contexto.addServlet(new ServletHolder(new CategoriaRecurso()), "/categorias");
        servidor.setHandler(contexto);

        servidor.start();
        servidor.join();
    }
}
