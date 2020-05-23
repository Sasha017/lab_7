package ua.lviv.iot.tableware.rest.manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.tableware.rest.model.DisponsableTableWare;

public class DisponsableTableWareManager {

    private List<DisponsableTableWare> disponsableTableWareList = new LinkedList<>();

    public DisponsableTableWareManager(List<DisponsableTableWare> disponsableTableWareList) {
        this.disponsableTableWareList = disponsableTableWareList;
    }

    public DisponsableTableWareManager() {
    }

    public void addExerciseToProgram(DisponsableTableWare disponsableTableWare) {
        this.disponsableTableWareList.add(disponsableTableWare);
    }

    public void addAllExercisesToProgram(List<DisponsableTableWare> disponsableTableWareList) {
        this.disponsableTableWareList.addAll(disponsableTableWareList);
    }

    public List<DisponsableTableWare> findTableWare(int appropriateprice) {
        List<DisponsableTableWare> foundedTableWare = new LinkedList<>();
        for (DisponsableTableWare disponsableTableWare : disponsableTableWareList) {
            if (disponsableTableWare.getPrice() > appropriateprice) {
                foundedTableWare.add(disponsableTableWare);
            }
        }
        return foundedTableWare;
    }
}