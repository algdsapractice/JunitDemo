package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SolutionSum {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>  result = new ArrayList<>();

        HashMap<Integer, Integer> freqMap = new HashMap<>();


        for(int candidate :candidates){
                freqMap.put(candidate,freqMap.getOrDefault(candidate,1)+1);
        }
return null;



    }


    public void calculate(List<int[]> bag, List<List<Integer>> combinations, int curr, int exist, LinkedList<Integer> comb){

        if(exist<=0){
            if(exist ==0){
                combinations.add(new ArrayList<>());
            }
            return;
        }

        for(int i =curr ; i<bag.size();i++ ){

            int [] entry = bag.get(i);
            Integer candidate = entry[0];
            Integer init = entry[1];
            if(init<=0){
                continue;
            }

            comb.addLast(candidate);
            bag.set(i,new int[]{candidate,init});
            calculate(bag,combinations,i,exist-candidate,comb);
            comb.removeLast();
        }
    }
}
