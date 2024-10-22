package loginUser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet") // Define a URL para acessar este servlet
public class LoginServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtém os parâmetros do formulário
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Aqui você pode verificar no banco de dados se o usuário existe (exemplo com UserDAO)
        Usuario userDAO = new Usuario();
        boolean isValidUser = userDAO.autenticar(username, password);

        // Verifica se o usuário é válido
        if (isValidUser) {
            // Se for válido, redireciona para a página principal
            response.sendRedirect("Menu.html");
        } else {
            // Se não for válido, exibe mensagem de erro e retorna à página de login
            request.setAttribute("error", "Usuário ou senha inválidos");
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }
}
