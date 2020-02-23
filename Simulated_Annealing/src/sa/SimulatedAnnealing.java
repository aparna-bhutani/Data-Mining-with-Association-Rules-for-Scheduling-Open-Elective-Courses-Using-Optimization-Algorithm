package sa;


public class SimulatedAnnealing {

	private int populationSize;
	private double crate;
	private int ecount;
	protected int tsize;

	public SimulatedAnnealing(int populationSize, double crate, int ecount,
			int tsize) {

		this.populationSize = populationSize;
		this.crate = crate;
		this.ecount = ecount;
		this.tsize = tsize;
	}

	/**
	 * Initialize population
	 * 
	 * @param chromosomeLength
	 *            The length of the individuals chromosome
	 * @return population The initial population generated
	 */
	public Population initPopulation(Schedule timetable) {
		// Initialize population
		Population population = new Population(this.populationSize, timetable);
		return population;
	}

	/**
	 * Check if population has met termination condition
	 * 
	 * @param generationsCount
	 *            Number of generations passed
	 * @param maxGenerations
	 *            Number of generations to terminate after
	 * @return boolean True if termination condition met, otherwise, false
	 */
	public boolean isTerminationConditionMet(int generationsCount, int maxGenerations) {
		return (generationsCount > maxGenerations);
	}

	/**
	 * Check if population has met termination condition
	 *
	 * @param population
	 * @return boolean True if termination condition met, otherwise, false
	 */
	public boolean isTerminationConditionMet(Population population) {
		return population.getFittest(0).getFitness() == 1.0;
	}

	/**
	 * Calculate individual's fitness value
	 * 
	 * @param individual
	 * @param timetable
	 * @return fitness
	 */
	public double calcFitness(Individual individual, Schedule timetable) {

		// Create new timetable object to use -- cloned from an existing timetable
		Schedule threadTimetable = new Schedule(timetable);
		threadTimetable.createClasses(individual);

		// Calculate fitness
		int clashes = threadTimetable.calcClashes();
		double fitness = 1 / (double) ((clashes) + 1);

		individual.setFitness(fitness);

		return fitness;
	}

	/**
	 * Evaluate population
	 * 
	 * @param population
	 * @param timetable
	 */
	public double evalPopulation(Population population, Schedule timetable) {
		double populationFitness = 0;

		// Loop over population evaluating individuals and summing population
		// fitness
		for (Individual individual : population.getIndividuals()) {
			populationFitness += this.calcFitness(individual, timetable);
		}

		population.setPopulationFitness(populationFitness);
		
		return populationFitness;
	}

	/**
	 * Selects parent for crossover using tournament selection
	 * 
	 * Tournament selection works by choosing N random individuals, and then
	 * choosing the best of those.
	 * 
	 * @param population
	 * @return The individual selected as a parent
	 */
	public Individual selectParent(Population population) {
		// Create tournament
		Population tournament = new Population(this.tsize);

		// Add random individuals to the tournament
		population.shuffle();
		for (int i = 0; i < this.tsize; i++) {
			Individual tournamentIndividual = population.getIndividual(i);
			tournament.setIndividual(i, tournamentIndividual);
		}

		// Return the best
		return tournament.getFittest(0);
	}



	public Population findNeighbors(Population population) {
		// Create new population
		Population newPopulation = new Population(population.size());

		// Loop over current population by fitness
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			Individual individual1 = population.getFittest(populationIndex);
			
				// Initialize neighbors
				Individual neighbor1 = new Individual(individual1.getChromosomeLength());
				
				// Find second parent
				Individual neighbor2 = selectParent(population);

				for (int geneIndex = 0; geneIndex < individual1.getChromosomeLength(); geneIndex++) {
					// Use half of parent1's genes and half of parent2's genes
					if (0.5 > Math.random()) {
						neighbor1.setGene(geneIndex, individual1.getGene(geneIndex));
					} else {
						neighbor1.setGene(geneIndex, neighbor2.getGene(geneIndex));
					}
				}

				// Add neighbor to new population
				newPopulation.setIndividual(populationIndex, neighbor1);
			} 
		

		return newPopulation;
	}



}
