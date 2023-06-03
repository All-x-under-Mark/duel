package Servlet;

import Entity.Personage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/BeginningServlet")
public class BeginningServlet extends jakarta.servlet.http.HttpServlet {


    Personage personageOne = new Personage();
    Personage personageTwo = new Personage();

    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();



        // отримуємо дані про першого гравця
        String namePlayerOne = request.getParameter("name_player_one");
        int hp_player_one = Integer.parseInt(request.getParameter("hp_player_one"));
        int damage_player_one = Integer.parseInt(request.getParameter("damage_player_one"));
        int protection_player_one = Integer.parseInt(request.getParameter("protection_player_one"));


        // отримуємо дані про другого гравця
        String namePlayerTwo = request.getParameter("name_player_two");
        int hp_player_two = Integer.parseInt(request.getParameter("hp_player_two"));
        int damage_player_two = Integer.parseInt(request.getParameter("damage_player_two"));
        int protection_player_two = Integer.parseInt(request.getParameter("protection_player_two"));

        //записуємо дані в об'єкт першого гравця
        personageOne.setName(namePlayerOne);
        personageOne.setHp(hp_player_one);
        personageOne.setDamage(damage_player_one);
        personageOne.setProtection(protection_player_one);

        // записуємо дані в об'єкт другого гравця
        personageTwo.setName(namePlayerTwo);
        personageTwo.setHp(hp_player_two);
        personageTwo.setDamage(damage_player_two);
        personageTwo.setProtection(protection_player_two);

        // дані об'єктів гравців записуємо в сесії
        session.setAttribute("personageOne", personageOne);
        session.setAttribute("personageTwo", personageTwo);

        getServletContext().getRequestDispatcher("/duel.jsp").forward(request, response);

    }
}
