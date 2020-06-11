# Workflow Manager
## Problem Statement
    ASFT as an org has orchestrator systems which interacts with multiple other services(hosted on different platforms, EC2, Lambda, ECS etc.). An orchestrator or a workflow system is one which coordinates which multiple other services to achieve desired result for the customer. 
    As an orchestrator:
    -- I should be able to define dependencies among tasks. eg. execute task B should be executed post task A.
    -- I should be able to execute multiple task in parallel.
    -- I should be call a task B only when output from task A meets certain criteria.
    say output of tasks A is a field X.
    if X == 'doB' then executeTaskB
    if X == 'doC' then executeTaskC
    -- I should able to define failure handling task for each of those tasks.
    -- I should be able to search execution of tasks in a workflow by a tagged id
    -- I should be able to support multiple type of tasks(Lambda, ECS etc.)
