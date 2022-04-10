package com.example.asyncapi.service;

import com.example.asyncapi.entity.User;
import com.example.asyncapi.repository.UserRepository;
import org.aspectj.apache.bcel.generic.MULTIANEWARRAY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    Object target;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Async
    public CompletableFuture<List<User>> saveUsers(MultipartFile file) throws Exception {
        var users = parseCsvFile(file);
        logger.info("saving list of users of size {}", users.size(),  "" + Thread.currentThread().getName());
        users = repository.saveAll(users);
        return CompletableFuture.completedFuture(users);
    }

    @Async
    public CompletableFuture<List<User>> findAllUsers() {
        var users = repository.findAll();
        return CompletableFuture.completedFuture(users);
    }

    private List<User> parseCsvFile(final MultipartFile file) throws Exception {
        final List<User> users = new ArrayList<>();

        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;

                while((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    final User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);
                    users.add(user);
                }
                return users;
            }
        }
        catch (final IOException e) {
            throw new Exception("failed to parse csv file {}", e);
        }
    }
}
