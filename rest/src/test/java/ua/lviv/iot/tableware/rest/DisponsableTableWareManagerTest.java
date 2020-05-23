package ua.lviv.iot.tableware.rest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.tableware.rest.manager.DisponsableTableWareManager;
import ua.lviv.iot.tableware.rest.model.DisponsableTableWare;
public class DisponsableTableWareManagerTest extends BaseDisponsableTableWareTest {
       
        private DisponsableTableWareManager disponsableTableWareManager;

        @BeforeEach
        public void setUp() {
            disponsableTableWareManager = new DisponsableTableWareManager();
            disponsableTableWareManager.addAllExercisesToProgram(disponsableTableWareList);
        }

        @Test
        public void testFindTableWareByPrice() {
            List<DisponsableTableWare> disponsableTableWareList = disponsableTableWareManager.findTableWare(23);
            assertEquals(2, disponsableTableWareList.size());
            assertEquals(132, disponsableTableWareList.get(0).getPrice());
            assertEquals(50, disponsableTableWareList.get(1).getPrice());
        }
}
