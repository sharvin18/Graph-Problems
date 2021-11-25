import java.util.*;
import java.io.*;

/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
*/


class KeysAndRooms {

    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        boolean result = false;
        Queue<Integer> unlockedRooms = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        
        if(rooms.get(0).size() == 0){
            return result;
        }else{
            visited.add(0);
            for(int k: rooms.get(0)){
                unlockedRooms.add(k);
            }
            
            while(!unlockedRooms.isEmpty()){
                
                int room = unlockedRooms.poll();
                if(!visited.contains(room)) {
                    visited.add(room);
                
                    for(int k: rooms.get(room)){
                        unlockedRooms.add(k);
                    }
                }
                
                
            }
        }
        
        if(visited.size() == n) result = true;
        return result;
    }

	public static void main(String[] args) throws IOException {
	
		BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> rooms = new ArrayList<>();
		ArrayList<Integer> temp;
		int i,j,n;
		boolean result;
		n = Integer.parseInt(infile.readLine());
		
		for(i=0; i<n; i++){
			String[] inp = infile.readLine().split(" ");
			temp = new ArrayList<>();
			for(String k: inp){
				temp.add(Integer.parseInt(k));
			}
			rooms.add(new ArrayList<>(temp));
		}
		
		result = canVisitAllRooms(rooms)
		
		if(result) System.out.println("All rooms can be visited");
		else System.out.println("All rooms cannot be visited");
		
		infile.close();
	}
}
