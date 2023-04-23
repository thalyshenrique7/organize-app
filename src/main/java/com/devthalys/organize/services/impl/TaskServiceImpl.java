package com.devthalys.organize.services.impl;

import com.devthalys.organize.dtos.TaskDto;
import com.devthalys.organize.exception.UserNotFoundException;
import com.devthalys.organize.models.TaskModel;
import com.devthalys.organize.models.UserModel;
import com.devthalys.organize.repositories.TaskRepository;
import com.devthalys.organize.repositories.UserRepository;
import com.devthalys.organize.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<TaskModel> findById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public TaskModel saveTaskAndUser(TaskDto taskDto) {
        UserModel user = userRepository.findByCpf(taskDto.getUser());
        if(userRepository.existsByCpf(taskDto.getUser())){

            TaskModel task = TaskModel.builder()
                    .nameTask(taskDto.getNameTask())
                    .taskStatus(taskDto.getTaskStatus())
                    .dateCreation(LocalDateTime.now())
                    .user(user)
                    .build();

            return task;

        }

        throw new UserNotFoundException("User not found, your task has not been saved.");
    }

    @Override
    public TaskModel saveTask(TaskModel task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(String id) {
        taskRepository.deleteById(id);
    }
}