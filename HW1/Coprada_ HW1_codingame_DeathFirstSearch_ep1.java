import java.util.*;
import java.io.*;
import java.math.*;


class Player {
    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        int [][] adj = new int [N][N];
        List<Integer> gate = new ArrayList<Integer>();
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            adj[N1][N2] = 1;
            adj[N2][N1] = 1;
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gate.add(EI);
        }
        int End = 0;
        List<Integer> candidates = new ArrayList<Integer>();    //candidates for removal (visited nodes)

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn, iS THE ROOT
            //If a link would allow the Agent to reach a gateway on the next turn, remove that link.
             boolean removed = false;       
            for (int i = 0; i <  N; i++)
            {
                    if (adj[SI][i] == 1)      //check if gate is 1 or 0, if yes
                {
                    candidates.add(i);
                }
            }
            for (int j = 0; j <  candidates.size(); j++)
            {
                    if (gate.contains(candidates.get(j)))
                {
                    System.out.println(SI + " " + candidates.get(j));
                    removed = true;
                    candidates.clear();
                    break;
                }
            }
            if(removed)
            {
                continue;   //pag may nalagyan na skip the succeding codes
            }
            candidates.clear();

            //If a gateway has only one reachable link remaining, remove that link.
            for (int i = 0; i<  E; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if(adj[gate.get(i)][j] == 1)
                    {
                        candidates.add(j);
                    } 
                }
                if(candidates.size() == 1)  //only one reachable link remaining
                {
                    System.out.println(candidates.get(0)+ " " + gate.get(i));
                    removed = true;
                    break;
                }
                else
                {
                    System.out.println(candidates.get(0)+ " " + gate.get(i));
                    removed = true;
                    candidates.clear();
                    break;
                }
            }
            if(removed)
            {
                continue;   //pag may nalagyan na skip the succeding codes
            }
        }
        
    }

}
