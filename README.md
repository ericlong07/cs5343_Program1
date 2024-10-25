# CPU Scheduler Implementation Report

## Overview
This project implements various CPU scheduling algorithms to manage task execution based on different criteria such as burst time, priority, and time quantum. The implementation demonstrates five different scheduling approaches: First-Come-First-Serve (FCFS), Shortest Job First (SJF), Priority Scheduling, Round Robin (RR), and Priority with Round Robin.

## Input Format
The scheduler takes input from a text file (`schedule.txt`) containing task definitions in the following format:
```
T1, 4, 20
T2, 3, 25
T3, 3, 25
T4, 5, 15
T5, 5, 20
T6, 1, 10
T7, 3, 30
T8, 10, 25
```
Each line represents a task with:
- Task name
- Priority (1-10, where higher numbers indicate higher priority)
- CPU burst time

## Implementation Details
- Time quantum for Round Robin: 10 milliseconds
- Priority range: 1-10 (higher number = higher priority)
- All tasks arrive simultaneously
- No preemption needed for priority-based scheduling

## Algorithm Implementations and Results

### 1. First-Come-First-Serve (FCFS)
Tasks are executed in the order they appear in the input file.

```
(base) eric@Erics-MacBook-Pro-3 java % java Driver fcfs schedule.txt
FCFS Scheduling 

Will run Name: T1
Tid: 0
Priority: 4
Burst: 20

Will run Name: T2
Tid: 1
Priority: 3
Burst: 25

Will run Name: T3
Tid: 2
Priority: 3
Burst: 25

Will run Name: T4
Tid: 3
Priority: 5
Burst: 15

Will run Name: T5
Tid: 4
Priority: 5
Burst: 20

Will run Name: T6
Tid: 5
Priority: 1
Burst: 10

Will run Name: T7
Tid: 6
Priority: 3
Burst: 30

Will run Name: T8
Tid: 7
Priority: 10
Burst: 25
```

### 2. Shortest Job First (SJF)
Tasks are ordered by CPU burst time, with shorter bursts executed first.

```
(base) eric@Erics-MacBook-Pro-3 java % java Driver sjf schedule.txt 
SJF Scheduling

Will run Name: T6
Tid: 5
Priority: 1
Burst: 10

Will run Name: T4
Tid: 3
Priority: 5
Burst: 15

Will run Name: T1
Tid: 0
Priority: 4
Burst: 20

Will run Name: T5
Tid: 4
Priority: 5
Burst: 20

Will run Name: T2
Tid: 1
Priority: 3
Burst: 25

Will run Name: T3
Tid: 2
Priority: 3
Burst: 25

Will run Name: T8
Tid: 7
Priority: 10
Burst: 25

Will run Name: T7
Tid: 6
Priority: 3
Burst: 30
```

Key observation: Tasks are ordered strictly by burst time, with T6 (10ms) running first, followed by T4 (15ms), and so on.

### 3. Priority Scheduling
Tasks are ordered by priority level, with higher priority tasks executing first.

```
(base) eric@Erics-MacBook-Pro-3 java % java Driver pri schedule.txt 
Priority Scheduling

Will run Name: T8
Tid: 7
Priority: 10
Burst: 25

Will run Name: T4
Tid: 3
Priority: 5
Burst: 15

Will run Name: T5
Tid: 4
Priority: 5
Burst: 20

Will run Name: T1
Tid: 0
Priority: 4
Burst: 20

Will run Name: T2
Tid: 1
Priority: 3
Burst: 25

Will run Name: T3
Tid: 2
Priority: 3
Burst: 25

Will run Name: T7
Tid: 6
Priority: 3
Burst: 30

Will run Name: T6
Tid: 5
Priority: 1
Burst: 10
```

Key observation: T8 with priority 10 executes first, followed by tasks with priority 5 (T4 and T5), and so on.

### 4. Round Robin (RR)
Tasks are executed in cycles with a time quantum of 10ms.

```
(base) eric@Erics-MacBook-Pro-3 java % java Driver rr schedule.txt 
RR Scheduling

Will run Name: T1
Tid: 0
Priority: 4
Burst: 20

Will run Name: T2
Tid: 1
Priority: 3
Burst: 25

Will run Name: T3
Tid: 2
Priority: 3
Burst: 25

Will run Name: T4
Tid: 3
Priority: 5
Burst: 15

Will run Name: T5
Tid: 4
Priority: 5
Burst: 20

Will run Name: T6
Tid: 5
Priority: 1
Burst: 10

Will run Name: T7
Tid: 6
Priority: 3
Burst: 30

Will run Name: T8
Tid: 7
Priority: 10
Burst: 25

Will run Name: T1
Tid: 0
Priority: 4
Burst: 10

Will run Name: T2
Tid: 1
Priority: 3
Burst: 15

Will run Name: T3
Tid: 2
Priority: 3
Burst: 15

Will run Name: T4
Tid: 3
Priority: 5
Burst: 5

Will run Name: T5
Tid: 4
Priority: 5
Burst: 10

Will run Name: T7
Tid: 6
Priority: 3
Burst: 20

Will run Name: T8
Tid: 7
Priority: 10
Burst: 15

Will run Name: T2
Tid: 1
Priority: 3
Burst: 5

Will run Name: T3
Tid: 2
Priority: 3
Burst: 5

Will run Name: T7
Tid: 6
Priority: 3
Burst: 10

Will run Name: T8
Tid: 7
Priority: 10
Burst: 5
```

Key observations:
- Each task gets a maximum of 10ms of CPU time before being moved to the back of the queue
- Tasks with remaining burst time return to the queue
- Process continues until all tasks complete

### 5. Priority with Round Robin
Combines priority scheduling with round robin for tasks of equal priority.

```
(base) eric@Erics-MacBook-Pro-3 java % java Driver pri-rr schedule.txt
Priority Round Robin Scheduling

Will run Name: T8
Tid: 7
Priority: 10
Burst: 25

Will run Name: T8
Tid: 7
Priority: 10
Burst: 15

Will run Name: T8
Tid: 7
Priority: 10
Burst: 5

Will run Name: T4
Tid: 3
Priority: 5
Burst: 15

Will run Name: T5
Tid: 4
Priority: 5
Burst: 20

Will run Name: T4
Tid: 3
Priority: 5
Burst: 5

Will run Name: T5
Tid: 4
Priority: 5
Burst: 10

Will run Name: T1
Tid: 0
Priority: 4
Burst: 20

Will run Name: T1
Tid: 0
Priority: 4
Burst: 10

Will run Name: T2
Tid: 1
Priority: 3
Burst: 25

Will run Name: T3
Tid: 2
Priority: 3
Burst: 25

Will run Name: T7
Tid: 6
Priority: 3
Burst: 30

Will run Name: T2
Tid: 1
Priority: 3
Burst: 15

Will run Name: T3
Tid: 2
Priority: 3
Burst: 15

Will run Name: T7
Tid: 6
Priority: 3
Burst: 20

Will run Name: T2
Tid: 1
Priority: 3
Burst: 5

Will run Name: T3
Tid: 2
Priority: 3
Burst: 5

Will run Name: T7
Tid: 6
Priority: 3
Burst: 10

Will run Name: T6
Tid: 5
Priority: 1
Burst: 10
```

Key observations:
- Highest priority tasks execute first (T8 with priority 10)
- Tasks with equal priority share CPU using round robin
- Each task gets up to 10ms before yielding to the next task of equal priority

## Analysis and Comparison

1. **Fairness**:
   - FCFS: Fair in terms of arrival time but can lead to convoy effect
   - SJF: Favors shorter tasks, potentially starving longer ones
   - Priority: Can lead to starvation of low-priority tasks
   - RR: Most fair in terms of CPU time distribution
   - Priority-RR: Balances priority requirements with fair CPU distribution

2. **Efficiency**:
   - SJF provides optimal average waiting time
   - RR has higher context switching overhead
   - Priority-RR balances system priorities with reasonable response times

3. **Complexity**:
   - FCFS: Simplest to implement
   - SJF: Requires burst time comparison
   - Priority: Requires priority queue implementation
   - RR: Requires queue management and time slice tracking
   - Priority-RR: Most complex, combining priority and RR mechanisms

## Conclusion
Each scheduling algorithm demonstrates different tradeoffs between fairness, efficiency, and complexity. The choice of algorithm depends on system requirements:
- For simple systems: FCFS
- For optimal average waiting time: SJF
- For systems with clear task priorities: Priority scheduling
- For interactive systems: RR
- For complex systems with both priority and fairness requirements: Priority-RR

