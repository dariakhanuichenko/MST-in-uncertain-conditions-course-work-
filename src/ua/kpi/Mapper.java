package ua.kpi;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<Integer> mapListMSTToListDelta( List<MST> msts) {
        List<Integer> deltas = new ArrayList<>();
        msts.forEach( mst -> deltas.add(mst.getDelta()));
        return deltas;
    }
}
