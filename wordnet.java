package coba.pak.bayu;

import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.ws4j.RelatednessCalculator;
import edu.cmu.lti.ws4j.impl.HirstStOnge;
import edu.cmu.lti.ws4j.impl.JiangConrath;
import edu.cmu.lti.ws4j.impl.LeacockChodorow;
import edu.cmu.lti.ws4j.impl.Lesk;
import edu.cmu.lti.ws4j.impl.Lin;
import edu.cmu.lti.ws4j.impl.Path;
import edu.cmu.lti.ws4j.impl.Resnik;
import edu.cmu.lti.ws4j.impl.WuPalmer;
import edu.cmu.lti.ws4j.util.WS4JConfiguration;
import java.util.Scanner;
import java.util.Vector;

public class wordnet {

    private static ILexicalDatabase db = new NictWordNet();

    /*
	//available options of metrics
	private static RelatednessCalculator[] rcs = { new HirstStOnge(db),
			new LeacockChodorow(db), new Lesk(db), new WuPalmer(db),
			new Resnik(db), new JiangConrath(db), new Lin(db), new Path(db) };
     */
    private static double compute(String word1, String word2) {
        WS4JConfiguration.getInstance().setMFS(true);
        double s = new WuPalmer(db).calcRelatednessOfWords(word1, word2);
        return s;
    }
    // @ autho CakRoyyan
    public static void main(String[] args) {
//        String[] words = {"water", "river"};
//
//        for (int i = 0; i < words.length - 1; i++) {
//            for (int j = i + 1; j < words.length; j++) {
//                double distance = compute(words[i], words[j]);
//                System.out.println(words[i] + " -  " + words[j] + " = " + distance);
//            }
//        }
        
        Vector <String> words = new Vector();
        Scanner sc = new Scanner (System.in);
        System.out.println("Masukkan banyak kata yang akan di masukkan ? ");
        int no = sc.nextInt();
        for (int i = 0; i < no; i++) {
            System.out.print("Masukkan Kata yang di cari ke "+(i+1)+": "); 
            String teks = sc.next ();
            words.add(teks);
            System.out.println("");
        }

        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                double distance = compute(words.get(i), words.get(j));
                System.out.println(words.get(i) + " -  " + words.get(j) + " = " + distance);
            }
        }

    }
}
