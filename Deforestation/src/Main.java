import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// read in all trees' mass.
		int numTrees = Integer.parseInt(reader.readLine());
		int[] trees = new int[numTrees];
		for (int i=0;i<numTrees;i++) {
			trees[i] = Integer.parseInt(reader.readLine());
		}
		
		// preprocess of the trees 
		int sum = 0;
		for (int i=0;i<trees.length;i++) {
			sum += trees[i];
			trees[i] = sum;
		}
		
		int numRanges = Integer.parseInt(reader.readLine());
		for (int i=0;i<numRanges;i++) {
			String[] sRange = reader.readLine().split(" ");
			int range1 = Integer.parseInt(sRange[0]);
			int range2 = Integer.parseInt(sRange[1]);
			
			if (range1 == 0) {
				System.out.println(trees[range2]);
			} else {
				System.out.println(trees[range2]-trees[range1-1]);
			}
		}
		
	}

}

