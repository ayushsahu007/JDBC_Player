package playerdb;
import dao.PlayerDao;
import java.util.Scanner;
import static java.lang.System.exit;
public class App {
    public static void
    main(String[] args) {
        PlayerDao playerDao = new PlayerDao();
        PlayerDao.buildConnection();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add Player ");
            System.out.println("2.Find All Player by Country ");
            System.out.println("3.Find All Player by IPL Team ");
            System.out.println("4.find ALl Player by age ");
            System.out.println("5.Update salary by Id ");
            System.out.println("6.Update salary by age ");
            System.out.println("7.Delete All Player by Country ");
            System.out.println("8.Delete player by Id ");
            System.out.println("9.Exit");
            System.out.println("Enter Choice");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    playerDao.addPlayer();
                    break;
                case 2:
                    playerDao.findAllPlayerByCountry();
                    break;
                case 3:
                    playerDao.findAllPlayerbyIplTeam();
                    break;
                case 4:
                    playerDao.findPlayerBetweenAge();
                    break;
                case 5:
                    playerDao.updatePlayerSalaryById();
                    break;
                case 6:
                    playerDao.updatePlayerSalaryBetweenAge();
                    break;
                case 7:
                    playerDao.daleteAllPlayerByCountry();
                    break;
                case 8:
                    playerDao.deletePlayerById();
                    break;
                case 9:
                    exit(0);
                    break;
                default:
                    System.out.println("Enter Vaild number ");
            }
        }


    }   //switch case
    }

