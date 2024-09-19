package HomeTaskManager.factory;

import HomeTaskManager.prototype.Task;

public abstract class TaskFactory {
    public abstract Task createTask(String type);
}
