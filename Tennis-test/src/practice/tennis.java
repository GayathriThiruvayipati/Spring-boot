package practice;

import java.util.*;

public class tennis {

	HashMap<String, Set<String>> won_with = new HashMap<String, Set<String>>();
	HashMap<String, Set<String>> lost_to = new HashMap<String, Set<String>>();
	String looser="";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;//no.of players
		tennis t = new tennis();
		t.match("p2", "p3", "p2", "p3"); //Player 1, Player 2, Won, Lost
		t.match("p3", "p1", "p3", "p1");
		t.match("p2", "p1", "p2", "p1");
		t.winner(n);
		t.getRanks(n);
	}

	
	
	private void getRanks(int n) {
		// TODO Auto-generated method stub
		System.out.print("The ranks are\t");
		for(String key:won_with.keySet()) {
			System.out.print(key+" ("+(n - won_with.get(key).size())+")\t");
		}
		looser(n);
		System.out.print(looser+" ("+n+")\n");
	}


	private void looser(int n) {
		// TODO Auto-generated method stub
		for(String key:lost_to.keySet()) {
			if(lost_to.get(key).size() == n-1) {
				looser = key;
				break;
			}
		}
	}

	private void winner(int n) {
		// TODO Auto-generated method stub
		for(String key:won_with.keySet()) {
			if(won_with.get(key).size() == n-1) {
				System.out.println("The winner is\t"+key);
				break;
			}
		}
		System.out.println();
	}



	private void match(String p1, String p2, String won, String lost) {
		// TODO Auto-generated method stub
		Set<String> set = null;
		if (!won_with.containsKey(won)) {
			set = new HashSet<String>();
		} else {
			set = won_with.get(won);

		}
		set.add(lost);
		won_with.put(won, set);
		if (!lost_to.containsKey(lost)) {
			set = new HashSet<String>();
		} else {
			set = lost_to.get(lost);

		}
		set.add(won);
		lost_to.put(lost, set);
	}

}
