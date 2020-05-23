package ua.lviv.iot.tableware.rest;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.tableware.rest.manager.DisponsableTableWareManagerUtils;
import ua.lviv.iot.tableware.rest.model.SortType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ua.lviv.iot.tableware.rest.model.MatherialType.*;

public class DisponsableTableWareManagerUtilsTest extends BaseDisponsableTableWareTest {

    @Test
    public void testSortByDateOfManufacture() {
        DisponsableTableWareManagerUtils.sortByDateOfManufacture(disponsableTableWareList, SortType.ASC);
        assertEquals(22, disponsableTableWareList.get(0).getDateOfManufacture());
        assertEquals(122, disponsableTableWareList.get(1).getDateOfManufacture());
        assertEquals(212, disponsableTableWareList.get(2).getDateOfManufacture());
    }

    @Test
    public void testSortByMatherialType() {
        DisponsableTableWareManagerUtils.sortByMatherialType(disponsableTableWareList, SortType.DESC);
        assertEquals(WOOD, disponsableTableWareList.get(0).getMatherial());
        assertEquals(PAPER, disponsableTableWareList.get(1).getMatherial());
        assertEquals(PLASTIC, disponsableTableWareList.get(2).getMatherial());
    }

    @Test
    public void testsortByDateOfManufactureAndMatherial() {
        DisponsableTableWareManagerUtils.sortByDateOfManufactureAndMatherial(disponsableTableWareList, SortType.DESC);
        assertEquals(212, disponsableTableWareList.get(0).getDateOfManufacture());
        assertEquals(122, disponsableTableWareList.get(1).getDateOfManufacture());
        assertEquals(22, disponsableTableWareList.get(2).getDateOfManufacture());
    }

    @Test
    public void testSortByFireResistance() {
        DisponsableTableWareManagerUtils.sortByFireResistance(disponsableTableWareList, SortType.ASC);
        assertEquals(33, disponsableTableWareList.get(0).getFireResistance());
        assertEquals(34, disponsableTableWareList.get(1).getFireResistance());
        assertEquals(304, disponsableTableWareList.get(2).getFireResistance());
    }


}

