package com.devthalys.organize.services;

import com.devthalys.organize.dtos.TaskDto;
import com.devthalys.organize.enums.TaskStatus;
import com.devthalys.organize.models.TaskModel;
import com.devthalys.organize.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {

    List<TaskModel> findAll();

    Optional<TaskModel> findById(String id);

    List<TaskModel> findByUser(UserModel user);

    List<TaskModel> findTasksOrderedByStatus(TaskStatus tasks);

    TaskModel save(TaskDto task);

    void deleteById(String id);

    void update(TaskModel task);
}
