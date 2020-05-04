package ua.kpi;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        DataReader dataReader = new DataReader();

        try {

            int l = 21;

            List<Integer[][]> matrixes = new LinkedList<>();
            List<MST> msts = new LinkedList<>();
            matrixes.add(dataReader.readData("C:\\Users\\deyad\\Desktop\\labs\\mateix.txt"));
            matrixes.add(dataReader.readData("C:\\Users\\deyad\\Desktop\\labs\\mateix1.txt"));
            matrixes.add(dataReader.readData("C:\\Users\\deyad\\Desktop\\labs\\mateix2.txt"));

            int vertices = matrixes.get(0)[0].length;

            // FIRST STEP
            // создали МКД для каждой матрицы
            matrixes.forEach(matrix -> msts.add(Utility.firstStep(matrix, vertices)));

            // SECOND STEP
            // для каждого МКД посчитать дельту
            msts.forEach(mst -> {
                mst.setDelta(matrixes, msts);
            });

            // THIRD STEP
            System.out.println(Utility.thirdStep(Mapper.mapListMSTToListDelta(msts), l));
            System.out.println("delta = " + msts.toString());
        } catch (IOException e) {
        }
    }
}
