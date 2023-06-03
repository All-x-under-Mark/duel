package Servlet;

import Entity.Personage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ServletDuel")
public class ServletDuel extends jakarta.servlet.http.HttpServlet {
    BeginningServlet beginningServlet;

    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // отримуємо із сесії дані про першого гравця
        Personage personageOne = (Personage) session.getAttribute("personageOne");
        // отримуємо із сесії дані про другого гравця
        Personage personageTwo = (Personage) session.getAttribute("personageTwo");

        // значення життя гравців
        int hpOne = personageOne.getHp();
        int hpTwo = personageTwo.getHp();

        // значення атаки гравців
        int dmOne = personageOne.getDamage();
        int dmTwo = personageTwo.getDamage();

        // значення захисту гравців
        int prOne = personageOne.getProtection();
        int prTwo = personageTwo.getProtection();

        int hpOneResult;
        int hpTwoResult;


        // отримуємо дані захисту першого гравця
        boolean head_player_one_defense = Boolean.parseBoolean(request.getParameter("head_player_one_defense"));
        boolean torso_player_one_defense = Boolean.parseBoolean(request.getParameter("torso_player_one_defense"));
        boolean legs_player_one_defense = Boolean.parseBoolean(request.getParameter("legs_player_one_defense"));

        // отримуємо дані атаки першого гравця
        boolean head_player_one_attack = Boolean.parseBoolean(request.getParameter("head_player_one_attack"));
        boolean torso_player_one_attack = Boolean.parseBoolean(request.getParameter("torso_player_one_attack"));
        boolean legs_player_one_attack = Boolean.parseBoolean(request.getParameter("legs_player_one_attack"));

        // отримуємо дані захисту другого гравця
        boolean head_player_two_defense = Boolean.parseBoolean(request.getParameter("head_player_two_defense"));
        boolean torso_player_two_defense = Boolean.parseBoolean(request.getParameter("torso_player_two_defense"));
        boolean legs_player_two_defense = Boolean.parseBoolean(request.getParameter("legends_player_two_defense"));

        // отримуємо дані атаки другого гравця
        boolean head_player_two_attack = Boolean.parseBoolean(request.getParameter("head_player_two_attack"));
        boolean torso_player_two_attack = Boolean.parseBoolean(request.getParameter("torso_player_two_attack"));
        boolean legs_player_two_attack = Boolean.parseBoolean(request.getParameter("legends_player_two_attack"));

        personageOne.setMessage("");
        personageTwo.setMessage("");

        if (hpOne > 0) {


            if (head_player_one_defense && torso_player_one_defense && legs_player_one_defense == true)
            // якщо три зони першого гравця захищені тобто true, то виводимо звісточку що перший гравець не може захищати більше двух зон
            {
                personageOne.setMessage("Гравець " + personageOne.getName() + " може захищати лише ДВІ зони");
            } else if (head_player_one_attack && torso_player_one_attack || head_player_one_attack && legs_player_one_attack || torso_player_one_attack && legs_player_one_attack == true)
            // якщо атака першого гравця йде більш ніж на одну зону виводимо попередження що перший гравець не може атакувати більш ніж оду зону
            {
                personageOne.setMessage("Гравець " + personageOne.getName() + " може атакувати лише ОДНУ зону");
            } else if (head_player_two_defense && torso_player_two_defense && legs_player_two_defense)
            // якщо три зони другого гравця захищені тобто true, то виводимо звісточку що другий гравець не може захищати більше двух зон
            {
                personageTwo.setMessage("Гравець " + personageTwo.getName() + " може захищати лише ДВІ зони");

            } else if (head_player_two_attack && torso_player_two_attack || head_player_two_attack && legs_player_two_attack || torso_player_two_attack && legs_player_two_attack == true)
            // якщо атака другого гравця йде більш ніж на одну зону виводимо попередження що другий гравець не може атакувати більш ніж оду зону
            {
                personageTwo.setMessage("Гравець " + personageTwo.getName() + " може атакувати лише ОДНУ зону");

            } else {

                //якщо перший гравець захистився від атак другого
                if (head_player_one_defense && head_player_two_attack || torso_player_one_defense && torso_player_two_attack || legs_player_one_defense && legs_player_two_attack == true) {
                    personageOne.setMessage("Гравець " + personageOne.getName() + " захистився від атаки гравця " + personageTwo.getName());
                }
                //якщо другий гравець пробив в голову першого гравця
                else if ((head_player_one_defense == false) && (head_player_two_attack == true)) {
                    hpOneResult = hpOne + prOne - dmTwo;
                    personageOne.setHp(hpOneResult);
                    personageOne.setMessage("Гравець " + personageOne.getName() + " отримав урон " + (personageTwo.getDamage() - personageOne.getProtection()) + " в ГОЛОВУ від гравця " + personageTwo.getName());
                }
                // якщо другий гравець пробив в тулуб першого гравця
                else if ((torso_player_two_defense == false) && (torso_player_two_attack == true)) {
                    hpOneResult = hpOne + prOne - dmTwo;
                    personageOne.setHp(hpOneResult);
                    personageOne.setMessage("Гравець " + personageOne.getName() + " отримав урон " + (personageTwo.getDamage() - personageOne.getProtection()) + " в ТУЛУБ від гравця " + personageTwo.getName());
                }
                // якщо другий гравець пробив в ноги першого гравця
                else if ((legs_player_one_defense == false) && (legs_player_two_attack == true)) {
                    hpOneResult = hpOne + prOne - dmTwo;
                    personageOne.setHp(hpOneResult);
                    personageOne.setMessage("Гравець " + personageOne.getName() + " отримав урон " + (personageTwo.getDamage() - personageOne.getProtection()) + " в НОГИ від гравця " + personageTwo.getName());
                }
                // якщо другий гравець захистився від першого
                if (head_player_two_defense && head_player_one_attack || torso_player_two_defense && torso_player_one_attack || legs_player_two_defense && legs_player_one_attack == true) {
                    personageTwo.setMessage("Гравець " + personageTwo.getName() + " захистився від атаки гравця " + personageOne.getName());
                }
                //якщо перший гравець пробив другого в голову
                else if ((head_player_two_defense == false) && (head_player_one_attack == true)) {
                    hpTwoResult = hpTwo + prTwo - dmOne;
                    personageTwo.setHp(hpTwoResult);
                    personageTwo.setMessage("Гравець " + personageTwo.getName() + " отримав урон " + (personageOne.getDamage() - personageTwo.getProtection()) + " в ГОЛОВУ від гравця " + personageOne.getName());
                }
                // якщо перший гравець пробив в тулуб другого
                else if ((torso_player_two_defense == false) && (torso_player_one_attack == true)) {
                    hpTwoResult = hpTwo + prTwo - dmOne;
                    personageTwo.setHp(hpTwoResult);
                    personageTwo.setMessage("Гравець " + personageTwo.getName() + " отримав урон " + (personageOne.getDamage() - personageTwo.getProtection()) + " в ТУЛУБ від гравця " + personageOne.getName());
                }
                // якщо перший гравець пробив в ноги другого гравця
                else if ((legs_player_two_defense == false) && (legs_player_one_attack == true)) {
                    hpTwoResult = hpTwo + prTwo - dmOne;
                    personageTwo.setHp(hpTwoResult);
                    personageTwo.setMessage("Гравець " + personageTwo.getName() + " отримав урон " + (personageOne.getDamage() - personageTwo.getProtection()) + " в НОГИ від гравця " + personageOne.getName());
                }


            }

        } else {
            personageOne.setMessage("Перший гравець помер");
        }


        session.setAttribute("personageOne", personageOne);
        session.setAttribute("personageTwo", personageTwo);

        getServletContext().getRequestDispatcher("/duel.jsp").forward(request, response);

    }


}