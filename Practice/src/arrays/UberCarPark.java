package arrays;

public class UberCarPark {

	boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
	    // lucky spot needs to be empty
	    for(int i = luckySpot[0]; i <= luckySpot[2]; i++) {
	        for(int j = luckySpot[1]; j <= luckySpot[3]; j++) {
	            if(parkingLot[i][j] == 1)
	                return false;
	        }
	    }
	    return checkLeft(parkingLot, luckySpot) || checkRight(parkingLot, luckySpot) || checkUp(parkingLot, luckySpot) || checkBottom(parkingLot, luckySpot);
	}

	boolean checkLeft(int[][] parkingLot, int[] luckySpot) {
	    for(int i = luckySpot[0]; i <= luckySpot[2]; i++) {
	        for(int j = 0; j < luckySpot[1]; j++) {
	            if(parkingLot[i][j] == 1)
	                return false;
	        }
	    }
	    return true;
	}

	boolean checkRight(int[][] parkingLot, int[] luckySpot) {
	    for(int i = luckySpot[0]; i <= luckySpot[2]; i++) {
	        for(int j = parkingLot[0].length - 1; j > luckySpot[3]; j--) {
	            if(parkingLot[i][j] == 1)
	                return false;
	        }
	    }
	    return true;
	}

	boolean checkUp(int[][] parkingLot, int[] luckySpot) {
	    for(int i = 0; i <= luckySpot[0]; i++) {
	        for(int j = luckySpot[1]; j <= luckySpot[3]; j++) {
	            if(parkingLot[i][j] == 1)
	                return false;
	        }
	    }
	    return true;
	}

	boolean checkBottom(int[][] parkingLot, int[] luckySpot) {
	    for(int i = parkingLot.length - 1; i > luckySpot[2]; i--) {
	        for(int j = luckySpot[1]; j <= luckySpot[3]; j++) {
	            if(parkingLot[i][j] == 1)
	                return false;
	        }
	    }
	    return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UberCarPark ucp = new UberCarPark();
		int[][] parkingLot = {{1,0,1,0,1,0},{1,0,0,0,1,0},{0,0,0,0,0,1},{1,0,0,0,1,1}};
		int[] luckySpot = {1,1,2,3};
		int[] carDimentions = {3,2};
		System.out.println(ucp.parkingSpot(carDimentions, parkingLot, luckySpot));
	}

}
