/**
 * Created by Nout on 16/03/2015.
 */

import com.gym.dao.DaoFactory;
import com.gym.dao.MySql.MySqlDaoFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class GymListener implements ServletContextListener {

    public GymListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        DaoFactory factory = new MySqlDaoFactory();
        sce.getServletContext().setAttribute("DaoFactory", factory);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("DaoFactory", null);
    }

}
