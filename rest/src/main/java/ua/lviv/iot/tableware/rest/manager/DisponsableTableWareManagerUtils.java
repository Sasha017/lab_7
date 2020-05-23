package ua.lviv.iot.tableware.rest.manager;

import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.tableware.rest.model.DisponsableTableWare;
import ua.lviv.iot.tableware.rest.model.SortType;

public class DisponsableTableWareManagerUtils {

	private static final SortByMatherial SONG_BY_MATERIAL = new DisponsableTableWareManagerUtils().new SortByMatherial();

    public static void SortByMaterial(List<DisponsableTableWare> disponsableTableWare, SortType sortType) {
    	disponsableTableWare.sort(sortType == SortType.ASC ? SONG_BY_MATERIAL : SONG_BY_MATERIAL.reversed());
    }

	//
	 private static final SortByDateOfManufacture SONG_BY_DATE_OF_MANUFACTURE = new SortByDateOfManufacture();
	
    private static class SortByDateOfManufacture implements Comparator<DisponsableTableWare> {

        @Override
        public int compare(DisponsableTableWare firstTableWare, DisponsableTableWare secondTableWare) {
            return firstTableWare.getDateOfManufacture() - secondTableWare.getDateOfManufacture();
        }

    }


    private class SortByMatherial implements Comparator<DisponsableTableWare> {
        @Override
        public int compare(DisponsableTableWare firstTableWare, DisponsableTableWare secondTableWare) {
            return firstTableWare.compareTo(secondTableWare);
        }

    }

    public static void sortByDateOfManufacture(List<DisponsableTableWare> disponsableTableWare, SortType sortType) {

        disponsableTableWare.sort(sortType == SortType.ASC ? SONG_BY_DATE_OF_MANUFACTURE : SONG_BY_DATE_OF_MANUFACTURE.reversed());
    }

    public static void sortByMatherialType(List<DisponsableTableWare> disponsableTableWare, SortType sortType) {
        Comparator<DisponsableTableWare> comparator = Comparator.comparing(DisponsableTableWare::getMatherial);
        disponsableTableWare.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
    }

    public static void sortByDateOfManufactureAndMatherial(List<DisponsableTableWare> disponsableTableWare, SortType sortType) {


        Comparator<DisponsableTableWare> comparator = new Comparator<DisponsableTableWare>() {

            @Override
            public int compare(DisponsableTableWare firstTableWare, DisponsableTableWare secondTableWare) {

                int result = firstTableWare.getDateOfManufacture() - secondTableWare.getDateOfManufacture();

                if (result != 0) {
                    return result;
                }

                return firstTableWare.getMatherial().compareTo(secondTableWare.getMatherial());

            }
        };
        disponsableTableWare.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
    }


    public static void sortByFireResistance(List<DisponsableTableWare> disponsableTableWare, SortType sortType) {
        if (sortType == SortType.ASC) {
            disponsableTableWare.sort((firstDisponsableTableWare, secondDisponsableTableWare) -> Integer.compare(firstDisponsableTableWare.getFireResistance(), secondDisponsableTableWare.getFireResistance()));
        } else
            disponsableTableWare.sort((secondDisponsableTableWare, firstDisponsableTableWare) -> Integer.compare(secondDisponsableTableWare.getFireResistance(), firstDisponsableTableWare.getFireResistance()));

    }
}
