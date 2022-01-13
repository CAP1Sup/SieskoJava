public class TowerOfHanoi {

    int[][] disks;

    TowerOfHanoi(int rings) {
        disks = new int[rings][3];
        for (int index = 0; index < rings; index++) {
            disks[index][0] = index + 1;
        }
    }

    public static void main(String[] args) {
        int towerSize = 4;
        TowerOfHanoi tower = new TowerOfHanoi(towerSize);
        tower.print();
        tower.moveTower(towerSize, 0, 1, 2);
        tower.print();
    }

    // Compute the tower movement based on the number of rings to move
    public void moveTower(int rings, int startPeg, int auxPeg, int endPeg) {

        // Check if we only need to move a single ring
        if (rings == 1) {
            System.out.println(
                    "Moving disk "
                            + move(startPeg, endPeg)
                            + " from peg "
                            + (startPeg + 1)
                            + " to peg "
                            + (endPeg + 1));
        } else {
            moveTower(rings - 1, startPeg, endPeg, auxPeg);
            moveTower(1, startPeg, auxPeg, endPeg);
            moveTower(rings - 1, auxPeg, startPeg, endPeg);
        }
    }

    public int move(int fromColumn, int toColumn) {

        // Find the top rows
        int fromRow = findTopRow(fromColumn);
        int toRow = findTopRow(toColumn) - 1;

        // if (toRow < 0) {
        // Too many disks stacked, this is illegal
        // }
        if (fromRow >= disks.length) {
            System.out.println("Illegal move, no disk to move!");
        } else if (!checkMove(fromRow, fromColumn, toRow, toColumn)) {
            System.out.println("Illegal move, cannot stack lower value disk!");
        } else {

            // Move the disk over
            disks[toRow][toColumn] = disks[fromRow][fromColumn];

            // Remove the old listing for the old disk
            disks[fromRow][fromColumn] = 0;

            // Return the disk number moved
            return disks[toRow][toColumn];
        }

        // Nothing was moved, return a -1
        return -1;
    }

    public int findTopRow(int column) {
        int row = 0;
        while (row < disks.length) {
            if (disks[row][column] != 0) {
                return row;
            }
            row++;
        }
        return (disks.length);
    }

    // Check to make sure that the rings aren't being stacked wrong
    public boolean checkMove(int fromRow, int fromColumn, int toRow, int toColumn) {

        // Find the value below the new location
        if (toRow >= disks.length) {
            System.out.println("Illegal row!");
            return false;
        } else if (toRow == disks.length - 1) {
            // No need to check this one, there is no ring below
            return true;
        } else {
            if (disks[fromRow][fromColumn] < disks[toRow + 1][toColumn]) {

                return true;
            } else {
                // The disk below is smaller
                System.out.println("Illegal move, disk on top is smaller!");
                return false;
            }
        }
    }

    public void print() {
        for (int[] row : disks) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
