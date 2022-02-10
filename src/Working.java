public class Working {

    public Working() {
        int x1 = (int) (Math.random() * Global.grid[0].length);
        int x2 = (int) (Math.random() * Global.grid[0].length);
        int y1 = (int) (Math.random() * Global.grid[0].length);
        int y2 = (int) (Math.random() * Global.grid[0].length);
        int num1 = Math.random() > 0.9 ? 4 : 2;
        int num2 = Math.random() > 0.9 ? 4 : 2;
        while (y1 == y2 && x1 == x2) {
            x2 = (int) (Math.random() * Global.grid[0].length);
            y2 = (int) (Math.random() * Global.grid[0].length);
        }
        Global.grid[y1][x1] = num1;
        Global.grid[y2][x2] = num2;

    }

    public static void shiftLeft() {
        for (int[] arr : Global.grid) {
            //arr[0] = arr[0] + arr[1];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = 0;
        }
    }

    public static void print() {

        for (int i = 0; i < Global.grid[0].length; i++) {
            System.out.print("\t" + (i + 1));
        }
        System.out.println();
        for (int row = 0; row < Global.grid.length; row++) {
            System.out.print(row + 1);
            for (int col = 0; col < Global.grid[row].length; col++) {
                System.out.print("\t" + Global.grid[row][col]);
            }
            System.out.println();
        }
    }

    public static void printPrev() {

        for (int i = 0; i < Global.prevGrid[0].length; i++) {
            System.out.print("\t" + (i + 1));
        }
        System.out.println();
        for (int row = 0; row < Global.prevGrid.length; row++) {
            System.out.print(row + 1);
            for (int col = 0; col < Global.prevGrid[row].length; col++) {
                System.out.print("\t" + Global.prevGrid[row][col]);
            }
            System.out.println();
        }
    }

    private static void shiftLeftImproved() {
        for (int[] arr : Global.grid) {
            for (int i = 0; i < arr.length; i++) {
                int offset = 0;
                while (arr[i] == 0 && offset + i < arr.length - 1) {
                    offset++;
                    arr[i] = arr[i + offset];
                    arr[i + offset] = 0;
                }

            }
        }
    }

    private static void shiftLeftCore(int[] arr, int col) {
        for (int i = 0; i < arr.length; i++) {
            int offset = 0;
            while (arr[i] == 0 && offset + i < arr.length - 1) {
                offset++;
                arr[i] = arr[i + offset];
                arr[i + offset] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Global.grid[i][col] = arr[i];
        }
    }

    private static void addSameLeft() {
        for (int[] arr : Global.grid) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    arr[i] *= 2;
                    arr[i + 1] = 0;
                }
            }
        }
    }

    private static void addLeftCore(int[] arr, int col) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                arr[i] *= 2;
                arr[i + 1] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Global.grid[i][col] = arr[i];
        }
    }

    public static void printLeft() {
        print();
        System.out.println();
        shiftLeftImproved();
        print();
        System.out.println();
        addSameLeft();
        print();
        System.out.println();
        shiftLeftImproved();
        print();
    }

    public static void goLeft() {
        copy();
        shiftLeftImproved();
        addSameLeft();
        shiftLeftImproved();
        if(!arrEquals()) {
            newNum();
        }
    }

    private static void shiftRightImproved() {
        for (int[] arr : Global.grid) {
            for (int i = arr.length - 1; i >= 0; i--) {
                int offset = 0;
                while (arr[i] == 0 && i + offset > 0) {
                    offset--;
                    arr[i] = arr[i + offset];
                    arr[i + offset] = 0;
                }
            }
        }
    }

    private static void shiftRightCore(int[] arr, int col) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int offset = 0;
            while (arr[i] == 0 && i + offset > 0) {
                offset--;
                arr[i] = arr[i + offset];
                arr[i + offset] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Global.grid[i][col] = arr[i];
        }
    }

    private static void addSameRight() {
        for (int[] arr : Global.grid) {
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i] == arr[i - 1]) {
                    arr[i] *= 2;
                    arr[i - 1] = 0;
                }
            }
        }
    }

    private static void addRightCore(int[] arr, int col) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == arr[i - 1]) {
                arr[i] *= 2;
                arr[i - 1] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Global.grid[i][col] = arr[i];
        }
    }

    public static void printRight() {
        print();
        System.out.println();
        shiftRightImproved();
        print();
        System.out.println();
        addSameRight();
        print();
        System.out.println();
        shiftRightImproved();
        print();
    }

    public static void goRight() {
        copy();
        shiftRightImproved();
        addSameRight();
        shiftRightImproved();
        if(!arrEquals()) {
            newNum();
        }
    }

    private static int[] grabColumn(int col) {
        int[] c = new int[Global.grid.length];
        for (int j = 0; j < Global.grid.length; j++) {
            c[j] = Global.grid[j][col];
        }
        return c;
    }

    private static void shiftUpImproved() {
        for (int i = 0; i < Global.grid[0].length; i++) {
            shiftLeftCore(grabColumn(i), i);
        }
    }

    private static void addSameUp() {
        for (int i = 0; i < Global.grid.length; i++) {
            addLeftCore(grabColumn(i), i);
        }
    }

    public static void printUp() {
        print();
        System.out.println();
        shiftUpImproved();
        print();
        System.out.println();
        addSameUp();
        print();
        System.out.println();
        shiftUpImproved();
        print();
    }

    public static void goUp() {
        copy();
        //printPrev();
        shiftUpImproved();
        addSameUp();
        shiftUpImproved();
        if(!arrEquals()) {
            newNum();
        }
    }

    private static void shiftDownImproved() {
        for (int i = 0; i < Global.grid[0].length; i++) {
            shiftRightCore(grabColumn(i), i);
        }
    }

    private static void addSameDown() {
        for (int i = 0; i < Global.grid.length; i++) {
            addRightCore(grabColumn(i), i);
        }
    }

    public static void printDown() {
        print();
        System.out.println();
        shiftDownImproved();
        print();
        System.out.println();
        addSameDown();
        print();
        System.out.println();
        shiftDownImproved();
        print();
    }

    public static void goDown() {
        copy();
        //printPrev();
        shiftDownImproved();
        addSameDown();
        shiftDownImproved();
        if(!arrEquals()){
            newNum();
        }
    }

    public static void newNum() {
        int num = Math.random() > 0.9 ? 4 : 2;
        int num0s = 0;
        for (int[] i : Global.grid) {
            for (int j : i) {
                num0s += j == 0 ? 1 : 0;
            }
        }
        if (num0s == 0)
            return;
        int rand = (int) (Math.random() * num0s);
        int ctr = -1;
        for (int row = 0; row < Global.grid.length; row++) {
            for (int col = 0; col < Global.grid[row].length; col++) {
                if (Global.grid[row][col] == 0) {
                    ctr++;
                    if (ctr == rand) {
                        Global.grid[row][col] = num;
                        break;
                    }

                }
            }
            if (ctr == rand)
                break;
        }

    }

    public static boolean arrEquals(){
        for(int row = 0; row<Global.grid.length; row++){
            for(int col = 0; col<Global.grid[row].length; col++){
                if(Global.grid[row][col] != Global.prevGrid[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void copy(){
        for(int row = 0; row<Global.grid.length; row++){
            for(int col = 0; col<Global.grid[row].length; col++){
                Global.prevGrid[row][col] = Global.grid[row][col];
            }
        }
    }
}