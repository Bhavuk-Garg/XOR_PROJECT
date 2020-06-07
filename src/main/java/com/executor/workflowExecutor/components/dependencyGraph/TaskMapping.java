package com.executor.workflowExecutor.components.dependencyGraph;

import com.executor.workflowExecutor.Task.Task;
import com.executor.workflowExecutor.database.model.TaskDependency;
import com.executor.workflowExecutor.database.model.TaskInfo;
import com.executor.workflowExecutor.service.TaskDependencyService;
import com.executor.workflowExecutor.service.TaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("taskMapping")
@Scope("prototype")
public class TaskMapping {
    private Map<Integer, Task> taskIdRecord=new HashMap<>();;

    @Autowired
    TaskFactory taskFactory;

    public void addTaskRecord(int id){
        if(taskIdRecord.containsKey(id))    return;
        taskIdRecord.put(id,taskFactory.createTask(id));
    }

    public Task getTask(int id) {
        if(taskIdRecord.containsKey(id))
            return taskIdRecord.get(id);
        else
            throw new RuntimeException("No Records for task id: "+id);
    }
}
