import com.gym.dao.DaoFactory;
import com.gym.dao.exceptions.PersistException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nout on 16/03/2015.
 */
public class MySqlDaoTest {

    public class OracleDaoTest extends TestCase {
        private DaoFactory daoF;

        @Before
        public void setUp() {
//            daoR = new OracleDAORecord();
        }

        @Test
        public void testGetByID() throws PersistException {

            assertNotNull(null);
        }


    }

}
