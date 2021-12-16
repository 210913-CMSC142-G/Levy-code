# Job Sequencing NP-Complete Readme

Ma. Levy Rizzell P. Coprada

CMSC 142 G

## Job Sequencing

The main premise of **Job Sequencing** is finding an optimal schedule for a set of jobs that maximizes the profit. We are then given:
* A set of n jobs 
* Each job i has a deadline d<sub>i</sub> >=1 and profit p<sub>i</sub> >=0
* There is one processor or machine
* Each job takes 1 unit of time (for simplification)
* We earn the profit if and only if the job is completed by its deadline

	* *Note that: “Profit” can be the priority of the task in a real time system that discards tasks that cannot be completed by their deadline*

***

## NP-Completeness

*Note that these notes here are how I understood them and are not the formal definition of NP-Complete*

NP Complete (NPC) problems are:
* **Search problems** or **Probems that are answerable by yes/no** with no known efficient algorithm to solve them, with efficient meaning not polynomial time algorithm.

* They can be solved in exponential time (at best) and uses non-deterministic method to solve it.

	* Non-deterministic method meaning it can have varied results every run of a program.

		* Unlike deterministic method wherein once we have this program it knows what to do and arrives at the same result every time.

* We can *"solve it in polynomial time if we can break the normal rules of step-by-step computing"*, and since we are not able to, we reduce the problem in such a way that we can solve it with polynomial time complexity.

**How is Job Sequencing NP-Complete?**

The general preemptive Job sequencing problem is considered NP-complete. In job sequencing, there are a lot of ways on how to schedule the jobs and after solving all of the possible ways to schedule, you would have to compare the results of the said schedule on whose total job done would yield the maximum profit, even if you restrict all jobs to 1 time unit, something that would definitely **not** take in a polynomial time.

It is considered as a searching algorithm due to the fact we are searching for the maximum profit that is to be gained by scheduling these jobs. To solve this problem, we then order it in such a way that it would be easier to solve.
 
***

## Solution for Job Sequencing

- **Greedy Algorithm**

Two greedy algorithms/pseudocodes are given with slight difference but of the same thought:

Version 1:
```` version 1
1. Sort all jobs in decreasing order of profit.
2. Initialize the result sequence as first job in sorted jobs.
3. Do following for remaining n-1 jobs : If the current job can fit in the current result sequence without missing the deadline, add current job to the result. Else ignore the current job.
````
Version 2:
```` version 2
1. Sort all jobs in decreasing order of profit.
2. Place each job at latest time that meets its deadline 
	 Note: Nothing is gained by scheduling it earlier,and scheduling it earlier could prevent another more profitable job from being done
3.Solve
````
Note that the time complexity for greedy algorithm is **O(n<sup>2</sup>).**

- **Sample Problems with Solution**

Given a set of **4 jobs** where each job has a deadline and profit associated to it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the maximum profit and the number of jobs done.


|Job ID|Deadline|Profit|
|------|--------|------|
|  A   |   4    |  20  |
|  B   |   1    |  10  |
|  C   |   1    |  40  |
|  D   |   1    |  30  |


Following the steps of the version 2 pseudocode to the given, we then have:
1. Sort all jobs in decreasing order of profit


|Job ID|Deadline|Profit|
|------|--------|------|
|  C   |   1    |  40  |
|  D   |   1    |  30  |
|  A   |   4    |  20  |
|  B   |   1    |  10  |


2. Place each job at latest time that meets its deadline 

	2.1. We place C in the (0,1) timeslot since C has a deadline of 1 and the said timeslot is unoccupied.
	

	|Time |Job ID|Deadline|Profit|
	|-----|------|--------|------|
	|(0,1)|   C  |   1    |  40  |
	|(1,2)| Empty| Empty  | Empty|
	|(2,3)| Empty| Empty  | Empty|
	|(3,4)| Empty| Empty  | Empty|

	2.2. Since D has a deadline of 1 and the (0,1) timeslot is already occupied by C, we **disregard** it. We then move forward to the next job which is A with a deadline of 4. Since the (3,4) timeslot is unoccupied, we put the job A at the said timeslot.

	

	|Time |Job ID|Deadline|Profit|
	|-----|------|--------|------|
	|(0,1)|   C  |   1    |  40  |
	|(1,2)| Empty| Empty  | Empty|
	|(2,3)| Empty| Empty  | Empty|
	|(3,4)|   A  |   4    |  20  |

	2.3. Lastly, since B has a deadline of 1 and since the (0,1) timeslot is occupied, we disregard it.

	
Thus, the maximum profit of sequence of jobs is : C,A with 40+20 = 60 as the total profit

---

Given a set of **7 jobs** where each job has a deadline and profit associated to it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the maximum profit and the number of jobs done.

|Job ID       |Deadline|Profit|
|-------------|--------|------|
|J<sub>1</sub>|   3    |  35  |
|J<sub>2</sub>|   4    |  30  |
|J<sub>3</sub>|   4    |  25  |
|J<sub>4</sub>|   2    |  20  |
|J<sub>5</sub>|   3    |  15  |
|J<sub>6</sub>|   1    |  12  |
|J<sub>7</sub>|   2    |   5  |

Following the steps of the version 2 pseudocode to the given, we then have:
1. Sort all jobs in decreasing order of profit. Since it is already sorted, it has the same values as the previous table.

|Job ID       |Deadline|Profit|
|-------------|--------|------|
|J<sub>1</sub>|   3    |  35  |
|J<sub>2</sub>|   4    |  30  |
|J<sub>3</sub>|   4    |  25  |
|J<sub>4</sub>|   2    |  20  |
|J<sub>5</sub>|   3    |  15  |
|J<sub>6</sub>|   1    |  12  |
|J<sub>7</sub>|   2    |   5  |


2. Place each job at latest time that meets its deadline 

	2.1. We place J<sub>1</sub> in the (2,3) timeslot since J<sub>1</sub> has a deadline of 3 and the said timeslot is the latest time of the deadline of the said job that is unoccupied.
	

	|Time |Job ID       |Deadline|Profit|
	|-----|-------------|--------|------|
	|(0,1)| Empty       | Empty  | Empty|
	|(1,2)| Empty       | Empty  | Empty|
	|(2,3)|J<sub>1</sub>|   3    |  35  |
	|(3,4)| Empty       | Empty  | Empty|

	2.2.We place J<sub>2</sub> in the (3,4) timeslot since J<sub>2</sub> has a deadline of 4 and the said timeslot is the latest time of the deadline of the said job and is also unoccupied.
	|Time |Job ID       |Deadline|Profit|
	|-----|-------------|--------|------|
	|(0,1)| Empty       | Empty  | Empty|
	|(1,2)| Empty       | Empty  | Empty|
	|(2,3)|J<sub>1</sub>|   3    |  35  |
	|(3,4)|J<sub>2</sub>|   4    |  30  |

	2.3. Since J<sub>3</sub> has a deadline of 4 and the (3,4) timeslot is already occupied by J<sub>2</sub>, we **check the timeslots before it**. We notice that timeslot (2,3) is already occupied by J<sub>1</sub>, we **check the timeslots before it**. Finally the timeslot (1,2) is unoccupied, we put the job J<sub>3</sub> at the said timeslot.

	|Time |Job ID       |Deadline|Profit|
	|-----|-------------|--------|------|
	|(0,1)| Empty       | Empty  | Empty|
	|(1,2)|J<sub>3</sub>|   4    |  25  |
	|(2,3)|J<sub>1</sub>|   3    |  35  |
	|(3,4)|J<sub>2</sub>|   4    |  30  |

	2.4.Since J<sub>4</sub> has a deadline of 2 and the (1,2) timeslot is already occupied by J<sub>3</sub>, we **check the timeslots before it**. We notice that timeslot (0,1) is unoccupied, we put the job J<sub>4</sub> at the said timeslot.

	|Time |Job ID       |Deadline|Profit|
	|-----|-------------|--------|------|
	|(0,1)|J<sub>4</sub>|   2    |  20  |
	|(1,2)|J<sub>3</sub>|   4    |  25  |
	|(2,3)|J<sub>1</sub>|   3    |  35  |
	|(3,4)|J<sub>2</sub>|   4    |  30  |

	2.3. Lastly, since the J<sub>5</sub> has a deadline of 3 and since the (2,3) timeslot and the timeslots before it are occupied, we **disregard** it. The same goes with J<sub>6</sub> with a deadline of 1 and J<sub>2</sub> with a deadline of 2.

Thus, the maximum profit of sequence of jobs is : J<sub>4</sub>, J<sub>3</sub>, J<sub>1</sub>,J<sub>2</sub> with 20+25+35+30 = 110 as the total profit.
***
## Additional Notes
The code that is with this md file (job.java) was from the website [GeeksforGeeks](https://www.geeksforgeeks.org/job-sequencing-problem/ "Job Sequencing Problem - GeeksforGeeks") and is contributed by Prateek Gupta. It was modified for the viewer to see what was the process inbetween and to see the total profit of the sorted job. Additional comments have also been inserted for ease of the viewer.
***

## References
[3.2 Job Sequencing with Deadlines - Greedy Method.(2018, February 07).](https://www.youtube.com/watch?v=zPtI8q9gvX8&t=16s "Reference 1, YT video") 

[Computer Algorithms in Systems Engineering.(2010).](https://bit.ly/3Dprups "Reference 2")

[Job Sequencing Problem. (2014, November 18). GeeksforGeeks. ](https://www.geeksforgeeks.org/job-sequencing-problem/ "Reference 3")

[Ullman, J.D. . NP-Complete Scheduling Problems.(1973, May 16). ](https://core.ac.uk/reader/82723490 "Reference 4")

[NP-Complete-A Rough Guide. MathisFun](https://www.mathsisfun.com/sets/np-complete.html "Reference 5")