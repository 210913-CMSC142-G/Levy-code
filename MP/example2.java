// Program to find the maximum profit job sequence from a given array of jobs with deadlines and profits
import java.util.*;

class Jobb
{
	// Each job has a unique-id, profit and deadline
	char id;
	int deadline, profit;

	// Constructors
	public Jobb() {}

	public Jobb(char id, int deadline, int profit)
	{
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	// Function to schedule the jobs take 2 arguments arraylist and no of jobs to schedule
	void printJobScheduling(ArrayList<Jobb> arr, int t)
	{
		// Length of array
		int n = arr.size();

		// Sort all jobs according to decreasing order of profit
		Collections.sort(arr,
						(a, b) -> b.profit - a.profit);

		// To keep track of free time slots
		boolean result[] = new boolean[t];

		// To store result (Sequence of jobs)
		char job[] = new char[t];

		//To store result (Sum of the maximum sequence)
		int pro[] = new int[t]; 	//pro for profit
		int sum = 0;

		// Iterate through all given jobs
		for (int i = 0; i < n; i++)
		{
			// Find a free slot for this job (Note that we start from the last possible slot)
			for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) 
			{
				//print the job id, deadline and profit
				System.out.println("  ");
				System.out.println("JOB TO BE SORTED: "+ arr.get(i).id);
				System.out.println("DEADLINE OF JOB: "+ arr.get(i).deadline);
				System.out.println("PROFIT OF JOB: "+ arr.get(i).profit);
				System.out.println("  ");

				//print before the sort to check what is the table before the changes
				System.out.print("Before the sorting: ");
				for (char jb : job)
			{
				System.out.print(jb + " ");
			}
			System.out.println("  ");
			//checks if the table is occupied
			System.out.println("Before the sorting, occupied?: ");
			for (boolean re : result)
			{
				System.out.println(re + " ");
			}
				// Free slot found
				System.out.println("  ");
				System.out.print("Do we put it in the sorted array?: ");
				if (result[j] == false)		//if empty
				{
					result[j] = true;		//we put true so we can say that the plot is occupied
					job[j] = arr.get(i).id;		//we insert the id of the current arr to job
					pro[j] = arr.get(i).profit;//we insert the profit of the current arr to pro
					for (char jb : job)		//print if the job is inserted in the sorted array, if not will return empty
					{
						System.out.print(jb + " ");
					}
					System.out.println("  ");
					break;
				}
				//if not empty, we move to the timeslot before the deadline of the current arr
			}
		}

		// Print the sequence.
		System.out.println("  ");
		System.out.println("Following is maximum " + "profit sequence of jobs:");
		for (char jb : job)
		{
			System.out.print(jb + " ");
		}
		//adds all the profits 
		for( int num : pro) {
			sum = sum+num;
		}
		System.out.println("with a total profit of "+sum);
		System.out.println();
	}

	// Driver code
	public static void main(String args[])
	{
		ArrayList<Jobb> arr = new ArrayList<Jobb>();
		//can modify the id, deadline and profit 
		arr.add(new Jobb('a', 3, 35));
		arr.add(new Jobb('b', 4, 30));
		arr.add(new Jobb('c', 4, 25));
		arr.add(new Jobb('d', 2, 20));
		arr.add(new Jobb('e', 3, 15));
        arr.add(new Jobb('d', 1, 12));
		arr.add(new Jobb('e', 2, 5));
		
		// Function call
		Jobb job = new Jobb();

		// Calling function
		job.printJobScheduling(arr, 4);
	}
}

// This code is contributed by Prateek Gupta
