import java.util.*;

public class DivingScores {
    private ArrayList<Double> scores;
    private double difficulty;

    public DivingScores(){
        difficulty = 0;
        scores = new ArrayList<Double>();
        Scanner in = new Scanner( System.in);
        while (difficulty < 1.2 || difficulty > 3.8){
            System.out.println("Please enter the difficulty level, from 1.2 to 3.8");
            difficulty = in.nextDouble();
            if(difficulty < 1.2 || difficulty > 3.8 ){
                System.out.println("Your input is not valid. Please do it again.");
            }
        }
    }

    public void setupScores(){
        Scanner en = new Scanner(System.in);
        for (int i=1;i<8;i++){
            double sco = -1;
            do {
                System.out.println("#" + i + " Please give your score.");
                sco = en.nextDouble();
                scores.add(sco);
            }
            while (sco <0.0 || sco > 10.0);
        }
    }

    public ArrayList<Double> getScores(){
        return scores;
    }

    public double getFinalScores(ArrayList<Double> scores){
        double min = scores.get(0);
        double max = scores.get(0);
        double sum = 0;
        for (double d: scores){
            if (d<min){ min = d; }
            if (d>max){ max = d; }
            sum += d;
        }//calculate the score sum without the highest score and the lowest score
        double finalScore = (sum - min - max) * 0.6 * difficulty;
        return finalScore;
    }//end of method

    public static void main(String[] arg){
        DivingScores ds = new DivingScores();
        ds.setupScores();
        System.out.println("The final score is " + ds.getFinalScores(ds.getScores()));
    }
}
