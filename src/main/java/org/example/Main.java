package org.example;

public class Main {
    private static final int BIG_COUNT = 5;
    private static final int SMALL_COUNT = 1;

    public static void main(String[] args) {
        boolean ans = canPack(4,18,19);
        System.out.println(ans);
    }

    public static boolean canPack(int bigCount, int smallCount, int goal){
        // Check if there is a negative value
        // if goal is 0 means we don't need to do anything and just return false
        if(bigCount < 0 || smallCount < 0 || goal <= 0)
            return false;

        // Create variable to track the total of flour
        int total = 0;

        // Check if goal is greater or equal than 5
        // there is no reason to check bigCount if goal is less than 5
        if(goal >= BIG_COUNT){
            // Check if we can reach the goal with bigCount
            for (int i=0;i<bigCount;i++){
                total += BIG_COUNT;

                if(total == goal)
                    return true;
            }
        }

        // Reduce the total value if it's bigger than goal (to remove unnecessary big bag of flour)
        while(total > goal)
            total -= BIG_COUNT;

        // Check if we can reach the goal with smallCount
        for (int i=0;i<smallCount;i++){
            total += SMALL_COUNT;

            if(total == goal)
                return true;
        }

        return false;
    }
}