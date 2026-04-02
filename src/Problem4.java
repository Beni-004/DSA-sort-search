import java.util.*;

class Asset {
    String name;
    double ret;
    double vol;

    Asset(String name, double ret, double vol) {
        this.name = name;
        this.ret = ret;
        this.vol = vol;
    }
}

public class Problem4 {
    static void mergeSort(List<Asset> list) {
        if (list.size() <= 1) return;
        int mid = list.size() / 2;
        List<Asset> left = new ArrayList<>(list.subList(0, mid));
        List<Asset> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).ret <= right.get(j).ret)
                list.set(k++, left.get(i++));
            else
                list.set(k++, right.get(j++));
        }
        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    static int partition(List<Asset> list, int low, int high) {
        Asset pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).ret > pivot.ret ||
                    (list.get(j).ret == pivot.ret && list.get(j).vol < pivot.vol)) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    static void quickSort(List<Asset> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        List<Asset> list = new ArrayList<>();
        list.add(new Asset("AAPL", 12, 5));
        list.add(new Asset("TSLA", 8, 7));
        list.add(new Asset("GOOG", 15, 4));

        mergeSort(list);
        for (Asset a : list) System.out.println(a.name + ":" + a.ret);

        quickSort(list, 0, list.size() - 1);
        for (Asset a : list) System.out.println(a.name + ":" + a.ret);
    }
}