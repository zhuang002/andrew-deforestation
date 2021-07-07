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
		
		// read in all ranges 
		int numRanges = Integer.parseInt(reader.readLine());
		Range[] ranges = new Range[2*numRanges];
		for (int i=0; i<numRanges;i++) {
			String[] sRange = reader.readLine().split(" ");
			int rangeStart = Integer.parseInt(sRange[0]);
			int rangeEnd = Integer.parseInt(sRange[1]);
			
			Range range = new Range(rangeStart, true, i);
			ranges[i*2] = range;
			range = new Range(rangeEnd, false, i);
			ranges[i*2+1] = range;
		}
		
		reader.close();
		
		// sort all ranges 
		
		Arrays.sort(ranges, (x,y)->x.range-y.range);
		
		// prepare for sums
		int[] sums = new int[numRanges];
		for (int i=0;i<sums.length;i++) {
			sums[i]=0;
		}
		boolean[] accumulating = new boolean[numRanges];
		for (int i=0;i<numRanges;i++) {
			accumulating[i] = false;
		}
		
		// do sums
		int rangePoint = 0;
		for (int i=0;i<numTrees;i++) {
			// if meet a range, change the state.
			if (i==ranges[rangePoint].range) {
				if (ranges[rangePoint].isStart) {
					accumulating[ranges[rangePoint].index]= true;
				} else {
					accumulating[ranges[rangePoint].index] = false;
				}
			}
			
			// sum up if the state is in accumulating.
			for (int j=0;j<numRanges;j++) {
				if (accumulating[j]) {
					sums[j]+=trees[i];
				}
			}
		}
		
		for (int i=0;i<sums.length;i++) {
			System.out.println(sums[i]);
		}
		
	}

}

class Range {
	int range;
	boolean isStart;
	int index;
	
	public Range(int rg, boolean start, int idx) {
		this.range = rg;
		this.isStart = start;
		this.index = idx;
	}
}
