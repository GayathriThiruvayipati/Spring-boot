package practice;

import java.util.*;

public class runner {

	
	int highestCheckpoint = 0;
	HashMap<Integer, List<String>> hm = new HashMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3 players and 2 checkpoints
		runner r = new runner();
		r.addRunnerToCheckPoint(2, 1); // first argument player and 2nd arguement checkpoint
		r.addRunnerToCheckPoint(1, 1);
		r.addRunnerToCheckPoint(1, 2);
		r.addRunnerToCheckPoint(3, 1);
		r.addRunnerToCheckPoint(3, 2);
		r.addRunnerToCheckPoint(2, 2);
	}

	private void addRunnerToCheckPoint(int i, int j) {
		// TODO Auto-generated method stub
		List<String> l = null;
		
		//if checkpoint greater than 1
		if (j > 1) {
			l = hm.get(j - 1);
			l.remove(l.indexOf("p" + i));
			hm.put(j - 1, l);
		}
		
		//if checkpoint greater than highestCheckpoint
		if (j > highestCheckpoint) {
			highestCheckpoint = j;
			l = new LinkedList();
		} else {
			l = hm.get(j);
		}
		l.add("p" + i);
		hm.put(j, l);
		
		//In order to print the positions
		System.out.print("The Race order:\t");
		int tempC = highestCheckpoint;
		while (tempC >= 1 && hm.get(tempC).size() > 0) {
			l = hm.get(tempC);
			for (String str : l) {
				System.out.print(str + " (" + tempC + ")\t");
			}
			tempC--;
		}
		System.out.println("");
	}

}
