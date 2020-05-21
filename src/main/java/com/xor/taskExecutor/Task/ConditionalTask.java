package com.xor.taskExecutor.Task;

import com.xor.taskExecutor.util.RandomOutput;

public class ConditionalTask implements Task {
    @Override
    public String execute() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("conditional task Executed");
        return RandomOutput.getOutput();
    }
}
