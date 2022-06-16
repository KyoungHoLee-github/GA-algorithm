import java.util.Random;

public class GA {

    Population population = new Population();
    Individual fittest;
    Individual secondFittest;
    int generationCount = 0;

    public static void main(String[] args) {
        int[] dataX = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        double[] dataY = {50.8, 55.2, 59, 62.5, 65.2, 66.8, 69, 70.4, 71.9, 73.5, 74.6, 76.5,77.8};

        int sumX = 0;
        int sumY = 0;

        for (int i = 0; i < dataX.length; i++){
            sumX += dataX[i];
        }

        for (int i = 0; i < dataY.length; i++){
            sumY += dataY[i];
        }

        double mx = (double) sumX / dataX.length;
        double my = (double) sumY / dataY.length;

        //a분모 계산
        double denominator = 0;

        for (int i = 0; i < dataX.length; i++){
            double temp = (double) dataX[i] - mx;
            denominator += Math.pow(temp, 2);
        }

        //a분자 계산
        double numerator = 0;

        for (int i = 0; i < dataY.length; i++){
            double temp1 = (double) dataX[i] - mx;
            double temp2 = dataY[i] - my;
            numerator += temp1 * temp2;
        }

        double a = numerator / denominator;     //최소제곱법을 통한 a값
        double b = my - (mx * a);               //최소제곱법을 통한 b값


        Random rn = new Random();
        GA ga_a = new GA();


        ga_a.population.initializePopulation();

        ga_a.population.calculateFitness();

        double minimumErrorValue = Integer.MAX_VALUE;

        int assumeA = 0;
        //오차값
        while(Math.abs(a - assumeA) > 0.5){
            ++ga_a.generationCount;

            ga_a.selection();
            ga_a.crossover();

            if(rn.nextInt()%10 <= 3){
                ga_a.mutation();
            }

            ga_a.addFittestOffspring();
            ga_a.population.calculateFitness();
            if(minimumErrorValue > ga_a.calculateError(dataX, dataY, ga_a, b)){
                assumeA = ga_a.population.fittest;
            }
            minimumErrorValue = Math.min(minimumErrorValue, ga_a.calculateError(dataX, dataY, ga_a, b));

            System.out.println("generation : " + ga_a.generationCount + "\tminimum assume a : " + assumeA +
                    "\terrorValue : " + minimumErrorValue + "\treality a value - assume a value : " + (a - assumeA));

        }

        System.out.println("reality a : " + a);
        System.out.println("reality b : " + b);
    }

    //오차값 계산
    double calculateError(int[] x, double[] y, GA a, double b) {
        double errorValue = 0;
        double temp;

        for(int i = 0; i < x.length; i++) {
            temp = a.population.fittest * x[i] + b - y[i];
            temp = Math.abs(temp);
            errorValue += temp;
        }

        errorValue /= x.length;

        return errorValue;
    }

    //선택 연산
    void selection() {
        fittest = population.getFittest();
        secondFittest = population.getSecondFittest();
    }

    //교차 연산
    void crossover() {
        Random rn = new Random();

        int crossOverPoint = rn.nextInt(population.individuals[0].geneLength);

        for (int i = 0; i < crossOverPoint; i++) {
            int temp = fittest.genes[i];
            fittest.genes[i] = secondFittest.genes[i];
            secondFittest.genes[i] = temp;

        }

    }

    //돌연변이 연산
    void mutation() {
        Random rn = new Random();

        int mutationPoint = rn.nextInt(population.individuals[0].geneLength);

        if (fittest.genes[mutationPoint] == 0) {
            fittest.genes[mutationPoint] = 1;
        } else {
            fittest.genes[mutationPoint] = 0;
        }

        mutationPoint = rn.nextInt(population.individuals[0].geneLength);

        if (secondFittest.genes[mutationPoint] == 0) {
            secondFittest.genes[mutationPoint] = 1;
        }
        else {
            secondFittest.genes[mutationPoint] = 0;
        }

    }

    //좋은 자손얻기
    Individual getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }


    //적합도가 낮은 후보를 가장 적합한 후보로 교체
    void addFittestOffspring() {
        fittest.calcFitness();
        secondFittest.calcFitness();

        int leastFittestIndex = population.getLeastFittestIndex();

        population.individuals[leastFittestIndex] = getFittestOffspring();
    }

}

//각각의 후보를 나타내는 클래스
class Individual {
    int fitness;
    int[] genes = new int[4];
    int geneLength = 4;

    public Individual() {
        Random rn = new Random();

        //유전자 값 설정
        for (int i = 0; i < genes.length; i++) {
            genes[i] = Math.abs(rn.nextInt() % 2);
        }

        fitness = 0;
    }

    //적합도 계산
    public void calcFitness() {
        fitness = 0;

        if(genes[0] == 1)  fitness += 8;
        if(genes[1] == 1)  fitness += 4;
        if(genes[2] == 1)  fitness += 2;
        if(genes[3] == 1)  fitness += 1;

        if(fitness > 12) {
            fitness = fitness % 13;
        }
    }

}

//모집단 클래스
class Population {
    Individual[] individuals = new Individual[10];
    int fittest = 0;

    //초기설정
    public void initializePopulation() {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new Individual();
        }
    }

    //가장 적합한 후보
    public Individual getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;

        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].fitness) {
                maxFit = individuals[i].fitness;
                maxFitIndex = i;
            }
        }

        fittest = individuals[maxFitIndex].fitness;
        return individuals[maxFitIndex];
    }

    //두번째로 적합한 후보
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;

        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].fitness > individuals[maxFit1].fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            }
            else if (individuals[i].fitness > individuals[maxFit2].fitness) {
                maxFit2 = i;
            }
        }

        return individuals[maxFit2];
    }

    //가장 적합하지 않은 후보의 인덱스값
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;

        for (int i = 0; i < individuals.length; i++) {
            if (minFitVal >= individuals[i].fitness) {
                minFitVal = individuals[i].fitness;
                minFitIndex = i;
            }
        }

        return minFitIndex;
    }

    //각 후보의 적합성 계산
    public void calculateFitness() {

        for (int i = 0; i < individuals.length; i++) {
            individuals[i].calcFitness();
        }

        getFittest();
    }
}