package cce105;

import java.util.*;

class Patient implements Comparable<Patient> {
    private final String name;
    private final int priority;
    private final String condition;
    private final String arrivalTime;

    public Patient(String name, int priority, String condition, String arrivalTime) {
        this.name = name;
        this.priority = priority;
        this.condition = condition;
        this.arrivalTime = arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public int compareTo(Patient other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return this.arrivalTime.compareTo(other.arrivalTime);
    }

    @Override
    public String toString() {
        return "[P" + priority + "] " + name + " - " + condition + " (" + arrivalTime + ")";
    }
}

class ERQueue {
    private final PriorityQueue<Patient> queue = new PriorityQueue<>();

    public void arrive(String name, int priority, String condition, String time) {
        Patient patient = new Patient(name, priority, condition, time);
        queue.offer(patient);
    }

    public void treatNext() {
        Patient next = queue.poll();
        if (next != null) {
            System.out.println("\nTreating patient now...");
            System.out.println("Treated: " + next);
        } else {
            System.out.println("No patients to treat.");
        }
    }

    public void displayQueue() {
        List<Patient> sortedList = new ArrayList<>(queue);
        Collections.sort(sortedList);

        System.out.println("\n--- UPDATED QUEUE ---");
        System.out.println("Patients Waiting: " + sortedList.size());
        
        int count = 1;
        for (Patient p : sortedList) {
            System.out.println(count++ + ". " + p);
        }
    }
}

public class Virtudazo_PriorityQueue {
    public static void main(String[] args) {
        ERQueue er = new ERQueue();

        er.arrive("Pedro Cruz", 1, "Head injury - NOW UNCONSCIOUS", "23:52");
        er.arrive("Carlos Mendoza", 2, "Compound fracture - leg", "23:50");
        er.arrive("Lisa Wang", 2, "Severe asthma attack", "23:56");
        er.arrive("Maria Santos", 3, "Deep laceration on arm", "23:48");
        er.arrive("Ana Lim", 4, "Sprained ankle", "23:49");

        er.displayQueue();
        er.treatNext();
        er.displayQueue();
    }
}
