package com.xor.taskExecutor.config.beanConfig;

import com.xor.taskExecutor.database.model.TaskDependency;
import com.xor.taskExecutor.service.TaskDependencyService;
import com.xor.taskExecutor.util.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DependencyGraphBean {

    @Autowired
    TaskDependencyService taskDependencyService;

    @Bean("dependencyGraph")
//    @Scope("prototype")
    public Graph getDependencyGraph(){
        Graph dependencyGraph=new Graph();
        Iterable<TaskDependency> dependencies= taskDependencyService.getAllDependencies();
        for(TaskDependency dependency : dependencies)
        {
            int from=dependency.getFromTask().getId();
            int to=dependency.getToTask().getId();
            String output=dependency.getOutput();
            dependencyGraph.addEdge(from,to,output);
        }
        return dependencyGraph;
    }
}
