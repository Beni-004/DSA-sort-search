public class Problem6 {
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    static int floor(int[] arr, int target) {
        int res = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                res = arr[mid];
                low = mid + 1;
            } else high = mid - 1;
        }
        return res;
    }

    static int ceil(int[] arr, int target) {
        int res = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                res = arr[mid];
                high = mid - 1;
            } else low = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        System.out.println(linearSearch(arr, 30));
        System.out.println(floor(arr, 30));
        System.out.println(ceil(arr, 30));
    }
}