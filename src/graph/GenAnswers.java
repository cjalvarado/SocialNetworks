package graph;

import java.io.PrintWriter;
import util.GraphLoader;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class GenAnswers {

    public static void main (String[] args) {
        //g.petition(amount);


        for(int i = 0; i < 10; i++) {
            CapGraph g = new CapGraph();

            try {
                GraphLoader.loadGraph(g, "data/scc/T" + (i +1));
                PrintWriter pw = new PrintWriter("data/scc_answers/answer" + (i + 1));

                List<Graph> graphSCCs = g.getSCCs();
                
                List<Set<Integer>> sccs = new ArrayList<Set<Integer>>();

                for(Graph graph : graphSCCs) {
                    HashMap<Integer, HashSet<Integer>> curr = graph.exportGraph();
                    TreeSet<Integer> scc = new TreeSet<Integer>();
                    for (Map.Entry<Integer, HashSet<Integer>> entry : curr.entrySet()) {
                        scc.add(entry.getKey());
                    }
                    sccs.add(scc);
                }
                // loop over SCCs
                for(int j = 0; j < sccs.size(); j++) {

                    Set<Integer> scc = sccs.get(j);
                    for(Integer val : scc) {
                        pw.print(val + " ");
                    }
                    pw.print("\n");
                }
                pw.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
