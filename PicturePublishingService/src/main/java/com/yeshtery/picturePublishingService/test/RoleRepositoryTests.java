package com.yeshtery.picturePublishingService.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.yeshtery.picturePublishingService.model.Role;
import com.yeshtery.picturePublishingService.model.User;
import com.yeshtery.picturePublishingService.repository.CreatedUserRepository;
import com.yeshtery.picturePublishingService.repository.RoleRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
    @Autowired private CreatedUserRepository repoUser;
    @Autowired private RoleRepository repoRole;
     
//    @Test
//    public void testCreateRoles() {
//        Role admin = new Role("ROLE_ADMIN");
//        Role user = new Role("ROLE_USER");
//        Role administrative = new Role("ROLE_ADMINSTRATIVEUSER");
//         
//        repoRole.saveAllAndFlush(List.of(admin, user, administrative));
//         
//        long count = repoRole.count();
//        assertEquals(3, count);
//    }
//    @Test
//    public void testAssignRoleToUser() {
//        Long userId1 = (long) 1;
//        Integer roleId1 = 1;
//        Long userId2 = (long) 6;
//        Integer roleId2 = 2;
//        Long userId3 = (long) 8;
//        Integer roleId3 = 3;
//       User user1 = repoUser.findById(userId1).get();
//       User user2 = repoUser.findById(userId2).get();
//       User user3 = repoUser.findById(userId3).get();
//        user1.addRole(new Role(roleId1));
//        user2.addRole(new Role(roleId2));
//        user3.addRole(new Role(roleId3));
//        repoUser.saveAllAndFlush(List.of(user1, user2, user3));
//        long count = repoUser.count();
//        assertEquals(3, count);
//        //User updatedUser = repoUser.save(user);
//        //assertThat(updatedUser.getRoles()).hasSize(1);
//         
//    }
}